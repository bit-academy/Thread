public class ThreadTest6 extends Thread {
    @Override
    public void run() {
        System.out.println("스레드 시작");

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("스레드 종료");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new ThreadTest6();
        thread.start();

        System.out.println("join 시작");

        synchronized (thread) {
            thread.join();
        }

        System.out.println("join 종료");
    }
}
