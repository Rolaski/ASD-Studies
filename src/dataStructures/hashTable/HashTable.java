package dataStructures.hashTable;

public class HashTable {
    private LinkedList[] hashArray;    // hashing table
    private int arraySize;

    public HashTable(int size)
    {
        arraySize = size;
        hashArray = new LinkedList[size];

        for (int i=0; i<size; i++) //creating empty list at every link of hashing table
        {
            hashArray[i] = new LinkedList();
        }
    }

    public LinkedList getLinkedList(int index) //returns LinkedList by its index num from HashingTable
    {
        return hashArray[index];
    }

    public int size() //size of whole hashing table
    {
        return arraySize;
    }

    private int hashFunction(int elem)
    {
        return elem % arraySize;
    }

    public void insert(int data)  // wstaw element do tablicy mieszajacej
    {
        int hashVal = hashFunction(data);   // oblicz indeks
        if (!hashArray[hashVal].find(data)) //Sprawdz czy element jest juz na liscie
        {
            hashArray[hashVal].insertFirst(data); // wstaw na liste na pozycji hashVal
        }
    }

    public void delete(int elem)       // usuń element z tablicy mieszajacej
    {
        int hashVal = hashFunction(elem);   // oblicz indeks
        hashArray[hashVal].delete(elem); // usuń element listy
    }

    public boolean find(int elem)   // sprawdz czy element jest w tablicy mieszajacej
    {
        int hashVal = hashFunction(elem);   // oblicz indeks
        return hashArray[hashVal].find(elem);
    }


    public HashTableIterator iterator() //Utworzenie iteratora
    {
        return new HashTableIterator(this);
    }

    public void print() //Przegladanie tablicy mieszajacej wraz z wypisywaniem elementow
    {
        System.out.print("Tablica mieszajaca:");
        HashTableIterator iterator = this.iterator();

        while (iterator.hasNext())      // Dopóki nie koniec elementow
        {
            ListElem elem = iterator.next();
            System.out.print(elem.toString()); // ...wypisujemy dane i...
            System.out.print(" ");
        }
        System.out.println();
    }


    public static void main(String[] args) //test tablicy mieszjacej
    {

        HashTable hashTable = new HashTable(10);

        hashTable.insert(1);
        hashTable.insert(11);
        hashTable.insert(2);
        hashTable.insert(32);
        hashTable.insert(42);
        hashTable.insert(3);
        hashTable.insert(33);
        hashTable.insert(4);

        hashTable.print();

        boolean result1 = hashTable.find(3);
        System.out.println("Wynik wyszukiwania 3:"+result1);

        hashTable.delete(3);

        hashTable.print();

        boolean result2 = hashTable.find(3);
        System.out.println("Wynik wyszukiwania 3:"+result2);

    }
}