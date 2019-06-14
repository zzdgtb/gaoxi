package com.gaoxi.tmp;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class RequestId {
    private static AtomicLong lastId = new AtomicLong();
    private static final long startTimeStamp = System.currentTimeMillis();
    private static final String ip = LocalIpAddress.resolveLocalIp();

    public RequestId() {
    }

    public static String createReqId() {
        return (hexIp(ip) + "-" + Long.toString(startTimeStamp, 36)).toUpperCase() + "-" + lastId.incrementAndGet();
    }

    private static String hexIp(String ip) {
        StringBuilder sb = new StringBuilder();
        String[] var2 = ip.split("\\.");
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            String seg = var2[var4];
            String h = Integer.toHexString(Integer.parseInt(seg));
            if (h.length() == 1) {
                sb.append("0");
            }

            sb.append(h);
        }

        return sb.toString();
    }
}
