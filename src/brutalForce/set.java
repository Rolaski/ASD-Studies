package brutalForce;

public class set
{
    public static void main(String[] args)
    {
        for(int a=0;a<=1; a++)
            for(int b=0; b<=1; b++)
                for(int c=0; c<=1; c++)
                    for(int d=0; d<=1; d++)
                    {
                        System.out.print("{ ");
                        if(a==1) System.out.print("1 ");
                        if(b==1) System.out.print("2 ");
                        if(c==1) System.out.print("3 ");
                        if(d==1) System.out.print("4 ");
                        System.out.print("}\n");
                    }
    }
}
