package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class ReplyDAO {
	// db관련 객체
		private Connection conn;
		private CallableStatement cs;
		
		private ReplyVO replyVO = new ReplyVO();
		
		public ArrayList<ReplyVO> getAllReplyList(int boardId){
			ArrayList<ReplyVO> replyList = new ArrayList<>();
			
			String runSP = "{ call select_reply_board (?, ?) }";
			
			try {
				conn = DBConnection.getConnection();
				cs = conn.prepareCall(runSP);
				
				cs.setInt(1, boardId); // 카테고리id 받아와서 할당하는 부분
				cs.registerOutParameter(2, OracleTypes.CURSOR);
				System.out.println();

				try {
					cs.execute();
					ResultSet resultSet = (ResultSet) cs.getObject(2);

					while (resultSet.next()) {
						
						replyVO.setContent(resultSet.getString(2));
						replyVO.setTime(resultSet.getDate(3));
						System.out.println("title: " + replyVO.getContent());
						System.out.println("price: " + replyVO.getTime().toString());
						System.out.println();
						replyList.add(new ReplyVO(
								resultSet.getInt(1), resultSet.getString(2),
								resultSet.getDate(3), resultSet.getInt(4)));
					}
					
					return replyList;

				} catch (SQLException e) {
					System.out.println("프로시저에서 에러 발생!");
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return replyList;
		}
		
		public void addReply(String content, int board_id) {
			String runSP = "{ call insert_reply_board (?, ?) }";
			
			try {
				conn = DBConnection.getConnection();
				cs = conn.prepareCall(runSP);

				cs.setString(1, content);
				cs.setInt(2, board_id);
				System.out.println();
				try {
					cs.executeUpdate();
					
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
