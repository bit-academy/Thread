public class ThreadTest4 extends Thread
{
    public void run()
    {
        while(true)
        {
            System.out.print("Runnable ");
            try
            {
                    sleep(1000);
            } catch(InterruptedException ie)
            {
                    System.out.println("������ȣ�� ó���Ǿ����ϴ�.");
                    break;
            }
        }
    }

    public static void main(String[] args)
    {
        ThreadTest4 thread1=new ThreadTest4();
        thread1.start();

        try
        {
                Thread.sleep(3000);
        } catch(InterruptedException ie)
        {
        }

        System.out.print(" ������û�� �մϴ�. ");
        thread1.interrupt();
    }
}
