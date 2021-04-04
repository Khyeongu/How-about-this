package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import database.UserSession;
import oracle.jdbc.OracleTypes;

public class RentDetailDAO {
	
	// db관련 객체
	private Connection conn;
	private CallableStatement cs;
	
	// UserVO 객체 생성
	private RentDetailVO rentDetail = new RentDetailVO();
	
	
	
	public RentDetailVO getBoardById(int boardId) {
		String runSP = "{ call select_board_detail( ?, ? ) }";
		
		try {
			conn = DBConnection.getConnection();
			cs = conn.prepareCall(runSP);
			
			cs.setInt(1, boardId);
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			
			try {
				cs.execute();
				ResultSet rs = (ResultSet) cs.getObject(2);
				
				while(rs.next()) {
					rentDetail.setTitle(rs.getString(1));
					rentDetail.setStartDate(rs.getDate(2));
					rentDetail.setEndDate(rs.getDate(3));
					rentDetail.setPrice(rs.getInt(4));
					rentDetail.setStatus(rs.getBoolean(5));
					rentDetail.setContent(rs.getString(6));
					rentDetail.setNickName(rs.getString(7));
					rentDetail.setPhoneNumber(rs.getString(8));
					rentDetail.setImageUrl(rs.getString(9));
				}
				
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return rentDetail;
	}
	
	public boolean isZzim(int memberId, int boardId) {
		String runSP = "{ call select_zzim( ?, ?, ? ) }";
		
		try {
			conn = DBConnection.getConnection();
			cs = conn.prepareCall(runSP);
			
			cs.setInt(1, boardId);
			cs.setInt(2, memberId);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			
			try {
				cs.executeQuery();
				
				 int zzim = cs.getInt(3);
				 
				 System.out.println(zzim);
				 
				 if(zzim == 1) return true;
				 else return false;
				 
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int getMemberId(int boardId) {
		String runSP = "{ call select_board_memberid( ?, ? ) }";
		int member_id = 0;
		
		try {
			conn = DBConnection.getConnection();
			cs = conn.prepareCall(runSP);
			
			cs.setInt(1, boardId);
			cs.registerOutParameter(2, java.sql.Types.INTEGER);
			
			try {
				cs.executeQuery();
				
				 member_id = cs.getInt(2);
				 
				 return member_id;
				 
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				return member_id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return member_id;
		} catch (Exception e) {
			e.printStackTrace();
			return member_id;
		}
	}

	
}
