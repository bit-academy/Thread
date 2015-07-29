public class ThreadGroupTest extends Thread {
    public ThreadGroupTest(ThreadGroup group, String name) {
        super(group, name);
    }

    public void run() {
        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException ie) {
                System.err.println(getName() + " - 중지신호가 처리되었습니다.");
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("my group");

        ThreadGroupTest thread1 = new ThreadGroupTest(group, "1");
        ThreadGroupTest thread2 = new ThreadGroupTest(group, "2");
        ThreadGroupTest thread3 = new ThreadGroupTest(group, "3");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("ThreadGroup count: " + group.activeCount());

        Thread.sleep(3000);

        System.out.println("중지신청을 합니다. ");
        group.interrupt();
    }
}
