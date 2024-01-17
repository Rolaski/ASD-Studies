package structures.Queue;

import java.util.ArrayList;

public class ArrayListQueue {
    private ArrayList<Integer> integerQueue;

    public ArrayListQueue()
    {
        integerQueue = new ArrayList<Integer>();
    }

    public void insert(int elem)
    {
        integerQueue.add(elem);
    }

    public int remove()
    {
        int firstElem = integerQueue.get(0).intValue();
        integerQueue.remove(0);
        return firstElem;
    }

    public int peek()
    {
        return integerQueue.get(0).intValue();
    }

    public boolean isEmpty()
    {
        return integerQueue.isEmpty();
    }

    public int size()
    {
        return integerQueue.size();
    }

    public static void main(String[] args)
    {
        ArrayListQueue theQueue = new ArrayListQueue();

        System.out.println("Insert: 10");
        theQueue.insert(10);
        System.out.println("Insert: 20");
        theQueue.insert(20);
        System.out.println("Insert: 30");
        theQueue.insert(30);
        System.out.println("Insert: 40");
        theQueue.insert(40);

        int elem = theQueue.remove();
        System.out.println(" Delete: "+elem);
        System.out.println(" Delete: "+theQueue.remove());
        System.out.println(" Delete: "+theQueue.remove());

        System.out.println("Insert: 50");
        theQueue.insert(50);
        System.out.println("Insert: 60");
        theQueue.insert(60);
        System.out.println("Insert: 70");
        theQueue.insert(70);
        System.out.println("Insert: 80");
        theQueue.insert(80);

        while (!theQueue.isEmpty())
        {
            System.out.println(" Delete: "+theQueue.remove());
        }
        System.out.println("");
    }
}