package dynamic;

import java.util.Scanner;

public class rabbitsDynamic
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of months: ");
        int month = scanner.nextInt();

        System.out.println("Number of rabbits:  "+(rabbits(month))*2);
    }

    public static int rabbits(int month)
    {
        int[] rabbits = new int[month];

        rabbits[0] = 1;
        rabbits[1] = 1;

        for(int i=2; i<month; i++)
        {
            rabbits[i] = rabbits[i-1] + rabbits[i-2];
        }
        return rabbits[month-1];
    }

}
