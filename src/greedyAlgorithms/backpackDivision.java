package greedyAlgorithms;
public class backpackDivision
{
    static int bpV = 10;
    static int[] volume = {6, 2, 3, 2, 3, 1};
    static int[] worth = {6, 4, 5, 7, 10, 2};
    static double[][] result = {{0, 1, 2, 3, 4, 5}, {0, 0, 0, 0, 0, 0}};

    public static void main(String[] args)
    {
        calculateRatios();
        sortDivision();

        //ładowanie plecaka książkami
        for(int i=0; i< volume.length; i++)
        {
            if(bpV - volume[(int) result[0][i]] >=0)
            {
                bpV = bpV - volume[(int) result[0][i]];
                System.out.println("book number: "+ (int) result[0][i]+" free space left: "+ bpV);
            }
        }
    }

    //obliczanie objetosci przez wartosc ksiazek
    public static void calculateRatios()
    {
        for (int i = 0; i < volume.length; i++)
            result[1][i] = (double) volume[i] / worth[i];
    }

    //sortowanie wszystkich wartosci
    public static void  sortDivision()
    {
        for (int i = 0; i < volume.length; i++)
            for (int j = i + 1; j < volume.length; j++)
                if (result[1][i] < result[1][j]) {
                    swapIndices(i, j);
                    swapValues(i, j);
                }
    }

    //sortowanie indeksów
    private static void swapIndices(int i, int j)
    {
        double tempIndex = result[0][i];
        result[0][i] = result[0][j];
        result[0][j] = tempIndex;
    }

    //sortowanie wartości
    private static void swapValues(int i, int j)
    {
        double tempValue = result[1][i];
        result[1][i] = result[1][j];
        result[1][j] = tempValue;
    }

}

