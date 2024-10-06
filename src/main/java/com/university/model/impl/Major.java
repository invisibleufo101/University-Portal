package com.university.model.impl;

import com.university.model.Model;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Major extends Model {

	private Long id;
	private String majorName;
}
