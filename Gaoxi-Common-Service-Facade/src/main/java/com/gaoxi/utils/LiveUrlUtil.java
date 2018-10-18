package com.gaoxi.utils;

import java.text.ParseException;

public class LiveUrlUtil {


    /**
     * 获取推流url
     *
     * @param bizid
     * @param pushkey
     * @param stream_id
     * @param livehours
     * @return
     * @throws ParseException
     */
    public static String getPushUrl(String bizid, String pushkey, String stream_id, int livehours) throws ParseException {

        return new StringBuilder().append("rtmp://")
                .append(bizid)
                .append(".livepush.myqcloud.com/live/")
                .append(stream_id)
                .append("?")
                .append(SafeKeyUtil.getSafeUrl(pushkey, stream_id, DateUtil.parseToUnix(DateUtil.getDateSomeHoursBehind(livehours))))
                .toString();
    }

    /**
     * 获取播放url-mp4格式
     *
     * @param bizid
     * @param stream_id
     * @return
     */
    public static String getMp4LiveUrl(String bizid, String stream_id) {
        return new StringBuilder().append("rtmp://").append(bizid).append(".liveplay.myqcloud.com/live/").append(stream_id).toString();
    }

    /**
     * 获取播放url-FLV格式
     *
     * @param bizid
     * @param stream_id
     * @return
     */
    public static String getFlvLiveUrl(String bizid, String stream_id) {
        return new StringBuilder().append("http://").append(bizid).append(".liveplay.myqcloud.com/live/").append(stream_id).append(".flv").toString();
    }

    /**
     * 获取播放url-Hls格式
     *
     * @param bizid
     * @param stream_id
     * @return
     */
    public static String getHlsLiveUrl(String bizid, String stream_id) {
        return new StringBuilder().append("http://").append(bizid).append(".liveplay.myqcloud.com/live/").append(stream_id).append(".m3u8").toString();
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getPushUrl("31884", "0a4c252417b70765ee2f75960438bad3", "31884_test001", 5));
        System.out.println(getMp4LiveUrl("31884", "31884_test001"));
        System.out.println(getFlvLiveUrl("31884", "31884_test001"));
        System.out.println(getHlsLiveUrl("31884", "31884_test001"));
    }
}
