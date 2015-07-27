public class ThreadTest2 extends Thread
{
    public ThreadTest2(String name)
    {
        super(name);
    }

    public void run()
    {
        for (int i=0; i<10; i++)
        {
            System.out.print(getName()+" ");
            try
            {
                    sleep(400);
            } catch(InterruptedException ie)
            {
            }
        }
    }

    public static void main(String[] args)
    {
        ThreadTest2 thread1=new ThreadTest2("스레드1");
        ThreadTest2 thread2=new ThreadTest2("스레드2");

        thread1.setPriority(MIN_PRIORITY);
        thread2.setPriority(MAX_PRIORITY);

        thread1.start();
        thread2.start();

        try
        {
                Thread.sleep(2000);
        } catch(InterruptedException ie)
        {
        }

        thread1.setPriority(MAX_PRIORITY);
        thread2.setPriority(MIN_PRIORITY);
    }
}
