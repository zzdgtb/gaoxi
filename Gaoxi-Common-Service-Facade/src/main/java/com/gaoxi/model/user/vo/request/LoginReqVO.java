package com.gaoxi.model.user.vo.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 *<p>Description: </p>  
 *@author wh
 *@date 2018年10月12日 
 *@version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginReqVO implements Serializable{
	
	private static final long serialVersionUID = -3639129842912671921L;
	@NotBlank
	private String phone;
	@NotBlank
	private String verifycode;

	
}
