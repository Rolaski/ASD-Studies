package dataStructures.hashTable;

public class HashTableIterator {
    private HashTable hashTable;
    private int size;
    private int listIndex;
    private LinkedListIterator listIterator;

    public HashTableIterator(HashTable hashTable)
    {
        this.hashTable = hashTable;
        listIndex = 0;
        size = hashTable.size();
        listIterator = hashTable.getLinkedList(listIndex).iterator();
    }

    public boolean hasNext()
    {
        if (listIterator.hasNext()) return true;

        int locListIndex = listIndex;
        LinkedListIterator locListIterator = listIterator;
        while (true)
        {
            locListIndex++;
            if (locListIndex==size) return false;
            locListIterator = hashTable.getLinkedList(locListIndex).iterator();
            if (locListIterator.hasNext()) return true;
        }
    }

    public ListElem next()
    {
        if (listIterator.hasNext())
        {
            return listIterator.next();
        }
        else
        {
            while (!listIterator.hasNext())
            {
                listIndex++;
                if (listIndex==size) return null;
                listIterator = hashTable.getLinkedList(listIndex).iterator();
            }
            return listIterator.next();
        }
    }
}