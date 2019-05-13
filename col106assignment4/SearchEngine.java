import java.util.*;
public class SearchEngine extends MyHashTable
{
	InvertedPageIndex ipi=new InvertedPageIndex();
	
	MyHashTable mht=new MyHashTable();
	//PageEntry temp=new PageEntry();
	
	SearchEngine()
	{
		ipi=new InvertedPageIndex();
	}
	void performAction(String actionMessage)
	{
	//System.out.println("abc");
		String newline="";
		String newline2="";
		String newline3="";
		int flag=0,flag2=0,flag3=0;
		for(int i=0;i<actionMessage.length();i++)
		{
			
			if(actionMessage.charAt(i)==' ')
				flag++;
			if(actionMessage.charAt(i)!=' ' && flag==0)
		  	  newline=newline+actionMessage.substring(i,i+1);
			if(actionMessage.charAt(i)!=' ' && flag==1)
		  	  newline2=newline2+actionMessage.substring(i,i+1);
			if(actionMessage.charAt(i)!=' ' && flag==2)
		  	  newline3=newline3+actionMessage.substring(i,i+1);
		}
newline2=newline2.toLowerCase();
if(newline2.equals("stacks"))
					newline2="stack";
				if(newline2.equals("structures"))
					newline2="structure";
				if(newline2.equals("applications"))
					newline2="application";
		
		if(newline.equals("addPage"))
		{	
			
			//System.out.println("in");

			try{
			PageEntry temp=new PageEntry(newline2);
			//System.out.println(newline2);
			//if(temp==null)
			//	System.out.println("its null");
			ipi.addPage(temp);
			}catch(Exception en){en.printStackTrace();}
			
		}
		
if(newline.equals("queryFindPagesWhichContainAnyOfTheseWords"))
		{

MySort mss=new MySort();
			MyLinkedList<String> mlls=new MyLinkedList<>();
				String newword="";

			for(int i=0;i<actionMessage.length();i++)
		{
			
					
			if(actionMessage.charAt(i)!=' ')
		  {				newword=newword+actionMessage.substring(i,i+1);
			//System.out.println(newword);
}
			if(actionMessage.charAt(i)==' ')
{
					mlls.addLast(newword);
					newword="";
					//System.out.println(mlls.get(0))
}
				
		}
mlls.addLast(newword);
			//System.out.println(mlls.get(0));
			//System.out.println(mlls.get(1));
			//System.out.println(mlls.get(2));
			//System.out.println(mlls.get(3));


			String[] array=new String[mlls.size()-1];
			for(int j=0;j<mlls.size()-1;j++)
			{
				array[j]=mlls.get(j+1);
				//System.out.println(array[j]);
			}
			Myset<PageEntry> answer=new Myset<>();
			Myset<String> answer2=new Myset<>();
			Myset<String> answer3=new Myset<>();
			int t=mlls.size()-1;
			for(int q=0;q<t;q++)
			{
				if(q==0)
		{			answer=ipi.getPagesWhichContainWord(array[q]);
	for(int u=0;u<answer.l1.size();u++){
		answer2.Insert(answer.l1.get(u).name);
		answer3.Insert(answer.l1.get(u).name);
	}
}
				else
{
	Myset<String> answer4=new Myset<>();
	//System.out.println(array[q]);
	answer=ipi.getPagesWhichContainWord(array[q]);
	for(int u=0;u<answer.l1.size();u++){
		
		answer4.Insert(answer.l1.get(u).name);}
	//System.out.println(answer2.l1.get(0)+" answer2-1");	
	//	System.out.println(answer2.l1.get(1)+" answer2-2");
	answer3=answer3.Union(answer4);
		//System.out.println(answer3.l1.get(0)+" answer3-1");	
		//System.out.println(answer3.l1.get(1)+" answer3-2");
	
	}
			}
		//System.out.println(answer3.l1.get(0));	
		//System.out.println(answer3.l1.get(1));
Myset<PageEntry> mspe=new Myset<>();
for(int g=0;g<answer3.l1.size();g++)
{
	PageEntry pee=new PageEntry(answer3.l1.get(g));
	//System.out.println("yu //"+pee.getPageIndex().store.size()) ;
	mspe.Insert(pee);
}
Myset<SearchResult> mssre=new Myset<>();
for(int w=0;w<mspe.l1.size();w++)
{
	SearchResult sre=new SearchResult(mspe.l1.get(w),mspe.l1.get(w).getRelevanceOfPage(array,false));
mssre.Insert(sre);
}
ArrayList<SearchResult> alsl= mss.sortThisList(mssre);
if(alsl.size()==0){
System.out.println("No webpage contains any of these words:");
for(int v=0;v<array.length;v++){
if(v!=array.length-1)
System.out.print(array[v]+" ");
else{
System.out.print(array[v]);
System.out.println("");
}
}
}
for(int y=0;y<alsl.size();y++)
{
	if(y!=alsl.size()-1)
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name+",");
	else{
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name);
	System.out.println("");
	}
}	

		}

		if(newline.equals("queryFindPagesWhichContainAllWords"))
		{
			
			MySort mss=new MySort();
			MyLinkedList<String> mlls=new MyLinkedList<>();
				String newword="";

			for(int i=0;i<actionMessage.length();i++)
		{
			
					
			if(actionMessage.charAt(i)!=' ')
		  {				newword=newword+actionMessage.substring(i,i+1);
			//System.out.println(newword);
}
			if(actionMessage.charAt(i)==' ')
{
					mlls.addLast(newword);
					newword="";
					//System.out.println(mlls.get(0))
}
				
		}
mlls.addLast(newword);
			//System.out.println(mlls.get(0));
			//System.out.println(mlls.get(1));
			//System.out.println(mlls.get(2));
			//System.out.println(mlls.get(3));


			String[] array=new String[mlls.size()-1];
			for(int j=0;j<mlls.size()-1;j++)
			{
				array[j]=mlls.get(j+1);
				//System.out.println(array[j]);
			}
			Myset<PageEntry> answer=new Myset<>();
			Myset<String> answer2=new Myset<>();
			Myset<String> answer3=new Myset<>();
			int t=mlls.size()-1;
			for(int q=0;q<t;q++)
			{
				if(q==0)
		{			answer=ipi.getPagesWhichContainWord(array[q]);
	for(int u=0;u<answer.l1.size();u++){
		answer2.Insert(answer.l1.get(u).name);
		answer3.Insert(answer.l1.get(u).name);
	}
}
				else
{
	Myset<String> answer4=new Myset<>();
	//System.out.println(array[q]);
	answer=ipi.getPagesWhichContainWord(array[q]);
	for(int u=0;u<answer.l1.size();u++){
		
		answer4.Insert(answer.l1.get(u).name);}
	//System.out.println(answer2.l1.get(0)+" answer2-1");	
	//	System.out.println(answer2.l1.get(1)+" answer2-2");
	answer3=answer3.Intersection(answer4);
		//System.out.println(answer3.l1.get(0)+" answer3-1");	
		//System.out.println(answer3.l1.get(1)+" answer3-2");
	
	}
			}
		//System.out.println(answer3.l1.get(0));	
		//System.out.println(answer3.l1.get(1));
Myset<PageEntry> mspe=new Myset<>();
for(int g=0;g<answer3.l1.size();g++)
{
	PageEntry pee=new PageEntry(answer3.l1.get(g));
	//System.out.println("yu //"+pee.getPageIndex().store.size()) ;
	mspe.Insert(pee);
}
Myset<SearchResult> mssre=new Myset<>();
for(int w=0;w<mspe.l1.size();w++)
{
	SearchResult sre=new SearchResult(mspe.l1.get(w),mspe.l1.get(w).getRelevanceOfPage(array,false));
mssre.Insert(sre);
}
ArrayList<SearchResult> alsl= mss.sortThisList(mssre);
if(alsl.size()==0){
System.out.println("No webpage contains all these words:");
for(int v=0;v<array.length;v++){
if(v!=array.length-1)
System.out.print(array[v]+" ");
else{
System.out.print(array[v]);
System.out.println("");
}
}
}
for(int y=0;y<alsl.size();y++)
{
	if(y!=alsl.size()-1)
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name+",");
	else{
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name);
	System.out.println("");
	}
	
}
		}
		if(newline.equals("queryFindPagesWhichContainWord"))
		{
			newline2=newline2.toLowerCase();
			if(newline2.equals("stacks"))
				newline2="stack";
			if(newline2.equals("structures"))
				newline2="structure";
			if(newline2.equals("applications"))
				newline2="application";
	//System.out.println(ipi.idf(newline2));
Myset<PageEntry>mspe=new Myset<>();
mspe=InvertedPageIndex.getPagesWhichContainWord(newline2);
MySort mss=new MySort();
Myset<SearchResult> mssre=new Myset<>();
for(int w=0;w<mspe.l1.size();w++)
{
	SearchResult sre=new SearchResult(mspe.l1.get(w),mspe.l1.get(w).getRelevance2(newline2));
mssre.Insert(sre);
}
ArrayList<SearchResult> alsl= mss.sortThisList(mssre);
if(alsl.size()==0){
System.out.println("No webpage contains word "+newline2);
}
for(int y=0;y<alsl.size();y++)
{
	if(y!=alsl.size()-1)
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name+",");
	else{
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name);
	System.out.println("");
	}
	
}




			/*try{
			//System.out.println(newline2);
			Myset<PageEntry> temp=new Myset<>();
			temp=ipi.getPagesWhichContainWord(newline2);
			//System.out.println(mht.arr[127]);
			if(temp==null)
				System.out.println("No webpage contains word "+ newline2);
                else{
			if(temp!=null){
			//System.out.println("this size //"+temp.l1.size());
			if(temp.l1.size()==0)
				System.out.println("No webpage contains word "+ newline2);
			else
			{
				
				for(int i=0;i<temp.l1.size();i++)
				{
				System.out.print(temp.l1.get(i).name);
					if(i!=(temp.l1.size()-1))
						System.out.print(",");
					else
						System.out.println("");
				}
				
			}}}
			}catch(Exception en){
                System.out.println("No webpage contains word "+ newline2);}*/
			
		}

