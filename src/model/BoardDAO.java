package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;
import javafx.collections.ObservableList;
import oracle.jdbc.OracleTypes;

public class BoardDAO {
	
	// db관련 객체
	private Connection conn;
	private CallableStatement callableStatement;
	
	private BoardVO boardVO = new BoardVO();
	private ArrayList<BoardVO> boardVOList = new ArrayList<>();

	/*
	 * 전체 boardList 출력 메소드 카테고리별 게시물 페이지
	 */	
	public ArrayList<BoardVO> getAllBoardList() {

		ArrayList<BoardVO> boardVOList = new ArrayList<>();

		String runSP = "{ call select_board_all(?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
				
				while (resultSet.next()) {
					boardVOList.add(new BoardVO(
							resultSet.getInt(1), resultSet.getString(2),
							resultSet.getInt(3), resultSet.getString(4),
							resultSet.getTimestamp(5)));
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
		
		return boardVOList;

	}
	
	/*
	 * 카테고리별 boardList 출력 메소드 카테고리별 게시물 페이지
	 */
	public ArrayList<BoardVO> getOneCtgBoardList(int ctgId) {
		ArrayList<BoardVO> boardVOList = new ArrayList<>();
		
		String runSP = "{ call select_board_one_category(?, ?) }";

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
					boardVOList.add(new BoardVO(
					resultSet.getInt(1), resultSet.getString(2),
					resultSet.getInt(3), resultSet.getString(4),
					resultSet.getTimestamp(5)));
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
		return boardVOList;
	}
	
	/*
	 * 렌트 게시글 검색어 프로시저
	 */	
	public ArrayList<BoardVO> boardListBySearch(String keyWord) {
		ArrayList<BoardVO> boardVOList = new ArrayList<>();
		
		String runSP = "{ call select_board_by_search(?, ?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);
			keyWord = keyWord.trim();
			
			callableStatement.setString(1, keyWord);
			callableStatement.setString(2, keyWord);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			System.out.println();
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(3);
				
				while (resultSet.next()) {
					boardVOList.add(new BoardVO(
							resultSet.getInt(1), resultSet.getString(2),
							resultSet.getInt(3), resultSet.getString(4),
							resultSet.getTimestamp(5)));
				}
				
				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardVOList;
	}
	

	/*
	 * 내 게시물 오름차순 호출
	 */	
	public ArrayList<BoardVO> getMyBoardDesc(int id) {
		ArrayList<BoardVO> boardVOList = new ArrayList<>();
		
		String runSP = "{ call select_board_my_recent(?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);
			
			callableStatement.setInt(1, id);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				
				while (resultSet.next()) {
					boardVOList.add(new BoardVO(
							resultSet.getInt(1), resultSet.getString(2),
							resultSet.getInt(3), resultSet.getString(4),
							resultSet.getTimestamp(5),
							resultSet.getString(6)));
				}
				
				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardVOList;
	}
	
	/*
	 * 내 게시물 내림차순 호출
	 */	
	public ArrayList<BoardVO> getMyBoardAsc(int id) {
		ArrayList<BoardVO> boardVOList = new ArrayList<>();
		
		String runSP = "{ call select_board_my_old(?, ?) }";
    
    try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);
			
			callableStatement.setInt(1, id);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				
				while (resultSet.next()) {
					boardVOList.add(new BoardVO(
							resultSet.getInt(1), resultSet.getString(2),
							resultSet.getInt(3), resultSet.getString(4),
							resultSet.getTimestamp(5),
							resultSet.getString(6)));
				}
				
				System.out.println("성공");

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardVOList;
	}

	
	/*
	 * 내가 찜한 게시물 호출
	 */	
	public ArrayList<BoardVO> getMyZzimList(int id) {
		ArrayList<BoardVO> boardVOList = new ArrayList<>();
		
		String runSP = "{ call select_board_my_zzim(?, ?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);
			
			callableStatement.setInt(1, id);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			System.out.println();
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
				
				while (resultSet.next()) {
					boardVOList.add(new BoardVO(
							resultSet.getInt(1), resultSet.getString(2),
							resultSet.getInt(3), resultSet.getString(4),
							resultSet.getTimestamp(5),
							resultSet.getString(6)));
				}
				
				System.out.println("성공");
        
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boardVOList;
	}
	
	/*
	 * status update
	 */	
	public void updateStatus(int id) {
		String runSP = "{ call update_board_status(?) }";

		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);
			
			callableStatement.setInt(1, id);
			
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
	

	  //홈화면 게시판 미리보기
		public ArrayList<BoardVO> getMiniBoardList() {
			String runSP = "{ call select_board_mini(?) }";

			try {
				conn = DBConnection.getConnection();
				callableStatement = conn.prepareCall(runSP);

				callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
				
				try {
					callableStatement.execute();
					ResultSet resultSet = (ResultSet) callableStatement.getObject(1);
					
					while (resultSet.next()) {
						boardVOList.add(new BoardVO(
								resultSet.getInt(1), resultSet.getString(2),
								resultSet.getInt(3)));
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
			
			return boardVOList;
		}
	}
