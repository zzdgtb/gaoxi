package com.gaoxi.tmp;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class LoggerServletFilter implements Filter, LogConstants {
    public LoggerServletFilter() {
    }

    /** @deprecated */
    @Deprecated
    public static void initLogger() {
        LogSetting.initLogger();
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        this.beforeFilter(request);

        try {
            chain.doFilter(request, response);
        } finally {
            this.afterFilter();
        }

    }

    void beforeFilter(ServletRequest request) {
        MDC.put("yes.req.remoteHost", request.getRemoteHost());
        MDC.put("yes.req.remoteAddr", request.getRemoteAddr());
        MDC.put("yes.req.remotePort", String.valueOf(request.getRemotePort()));
        MDC.put("yes.req.localAddr", request.getLocalAddr());
        MDC.put("yes.req.localPort", String.valueOf(request.getLocalPort()));
        String requestId = request.getParameter("reqId");
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            MDC.put("yes.req.requestURI", httpServletRequest.getRequestURI());
            StringBuffer requestURL = httpServletRequest.getRequestURL();
            if (requestURL != null) {
                MDC.put("yes.req.requestURL", requestURL.toString());
            }

            MDC.put("yes.req.method", httpServletRequest.getMethod());
            MDC.put("yes.req.queryString", httpServletRequest.getQueryString());
            MDC.put("yes.req.userAgent", httpServletRequest.getHeader("User-Agent"));
            MDC.put("yes.req.xForwardedFor", httpServletRequest.getHeader("X-Forwarded-For"));
            if (requestId == null) {
                requestId = httpServletRequest.getHeader(AbstractMicroServiceContext.createContextKey("yes.req.requestId"));
            }
        }

        if (requestId == null) {
            requestId = RequestId.createReqId();
        }

        MDC.put("yes.req.requestId", requestId);
        MDC.put("yes.req.userId", "anonymous");
        ServiceContext.getContext().setAttachment("yes.req.requestId", requestId);
    }

    void afterFilter() {
        MDC.remove("yes.req.remoteHost");
        MDC.remove("yes.req.remoteAddr");
        MDC.remove("yes.req.remotePort");
        MDC.remove("yes.req.localAddr");
        MDC.remove("yes.req.localPort");
        MDC.remove("yes.req.requestURI");
        MDC.remove("yes.req.requestURL");
        MDC.remove("yes.req.method");
        MDC.remove("yes.req.queryString");
        MDC.remove("yes.req.userAgent");
        MDC.remove("yes.req.xForwardedFor");
        MDC.remove("yes.req.requestId");
        MDC.remove("yes.req.userId");
        ServiceContext.getContext().removeAttachment("yes.req.requestId");
    }

    public void destroy() {
    }
}