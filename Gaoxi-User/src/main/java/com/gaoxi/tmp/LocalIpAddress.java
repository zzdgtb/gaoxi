package com.gaoxi.tmp;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/29
 * @version: 1.0.0
 */
public class LocalIpAddress {
    public LocalIpAddress() {
    }

    public static List<InetAddress> resolveLocalAddresses() {
        List<InetAddress> addrs = new ArrayList();
        Enumeration ns = null;

        try {
            ns = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException var5) {
        }

        while(ns != null && ns.hasMoreElements()) {
            NetworkInterface n = (NetworkInterface)ns.nextElement();
            Enumeration is = n.getInetAddresses();

            while(is.hasMoreElements()) {
                InetAddress i = (InetAddress)is.nextElement();
                if (!i.isLoopbackAddress() && !i.isLinkLocalAddress() && !i.isMulticastAddress() && !isSpecialIp(i.getHostAddress())) {
                    addrs.add(i);
                }
            }
        }

        return addrs;
    }

    public static String resolveLocalIp() {
        System.out.println("[DTYUNXI] resolving local IP address...");
        List<InetAddress> addrs = resolveLocalAddresses();
        String ip = null;
        if (!addrs.isEmpty()) {
            ip = ((InetAddress)addrs.get(0)).getHostAddress();
        }

        System.out.println("[DTYUNXI] resolving local IP address..." + ip);
        return ip;
    }

    public static List<String> resolveLocalIps() {
        List<InetAddress> addrs = resolveLocalAddresses();
        List<String> ret = new ArrayList();
        Iterator var2 = addrs.iterator();

        while(var2.hasNext()) {
            InetAddress addr = (InetAddress)var2.next();
            ret.add(addr.getHostAddress());
        }

        return ret;
    }

    private static boolean isSpecialIp(String ip) {
        if (ip.contains(":")) {
            return true;
        } else if (ip.startsWith("127.")) {
            return true;
        } else if (ip.startsWith("169.254.")) {
            return true;
        } else {
            return ip.equals("255.255.255.255");
        }
    }
}
