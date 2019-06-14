package com.gaoxi;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class LogSetting {
    public LogSetting() {
    }

    public static void setUserId(Long userId) {
        MDC.put("yes.req.userId", String.valueOf(userId));
        String[] requestKeys = new String[]{"yes.req.userId"};

        for (int i = 0; i < requestKeys.length; ++i) {
            System.out.println("===LoggerFilters " + requestKeys[i] + ": " + MDC.get(requestKeys[i]));
        }

    }

    public static void initLogger() {
        String ip = LocalIpAddress.resolveLocalIp();
        if (ip == null) {
            ip = "127.0.0.1";
        }

        MDC.put("yes.server.localHost", ip);
        System.setProperty("yes.server.localHost", ip);
    }
}