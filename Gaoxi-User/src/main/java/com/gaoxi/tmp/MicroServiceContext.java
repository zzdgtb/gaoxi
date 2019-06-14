package com.gaoxi;

import java.util.Map;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public interface MicroServiceContext {
    String CONTEXT_PREFIX = "x-dtyunxi-context-";

    void setAttachment(String var1, String var2);

    String getAttachment(String var1);

    void removeAttachment(String var1);

    Map<String, String> getAttachments();

    void removeContext();
}