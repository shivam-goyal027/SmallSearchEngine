//import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class PageEntry
{
	int totalwords=0;
	//InvertedPageIndex ipipe=new InvertedPageIndex();
	String str;
	String name;
	int i=1;
	PageIndex index=new PageIndex();
	int flag=0;
	MyLinkedList<Integer> cindex=new MyLinkedList<>();
	//InvertedPageIndex ipipe=new InvertedPageIndex();
		MyLinkedList<String>conn=new MyLinkedList<>();
	//Myset<String>punc=new Myset<>();
		PageEntry(String pageName)
	{
		try{
		conn.addLast("a");conn.addLast("an");conn.addLast("the");conn.addLast("they");conn.addLast("these");conn.addLast("this");conn.addLast("for");conn.addLast("is");conn.addLast("are");conn.addLast("was");conn.addLast("of");conn.addLast("and");conn.addLast("does");conn.addLast("will");conn.addLast("whose");conn.addLast("or");

		name=pageName;
		//System.out.println("ab");
		FileInputStream fs=new FileInputStream("./webpages/"+pageName);
		Scanner s=new Scanner(fs);
		int counter=1;
//System.out.println("ab");
		while(s.hasNext())
		{	//System.out.println("ab");
			String line=s.nextLine();
			//System.out.println(line);
			line=line.toLowerCase();
			String[] arr = line.split("\\s++|\\{|}|<|>|\\(|\\)|\\.|,|;|'|\"|\\?|#|!|-|:");
		for(int i=0;i<arr.length;i++)
		{	
			
			if(!arr[i].equals("")){
				if(!conn.contains(arr[i])){
				if(arr[i].equals("stacks"))
					arr[i]="stack";
				if(arr[i].equals("structures"))
					arr[i]="structure";
				if(arr[i].equals("applications"))
					arr[i]="application";
//System.out.println(arr[i]);
			index.addPositionForWord(arr[i],new Position(this,counter));
	}
else
cindex.addLast(counter);

counter++;
		}
totalwords=counter;
		}
	
}
}catch(Exception en){}
}
		 

		
	
	PageIndex getPageIndex( )
	{
		return index;
	}
float getTermFrequency(String word)
	{
		int i=0,j=0,flag=0;
		//float ans;
		for(i=0;i<index.store.size();i++)
		{
			if(index.store.get(i).str.equals(word)){flag=1;
				j=index.store.get(i).llist.size();}
			//System.out.println(j+" j");
		}
		if(flag==0)
		return (float)0;
		//ans=(j*100)/totalwords;
		//System.out.println((double)26/462);
		//System.out.println(j+" j");
		//System.out.println(totalwords+" words");
		//System.out.println((float)j/totalwords+" ans");
		//System.out.println(totalwords+" words");
//System.out.println(cindex.size()+" final");
		int ao=totalwords-this.cindex.size();
		return (float)j/(float)(ao);
	}
	


int countOfPhrase(String str[])
	{
	int count=0;
	
	
	//Myset<PageEntry> mpe=new Myset<>();
	Myset<PageEntry> ab=InvertedPageIndex.getPagesWhichContainWord(str[0]);
WordEntry wep=null;
WordEntry wep2=null;
//System.out.println("00");
MyLinkedList<Integer> pos=new MyLinkedList<>();
		for(int j=0;j<this.getPageIndex().getWordEntries().size();j++)
{
	if(this.getPageIndex().getWordEntries().get(j).str.equals(str[0])){
	wep=	this.getPageIndex().getWordEntries().get(j);
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
        		while(this.cindex.contains(y))
		{
			y++;		
		}

			for(int r=0;r<this.getPageIndex().getWordEntries().size();r++)
{
	if(this.getPageIndex().getWordEntries().get(r).str.equals(str[s])){
	wep2=	this.getPageIndex().getWordEntries().get(r);
	break;}
		}

if(wep2.avl.find(y,wep2.avl.root)==true)
{s++;}
else break;
y++;
	}
if(s==str.length)
count++;
	}
	    
	

return count;

}


	float getRelevanceOfPage(String str[ ], boolean doTheseWordsRepresentAPhrase)
	{
		float r=(float)0;
		if(!doTheseWordsRepresentAPhrase)
		{
			for(int i=0;i<str.length;i++)
			{
r=r+InvertedPageIndex.relevance(this,str[i]);
			}
			return r;
		}
		else
		{
//System.out.println("seecount "+countOfPhrase(str));
r=(float)((float)(countOfPhrase(str)/(float)(totalwords-(str.length-1)*countOfPhrase(str)))*(float)(Math.log((float)InvertedPageIndex.pel.size()/(float)InvertedPageIndex.getPagesWhichContainPhrase(str).l1.size())));	
return r;
		}

	}
float getRelevance2(String str){
	return (float)(InvertedPageIndex.relevance(this,str));
}

}

