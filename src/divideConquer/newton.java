package divideConquer;

public class newton
{
    public static void main(String[] args)
    {
        final int n=5;
        final int k=3;
        System.out.println("Newton's binomial for "+n+","+k+" is:");
        System.out.println(newton(n,k));
    }

    public static int newton(int n, int k)
    {
        if(k==0 || k==n)
        {
            return 1;
        }
        else
        {
            return newton(n-1, k-1) + newton(n-1,k);
        }
    }
}
