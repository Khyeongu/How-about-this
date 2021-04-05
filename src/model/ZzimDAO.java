package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import database.DBConnection;

public class ZzimDAO {
	// db관련 객체
		private Connection conn;
		private CallableStatement callableStatement;
		
		/*
		 * status update
		 */	
		public void deleteZzim(int boardId, int memberId) {
			String runSP = "{ call how_board_pack.delete_zzim_list(?, ?) }";

			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);
				
				callableStatement.setInt(1, boardId);
				callableStatement.setInt(2, memberId);
				
				try {
					callableStatement.execute();

					System.out.println("updateStatus 성공");

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
		
		// db관련 객체
		public void insertZzim(int board_id, int member_id) {
			String runSP = "{ call how_board_pack.insert_zzim_board(?, ?) }";

			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);

				callableStatement.setInt(1, board_id);
				callableStatement.setInt(2, member_id);

				try {
					callableStatement.executeUpdate();
				} catch (SQLException e) {
					System.out.println("프로시저에서 에러 발생!");
					System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				}
				}catch(SQLException e){
					e.printStackTrace();
				}catch(Exception e){
					e.printStackTrace();
				}
		}
}
