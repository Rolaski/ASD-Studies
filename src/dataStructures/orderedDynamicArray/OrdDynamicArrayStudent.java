package dataStructures.orderedDynamicArray;

//Implementacja uporzadkowanej tablicy dynamicznej zlozonych obiektow Student

public class OrdDynamicArrayStudent
{
    private Person [] table;  //Referencja do tablicy
    private int nElems;  //Aktualna liczba elementow w tablicy

    public OrdDynamicArrayStudent(int maxSize)
    {
        table = new Person[maxSize];
        nElems = 0;
    }

    public void add(Person value)    	// Wstawienie elementu do tablicy
    {
        if (nElems >= table.length)
        {
            Person [] locTable = new Person[table.length*2];
            for (int i=0; i<table.length; i++)
                locTable[i]=table[i];
            table = locTable;
        }

        int j;
        for (j = 0; j < nElems; j++)   // Znajdujemy miejsce dla elementu
            if (table[j].compareTo(value) > 0)
                break;

        for (int k = nElems; k > j; k--)    // Przesuwamy większe elementy
            table[k] = table[k - 1];

        table[j] = value;       	// Wstawiamy element
        nElems++;                      	// Zwiekszamy licznik elementow
    }

    public Person get(int index) // Pozyskanie elementu o danym indeksie
    {
        return table[index];
    }

    public int size() // Aktualna liczba elementow w tablicy
    {
        return nElems;
    }

    public boolean remove(int index) 	// Usuniecie elementu o danym indeksie
    {
        if (nElems==0 || index>=nElems || index<0)
        {
            return false;
        }
        for (int j = index; j < nElems - 1; j++) 	// Przesuwamy pozostale elementy w lewo
        {
            table[j] = table[j + 1];
        }
        nElems--;                   		// Zmniejszamy licznik elementow
        return true;
    }

    public int find(Person searchElem) // Szukanie okreslonego elementu
    {
        for (int j = 0; j < nElems; j++)
        {
            if (table[j].getName().equals(searchElem.getName())
                    && table[j].getSurname().equals(searchElem.getSurname())
                    && table[j].getAlbumNumber()== (searchElem.getAlbumNumber()))
                return j; //Element znaleziono
        }
        return -1; // Elementu nie znaleziono
    }

    public int find2(Person searchElem) // Szukanie okreslonego elementu
    {
        for (int j = 0; j < nElems; j++)
            if (table[j].compareTo(searchElem) == 0)
                return j; //Element znaleziono
        return -1; // Elementu nie znaleziono
    }

    public void print()
    {
        for (int i = 0; i < nElems; i++)
            System.out.print(get(i).toString() + "\n");
        System.out.println();
    }

    public static void main(String[] args) {
        int maxSize = 3;
        OrdDynamicArrayStudent array = new OrdDynamicArrayStudent(maxSize);

        array.add(new Person("Aleksandra", "Ząb", 135500));
        array.add(new Person("Aleksandra","Baniatowska",199000));
        array.add(new Person("Maciek", "Król",100100));

        array.print();
    }
}




class Person implements Comparable<Person> {
    private String name, surname;
    private int albumNumber;

    public Person() {
        name = "";
        surname = "";
        albumNumber = 0;
    }

    public Person(String name, String surname, int albumNumber) {
        this.name = name;
        this.surname = surname;
        this.albumNumber = albumNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", albumNumber=" + albumNumber +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAlbumNumber() {
        return albumNumber;
    }

    public void setAlbumNumber(int albumNumber) {
        this.albumNumber = albumNumber;
    }

    @Override
    public int compareTo(Person p)
    {
        // kolejnosc kryteriow:
        // album (od najmniejszego numeru albumu)
        // nazwisko (alfabetycznie od A do Z)
        // imie (alfabetycznie od A do Z)

        //osoba.compareTo(osoba2)

        if (this.getAlbumNumber() < p.getAlbumNumber())
            return -1;
        if (this.getAlbumNumber() > p.getAlbumNumber())
            return 1;
        if (this.getAlbumNumber() == p.getAlbumNumber() && this.getSurname().compareTo(p.getSurname()) != 0) // ten sam wiek, rozne nazwiska
            return this.getSurname().compareTo(p.getSurname());
        if (this.getAlbumNumber() == p.getAlbumNumber() && this.getSurname().compareTo(p.getSurname()) == 0) // ten sam wiek, takie same nazwiska
            return this.getName().compareTo(p.getName());
        return 0;
    }
}

