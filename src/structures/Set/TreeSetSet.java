package structures.Set;

import java.util.Iterator;
import java.util.TreeSet;
//ZBIÓR
public class TreeSetSet {
    private TreeSet<Integer> treeSet;

    public TreeSetSet()
    {
        treeSet = new TreeSet<Integer>();
    }

    public TreeSet<Integer> getTreeSet()
    {
        return treeSet;
    }

    public int size()
    {
        return treeSet.size();
    }

    public void insert(int elem)
    {
        if (!member(elem))
            treeSet.add(elem);
    }

    public boolean member(int elem)
    {
        return treeSet.contains(elem);
    }

    public boolean delete(int elem)
    {
        if (member(elem))
        {
            treeSet.remove(elem);
            return true;
        }
        else return false;
    }


    public TreeSetSet union(TreeSetSet secondSet)
    {
        TreeSetSet unionSet = new TreeSetSet();
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            unionSet.insert(locElem);
        }

        Iterator<Integer> iteratorS = secondSet.getTreeSet().iterator();
        while (iteratorS.hasNext())
        {
            int locElem = iteratorS.next().intValue();
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public TreeSetSet intersection(TreeSetSet secondSet)
    {
        TreeSetSet intersectionSet = new TreeSetSet();

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            if (secondSet.member(locElem))
                intersectionSet.insert(locElem);
        }

        return intersectionSet;
    }

    public TreeSetSet difference(TreeSetSet secondSet)
    {
        TreeSetSet differenceSet = new TreeSetSet();

        Iterator<Integer> iterator = treeSet.iterator();

        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            if (!secondSet.member(locElem))
                differenceSet.insert(locElem);
        }

        return differenceSet;
    }

    public void print()
    {
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            System.out.print(locElem+" ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        TreeSetSet theSetA = new TreeSetSet();
        theSetA.insert(60);
        theSetA.insert(20);
        theSetA.insert(40);

        theSetA.print();

        boolean test20 = theSetA.member(20);
        System.out.println("Wynik testu w zbiorze A dla 20: "+test20);

        theSetA.print();

        boolean test30 = theSetA.member(30);
        System.out.println("Wynik w zbiorze A pierwszego testu dla 30: "+test30);

        theSetA.insert(30);

        theSetA.print();

        test30 = theSetA.member(30);
        System.out.println("Wynik w zbiorze A drugiego testu dla 30: "+test30);

        theSetA.delete(30);

        theSetA.print();

        test30 = theSetA.member(30);
        System.out.println("Wynik w zbiorze A trzeciego testu dla 30: "+test30);

        theSetA.insert(10); //Dodanie jeszcze dwoch elementow
        theSetA.insert(90);

        System.out.println("--------------------------------------------");

        System.out.println("Zbior A:");
        theSetA.print();

        TreeSetSet theSetB = new TreeSetSet();
        theSetB.insert(40);
        theSetB.insert(70);
        theSetB.insert(60);
        theSetB.insert(80);

        System.out.println("Zbior B:");
        theSetB.print();


        TreeSetSet unionSet = theSetA.union(theSetB);
        System.out.println("Suma A i B:");
        unionSet.print();

        TreeSetSet intersectionSet = theSetA.intersection(theSetB);
        System.out.println("Iloczyn A i B:");
        intersectionSet.print();

        TreeSetSet differenceSet = theSetA.difference(theSetB);
        System.out.println("Roznica A-B:");
        differenceSet.print();

        TreeSetSet differenceSet2 = theSetB.difference(theSetA);
        System.out.println("Roznica B-A:");
        differenceSet2.print();

    }
}