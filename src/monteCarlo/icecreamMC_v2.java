package monteCarlo;

import java.util.Random;

public class icecreamMC_v2
{
    public static final int[][] czas =
            {{0, 7, 20, 21, 12, 23},
                    {27, 0, 13, 16, 46, 5},
                    {53, 15, 0, 25, 27, 6},
                    {16, 2, 35, 0, 47, 10},
                    {31, 29, 5, 18, 0, 4},
                    {28, 24, 1, 17, 5, 0}};
    public static final int N = czas.length;

    public static int czasBest = Integer.MAX_VALUE;
    public static int[] listaBest = new int[N+1];

    public static void main(String[] args) {
        Random r = new Random();
        for(int i=0; i<100; i++)
        {
            boolean[] tabID = {false, false, false, false, false, false};
            boolean allUsed = false;

            int[] listaAktual=new int[N+1];

            int q=0;
            while(!allUsed)
            {
                int x = r.nextInt(6);

                if(!tabID[x])
                {
                    tabID[x]=true;
                    listaAktual[q]=x; q++;

                    allUsed=true;
                    for(int k=0; k<N; k++) if (!tabID[k]) allUsed=false;
                }
            }
            listaAktual[N]=listaAktual[0];

            int czasAktual=0;
            for(int k=1; k<N; k++)
            {
//                System.out.print(listaAktual[k-1]+" - " + czas[listaAktual[k-1]][listaAktual[k]] +" -> "+listaAktual[k]+"\t");
                czasAktual+=czas[listaAktual[k-1]][listaAktual[k]];
            }
//            System.out.print(listaAktual[N-1]+ "- "+ czas[listaAktual[N-1]][listaAktual[N]] +" -> "+listaAktual[N]);
            czasAktual+=czas[listaAktual[N-1]][listaAktual[N]];
//            System.out.print("\t\t"+czasAktual);

            if(czasAktual<czasBest)
            {
                czasBest=czasAktual; listaBest=listaAktual.clone();
            }

//            System.out.println();
        }
        System.out.println("Najlepszy wynik: ");
        for(int k=0; k<N+1; k++) System.out.print(listaBest[k]);
        System.out.print("\t\t czas: "+czasBest);



    }
}
