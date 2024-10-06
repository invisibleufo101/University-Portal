package com.university.model;

public abstract class Model {

	protected String table;
	protected FieldHandler fieldHandler;

	/**
	 * 상속받은 자식 클래스의 이름을 기반으로 테이블 이름을 자동으로 설정합니다. 보통 테이블의 이름이 복수형인 경우가 많고 모델 클래스는
	 * 단수형인 경우가 많아 테이블 이름은 클래스 이름의 소문자로 변형된 클래스 이름 뒤에 's'가 붙는 형태로 설정했습니다.
	 */
	public Model() {
		String lowerCaseClassName = this.getClass().getSimpleName();
		this.table = lowerCaseClassName.concat("s");
		this.fieldHandler = new FieldHandler(this);
	}

	/**
	 * 테이블 이름을 명시적으로 설정하는 생성자입니다.
	 * 예를 들어)
	 * 데이터베이스 테이블명이 categories고 모델 자식 객체명이 category면 위와 같이 단순히 "s"를 붙히는 패턴이 적용될 수 없기에 
	 * 모델 자식 객체의 테이블명을 직접 작성할 수 있는 옵션을 만들었습니다.
	 *
	 * @param table 데이터베이스 테이블 이름
	 */
	public Model(String table) {
		this.table = table;
		this.fieldHandler = new FieldHandler(this);
	}

	/**
	 * 모델 객체에 지정할 선언된 필드 이름에 해당하는 필드 값을 설정합니다.
	 *
	 * @param column 컬럼 이름
	 * @param value  설정할 값
	 */
	public void setField(String column, Object value) {
		this.fieldHandler.setField(column, value);
	}

	/**
	 * 모델 객체에 선언된 필드 이름에 해당하는 필드 값을 반환합니다.
	 *
	 * @param column 컬럼 이름
	 * @return 필드 값
	 */
	public Object getField(String column) {
		return this.fieldHandler.getField(column);
	}

	/**
	 * 모델 객체의 테이블 이름을 반환합니다.
	 *
	 * @return 테이블 이름
	 */
	public String getTable() {
		return table;
	}
}

