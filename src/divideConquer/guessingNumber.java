package divideConquer;

import java.util.Random;

public class guessingNumber
{
    public static void main(String[] args)
    {
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(100)+1;
        int a=0;
        int b=100;
        System.out.println("LETS PLAY THE GAME");

        recursion(a,b,number);
    }

    public static void recursion(int a, int b, int number)
    {
        int guess = (a+b)/2;

        System.out.println("Is that a number "+guess+"?");
        if(guess == number)
        {
            System.out.println("I guessed it! this is the number "+number);
        }
        else if(guess < number)
        {
            System.out.println("the number is bigger! "+(guess+1)+" - "+b);
            recursion(guess+1, b, number);
        }
        else {
            System.out.println("the number is smaller! "+a+" - "+(guess-1));
            recursion(a,guess-1, number);
        }
    }
}
