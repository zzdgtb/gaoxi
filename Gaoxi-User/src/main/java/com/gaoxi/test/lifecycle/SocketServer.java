package com.gaoxi.test.lifecycle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class SocketServer extends DefaultLifeCycleManager {
    private int port = 9527;
    private ServerSocket server;

    @Override
    protected void init0() throws LifeCycleException {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            throw new LifeCycleException(e.getMessage());
        }
    }

    @Override
    protected void start0() throws LifeCycleException {
        Socket socket = null;
        try {
            while(true){
                socket = server.accept();
                Thread thread = new Thread(new Handle(socket));
                thread.start();
            }
        } catch (Exception e) {
            throw new LifeCycleException(e.getMessage());
        } finally {
            if (null != socket) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new LifeCycleException(e.getMessage());
                }
            }
        }
    }

    @Override
    protected void destroy0() throws LifeCycleException {
        if (null != server) {
            try {
                server.close();
            } catch (IOException e) {
                throw new LifeCycleException(e.getMessage());
            }
        }
    }
}
