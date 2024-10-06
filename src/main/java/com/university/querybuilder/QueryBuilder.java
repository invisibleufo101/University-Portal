package com.university.querybuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.university.model.Model;

public class QueryBuilder {

	private Class<? extends Model> modelClass;
	private String table;
	private QueryExecutor queryExecutor;
	private StringBuilder query = new StringBuilder();
	private List<Object> parameters = new ArrayList<>();

	/**
	 * QueryBuilder 객체는 Model 자식 클래스를 인자 값으로 받아 SELECT 쿼리문을 실행할 때 
	 * 모델 객체로 결과 값들을 담아서 반환합니다.
	 * 
	 * QueryBuilder 객체는 쿼리문을 만드는 것에 중점을 둔 객체이고
	 * QueryExecutor 객체는 대신 쿼리문을 실행해주는 객체입니다.
	 * 
	 * @param modelClass Data Container로 쓸 Model 자식 클래스
	 */
	public QueryBuilder(Class<? extends Model> modelClass) {
		this.modelClass = modelClass;
		this.table = setTableName(modelClass);
		this.queryExecutor = new QueryExecutor();
	}

	/**
	 * 생성자 인자 값으로 받은 Class Object로 새로 객체를 만들어서 데이터베이스 테이블명을 추출하는 메소드 입니다.
	 * 
	 * @param modelClass 		 테이블 명을 추출할 Model 자식 객체
	 * @return String tableName	 SQL 쿼리를 실행하는 데 필요한 테이블 이름을 반환합니다.
	 */
	private String setTableName(Class<? extends Model> modelClass) {
		try {
			Object modelInstance = modelClass.getDeclaredConstructor().newInstance();
			Method getTableMethod = modelClass.getMethod("getTable");
			String tableName = (String) getTableMethod.invoke(modelInstance);
			return tableName;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			System.out.println("Model class (" + modelClass + ") can't be found by QueryBuilder!");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * SQL의 SELECT문을 구현한 메소드입니다.
	 * 문자열 배열을 인자 값으로 받고 객체의 쿼리문에 SELECT 해야할 항목들을 저장합니다. 
	 * 
	 * @param columns 	인자 값으로 받는 데이터베이스 테이블의 항목들
	 * @return 			사슬 메소드를 위한 QueryBuilder 객체. 
	 */
	public QueryBuilder select(String... columns) {
		columns = Arrays.stream(columns).map(this::camelCaseToSnakeCase).toArray(String[]::new);
		String selectColumns = String.join(", ", columns);

		this.query.append("SELECT ").append(selectColumns).append(" FROM ").append(this.table);

		return this;
	}

	/**
	 * 데이터베이스 테이블의 전체 항목을 검색할 때 쓰는 메소드입니다.
	 * 객체의 문자열에 SELECT 메소드를 저장합니다.
	 * 
	 * @return 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder select() {
		this.query.append("SELECT * FROM ").append(this.table);

		return this;
	}

	/**
	 * INSERT문을 위한 메소드입니다.
	 * 테이블에 들어갈 항목들을 저장하며 INSERT문을 쿼리 문자열에 넣습니다.
	 *  
	 * @param 	columns
	 * @return  사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder insert(String... columns) {
		columns = Arrays.stream(columns).map(this::camelCaseToSnakeCase).toArray(String[]::new);
		String insertColumns = String.join(", ", columns);

		this.query.append("INSERT INTO ").append(this.table).append("( ").append(insertColumns).append(") ");

		return this;
	}

	/**
	 * 데이터베이스 테이블의 모든 항목들에 데이터를 넣을 때 쓰는 메소드입니다.
	 * 쿼리 문자열에 INSERT를 저장합니다.
	 * 
	 * @return 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder insert() {
		this.query.append("INSERT INTO ").append(this.table).append(" ");

		return this;
	}

	/**
	 * UPDATE문을 위한 메소드입니다.
	 * 쿼리 문자열에 UPDATE를 저장합니다.
	 * 
	 * @return 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder update() {
		this.query.append("UPDATE ").append(this.table).append(" ");

		return this;
	}

	/**
	 * DELETE문을 위한 메소드입니다.
	 * 쿼리 문자열에 DELETE를 저장합니다.
	 * 
	 * @return 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder delete() {
		this.query.append("DELETE FROM ").append(this.table).append(" ");

		return this;
	}


	/**
	 * INSERT문의 넣을 데이터를 저장하는 메소드입니다.
	 * 쿼리문에 인자 값 대신 인자 값의 수만큼 "?"를 넣으며 객체 배열에 인자 값을 담슴니다. 
	 * 
	 * @param values INSERT문으로 넣을 데이터
	 * @return 		 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder values(Object... values) {
		String valueParameters = String.join(", ", Collections.nCopies(values.length, "?"));

		this.query.append("VALUES (").append(valueParameters).append(")");

		this.parameters.addAll(Arrays.asList(values));

		return this;
	}

	/**
	 * UPDATE문의 수정해야 될 항목과 값을 저장하는 메소드입니다.
	 * 
	 * @param column 데이터베이스 테이블의 항목
	 * @param value  해당 항목의 데이터 
	 * @return 		 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder set(String column, Object value) {
		column = camelCaseToSnakeCase(column);
		// Check if SET clause was used before so that we can decide to add a comma or not
		// ex) SET param = ?, param2 = ?
		if (this.query.toString().contains("SET")) {
			this.query.append(", ");
		} else {
			this.query.append("SET ");
		}

		this.query.append(column).append(" = ?");
		this.parameters.add(value);

		return this;
	}

	/**
	 * WHERE문의 조건식을 저장하는 메소드입니다.
	 * 
	 * @param column 	데이터베이스 테이블의 항목
	 * @param operand	조건식을 위한 연산자 (=, <, >, >=, ^=, <> 등)
	 * @param value		테이블 항목의 데이터 값
	 * @return			사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder where(String column, String operand, Object value) {
		column = camelCaseToSnakeCase(column);
		this.query.append(" WHERE ").append(column).append(" ").append(operand).append(" ? ");

		this.parameters.add(value);

		return this;
	}

	/**
	 * WHERE문의 '=' 조건식을 저장하는 메소드입니다.
	 * 
	 * @param column 데이터베이스 테이블의 항목
	 * @param value	 테이블 항목의 데이터 값
	 * @return 		 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder where(String column, Object value) {
		column = camelCaseToSnakeCase(column);
		this.query.append(" WHERE ").append(column).append(" = ?");

		this.parameters.add(value);
		return this;
	}

	/**
	 * WHERE문의 NOT 조건식을 저장하는 메소드입니다.
	 * 
	 * @param column 데이터베이스 테이블의 항목
	 * @param value  테이블 항목의 데이터 값
	 * @return 		 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder whereNot(String column, Object value) {
		column = camelCaseToSnakeCase(column);
		this.query.append(" WHERE NOT ").append(column).append(" = ? ");

		this.parameters.add(value);
		return this;
	}

	/**
	 * WHERE문의 LIKE 조건식을 저장하는 메소드입니다.
	 * 
	 * @param column 데이터베이스 테이블의 항목
	 * @param value  테이블 항목의 데이터 값
	 * @return 		 사슬 메소드를 위한 QueryBuilder 객체.
	 */
	public QueryBuilder whereLike(String column, String expression) {
		column = camelCaseToSnakeCase(column);
		this.query.append(" WHERE ").append(column).append(" LIKE '").append(expression).append("' ");

		return this;
	}

//	/**
//	 * 아직 준비가 안된 메소드입니다.
//	 * @param column
//	 * @param values
//	 * @return
//	 */
//	public QueryBuilder whereIn(String column, Object... values) {
//		column = camelCaseToSnakeCase(column);
//		String valueParameters = String.join(", ", Collections.nCopies(values.length, "?"));
//
//		this.query.append(" WHERE ").append(column).append(" IN (").append(valueParameters).append(") ");
//
//		this.parameters.add(Arrays.asList(values));
//		return this;
//	}

	/**
	 * OR 연산자를 위한 메소드입니다.
	 * 
	 * @param column  데이터베이스 테이블의 항목
	 * @param operand 조건식의 연산자
	 * @param value   테이블 항목의 데이터 값
	 * @return 		  사슬 메소드를 위한 QueryBuilder 객체.
	 * @throws SQLException
	 */
	public QueryBuilder or(String column, String operand, Object value) throws SQLException {
		column = camelCaseToSnakeCase(column);
		this.query.append(" OR ").append(column).append(" ").append(operand).append(" ? ");

		this.parameters.add(value);

		return this;
	}

	/**
	 * OR 연산자의 '=' 조건식을 위한 메소드입니다.
	 * 
	 * @param column  데이터베이스 테이블의 항목
	 * @param operand 조건식의 연산자
	 * @param value   테이블 항목의 데이터 값
	 * @return 		  사슬 메소드를 위한 QueryBuilder 객체.
	 * @throws SQLException
	 */
	public QueryBuilder or(String column, Object value) throws SQLException {
		column = camelCaseToSnakeCase(column);
		this.query.append(" OR ").append(column).append(" = ? ");

		this.parameters.add(value);

		return this;
	}
	
	/**
	 * AND 연산자를 위한 메소드입니다.
	 * 
	 * @param column  데이터베이스 테이블의 항목
	 * @param operand 조건식의 연산자
	 * @param value   테이블 항목의 데이터 값
	 * @return 		  사슬 메소드를 위한 QueryBuilder 객체.
	 * @throws SQLException
	 */
	public QueryBuilder and(String column, String operand, Object value) throws SQLException {
		column = camelCaseToSnakeCase(column);
		this.query.append(" AND ").append(column).append(" ").append(operand).append(" ? ");

		this.parameters.add(value);

		return this;
	}

	/**
	 * OR 연산자의 '=' 연산자를 위한 메소드입니다.
	 * 
	 * @param column  데이터베이스 테이블의 항목
	 * @param operand 조건식의 연산자
	 * @param value   테이블 항목의 데이터 값
	 * @return 		  사슬 메소드를 위한 QueryBuilder 객체.
	 * @throws SQLException
	 */
	public QueryBuilder and(String column, Object value) throws SQLException {
		column = camelCaseToSnakeCase(column);
		this.query.append(" AND ").append(column).append(" = ? ");

		this.parameters.add(value);

		return this;
	}
	
	public QueryBuilder join(String foreignTable, String foreignKey, String referenceKey) {
		foreignTable = camelCaseToSnakeCase(foreignTable);
		referenceKey = camelCaseToSnakeCase(referenceKey);
		foreignKey = camelCaseToSnakeCase(foreignKey);
		
		this.query.append(" JOIN ").append(foreignTable).append(" ON ").append(foreignTable).append(".").append(foreignKey).append(" = ").append(this.table).append(".").append(referenceKey).append(" ");
		
		return this;
	}
	
	public QueryBuilder orderBy(String column, String direction) {
		this.query.append(" ORDER BY ").append(column).append(" ").append(direction).append(" ");
		return this;
	}
	
	public QueryBuilder orderBy(String column) {
		this.query.append(" ORDER BY ").append(column).append(" ASC ");
		return this;
	}

	/**
	 * SELECT문으로 모든 결과 값을 반환하는 메소드입니다.
	 * 
	 * @param List<T> 결과 값들을 담을 컨테이너 객체들
	 * @return	  	  데이터베이스 검색의 결과 값들
	 */
	@SuppressWarnings("unchecked")
	public <T extends Model> List<T> getAll() {
		String queryString = this.query.toString();
		List<Object> resultParameters = this.parameters;
		List<T> results = (List<T>) this.queryExecutor.fetchResults(queryString, resultParameters, this.modelClass);

		clearQuery();
				
		return results;
	}

	/**
	 * SELECT문으로 하나의 결과 값만 반환하는 메소드입니다.
	 * H2에 경우 FETCH FIRST 1 ROWS ONLY를 쓰면 LIMIT 1 같은 효과를 볼 수 있습니다.
	 * @param <T> 데이터를 담을 컨테이너 객체
	 * @return	  데이터베이스 검색의 결과 값
	 */
	public <T extends Model> T get() {
		this.query.append(" FETCH FIRST 1 ROWS ONLY ");
		String queryString = this.query.toString();
		List<Object> resultParameters = this.parameters;

		T result = this.queryExecutor.fetchResult(queryString, resultParameters, this.modelClass);

		clearQuery();
		return result;
	}

	/**
	 *  INSERT, UPDATE, DELETE 작업을 위해 쓰는 메소드입니다.
	 *  QueryExecutor의 execute() 메소드를 호출해 DML문을 수행합니다.
	 *  @return void
	 */
	public void execute() {
		String queryString = this.query.toString();
		List<Object> resultParameters = this.parameters;

		this.queryExecutor.execute(queryString, resultParameters);

		clearQuery();
	}

	/**
	 * SQL문을 실행하고 나서 QueryBuilder 객체가 가지고 있던 인자 값들을 해제 시키는 메소드입니다.
	 * 
	 * @return void
	 */
	private void clearQuery() {
		this.query.setLength(0);
		this.parameters.clear();
	}
	
	/**
	 *  QueryBuilder 객체의 메소드를 쓰는 사용자 편의성을 위해 만들었습니다. 
	 *  데이터베이스에서는 객체의 이름을 snake_case로 쓰는 것이 일반적이지만 자바에서는 camelCase가 표준입니다. 
	 *  그러므로 snake_case의 underscore("_")가 어디 있는지 일일히 기억해야되는 것은 꽤나 불편합니다.
	 *  
	 *  그래서 chatGPT의 도움으로 자동으로 camelCase 표기법을 snake_case로 변환하는 메소드를 만들었습니다.
	 *  
	 * @param camelCase camelCase로 된 데이터베이스 테이블 항목
	 * @return 			snake_case로 변환된 테이블 항목
	 */
	private String camelCaseToSnakeCase(String camelCase) {
        String snake_case = camelCase.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase(); // Code provided by ChatGPT
        return snake_case;
    }
}
