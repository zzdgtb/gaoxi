package com.gaoxi;
public class Count {
    int num = 200;
 
    public void count_num() {
        this.num--;
    }
 
    public static void main(String args[]) {
        Count c = new Count();
        ThreadNum t1 = new ThreadNum(c);
        ThreadNum t2 = new ThreadNum(c);
        ThreadNum t3 = new ThreadNum(c);
        ThreadNum t4 = new ThreadNum(c);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
 
class ThreadNum extends Thread {
    Count t_;
    String name;
 
    public ThreadNum(Count t) {
        this.t_ = t;
    }
 
    public void run() {
       while (true) {
            synchronized (t_) {
                this.name = Thread.currentThread().getName();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(t_.num > 0){
                    t_.count_num();
                     
                }else{
                    break;
                }
                System.out.println(this.name + " " + t_.num);               
            }
        }
    }
}