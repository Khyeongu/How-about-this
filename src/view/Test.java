package view;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import model.BoardVO;
import oracle.jdbc.OracleTypes;

public class Test {

	public static void main(String[] args) {

		String runSP = "{ call select_by_search_board(?, ?, ?) }";

		try {
			Connection conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, "하");
			callableStatement.setString(2, "하");
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			System.out.println();
			
			try {
				BoardVO boardVO = new BoardVO();
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(3);
				
				while (resultSet.next()) {
					boardVO.setTitle(resultSet.getString(1));
					boardVO.setPrice(resultSet.getInt(2));
					boardVO.setImageUrl(resultSet.getString(3));
					boardVO.setTime(resultSet.getDate(4));
					System.out.println("title: " + boardVO.getTitle());
					System.out.println("price: " + boardVO.getPrice());
					System.out.println("image_url: " + boardVO.getImageUrl());
					System.out.println("time: " + boardVO.getTime());
					System.out.println();

				}
				
				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
