package com.zdrv.domain;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class User {

	private Integer id;
	
	@NotBlank
	private String loginId;
	private String loginPass;
	private String name;
	private Integer level;
}
