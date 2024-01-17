package dataStructures.sortedLinkedList;

import java.util.Random;

public class SortedLinkedList {
    private ListElem first;  //"pointer"/reference to first element

    public SortedLinkedList()
    {
        first = null;    //no elements on initialization
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void insertFirst(int value)
    {
        ListElem newElem = new ListElem(value);
        newElem.next = first;
        first = newElem;
    }


    public void insert(int value)
    {
        ListElem newElem = new ListElem(value);
        ListElem previous = null;
        ListElem current = first;            //from beginning

        //finding place for new element (until list is not empty and new element is smaller than current element)
        while (current != null && newElem.data > current.data)
        {
            previous = current;
            current = current.next;
        }

        //placing new element and linking previous and next
        if (previous == null) first = newElem;
        else previous.next = newElem;
        newElem.next = current;
    }

    public ListElem find(int elem)
    {
        if (isEmpty()) return null;

        ListElem current = first;
        while (current.data != elem)
        {
            if (current.next == null) return null;
            else
                current = current.next;
        }
        return current;
    }

    public ListElem deleteFirst()
    {
        if (isEmpty())
            return null;
        ListElem temp = first;
        first = first.next;
        return temp;
    }

    public ListElem delete(int elem)
    {
        if (isEmpty()) return null;

        ListElem current = first;
        ListElem previous = null;

        while (current.data != elem){
            if (current.next == null) return null; //not found
            else{
                previous = current;     //go to next
                current = current.next;
            }
        }
        //delete found element
        if (previous == null)  //if first
            first = first.next; //set next to first
        else                  //if not first
            previous.next = current.next;   //go back one elem - link it to element after found element (unlink it/skip it)

        return current; //return deleted element
    }

    public void print()
    {
        System.out.print("Lista (początek-->koniec): ");
        ListElem current = first;   //from beginning
        while (current != null)      //until list is not empy
        {
            System.out.print(current.toString()+" ");
            current = current.next;  //print and go to next element
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        //create list
        SortedLinkedList theSortedList = new SortedLinkedList();

        Random rand = new Random();
        for (int j = 0; j < 10; j++)  //get random ints and assign them to list
        {
            int number = rand.nextInt(100);
            theSortedList.insert(number);
        }

        theSortedList.print();
    }
}