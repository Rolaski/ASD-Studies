package dynamic;

import java.util.Arrays;
import java.util.Random;

public class guessingNumber
{
    public static void main(String[] args)
    {
        Random randomNumber = new Random();
        int number = randomNumber.nextInt(100) + 1;

        System.out.println("LET'S PLAY THE GAME");

        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = i + 1;
        }

        dynamicProgramming(array, 0, array.length - 1, number);
    }

    public static void dynamicProgramming(int[] array, int low, int high, int number)
    {
        int[] dp = new int[array.length + 1];

        for (int i = 1; i <= array.length; i++)
        {
            dp[i] = i;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = array[mid];

            System.out.println("Is that a number " + guess + "?");

            if (guess == number) {
                System.out.println("I guessed it! This is the number " + number);
                return;
            } else if (guess < number) {
                System.out.println("The number is higher! Searching in the range " + (mid + 1) + " - " + high);
                dp[mid + 1] = Math.min(dp[mid + 1], dp[high + 1] + 1);
                low = mid + 1;
            } else {
                System.out.println("The number is lower! Searching in the range " + low + " - " + (mid - 1));
                dp[mid + 1] = Math.min(dp[mid + 1], dp[low] + 1);
                high = mid - 1;
            }
        }

        System.out.println("Number not found in the array.");
    }
}
