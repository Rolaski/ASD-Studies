package EXAM;

public class IcecreamGreedy {
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

    static void zachlanniePermutacje() {
        int aktualnyCzas = 0;
        String aktualneLody = "";

        // Wybór pierwszego smaku na podstawie najmniejszego średniego czasu przestrojenia maszyny
        int obecnySmak = wybierzPierwszySmak();
        kolejnosc[0] = obecnySmak;
        odwiedzone[obecnySmak] = true;
        aktualneLody += (obecnySmak + 1) + ", ";

        // Kolejne smaki wybierane są na podstawie najmniejszego czasu przestrojenia maszyny
        for (int i = 1; i < N; i++) {
            int najkrotszyCzas = Integer.MAX_VALUE;
            int wybranySmak = -1;

            for (int j = 0; j < N; j++) {
                if (!odwiedzone[j]) {
                    int czasPrzestrojenia = czasy[obecnySmak][j]; // Zamiana na kolumnę
                    if (czasPrzestrojenia < najkrotszyCzas && czasPrzestrojenia != 0) {
                        najkrotszyCzas = czasPrzestrojenia;
                        wybranySmak = j;
                    }
                }
            }

            if (wybranySmak != -1) {
                aktualnyCzas += najkrotszyCzas;
                obecnySmak = wybranySmak;
                kolejnosc[i] = obecnySmak;
                odwiedzone[obecnySmak] = true;
                aktualneLody += (obecnySmak + 1) + ", ";
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

    static int wybierzPierwszySmak() {
        int wybranySmak = -1;
        double minSredniCzas = Double.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            double sredniCzas = obliczSredniCzasPrzestrojenia(i);
            if (sredniCzas < minSredniCzas) {
                minSredniCzas = sredniCzas;
                wybranySmak = i;
            }
        }

        return wybranySmak;
    }

    static double obliczSredniCzasPrzestrojenia(int smak) {
        int iloscNiezerowychCzasow = 0;
        int sumaCzasow = 0;

        for (int i = 0; i < N; i++) {
            if (czasy[smak][i] > 0) { // Zamiana na kolumnę
                sumaCzasow += czasy[smak][i];
                iloscNiezerowychCzasow++;
            }
        }

        return iloscNiezerowychCzasow > 0 ? (double) sumaCzasow / iloscNiezerowychCzasow : Double.MAX_VALUE;
    }

    public static void main(String[] args) {
        zachlanniePermutacje();
        System.out.println(">> NAJLEPSZE:\n\tCzas: " + minCzas + "\tSekwencja: " + lody);
    }
}