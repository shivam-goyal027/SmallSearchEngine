import java.util.*;
public class InvertedPageIndex extends MyHashTable
{
	public static MyLinkedList<PageEntry> pel=new MyLinkedList<>();
	Myset<PageEntry> pes=new Myset<>();
	public static MyHashTable mht=new MyHashTable();
	//int idfe=0;	
	int getSize()
	{return pel.size();}
	MyLinkedList<WordEntry>llwe=new MyLinkedList<>();
	void addPage(PageEntry p)
	{
		pel.addLast(p);
		//p.ipipe=this;
		//System.out.println(pel.get(0));
	//System.out.println("heho");
		MyLinkedList<WordEntry>llwe2=p.getPageIndex().getWordEntries();
//System.out.println(llwe2.size());
for(int i=0;i<llwe2.size();i++)
	llwe.addLast(llwe2.get(i));
//System.out.println("heho");
//System.out.println(llwe.size());
//for(int i=0;i<llwe.size();i++)
//{System.out.println(llwe.get(i).str);
//	System.out.println("heho");}
		for(int i=0;i<llwe2.size();i++)
			mht.addPositionsForWord(llwe2.get(i));
	
	}
 public static Myset<PageEntry> getPagesWhichContainWord(String stri)
	{
		//System.out.println(pel.size());
		Myset<PageEntry> msp=new Myset<>();
	try{
		
		MyLinkedList<Position> llp=new MyLinkedList<>();
		int k=mht.getHashIndex(stri);
		int flag=0;
		//System.out.println(k);
		node2 pin= new node2();
	      pin=mht.arr[k];
		//System.out.println(mht.arr[k].wen.str);
		while(pin.next!=null)
		{
			if(pin.wen.str.equals(stri))
			{
				llp=pin.wen.llist;
				flag++;
			}
			pin=pin.next;
		}
		if(pin.wen.str.equals(stri) && flag==0)
		{
			llp=pin.wen.llist;
			flag++;
		}
		
		for(int i=0;i<llp.size();i++)
		{
			msp.Insert(llp.get(i).getPageEntry());
		} 
		
		
	}catch(Exception en){}
	//idfe=msp.l1.size()
	return msp;
	}
/*public void test(){
	int id=0 ;
id=getPagesWhichContainWord("stack").l1.size();
     
System.out.println("yy"+id);}*/
	public static float idf(String ws)
	{
//test();
		//System.out.println("inidf");
		//int idfe=getPagesWhichContainWord(ws).l1.size();
		//System.out.println(pel.size()+" yi");
/*System.out.println((double)Math.log(pel.size()/((getPagesWhichContainWord(ws).l1.size()))));*/
		if(getPagesWhichContainWord(ws).l1.size()!=0)
	return (float)Math.log((float)(pel.size())/(float)(getPagesWhichContainWord(ws).l1.size()));
		else
		return (float)0;
		
	}
	
	public static float relevance(PageEntry p, String word)
	{
//System.out.println(idf(word));
return (float)((idf(word))*(p.getTermFrequency(word)));
	}
	
	public static Myset<PageEntry>getPagesWhichContainPhrase(String str[])
	{
	
	
	Myset<PageEntry> mpe=new Myset<>();
	Myset<PageEntry> ab=getPagesWhichContainWord(str[0]);
	WordEntry wep=null;
	WordEntry wep2=null;
	for(int i=0;i<ab.l1.size();i++)
	{
		PageEntry a=ab.l1.get(i);
MyLinkedList<Integer> pos=new MyLinkedList<>();//
				for(int j=0;j<a.getPageIndex().getWordEntries().size();j++)
{
	if(a.getPageIndex().getWordEntries().get(j).str.equals(str[0])){
	wep=	a.getPageIndex().getWordEntries().get(j);
	break;}
}
	for(int k=0;k<wep.llist.size();k++)
		pos.addLast(wep.llist.get(k).getWordIndex());
	for(int l=0;l<pos.size();l++)
	{
		int y=pos.get(l)+1;

		int s;
		for(s=1;s<str.length;)
		{

		while(a.cindex.contains(y))
		{
			y++;		
		}

			for(int r=0;r<a.getPageIndex().getWordEntries().size();r++)
{
	if(a.getPageIndex().getWordEntries().get(r).str.equals(str[s])){
	wep2=	a.getPageIndex().getWordEntries().get(r);
	break;}
		}
if(wep2==null){
//System.out.println("out");
break;
}
if(wep2.avl.find(y,wep2.avl.root)==true)
{
//System.out.println("in");
s++;}
else break;
y++;
	}
if(s==str.length)
mpe.Insert(a);
	}}
return mpe;


}
















/*for(int i=0;i<pel.size();i++)
		{
			PageEntry p=pel.get(i);
			for(int j=0;j<p.getPageIndex().getWordEntries.size();j++)
			{
if(p.getPageIndex().getWordEntries().get(j).str.equals(str[q]))
				WordEntrty wo=p.getPageIndex().getWordEntries().get(j);

MyLinkedList<Integer> mli=new MyLinkedList<>();
for(int k=0;k<wo.llist.size();k++)
{
	Position py=wo.llist.get(k);
	mli.addLast(py.getWordIndex());
}
			}
		}
	}*/
}