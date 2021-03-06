package model;

import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import database.DBConnection;

public class PostDAO {
	// db관련 객체
	private static Connection conn;
	private static CallableStatement callableStatement;
	
	public static PostVO postVO = new PostVO();
	ArrayList<String> insert_board_post_list = new ArrayList<>();

	/* 게시판 글 입력*/
	public static void insertBoardPost(int memberid) {
		String runSP = "{ call how_board_pack.insert_board_post(?, ?, ?, ?, ?, ?, ?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);
			
			SimpleDateFormat spformat = new SimpleDateFormat("yyyy-MM-dd");
			String format_start_date = spformat.format(postVO.getStart_date());
			String format_end_date = spformat.format(postVO.getEnd_date());
			
			callableStatement.setString(1, postVO.getTitle());
			callableStatement.setString(2, postVO.getContent());
			callableStatement.setInt(3, postVO.getPrice());
			callableStatement.setDate(4, java.sql.Date.valueOf(format_start_date));
			callableStatement.setDate(5, java.sql.Date.valueOf(format_end_date));
			callableStatement.setString(6, postVO.getImage_url());
			callableStatement.setInt(7, postVO.getCategory_id());
			callableStatement.setInt(8, memberid);
			callableStatement.executeQuery();
			
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
