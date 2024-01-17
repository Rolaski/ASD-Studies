package dataStructures.dynamicArray;

// Implementacja tablicy dynamicznej liczb calkowitych


public class DynamicArrayInt
{
    static private int[] array;
    private int quantity;

    public static void main(String[] args)
    {
        int maxSize = 3;
        DynamicArrayInt arrayInt = new DynamicArrayInt(maxSize);

        System.out.println("TESTING!");
        arrayInt.add(55);
        arrayInt.add(13);
        arrayInt.add(24);
        arrayInt.add(62);
        arrayInt.add(58);
        arrayInt.add(12);
        arrayInt.remove(2);
        System.out.println("62 on index: "+arrayInt.find(62));
        arrayInt.print();
    }

    //constructor
    public DynamicArrayInt(int maxSize)
    {
        array = new int[maxSize];
        quantity = 0;
    }

    public void add(int value)
    {
        if(array.length <= quantity)
        {
            int[] localArray = new int[array.length*2];
            System.arraycopy(array, 0, localArray, 0, array.length);
            array = localArray;
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

    public int get(int index)
    {
        return array[index];
    }

    public int size()
    {
        return quantity;
    }

    public int find(int searchValue)
    {
        for(int i=0; i<quantity; i++)
        {
            if(array[i] == searchValue)
                return i;
        }
        return -1;
    }
    public void print()
    {
        for(int i=0; i<quantity; i++)
        {
            System.out.print(get(i)+", ");
        }
        System.out.println();
    }
}
