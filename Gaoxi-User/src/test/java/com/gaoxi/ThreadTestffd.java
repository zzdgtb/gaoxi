package com.gaoxi;
 
 
public class ThreadTestffd {
 
 
	private static Integer a = 1;
	private static Integer b = 1;
	public static void main(String[] args) {
		ThreadTestffd test = new ThreadTestffd();
		test.A();
		//ThreadTestffd test2 = new ThreadTestffd();
		test.B();
		System.out.println(test.a==test.b);
	}
 public static synchronized void a(){
	 System.out.println("A线程准备");
	 
	 
		//synchronized (a) {
			System.out.println("A线程开始");
			for (int i = 0; i < 10; i++) {
				System.out.println("a" + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			//}
		}
 }
 
	public   void A() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				a();
			}
		}).start();
	}
 

	public void B() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("B线程准备");
				synchronized (ThreadTestffd.class) {
					System.out.println("B线程开始");
					for (int i = 0; i < 10; i++) {
						System.out.println("b" + i);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
}
