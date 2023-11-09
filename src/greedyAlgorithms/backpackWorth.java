package greedyAlgorithms;

public class backpackWorth
{
    static int bpV = 10;
    static int[] volume = {6, 2, 3, 2, 3, 1};
    static int[] worth = {6, 4, 5, 7, 10, 2};

    public static void main(String[] args)
    {
        backpack1();
    }


    static int[] max()
    {
        int[] max = {0,0};
        for(int i = 0; i < worth.length; i++)
        {
            if(worth[i] > max[1])
            {
                max[1] = worth[i];
                max[0] = i;
            }
        }
        return max;
    }
    static void backpack1()
    {
        int Vbp = 10;
        for(int i = 0; i < worth.length; i++)
        {
            System.out.println("id: "+max()[0]+ ", worth: "+max()[1]+ ", volume: "+volume[max()[0]]);
            if(Vbp - volume[max()[0]] >= 0)
            {
                Vbp = Vbp - volume[max()[0]];
                System.out.println("id: "+max()[0]+", free space: "+Vbp);
            }
            worth[max()[0]] =- max()[1];
        }
    }
}
