import java.util.*;
import java.lang.*;
import java.io.*;
public class MyHashTable
{
		public static class node2
	{
		WordEntry wen;
		node2 next=null;
		node2(){}
		node2(WordEntry ab)
		{
			wen=ab;
		}
	}
 	node2[] arr=new node2[300];
 	
	int getHashIndex(String stri)
	{
		int s=0;
		for(int i=0;i<stri.length();i++)
		{
			s=s+(int)stri.charAt(i);
		}
		return s%300;
	}
	void addPositionsForWord(WordEntry w)
	{
		int flag=0;
		//System.out.println("hmm");
		int k=getHashIndex(w.str);
		node2 temp=arr[k];
		if(temp==null)
		{
			node2 pb=new node2(w);
			arr[k]=pb;
		}
		else{
			while(temp.next!=null)
			{
				if(temp.wen.str.equals(w.str))
				{
					temp.wen.addPositions(w.llist);
					flag++;
				}
				temp=temp.next;
			}
			if(temp.wen.str.equals(w.str) && flag==0)
			{
				temp.wen.addPositions(w.llist);
				flag++;
			}
			if(flag==0)
			{
				node2 temp2=new node2(w);
				temp.next=temp2;
			}
		}
	}
}