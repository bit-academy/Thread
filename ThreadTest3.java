public class ThreadTest3 extends Thread
{
    static SyncObject sync;
    static
    {
        sync=new SyncObject();
    }

    public ThreadTest3(String name)
    {
        super(name);
    }

    public void run()
    {
        boolean res=false;

        do
        {
            try
            {
                sleep(100);
            } catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }

            res=sync.printOut(this);
        } while(res);
    }

    static class SyncObject
    {
        int i;

        public synchronized boolean printOut(Thread thread)
        {
            if (i>10)
            {
                return false;
            }

            System.out.println(thread.getName() + " : " + i++);
            return true;
        }
    }

    public static void main(String[] args)
    {
        ThreadTest3 thread1=new ThreadTest3("첫 번째");
        ThreadTest3 thread2=new ThreadTest3("두 번째");
        ThreadTest3 thread3=new ThreadTest3("세 번째");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
