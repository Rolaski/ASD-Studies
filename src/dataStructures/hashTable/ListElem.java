package dataStructures.hashTable;

public class ListElem {
    public int data;
    public ListElem next; //"pointer" to next element
    public ListElem previous;

    public ListElem(int data)
    {
        this.data = data;   //data assigment
        next = null; //null on initialization - doesnt have next element
        previous = null;
    }

    public String toString()
    {
        return Integer.toString(data);
    }
}