package com.university.exception;

public class InvalidSchoolIdGenerationException extends RuntimeException {

	public InvalidSchoolIdGenerationException() {
		super("Auto-generated school_id does not reach 10 digits!");
	}
}
