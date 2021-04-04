package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;
import oracle.jdbc.OracleTypes;

public class CategoryRankDAO {
	
	// db관련 객체
	private Connection conn;
	private CallableStatement callableStatement;

	// UserVO 객체 생성
	public CategoryRankVO categoryRankVO = new CategoryRankVO();


}
