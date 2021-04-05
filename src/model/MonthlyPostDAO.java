package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class MonthlyPostDAO {
	private Connection conn;
	private CallableStatement callableStatement;

	private ArrayList<MonthlyPostVO> monthlyPosts = new ArrayList<>();;

	public ArrayList<MonthlyPostVO> getMonthlyPost(int userId, String postYear) {
		String runSP = "{ call how_statistic_pack.select_traderecord_monthly_post(?,?,?)}";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, userId);
			callableStatement.setString(2, postYear);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(3);

				while (resultSet.next()) {
					monthlyPosts.add(
							new MonthlyPostVO(resultSet.getString(1), resultSet.getInt(2), resultSet.getString(3)));
				}

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return monthlyPosts;
	}
}
