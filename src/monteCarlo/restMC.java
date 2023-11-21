package monteCarlo;

import java.util.Random;
import java.util.Scanner;

public class restMC
{
    static final int[] coins = {500, 200, 100,50,20,10,5,2,1};
    static final int coinLimit = 11;
    static final int draws = 10000;
    static int minCoins = draws;

    public static void main(String[] args)
    {
        int suma =0;
        //losowanie monety
        Random random = new Random();

        //tablica wydanych monet dla NAJLEPSZEGO rozwiazania
        int[] bestCoinsIssued = new int[coinLimit];
        int actualCoin, zl, gr, r;



        zl = scanner("Enter the number of Polish zlotys: ");
        gr = scanner("Enter the number of Polish groszy: ");

        for(int i=0; i<draws; i++)
        {
            //tablica wydanych monet dla danego rozwiazania
            int[] actualCoinsIssued = new int[coinLimit];

            int coinsIssued = 0;
            r = zl*100+gr;
            while(r>0 && coinsIssued < coinLimit)
            {
                actualCoin = coins[random.nextInt(coins.length)]; //losowanie monety z tablicy
                if(r >= actualCoin)
                {
                    actualCoinsIssued[coinsIssued] = actualCoin;
                    r = r - actualCoin;
                    coinsIssued++;
                }
            }
            //wybor najlepszego rozwiazania
            if(coinsIssued < minCoins)
            {
                minCoins = coinsIssued;
                for(int j=0; j<coinsIssued; j++)
                {
                    bestCoinsIssued[j] = actualCoinsIssued[j];
                }
            }
        }
        //jesli najlepsze losowe rozwiazanie miesci sie w limicie
        if(minCoins < draws)
        {
            System.out.print("Rest: ");
            for(int i=0; i<minCoins; i++)
            {
                System.out.print(bestCoinsIssued[i]/100.0 +" ");
                suma = suma + bestCoinsIssued[i];
            }
        }
        else
        {
            System.out.println("i didn't found solution");
        }
        System.out.println("\nsuma: "+(suma/100.0));

    }

    public static int scanner(String dscrb)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(dscrb);
        return scanner.nextInt();
    }
}