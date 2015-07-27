public class ThreadTest1 extends Thread
{
    int 주기;
    int number;

    public ThreadTest1(String name, int 주기)
    {
        super(name);
        this.주기=주기;
    }

    public void run()
    {
        while (true)
        {
            try
            {
                sleep(주기);
            } catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }

            System.out.println(getName() + " : " + number++);
            if (number>10)
            {
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        ThreadTest1 first=new ThreadTest1("첫 번째", 1000);
        ThreadTest1 second=new ThreadTest1("두 번째", 2000);
        ThreadTest1 third=new ThreadTest1("세 번째", 3000);

        first.start();
        second.start();
        third.start();
    }
}
