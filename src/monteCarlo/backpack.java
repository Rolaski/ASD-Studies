package monteCarlo;

import java.util.Random;
import java.util.Scanner;

public class backpack
{
    static int[] booksId = {0,1,2,3,4,5};
    static int[] volume = {6, 2, 3, 2, 3, 1};
    static int[] worth = {6, 4, 5, 7, 10, 2};
    static int draw = 100;


    public static void main(String[] args)
    {
        Random random = new Random();
        String[] actualSolution;
        String[] bestSolution = new String[6];
        int minWorth = 1;
        int actualBook;

        int bpV = scanner("Enter your backpack volume: ");


        for(int i=0; i<draw; i++)
        {
            int booksVolume = 0;
            int booksWorth = 0;
            int[] quantity = {1,1,1,1,1,1};
            actualSolution= new String[6];

            while(booksVolume<bpV)
            {
                actualBook = booksId[random.nextInt(booksId.length)];
                if(quantity[actualBook] == 1)
                {
                    actualSolution[actualBook] = String.valueOf(actualBook);
                    booksVolume = booksVolume + volume[actualBook];
                    booksWorth = booksWorth + worth[actualBook];
                    quantity[actualBook] = 0;
                }

            }
            if(booksVolume <= bpV && booksWorth > minWorth)
            {
                minWorth = booksWorth;
                for(int j=0; j<6; j++)
                {
                    bestSolution[j] = actualSolution[j];
                }
            }
        }

        //sprawdzanie czy tablica najlepszych rozwiazan nie jest czasem pusta, czyli brak rozwiazan
        boolean isNull = true;
        for (String id : bestSolution)
        {
            if (id != null)
            {
                isNull = false;
                break;
            }
        }
        //wypisywanie czy mamy rozwiazanie czy go nie mamy
        if (isNull)
        {
            System.out.println("I didn't found solution");
        }
        else
        {
            System.out.print("packs books with numbers: ");
            for(int i=0; i<6; i++)
            {
                if(bestSolution[i] == null)
                {
                    continue;
                }
                System.out.print(bestSolution[i]+", ");
            }
        }
    }

    public static int scanner(String dscrb)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(dscrb);
        return scanner.nextInt();
    }
}
