public class StringArrayList implements StringList
{
	String[] myArray = new String[10];
	String[] newArray, toArray;

	private int size = 0;

	public int add(String s)
	{
		ensureCapacity();
		myArray[size] = s;
		size++;
		return size;
	}

	public void ensureCapacity()
	{
		if(size == myArray.length)//check if array is full
		{
			newArray = new String[myArray.length * 2 + 1];
			System.arraycopy(myArray, 0, newArray, 0, size);//make more space
			myArray = newArray;			
		}
	}

	public String get(int i)
	{
		return myArray[i];
	}

	public boolean contains(String s)
	{
		return indexOf(s) != -1;
	}

	public int indexOf(String s)
	{
		for(int i = 0; i < size; i++)
		{
			if(myArray[i].equals(s))
			{
				return i;
			}
		}
		return -1;
	}

	public int size()
	{
		return size;
	}
	
	public int add(int index, String s)
	{
		ensureCapacity();
		for(int i = size; i > index; i--)
		{
			myArray[i] = myArray[i - 1];
		}
		set(index, s);
		size++;
		return index;
	}

	public void clear()
	{
		size = 0;
	}

	public boolean isEmpty()
	{
		return size == 0;
	}

	public String remove(int i)
	{
		if(i >= size){
			throw new IndexOutOfBoundsException("fail");
		}
		String stringToRemove = myArray[i];
		size--;
		for(int j = i; j < size; j++)
		{
			myArray[j] = myArray[j + 1];
		}
		return stringToRemove;
	}

	public void set(int index, String s)
	{
		myArray[index] = s;
	}

	public String[] toArray()
	{
		String[] toArray1 = new String[size];
		for(int i = 0; i < size; i++)
		{
			toArray1[i] = myArray[i];
		}
		return toArray1;
	}
}