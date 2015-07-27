public class ThreadTest4 extends Thread {
	public void run() {
		while (true) {
			System.out.print("Runnable ");
			try {
				sleep(1000);
			} catch (InterruptedException ie) {
				System.out.println("중지신호가 처리되었습니다.");
				break;
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest4 thread1 = new ThreadTest4();
		thread1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException ie) {
		}

		System.out.print(" 중지신청을 합니다. ");
		thread1.interrupt();
	}
}
