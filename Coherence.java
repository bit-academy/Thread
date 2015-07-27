/**
 * This class checks to see if a Java Virtual Machine
 * respects the Java Memory Model, as described in
 * Chapter 17 of the Java Language Specification.
 *
 * The Java Memory Model prohibits certain compiler optimizations.
 * In particular, it requires that for each memory location in isolation,
 * the reads and writes to that memory location have sequentially
 * consistent semantics. One effect of this is that once a thread
 * sees a write to a variable by another thread, it cannot forget that
 * it has seen the write.
 *
 * In particular, for the code sequence:
 *
 *    i = p.x;
 *    j = q.x;
 *    k = p.x;
 *
 * the compiler may not eliminate the second load of p.x unless
 * it can prove that q and p do not point to the same object,
 * or that no other thread can update p.x.
 *
 * This is spelled out in much more detail in
 *
 * "Fixing the Java Memory Model", William Pugh, ACM SIGPLAN Java Grande
 * Conference, 1999, available from http://www.cs.umd.edu/~pugh/java.
 *
 */
import java.awt.Point;

public strictfp class Coherence
{
    static Point p = new Point();
    static Point q = p;

    public strictfp static void check()
    {
        boolean optimizationDone = true;
        boolean interleavingSeen = false;
        boolean loopHoistingDone = true;
        Point pp = p;
        Point qq = q;
        int i, i0, j, k, m;
        i = 0;
        for (int l = 0; l < 10000000; l++)
        {
            i0 = i;
            i = pp.x;
            j = qq.x;
            k = pp.x;
            m = pp.x;

            if (l > 0 && i0 != i)
                loopHoistingDone = false;
            if (k != m)
                optimizationDone = false;
            if (i != j)
                interleavingSeen = true;
            if (j > k)
            {
                System.out.println(
                                   "i = " + i
                                   + ", j = " + j
                                   + ", k = " + k
                                   + ", j > k -- in violation of JMM");
                System.exit(0);
            }
        }
        if (!optimizationDone)
        {
            System.out.println("optimization not done (yet)");
            interleavingSeen = false;
        } else if (loopHoistingDone)
            System.out.println(
                       "Extremely poor interleaving or Loop hoisting done");
        else if (!interleavingSeen)
            System.out.println("no intra-loop interleaving seen");
        else
            System.out.println(
                "Saw intra-loop interleaving and only legal optimizations");
        Thread.yield();

    }


    public static void main(String args[])
    {
        Thread t1 = new Thread()
        {
            public void run()
            {
                while (true)
                {
                    for (int l = 0; l < 10000000; l++)
                    {
                        p.x++;
                    }
                    Thread.yield();
                }
            }
        };
        Thread t2 = new Thread()
        {
            public void run()
            {
                for (int l = 0; l < 10; l++)
                    check();
                System.out.println("No violation of the JMM detected");
                System.exit(0);
            }
        };
        t1.start();
        t2.start();
    }
}