if(newline.equals("queryFindPagesWhichContainPhrase"))
{

MySort mss=new MySort();
			MyLinkedList<String> mlls=new MyLinkedList<>();
				String newword="";

			for(int i=0;i<actionMessage.length();i++)
		{
			
					
			if(actionMessage.charAt(i)!=' ')
		  {				newword=newword+actionMessage.substring(i,i+1);
			//System.out.println(newword);
}
			if(actionMessage.charAt(i)==' ')
{
					mlls.addLast(newword);
					newword="";
					//System.out.println(mlls.get(0))
}
				
		}
mlls.addLast(newword);
			//System.out.println(mlls.get(0));
			//System.out.println(mlls.get(1));
			//System.out.println(mlls.get(2));
			//System.out.println(mlls.get(3));


			String[] array=new String[mlls.size()-1];
			for(int j=0;j<mlls.size()-1;j++)
			{
				array[j]=mlls.get(j+1);
				//System.out.println(array[j]);
			}
Myset<PageEntry> answer=new Myset<>();
			Myset<String> answer3=new Myset<>();
answer=ipi.getPagesWhichContainPhrase(array);
	for(int u=0;u<answer.l1.size();u++){
		//answer2.Insert(answer.l1.get(u).name);
		answer3.Insert(answer.l1.get(u).name);
	}
Myset<PageEntry> mspe=new Myset<>();
for(int g=0;g<answer3.l1.size();g++)
{
	PageEntry pee=new PageEntry(answer3.l1.get(g));
	//System.out.println("yu //"+pee.getPageIndex().store.size()) ;
	mspe.Insert(pee);
}
Myset<SearchResult> mssre=new Myset<>();
for(int w=0;w<mspe.l1.size();w++)
{
	SearchResult sre=new SearchResult(mspe.l1.get(w),mspe.l1.get(w).getRelevanceOfPage(array,true));
mssre.Insert(sre);
}
ArrayList<SearchResult> alsl= mss.sortThisList(mssre);
if(alsl.size()==0){
System.out.println("No webpage contains phrase:");
for(int v=0;v<array.length;v++){
if(v!=array.length-1)
System.out.print(array[v]+" ");
else{
System.out.print(array[v]);
System.out.println("");
}
}
}
for(int y=0;y<alsl.size();y++)
{
	if(y!=alsl.size()-1)
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name+",");
	else{
	System.out.print(alsl.get(alsl.size()-1-y).getPageEntry().name);
	System.out.println("");
	}
	
}




}



		if(newline.equals("queryFindPositionsOfWordInAPage"))
		{
			//PageEntry pii=new PageEntry(newline3);
			
			newline2=newline2.toLowerCase();
			if(newline2.equals("stacks"))
				newline2="stack";
			if(newline2.equals("structures"))
				newline2="structure";
			if(newline2.equals("applications"))
				newline2="application";
			
			MyLinkedList<Integer> mlli=new MyLinkedList<>();
			int flag4=0,flag5=0,flag6=0;
			try{
		for(int i=0;i<ipi.pel.size();i++)
			{
				//System.out.println("see"+ipi.pel.get(i).name);
				if(ipi.pel.get(i).name.equals(newline3))
					flag6++;
			}
			if(flag6==0)
				System.out.println("No webpage "+newline3+ " found");

			else{
			/*MyLinkedList<Position> llp=new MyLinkedList<>();
		int k=mht.getHashIndex(newline2);
		//System.out.println("index "+k);
		node2 pin=mht.arr[k];
		if(pin==null)
		{arr[k]=new node2();
		pin=mht.arr[k];
		}
		//System.out.println(mht.arr[k].wen.str);
		if(pin==null)
		{
		if(pin.wen.str.equals(newline2))
				llp=pin.wen.llist;
		}
		while(pin.next!=null)
		{
			//System.out.println("in it");

			if(pin.wen.str.equals(newline2))
			{
				llp=pin.wen.llist;
				//System.out.println("in it");
				flag4++;
				pin=null;
				break;
			}
			pin=pin.next;
		}
		if(pin.wen.str.equals(newline2) && flag4==0)
		{
			System.out.println("in it");

			llp=pin.wen.llist;
			flag4++;
		}
	
		for(int i=0;i<llp.size();i++)
		{
			if(llp.get(i).getPageEntry().name.equals(newline3))
	{
			mlli.addLast(llp.get(i).getWordIndex());
			flag5++;
	}
		}
	if(flag5==0)
		System.out.println("Webpage "+ newline3+" does not contain word "+ newline2);
	else
	{
		for(int i=0;i<mlli.size();i++)
		{
			if(i!=0)
				System.out.print(",");
			System.out.print(mlli.get(i));	
		}
	}*/
	
	MyLinkedList<Position> llp=new MyLinkedList<>();
	MyLinkedList<WordEntry> store2=new MyLinkedList<>( );
	PageEntry pe=new PageEntry(newline3);
	int flag7=0;
	store2=pe.getPageIndex().store;
	for(int i=0;i<store2.size();i++)
	{
		if(store2.get(i).str.equals(newline2))
		{
			llp=store2.get(i).llist;
			flag7++;
		}
	}
	if(flag7==0)
		System.out.println("Webpage "+ newline3+" does not contain word "+ newline2);
	else
	{
		for(int i=0;i<llp.size();i++)
		{
			System.out.print(llp.get(i).getWordIndex());
			if(i!=llp.size()-1)
				System.out.print(",");
			else
				System.out.println("");
		}
	}
		
	
}
}catch(Exception en){}
	}
}
}
