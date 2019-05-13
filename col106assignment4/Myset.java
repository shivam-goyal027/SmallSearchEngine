import java.util.*;
public class Myset<T>
{
	private T o;
	MyLinkedList<T> l1 = new MyLinkedList<>();
	
	public Boolean IsEmpty()
	{
	//returns true if the set is empty.
		return l1.isEmpty();	
	}

	public Boolean IsMember(T o)
	{
	// Returns true if o is in the set, false otherwise.
		return l1.contains(o);
	}
	public void Insert(T o)
	{
		if(!IsMember(o))
			l1.addLast(o);
	// Inserts o into the set.
	}	
	public void Delete(T o)throws Exception
	{ 
	//Deletes o from the set, throws exception if o is not in 
	//the set.
		
			if(IsMember(o))
			    l1.remove(o);
			else
				throw new Exception("Element not present");
		   
	}

	public Myset<T> Union(Myset<T> a)
	{
	//Returns a set which is the union of the current set with 
	//the set a.
		Myset<T> b=new Myset<>();
		int i=0;
		while(i<a.l1.size())
		{
			
			if(!IsMember(a.l1.get(i)))
				Insert(a.l1.get(i));
			i++;
		}
		i=0;
		while(i<l1.size())
		{
			
			b.Insert(l1.get(i));
			i++;
		}
		return b;
	}
	public Myset<T> Intersection(Myset<T> a)
	{
	//Returns a set which is
	//the intersection of the current set with the set a.
		Myset<T> b=new Myset<>();
		int i=0;
		while(i<a.l1.size())
		{
			
			if(IsMember(a.l1.get(i))){
//System.out.println("mn");
				b.Insert(a.l1.get(i));}
		i++;
		}
		return b;
	}
}
