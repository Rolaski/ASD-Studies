package greedyAlgorithms;

public class icecreamGreedy
{
    final static int N = 6;
    private static int[] kolejnosc = new int[N];
    private static boolean[] odwiedzone = new boolean[N];

    static int[][] czasy = {
            {0, 7, 20, 0, 12, 23},
            {27, 0, 13, 16, 0, 5},
            {53, 0, 0, 25, 27, 6},
            {16, 2, 35, 0, 47, 0},
            {31, 29, 0, 18, 0, 4},
            {0, 24, 1, 17, 5, 0}
    };

    static int minCzas = Integer.MAX_VALUE;
    static String lody = "";

    static void zachlanniePermutacje()
    {
        int aktualnyCzas = 0;
        String aktualneLody = "";
        int obecnySmak = 0;

        for (int i = 0; i < N; i++) {
            int najkrotszyCzas = Integer.MAX_VALUE;
            int wybranySmak = -1;
            kolejnosc[i] = obecnySmak;
            odwiedzone[obecnySmak] = true;
            aktualneLody += (obecnySmak + 1) + ", ";

            for (int j = 0; j < N; j++) {
                if (!odwiedzone[j] && czasy[obecnySmak][j] < najkrotszyCzas) {
                    najkrotszyCzas = czasy[obecnySmak][j];
                    wybranySmak = j;
                }
            }

            if (wybranySmak != -1) {
                aktualnyCzas += najkrotszyCzas;
                obecnySmak = wybranySmak;
            }
        }
        aktualnyCzas += czasy[obecnySmak][kolejnosc[0]];
        aktualneLody += (kolejnosc[0] + 1);

        if (aktualnyCzas < minCzas) {
            minCzas = aktualnyCzas;
            lody = aktualneLody;
        }

        System.out.println("LODY: " + aktualneLody + " CZAS: " + aktualnyCzas);
    }

    public static void main(String[] args) {
        zachlanniePermutacje();
        System.out.println(">> NAJLEPSZE:\n\tCzas: " + minCzas + "\tSekwencja: " + lody);
    }
}
