package greedyAlgorithms;

public class road
{
    static String[] city = {"Warszawa", "Katowice", "Zakopane", "Lwów" ,"Wiedeń" ,"Budapeszt" ,"Bukareszt" ,"Zagrzeb", "Sofia"};
    static int[][] road = {
           //0    1   2   3    4   5   6   7   8
            {0  ,300,402,356,  0,  0,  0,  0,  0},
            {300,  0,  0,  0,440,474,  0,  0,  0},
            {402,  0,  0,  0,  0,330,  0,  0,  0},
            {356,  0,  0,  0,  0,  0,823,  0,  0},
            {  0,440,  0,  0,  0,  0,  0,430,  0},
            {  0,474,330,  0,  0,  0,813,365,774},
            {  0,  0,  0,823,  0,813,  0,  0,403},
            {  0,  0,  0,  0,430,365,  0,  0,768},
            {  0,  0,  0,  0,  0,774,403,768,  0}
    };


    public static void main(String[] args)
    {
        shortestWay(0,8);
    }

    public static void shortestWay(int start, int endIndex)
    {
        int distance = 0;
        int currentIndex = start;
        int newIndex = 0;

        while (currentIndex != endIndex)
        {
            int minDistance = Integer.MAX_VALUE;

            //trasa bezpośrednia
            if(road[currentIndex][endIndex] != 0)
            {
                System.out.println("CITY: "+city[currentIndex]);
                System.out.println("CITY: "+city[8]);
                distance += road[currentIndex][endIndex];
                System.out.println("distance: "+distance);
                break;
            }
            else
            {
                System.out.println("CITY: "+city[currentIndex]);
                for(int j=0; j<road.length; j++)
                {
                    if(minDistance > road[currentIndex][j] && road[currentIndex][j]>0 && currentIndex < j)
                    {
                        minDistance = road[currentIndex][j];
                        newIndex = j;
                    }
                }
                distance += minDistance;
                currentIndex = newIndex;
            }
        }
    }
}
