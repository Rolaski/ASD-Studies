package dataStructures.dynamicArray;

// Implementacja tablicy dynamicznej zlozonych obiektow stundentow

public class DynamicArrayStudent
{
    private Student[] array;
    private int quantity;

    public static void main(String[] args)
    {
        int maxSize = 3;
        DynamicArrayStudent arrayStudent = new DynamicArrayStudent(maxSize);

        Student s1 = new Student("Jacob", "Kowalski", 156223);
        arrayStudent.add(s1);
        Student s2 = new Student("Matthew", "Nowakowski",137911);
        arrayStudent.add(s2);
        Student s3 = new Student("Monika", "Patrykowska",189233);
        arrayStudent.add(s3);

        arrayStudent.print();
        System.out.println("\nIndex 2: "+arrayStudent.get(2));
    }

    //constructor
    public DynamicArrayStudent(int maxSize)
    {
        array = new Student[maxSize];
        quantity=0;
    }
    public void add(Student value)
    {
        if(array.length <= quantity)
        {
            Student[] localArray = new Student[array.length*2];
            for(int i=0; i< array.length; i++)
            {
                localArray[i] = array[i];
            }
            array=localArray;
        }
        array[quantity] = value;
        quantity++;
    }

    public boolean remove(int index)
    {
        if(quantity==0 || quantity<=index || index<0)
            return false;
        for(int i=index; i<quantity-1; i++)
        {
            array[i] = array[i+1];
        }
        quantity--;
        return true;
    }

    public Student get(int index)
    {
        return array[index];
    }
    public int size()
    {
        return quantity;
    }

    public int find(Student searchValue)
    {
        for(int i=0; i<quantity; i++)
        {
            if(
                    array[i].getName().equals(searchValue.getName())
                    && array[i].getSurname().equals(searchValue.getSurname())
                    && array[i].getAlbumNumber() == searchValue.getAlbumNumber()
            )
                return i;
        }
        return -1;
    }

    public void print()
    {
        for(int i=0; i<quantity; i++)
        {
            System.out.println(get(i).toString());
        }
    }

}

class Student
{
    private String name,surname;
    private int albumNumber;

    //empty constructor
    public Student()
    {
        name ="";
        surname="";
        albumNumber=0;
    }
    public Student(String name, String surname, int albumNumber)
    {
        this.name = name;
        this.surname = surname;
        this.albumNumber = albumNumber;
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
    public String toString()
    {
        return "Student: "+name+" "+surname+" "+albumNumber;
    }
}
