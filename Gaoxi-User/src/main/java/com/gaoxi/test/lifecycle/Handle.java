package com.gaoxi.test.lifecycle;
import java.io.*;
import java.net.Socket;

/**
 * @Description:
 * @author: 西门
 * @Date: 2018/12/28
 * @version: 1.0.0
 */
public class Handle implements Runnable {
    private Socket socket;
    public Handle(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr =new InputStreamReader(is);
            BufferedReader br =new BufferedReader(isr);
            String info =null;
            while((info=br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }
            socket.shutdownInput();//关闭输入流
//4、获取输出流，响应客户端的请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("欢迎您！");
            pw.flush();
            pw.close();
            os.close();
            br.close();
            isr.close();
            is.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
