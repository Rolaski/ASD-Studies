package dynamic;

public class epidemic
{
    public static void main(String[] args) {
        final int dni = 5;
//        System.out.println("zdrowych: " + (10000 - epidemia(dni))
//                + ", chorych: " + epidemia(dni));
        System.out.println("Number of days: "+epidemia(8));
    }

    static int epidemia(int dni) {
        int[] tab = new int[dni + 1];
        tab[1] = 10;

        for (int i = 2; i < tab.length; i++) {
            if (i < 8) tab[i] = 3 * tab[i - 1];
            else if (i == 8) {
                tab[i] = 3 * tab[i - 1] - tab[i - 7];
            }
            else tab[i] = 3 * tab[i - 1] - 2*tab[i - 8];
        }
        return tab[tab.length - 1];
    }
}
