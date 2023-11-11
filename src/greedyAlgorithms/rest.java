package greedyAlgorithms;
import java.io.*;

public class rest
{
    public static void main(String[] args) throws IOException
    {
        InputStreamReader str = new InputStreamReader(System.in);
        BufferedReader wejscie = new BufferedReader(str);
        String tekst;
        final int[] M = {500,200,100,50,20,10,5,2,1};
        final int[] L = {50,30,20,20,20,20,20,20,20};
        int[] monetki = new int[9];
        int zl, gr, r, i = 0;
        System.out.println("Podaj reszte..");
        System.out.print("zlotych: ");
        tekst = wejscie.readLine();

        zl = Integer.parseInt(tekst);
        System.out.print("groszy: ");
        tekst = wejscie.readLine();
        gr = Integer.parseInt(tekst);

        System.out.print("Reszta: ");
        r = zl*100 + gr;
        while (r > 0 && i<M.length)
        {
            if (r >= M[i] && L[i] >0)
            {
                    monetki[i]++;
                    System.out.print(M[i]/100.0 + " ");
                    r = r - M[i];
                    L[i]--;
            }
            else
                i++;
        }
        System.out.println();


        System.out.println("\n======================");
        System.out.println("ilosc 5: "+monetki[0]);
        System.out.println("ilosc 2: "+monetki[1]);
        System.out.println("ilosc 1: "+monetki[2]);
        System.out.println("ilosc 0.5: "+monetki[3]);
        System.out.println("ilosc 0.2: "+monetki[4]);
        System.out.println("ilosc 0.1: "+monetki[5]);
        System.out.println("ilosc 0.05: "+monetki[6]);
        System.out.println("ilosc 0.02: "+monetki[7]);
        System.out.println("ilosc 0.01: "+monetki[8]);
        if(r>0)
        {
            System.out.println("NIE MOŻNA WYDAĆ CAŁEJ RESZTY, BRAKUJĄCA: "+r/100+"ZŁ");
        }
    }
}

//zad domowe
//plecak - algorytm zachłanny
//pakujemy wszystko od najwiekszej wartosci I W DRUGA STRONE
//objetosc od najwiekszej do najmniejszej I W DRUGA STRONE
//stosunek wartosci do objetnosci, wartosc/objetosc.
//to sa 3 strategie do zrobienia

