package dataStructures.hashTable;

public class LinkedList
{
    private ListElem first;

    public LinkedList()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public ListElem getFirst()
    {
        return first;
    }

    public void insertFirst(int value)
    {
        ListElem newElem = new ListElem(value);
        if(!isEmpty())
            newElem.next = first;
        first = newElem;
    }

    public boolean find(int elem)
    {
        if (isEmpty()) return false;

        ListElem current = first;
        while (current.data != elem)
        {
            if (current.next == null) return false;
            else
                current = current.next;
        }
        return true;
    }

    public ListElem deleteFirst()
    {
        if (isEmpty())
        {
            return null;
        }
        ListElem temp = first;
        first = first.next;
        return temp;
    }

    public ListElem delete(int elem)
    {
        if (isEmpty()) return null;

        ListElem current = first;
        ListElem previous = null;

        while (current.data != elem)
        {
            if (current.next == null) return null;
            else
            {
                previous = current;
                current = current.next;
            }
        }
        if (previous == null)
            first = first.next;
        else
            previous.next = current.next;

        return current;
    }
    public LinkedListIterator iterator()
    {
        return new LinkedListIterator(this);
    }

    public void print2()
    {
        System.out.print("Lista (początek-->koniec): ");
        ListElem current = first;   // Zaczynamy na początku listy
        while (current != null)      // Dopóki nie koniec listy...
        {
            System.out.print(current.toString()+" ");
            current = current.next;  // ...przechodzimy do następnego elementu.
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        LinkedList theList = new LinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertFirst(88);

        theList.print2();

        int liczba = 44;
        boolean wynik = theList.find(liczba);
        if (wynik)
            System.out.println("Znaleziono element " + liczba);
        else
            System.out.println("Nie znaleziono elementu "+liczba);

        ListElem dElem = theList.delete(66);
        if (dElem != null)
            System.out.println("Usunięto element o kluczu " + dElem.data);
        else
            System.out.println("Nie można usunąć elementu");


        theList.print2();

        theList.deleteFirst();
        theList.print2();
    }
}