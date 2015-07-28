public class DaemonTest extends Thread {
	public void run() {
		while (true) {
			System.out.println("살아있음");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println("종료됨");
			}
		});

		Thread thread = new DaemonTest();
		thread.setDaemon(true);
		thread.start();

		Thread.sleep(1000);
	}
}
