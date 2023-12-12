package EXAM;

public class taskFirst
{
    public static void main(String[] args)
    {
        //wywolanie funkcji z obliczeniem 8 wyrazu ciagu
        System.out.printf("9 wyraz ciagu: "+ciag(8));
    }

    public static int ciag(int n)
    {
        if(n==1)
        {
            return 2;
        }
        else if(n==2)
        {
            return 4;
        }
        else
        {
            return (ciag(n-1)*ciag(n-2))/2;
        }
    }
}
