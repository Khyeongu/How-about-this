package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class CategoryDAO {
	// db관련 객체
	private Connection conn;
	private CallableStatement callableStatement;

	// UserVO 객체 생성
	private BoardVO boardVO = new BoardVO();

	/*
	 * 채경 카테고리별 boardList 출력 메소드 카테고리별 게시물 페이지
	 */
	public void getOneCtgBoardList(int ctgId) {
		String runSP = "{ call select_one_category_board(?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, ctgId); // 카테고리id 받아와서 할당하는 부분
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

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
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
