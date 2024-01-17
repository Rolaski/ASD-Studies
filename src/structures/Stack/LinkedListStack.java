package structures.Stack;

import java.util.LinkedList;

//Implementacja stosu liczb calkowitych za pomoca listy powiazanej LinkedList przez OSADZANIE

public class LinkedListStack {
    private LinkedList<Integer> integerStack;

    public LinkedListStack()
    {
        integerStack = new LinkedList<>();
    }

    public void push(int elem)
    {
        integerStack.push(elem);
    }

    public int pop()
    {
        return integerStack.pop();
    }

    public int peek()
    {
        return integerStack.peek();
    }

    public boolean isEmpty()
    {
        return integerStack.isEmpty();
    }

    public static void main(String[] args)
    {
        LinkedListStack theStack = new LinkedListStack();
        theStack.push(20);
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        while (!theStack.isEmpty())
        {
            long value = theStack.pop();
            System.out.print(value+"\n");
        }
        System.out.println("");
    }
}