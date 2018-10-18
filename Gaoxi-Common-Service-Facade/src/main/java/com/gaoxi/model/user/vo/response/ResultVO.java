package com.gaoxi.model.user.vo.response;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.gaoxi.utils.ApiErrorType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Description: 返回</p>
 *
 * @author wh
 * @version 1.0.0
 * @date 2018年10月12日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1063278289490780877L;

    private String code;

    private String msg;

    private Object data;

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static ResultVO success(Object data) {
        return new ResultVO("200", "sucess", data);
    }

    /**
     * 失败
     *
     * @param data
     * @return
     */
    public static ResultVO error(Object data) {
        ApiErrorType apiErrorTypenum = ApiErrorType.valueOf(data.toString());
        return new ResultVO(apiErrorTypenum.code, apiErrorTypenum.msg, null);
    }
}
