package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import database.DBConnection;
import database.UserSession;
import oracle.jdbc.OracleTypes;

public class MemberDAO {
	// db관련 객체
		private Connection conn;
		private CallableStatement callableStatement;
		
		private MemberVO mem= new MemberVO();
		
		private UserSession session;
		
		public boolean loginCheck(String id, String pw) {
			String runSP = "{ call how_member_pack.select_member_info(?, ?, ?, ?, ?, ?, ?) }";
			int mem_id = 0;

			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);

				callableStatement.setString(1, id); 
				callableStatement.setString(2, pw);
				callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
				callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
				callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
				callableStatement.registerOutParameter(6, java.sql.Types.DATE);
				callableStatement.registerOutParameter(7, java.sql.Types.VARCHAR);
				System.out.println("input id : " + id + " , pw : " + pw);
				System.out.println();

				try {
					callableStatement.executeQuery();
					
					 mem.setId(callableStatement.getInt(3));
					 mem.setLoginId(id);
					 mem.setName(callableStatement.getString(4));
					 mem.setPhoneNumber(callableStatement.getString(5));
					 mem.setBirthdate(callableStatement.getDate(6));
					 mem.setNickName(callableStatement.getString(7));
					 
					 System.out.println(mem_id);
					 
					 session = UserSession.getInstance();
					 
					 session.setMember(mem);
					 
					 
					return true;
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
		
		public boolean idCheck(String id) {
			String runSP = "{ call how_member_pack.select_member_id_check(?, ?) }";
			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);

				callableStatement.setString(1, id); 
				callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
				System.out.println();

				try {
					callableStatement.executeQuery();
					
					 if(callableStatement.getInt(2) == 0) return true;
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
		
		public boolean nickNameCheck(String nickName) {
			String runSP = "{ call how_member_pack.select_member_nickname_check(?, ?) }";
			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);

				callableStatement.setString(1, nickName); 
				callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);
				System.out.println();

				try {
					callableStatement.executeQuery();
					
					 if(callableStatement.getInt(2) == 0) return true;
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
		
		public void signUp(MemberVO member) {
			String runSP = "{ call how_member_pack.insert_member_signUp(?, ?, ?, ?, ?, ?) }";
			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);

				callableStatement.setString(1, member.getLoginId());
				callableStatement.setString(2, member.getLoginPassword());
				callableStatement.setString(3, member.getName());
				callableStatement.setString(4, member.getPhoneNumber());
				SimpleDateFormat spformat = new SimpleDateFormat("yyyy-MM-dd");
				String formattedDate = spformat.format(member.getBirthdate());
				callableStatement.setDate(5, java.sql.Date.valueOf(formattedDate));
				callableStatement.setString(6, member.getNickName());
				System.out.println();
				try {
					callableStatement.executeUpdate();
					
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
