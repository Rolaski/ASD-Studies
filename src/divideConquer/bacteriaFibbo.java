package divideConquer;

public class bacteriaFibbo
{
    public static void main(String[] args)
    {
        System.out.println(bakt(10));
    }

    static int bakt(int czas){
        if (czas < 2){
            return 1;
        }
        else{
            return 2*bakt(czas-2);
        }
    }
}
