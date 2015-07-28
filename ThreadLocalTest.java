import java.util.Date;

public class ThreadLocalTest extends Thread {
	private static ThreadLocal<Date> threadLocal = new ThreadLocal<Date>();

	public void run() {
		threadLocal.set(new Date());

		while (true) {
			System.out.println(threadLocal.get());

			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ThreadLocalTest().start();
		Thread.sleep(2000);
		new ThreadLocalTest().start();
		Thread.sleep(2000);
		new ThreadLocalTest().start();
	}
}
