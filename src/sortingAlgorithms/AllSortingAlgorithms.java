package sortingAlgorithms;

import java.util.Random;

//sorting algorithms for array
public class AllSortingAlgorithms {
    private static int[] table;
    private static int N = 10;

    public static void main(String[] args)
    {
        table = new int[N];

        Random rand = new Random();
        for (int i=0; i<table.length; i++) {
            table[i]=rand.nextInt(100);
        }

        System.out.println("Przed sortowaniem:");
        print();

        bubbleSort();
//        selectionSort();
//        insertionSort();
//        quickSort(0,table.length-1);
//        mergeSort(0,table.length-1);

        System.out.println("Po sortowaniu:");
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

    public static void selectionSort()
    {
        for (int i = 0; i < table.length - 1; i++)
        {
            System.out.print("i="+i+" Przed: ");
            for (int j=0; j<table.length; j++)
                System.out.print(table[j]+" ");

            int minPos = i;
            for (int j = i + 1; j < table.length; j++)
            {
                if (table[j] < table[minPos])
                {
                    minPos = j;
                }
            }
            swap(i, minPos);

            System.out.print(" Po: ");
            for (int j=0; j<table.length; j++)
                System.out.print(table[j]+" ");
            System.out.println();
        }
    }



    public static void insertionSort()
    {
        for (int i = 1; i < table.length; i++)  // i to pozycja pierwego nieposortowanego elementu
        {
            int e = table[i]; // kopiujemy wyróżniony element

            System.out.print("i="+i+" temp="+e+" Przed: ");
            for (int j=0; j<table.length; j++)
            {
                System.out.print(table[j]+" ");
            }

            int j = i;           // zaczynamy przesuwanie od i
            while (j > 0 && table[j - 1] >= e) // dopóki elementy są większe niż temp
            {
                table[j] = table[j - 1];    // przesuwamy elementy w prawo w celu zrobienia miejsca na temp
                j--;                       // przesuwamy się w lewo
            }
            table[j] = e;   // wstawiamy wyróżniony element w nowym miejscu

            System.out.print(" Po: ");
            for (j=0; j<table.length; j++)
            {
                System.out.print(table[j]+" ");
            }
            System.out.println();
        }
    }

    public static void quickSort(int left,int right)
    {
        if (left<right)
        {
            int pivot = table[left];
            int s=left;
            for (int i=left+1; i<=right; i++)
            {
                if (table[i]<pivot)
                {
                    s=s+1;
                    swap(s,i);
                }
            }

            swap(left,s);

            quickSort(left,s-1);
            quickSort(s+1,right);
        }
    }

    public static void merge(int left,int mid,int right) //łącz fragment od l do mid z fragmentem od mid+1 do r
    {
        int [] tab = new int[right-left+1]; //Tworz tablice pomocnicza

        int k = 0; //Indeks w scalanej tablicy
        int i = left; //Indeks w pierwszym fragmencie do scalenia
        int j = mid+1; //Indeks w drugim fragmencie do scalenia

        while ((i<mid+1) || (j<right+1)) //...az do konca obydwu scalanych fragmentow
        {
            if (i==mid+1) //Jesli pierwszy fragment juz jest scalony...
            {
                tab[k] = table[j]; k++; j++; //...kopiuj kolejna liczbe z drugiego fragmentu
            }
            else if (j == right + 1) //Jesli drugi fragment juz jest scalony...
            {
                tab[k] = table[i]; k++; i++; //...kopiuj kolejna liczbe z pierwszego fragmentu
            }
            else //Scalanie elementow z obydwu fragmentow
            {
                if (table[i] <= table[j]) //Element z pierwszego fragmentu jest mniejszy i ma byc scalony jako pierwszy
                {
                    tab[k] = table[i]; i++; //... i jest scalany jako pierwszy
                }
                else // table[j]<table[i], czyli element z drugiego fragmentu jest mniejszy
                {
                    tab[k] = table[j];  j++; //... i jest scalany jako pierwszy
                }
                k++; //Przechodzimy do nastepnej pozycji scalanej tablicy
            }
        }

        //Przepisanie zawartosci tablicy pomocniczej do tablicy table
        int l = left;
        for (i=0; i<tab.length; i++)
        {
            table[l] = tab[i]; l++;
        }
    }

    public static void mergeSort(int left, int right) //Sortowanie przez scalanie
    {
        if (left < right)
        {
            int mid = (left + right) / 2;  //Wyliczenie srodka
            mergeSort(left, mid); //Sortowanie lewej czesci
            mergeSort(mid + 1, right); //Sortowanie prawej czesci
            merge(left, mid, right); //Sacalnie posortowanych czesci
        }
    }
    //--------------------------------------------------------------
    public static void swap(int one, int two) //Zamiana elementow tablicy
    {
        int temp = table[one];
        table[one] = table[two];
        table[two] = temp;
    }
//--------------------------------------------------------------

    public static void print()
    {
        for (int i = 0; i < table.length; i++)
        {
            System.out.print(table[i] + " ");
        }
        System.out.println();
    }
}