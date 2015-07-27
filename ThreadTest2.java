public class ThreadTest2 extends Thread
{
    public ThreadTest2(String name)
    {
        super(name);
    }

    public void run()
    {
        for (int i=0; i<1000; i++)
        {
            System.out.print(getName());
        }
    }

    public static void main(String[] args)
    {
        ThreadTest2 thread1=new ThreadTest2("1");
        ThreadTest2 thread2=new ThreadTest2("2");

        thread1.setPriority(MIN_PRIORITY);
        thread2.setPriority(MAX_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
