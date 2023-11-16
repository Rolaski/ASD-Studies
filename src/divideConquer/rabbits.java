package divideConquer;

import java.util.Scanner;

public class rabbits
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of months: ");
        int month = scanner.nextInt();

        System.out.println("Number of rabbits:  "+(fibbo(month))*2);
    }

    public static int fibbo(int t)
    {
        if(t ==1 || t==2)
        {
            return 1;
        }
        else if(t<=0)
        {
            return 0;
        }
        else
        {
            return fibbo(t-1)+fibbo(t-2);
        }
    }
}
