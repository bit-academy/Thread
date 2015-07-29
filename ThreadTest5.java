public class ThreadTest5 extends Thread {
    private static Object myLock = new Object();

    @Override
    public void run() {
        try {
            System.out.println(holdsLock(myLock));
            // myLock.wait(1000);

            synchronized (myLock) {
                System.out.println(holdsLock(myLock));
                myLock.wait(1000);
            }

            System.out.println(holdsLock(myLock));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ThreadTest5().start();
    }
}
