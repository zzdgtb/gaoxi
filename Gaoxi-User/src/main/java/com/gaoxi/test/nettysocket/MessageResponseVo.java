package com.dtyunxi.iservice.agent.app.api.vo.response;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: 聊天信息回复
 * @author: 西门
 * @Date: 2018/12/18
 * @version: 1.0.0
 */
public class MessageResponseVo implements Serializable {

    private static final long serialVersionUID = 9177783394876553164L;
    /**
     * 回复内容
     */
    private String content;
    /**
     * 建议列表
     */
    private List<String> recommondLists;

    public String getContent() {
        return content;
    }

    public MessageResponseVo setContent(String content) {
        this.content = content;
        return this;
    }

    public List<String> getRecommondLists() {
        return recommondLists;
    }

    public MessageResponseVo setRecommondLists(List<String> recommondLists) {
        this.recommondLists = recommondLists;
        return this;
    }
}
