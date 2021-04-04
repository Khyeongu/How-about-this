package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class CategoryRankDAO {
	
	// db관련 객체
	private Connection conn;
	private CallableStatement callableStatement;

	// UserVO 객체 생성
	public CategoryRankVO categoryRankVO = new CategoryRankVO();
	ArrayList<String> list = new ArrayList<>();
	
	/* 카테고리별 랭크 집계 결과*/
	public ArrayList<String> getCategoryRank() {
		String runSP = "{ call select_category_rank(?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(1);

				while (resultSet.next()) {
					categoryRankVO.setId(resultSet.getInt(1));
					categoryRankVO.setName(resultSet.getString(2));
										
					list.add(resultSet.getString(2));

				}

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
