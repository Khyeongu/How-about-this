package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class TradeRecordDAO {
	// db관련 객체
		private Connection conn;
		private CallableStatement callableStatement;
		
		private ArrayList<TradeRecordVO> categoryRanks = new ArrayList<>();;

		public ArrayList<TradeRecordVO> getCategoryRank() {
			String runSP = "{ call select_category_rank(?)}";

			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);

				callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

				try {
					callableStatement.execute();
					ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

					while (resultSet.next()) {
						categoryRanks.add(
								new TradeRecordVO(resultSet.getInt(1)));
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

			return categoryRanks;
		}
}	
