package dataStructures.sortedLinkedList;

public class ListElem {
    public int data;
    public ListElem next; //"pointer" to next element

    public ListElem(int data)
    {
        this.data = data;   //data assigment
        next = null; //null on initialization - doesnt have next element
    }

    public String toString()
    {
        return Integer.toString(data);
    }
}