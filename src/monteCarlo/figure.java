package monteCarlo;

import java.util.Random;

public class figure
{
    public static void main(String[] args)
    {
        Random point = new Random();
        int couting = 0;

        for(int i=0; i<100; i++)
        {
            double x = point.nextInt(100+1)/100.0;
            double y = point.nextInt(100+1)/100.0;
//            System.out.println("x= "+x+", y= "+y);

            if(y<= Math.sin(x))
            {
                couting++;
            }
        }
        System.out.println("Pole = "+(couting/100.0));
    }
}
