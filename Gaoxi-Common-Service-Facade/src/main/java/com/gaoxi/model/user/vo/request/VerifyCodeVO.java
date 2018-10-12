package com.gaoxi.model.user.vo.request;




import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *<p>Description: 获取验证码的请求参数</p>  
 *@author wh
 *@date 2018年10月12日 
 *@version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifyCodeVO {
	/**
	 * 手机号码
	 */
	@NotNull
	private String phone;
}
