public class ThreadTest1 extends Thread
{
    int �ֱ�;
    int number;

    public ThreadTest1(String name, int �ֱ�)
    {
        super(name);
        this.�ֱ�=�ֱ�;
    }

    public void run()
    {
        while (true)
        {
            try
            {
                sleep(�ֱ�);
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
        ThreadTest1 first=new ThreadTest1("ù ��°", 1000);
        ThreadTest1 second=new ThreadTest1("�� ��°", 2000);
        ThreadTest1 third=new ThreadTest1("�� ��°", 3000);

        first.start();
        second.start();
        third.start();
    }
}
