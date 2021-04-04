package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class PostDAO {
	// db관련 객체
	private static Connection conn;
	private static CallableStatement callableStatement;

	// UserVO 객체 생성
	public static PostVO postVO = new PostVO();
	ArrayList<String> insert_board_post_list = new ArrayList<>();

	/*
	 * 게시판 글 입력
	 */
	public static void insertBoardPost() {
		String runSP = "{ call insert_board_post(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

//			callableStatement.setInt(1, postVO.getId());
//			callableStatement.setString(2, postVO.getTitle());
//			callableStatement.setString(3, postVO.getContent());
//			callableStatement.setInt(4, postVO.getPrice());
//			callableStatement.setString(5, postVO.getStatus());
//			callableStatement.setDate(6, (Date) postVO.getTime());
//			callableStatement.setDate(7, postVO.getStart_date()+" 00:00:01.00");
//			callableStatement.setDate(8, postVO.getEnd_date());
//			callableStatement.setString(9, postVO.getImage_url());
//			callableStatement.setInt(10, postVO.getCategory_id());
//			callableStatement.setInt(11, postVO.getMember_id());
//			callableStatement.executeQuery();
			
			System.out.println(postVO.getId());
			System.out.println(postVO.getTitle());
			System.out.println(postVO.getContent());
			System.out.println(postVO.getPrice());
			System.out.println(postVO.getStatus());
			System.out.println(postVO.getTime());
			System.out.println(postVO.getStart_date());
			System.out.println(postVO.getEnd_date());
			System.out.println(postVO.getImage_url());
			System.out.println(postVO.getCategory_id());
			System.out.println(postVO.getMember_id());

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
