package sortingAlgorithms;

import java.util.Random;

public class bubbleSort
{
    private static int[] table;
    private static int N = 10;

    public static void main(String[] args)
    {
        table = new int[N];

        Random rand = new Random();
        for (int i=0; i<table.length; i++)
        {
            table[i]=rand.nextInt(100);
        }
        System.out.println("Przed sortowaniem:");
        print();

        bubbleSort();
        System.out.println("Po sortowaniem:");
        print();
    }

    public static void bubbleSort()
    {
        for (int i = table.length - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (table[j] > table[j + 1])
                {
                    swap(j, j + 1);
                }
            }
        }
    }

    public static void swap(int one, int two) //Zamiana elementow tablicy
    {
        int temp = table[one];
        table[one] = table[two];
        table[two] = temp;
    }

    public static void print()
    {
        for (int i = 0; i < table.length; i++)
        {
            System.out.print(table[i] + " ");
        }
        System.out.println();
    }
}
