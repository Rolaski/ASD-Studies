package structures.List;

import java.util.ArrayList;

public class ArrayListList
{

    private ArrayList<Object> oList;

    public ArrayListList()
    {
        oList = new ArrayList<Object>();
    }

    public boolean addLast(Object elem)
    {
        return oList.add(elem);
    }

    public Object removeLast()
    {
        int lastIndex = oList.size()-1;
        return oList.remove(lastIndex);
    }

    public Object get(int index)
    {
        return oList.get(index);
    }

    public int find(Object elem)
    {
        return oList.indexOf(elem);
    }

    public int size()
    {
        return oList.size();
    }

    public void print()
    {
        for (int i = 0; i < oList.size(); i++)
        {
            System.out.print(oList.get(i)+" ");
        }
        System.out.println("");
    }


    public static void main(String[] args)
    {
        ArrayListList theList = new ArrayListList();

        theList.addLast("elem0");
        theList.addLast("elem1");
        theList.addLast("elem2");
        theList.addLast("elem3");
        theList.addLast("elem4");

        theList.print();
        System.out.println("");

        System.out.println(theList.get(3));
        System.out.println("");

        theList.print();
        System.out.println("");

        System.out.println(theList.removeLast());
        System.out.println("");

        System.out.println(theList.find("elem4"));
        System.out.println("");

        theList.print();
        System.out.println("");
    }

}
