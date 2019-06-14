package com.gaoxi;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public interface LogConstants extends ServiceConstants {
    String REQ_REMOTEHOST = "yes.req.remoteHost";
    String REQ_REMOTEADDR = "yes.req.remoteAddr";
    String REQ_REMOTEPORT = "yes.req.remotePort";
    String REQ_LOCALADDR = "yes.req.localAddr";
    String REQ_LOCALPORT = "yes.req.localPort";
    String REQ_REQUESTURI = "yes.req.requestURI";
    String REQ_REQUESTURL = "yes.req.requestURL";
    String REQ_METHOD = "yes.req.method";
    String REQ_QUERYSTRING = "yes.req.queryString";
    String REQ_USERAGENT = "yes.req.userAgent";
    String REQ_XFORWARDEDFOR = "yes.req.xForwardedFor";
    String LOG_VERSION = "yes.log.version";
}