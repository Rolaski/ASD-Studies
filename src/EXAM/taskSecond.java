package EXAM;

public class taskSecond
{
    static String[] city = {"Warszawa", "Katowice","Zakopane", "Lwów", "Wiedeń","Budapeszt","Bukareszt","Zagrzeb","Sofia"};
    static int[][] road = {
            //0    1    2     3    4    5    6    7    8
            {0,   300, 402,  356,  0,   0,   0,   0,  0},   //0
            {300,  0,   0,    0,  440, 474,  0,   0,  0},   //1
            {402,  0,   0,    0,   0,  330,  0,   0,  0},   //2
            {356,  0,   0,    0,   0,   0,  823,  0,  0},   //3
            {0,   440,  0,    0,   0,   0,   0,  430, 0},   //4
            {0,   474, 330,   0,   0,   0,  813, 365,774},  //5
            {0,    0,   0,   823,  0,  813,  0,   0, 403},  //6
            {0,    0,   0,    0,  430, 365,  0,   0, 768},  //7
            {0,    0,   0,    0,   0,  774, 403,  768, 0}   //8
    };

    public static void main(String[] args)
    {
        int maxPolaczen = 0;
        int maxMiasto = 0;
        //szukanie miasta z najwieksza iloscia polaczen
        for(int i=0; i<9; i++)
        {
            if(miastoStartowe(i) > maxPolaczen )
            {
                maxPolaczen = miastoStartowe(i);
                maxMiasto = i;

            }
        }
        System.out.println("Miasto z najwieksza liczba połączen: "+city[maxMiasto]+", ma ich: "+maxPolaczen);

        najkrotszaDroga(maxMiasto);
    }

    public static void najkrotszaDroga(int start)
    {
        int dystans = 0;
        int aktualnyIndeks = start;
        int nowyIndeks = 0;
        int zwiedzoneMiasta = 0; //ma byc 8

        int[] miastaGdzieBylem = {0,0,0,0,0,1,0,0,0};

        int i=0;
        while(i<9)
        {
            System.out.println("Jestem w mieście: "+city[aktualnyIndeks]);
            int minimalnyDystans = Integer.MAX_VALUE;
            for(int j=0; j<road.length; j++)
            {
                if(minimalnyDystans > road[aktualnyIndeks][j] && road[aktualnyIndeks][j] >0)
                {
                    if(miastaGdzieBylem[j] == 0)
                    {
                        minimalnyDystans = road[aktualnyIndeks][j];
                        nowyIndeks = j;
                    }
                }
            }
            miastaGdzieBylem[nowyIndeks] = 1;
            int costam = 0;
            for(int j=0; j<miastaGdzieBylem.length; j++)
            {
                if(miastaGdzieBylem[j] == 1)
                {
                    costam++;
                }
            }
            if(costam == 9)
            {
                System.out.println("\nBYLEM WSZEDZIE GDZIE MOGE");
                System.out.println("Suma dystansu: "+dystans+"\n");
                System.exit(404);
                break;
            }

            System.out.println("Minimalny dystans: "+minimalnyDystans);
            System.out.println("Nowy indeks: "+nowyIndeks+"\n");

            dystans += minimalnyDystans;;
            aktualnyIndeks = nowyIndeks;
            i++;
        }
    }


    public static int miastoStartowe(int start)
    {
        int iloscPolaczen = 0;
        for(int i =0; i<9; i++)
        {
            if(road[start][i] != 0)
            {
                iloscPolaczen++;
            }
        }
        return iloscPolaczen;
    }
}
