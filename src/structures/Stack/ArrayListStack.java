package structures.Stack;

import java.util.ArrayList;

//Implementacja stosu liczb calkowitych za pomoca tablicy dynamicznej ArrayList przez OSADZANIE

public class ArrayListStack {
    private ArrayList<Integer> integerStack;

    public ArrayListStack()
    {
        integerStack = new ArrayList<>();
    }

    public void push(int elem)
    {
        integerStack.add(elem);
    }

    public int pop()
    {
        int topElem = integerStack.get(integerStack.size()-1);
        integerStack.remove(integerStack.size()-1);
        return topElem;
    }

    public int peek()
    {
        return integerStack.get(integerStack.size()-1);
    }

    public boolean isEmpty()
    {
        return integerStack.isEmpty();
    }

    public static void main(String[] args)
    {
        ArrayListStack theStack = new ArrayListStack();
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);
        theStack.push(81);

        while (!theStack.isEmpty())
        {
            int value = theStack.pop();
            System.out.println(value+" ");
        }
        System.out.println("");
    }
}