package model;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import oracle.jdbc.OracleTypes;



public class MonthlyProfitDAO {
	private Connection conn;
	private CallableStatement callableStatement;
	
	private MonthlyProfitVO monthlyProfit;
	private ArrayList<MonthlyProfitVO> monthlyProfits= new ArrayList<>();
	
		
	public ArrayList<MonthlyProfitVO> getMonthlyProfit(String startDate, String endDate){
		monthlyProfit= new MonthlyProfitVO();
		String runSP ="{ call select_traderecord_monthly2(?,?,?)}";
		
		try {
			conn = DBConnection.getConnection();
			callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, startDate);
			callableStatement.setString(2, endDate);
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			
			try {
				callableStatement.execute();
				ResultSet resultSet = (ResultSet) callableStatement.getObject(3);
				
				while (resultSet.next()) {
					monthlyProfits.add(new MonthlyProfitVO(
							resultSet.getString(1),
							resultSet.getInt(2)
						));
				}
				
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return monthlyProfits;
	}

}
