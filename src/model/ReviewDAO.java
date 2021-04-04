package model;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class ReviewDAO {
	// db관련 객체
	private static Connection conn;
	private static CallableStatement callableStatement;

	public static ReviewVO reviewVO = new ReviewVO();
	public ArrayList<String> review_merge_list = new ArrayList<>();
	public static String member_name;
	public static String member_grade;

	/* 멤버 이름 가져오기 */
	public void getMemberName(int memberid) {
		String runSP = "{ call select_memberid_name(?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, memberid);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

			try {
				callableStatement.executeQuery();
				member_name = callableStatement.getString(2);
				
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
			}catch(

			SQLException e)
			{
				e.printStackTrace();
			}catch(
			Exception e)
			{
				e.printStackTrace();
			}
	}
	
	
	/*멤버 평점 가져오기*/
	public void getMemberGrade(int memberid) {
		String runSP = "{ call select_member_grade(?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, memberid);
			callableStatement.registerOutParameter(2, java.sql.Types.FLOAT);

			try {
				callableStatement.executeQuery();
				member_grade = callableStatement.getString(2);
				
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
			}catch(

			SQLException e)
			{
				e.printStackTrace();
			}catch(
			Exception e)
			{
				e.printStackTrace();
			}
	}

	/* 리뷰 리스트 가져오기 */
	public void getReviewList(int memberid) {
		String runSP = "{ call select_review_member(?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.setInt(1, memberid);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);

				while (resultSet.next()) {
					reviewVO.setId(resultSet.getInt(1));
					reviewVO.setGrade(resultSet.getFloat(2));
					reviewVO.setContent(resultSet.getString(3));
					reviewVO.setTime(resultSet.getDate(4));
					
					String temp [] = resultSet.getString(4).split(" ");
					
					review_merge_list.add("[No"     + resultSet.getString(1) + 
										"]  [평점:"    + resultSet.getString(2) + 
										"]  [내용:"    + resultSet.getString(3) + 
										"]  [작성시간:" +temp[0] + "]");
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
	
	/* 리뷰 작성 */
	public static void reviewPost(int memberid) {
		String runSP = "{ call insert_review_post(?, ?, ?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);
			
			SimpleDateFormat spformat = new SimpleDateFormat("yyyy-MM-dd");
			String time_date = spformat.format(reviewVO.getTime());
			
			callableStatement.setFloat(1, reviewVO.getGrade());
			callableStatement.setString(2, reviewVO.getContent());
			callableStatement.setDate(3,java.sql.Date.valueOf(time_date));
			callableStatement.setInt(4, memberid);

			try {
				callableStatement.executeQuery();
								
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
			}catch(

			SQLException e)
			{
				e.printStackTrace();
			}catch(
			Exception e)
			{
				e.printStackTrace();
			}
	}


}
