package structures.Queue;
import java.util.LinkedList;

//Implementacja kolejki liczb calkowitych za pomoca klasy LinkedList przez OSADZANIE
public class LinkedListQueue
{

    private LinkedList<Integer> intQueue;

    public LinkedListQueue()
    {
        intQueue = new LinkedList<Integer>();
    }

    public void insert(int elem)
    {
        intQueue.addLast(elem);
    }

    public int remove()
    {
        int firstElem = intQueue.get(0).intValue();
        intQueue.removeFirst();
        return firstElem;
    }

    public int peek()
    {
        return intQueue.peekFirst().intValue();
    }

    public boolean isEmpty()
    {
        return intQueue.isEmpty();
    }

    public int size()
    {
        return intQueue.size();
    }

    public static void main(String[] args)
    {
        LinkedListQueue theQueue = new LinkedListQueue();

        System.out.println("Wstawiam: 10");
        theQueue.insert(10);
        System.out.println("Wstawiam: 20");
        theQueue.insert(20);
        System.out.println("Wstawiam: 30");
        theQueue.insert(30);
        System.out.println("Wstawiam: 40");
        theQueue.insert(40);

        int elem = theQueue.remove();
        System.out.println(" Usuwam: "+elem);
        System.out.println(" Usuwam: "+theQueue.remove());
        System.out.println(" Usuwam: "+theQueue.remove());

        System.out.println("Wstawiam: 50");
        theQueue.insert(50);
        System.out.println("Wstawiam: 60");
        theQueue.insert(60);
        System.out.println("Wstawiam: 70");
        theQueue.insert(70);
        System.out.println("Wstawiam: 80");
        theQueue.insert(80);

        while (!theQueue.isEmpty())
        {
            System.out.println(" Usuwam: "+theQueue.remove());
        }
        System.out.println("");
    }
}

