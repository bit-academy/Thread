public class UEHandlerTest extends Thread implements
		Thread.UncaughtExceptionHandler {
	public static void main(String[] args) {
		Thread thread = new UEHandlerTest();
		thread.setName("UE 테스트");

		Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler) thread);

		thread.start();
	}

	public void run() {
		int i = 5 / 0;
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.err.printf("'%s' 스레드에서 예외 '%s' 발생", t.getName(), e.getMessage());
	}
}
