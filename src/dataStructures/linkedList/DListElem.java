package dataStructures.linkedList;

public class DListElem
{
    public int iData;
    public DListElem next;
    public DListElem previous;

    public DListElem(int iData)
    {
        this.iData = iData;
        next = null;
        previous = null;
    }

    public String toString()
    {
        return Integer.toString(iData);
    }
}
