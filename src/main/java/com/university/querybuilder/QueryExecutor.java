package com.university.querybuilder;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.university.model.Model;
import com.university.util.JDBCUtil;

public class QueryExecutor {
	
	/**
	 * QueryBuilder 객체 대신 SQL문을 실행하는 객체입니다.
	 * 각 객체마다 단일 책임성 규칙을 적용해보고 싶어서 만든 객체입니다.
	 */
	public QueryExecutor() {}
	
	/**
	 * QueryBuilder가 만든 Query String, PreparedStatement, 생성자 인자 값으로 받은 모델 객체를 받습니다.
	 * JDBCUtil로 DB connection을 열고 가지고 있는 pstmt로 
	 * 
	 * 작업이 마무리되면 
	 * 
	 * @param <T>		  모델 클래스의 자식 객
	 * @param query		  SQL작업을 위해 필요한 Query String
	 * @param parameters  QueryBuilder 객체에서 저장한 인자 값들  
	 * @param modelClass  데이터베이스 쿼리에서 각 행의 데이터를 담을 클래스 객체
	 * @return 			  모델 자식 객체들에 담은 결과 값들
	 */
	<T extends Model> List<T> fetchResults(String query, List<Object> parameters, Class<? extends Model> modelClass){
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> modelObjects = new ArrayList<>();
        
        try {
            conn = JDBCUtil.startConnection();
            pstmt = conn.prepareStatement(query);
            setParameters(pstmt, parameters);
            rs = pstmt.executeQuery();
            modelObjects = RowMapHandler.mapRows(modelClass, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, pstmt, conn);
        }

        return modelObjects;
	}
	
	/**
	 * SELECT문의 결과 값 하나를 반환합니다.
	 * JDBCUtil로 데이터베이스에 연결하고 데이터베이스 작업이 끝나면 커넥션을 닫습니다.
	 * 
	 * @param <T>		  모델 클래스의 자식 객
	 * @param query		  SQL작업을 위해 필요한 Query String
	 * @param parameters  QueryBuilder 객체에서 저장한 인자 값들  
	 * @param modelClass  데이터베이스 쿼리에서 각 행의 데이터를 담을 클래스 객체
	 * @return 			  모델 자식 객체들에 담은 결과 값들
	 */
	<T extends Model> T fetchResult(String query, List<Object> parameters, Class<? extends Model> modelClass) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		T modelObject = null;
		
		try {
			conn = JDBCUtil.startConnection();
			pstmt = conn.prepareStatement(query);
			setParameters(pstmt, parameters);
			rs = pstmt.executeQuery();
			modelObject = RowMapHandler.mapRow(modelClass, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return modelObject;
	}
	
	/**
	 * INSERT, UPDATE, DELETE문의 작업을 실행하기 위한 메소드입니다.
	 * get()과 getAll()과 마찬가지로 JDBCUtil로 데이터베이스 커넥션을 조절합니다.
	 * 
	 * @param query		 SQL작업을 위해 필요한 Query String
	 * @param parameters QueryBuilder 객체에서 저장한 인자 값들 
	 */
	void execute(String query, List<Object> parameters) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = JDBCUtil.startConnection();
			pstmt = conn.prepareStatement(query);
			setParameters(pstmt, parameters);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	/**
	 * SQL문을 실행할 때 PreparedStatment 객체에 인자 값들을 실어주기 위한 메소드입니다.
	 * 
	 * @param pstmt		 	QueryBuilder 객체에서 가져온 PreparedStatement 객
	 * @param parameters 	QueryBuilder 객체에서 저장한 인자 값들 
	 * @throws SQLException 
	 */
	private void setParameters(PreparedStatement pstmt, List<Object> parameters) throws SQLException {
		for (int idx=1; idx<=parameters.size(); idx++) {
			Object parameter = parameters.get(idx-1); //  subtract 1 from idx to avoid ArrayOutOfBounds
			
			if (parameter instanceof String) {
				pstmt.setString(idx, (String) parameter);
			} else if (parameter instanceof Date) { // (!) this is java.sql.Date
				pstmt.setDate(idx, (Date) parameter);
			} else if (parameter instanceof Boolean) {
				pstmt.setBoolean(idx, (Boolean) parameter);
			} else if (parameter instanceof Byte) {
				pstmt.setByte(idx, (Byte) parameter);
			} else if (parameter instanceof Short) {
				pstmt.setShort(idx, (Short) parameter);
			} else if (parameter instanceof Double) {
				pstmt.setDouble(idx, (Double) parameter);
			} else if (parameter instanceof Float) {
				pstmt.setFloat(idx, (Float) parameter);
			} else if (parameter instanceof Long) {
				pstmt.setLong(idx, (Long) parameter);
			} else if (parameter instanceof Integer) {
				pstmt.setInt(idx, (Integer) parameter);
			} else if (parameter instanceof Array) {
				pstmt.setArray(idx, (Array) parameter);
			} else if (parameter instanceof byte[]) {
				pstmt.setBytes(idx, (byte[]) parameter);
			} else {
				System.out.println("Parameter Error value: " + parameter);
				throw new SQLException();
			}
		}
	}
}

