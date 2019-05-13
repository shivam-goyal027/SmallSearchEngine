public class PageIndex
{
	MyLinkedList<WordEntry> store=new MyLinkedList<>( );
	
	void addPositionForWord(String stri,Position p)
	{
		int flag=0;
			for(int i=0;i<store.size( );i++)
			{
				WordEntry we=store.get(i);
				if(we.str.equals(stri))
				{
					we.addPosition(p);
					flag++;	
				}
			}
			if(flag==0)
			{
				WordEntry k=new WordEntry(stri);
				k.addPosition(p);
				store.addLast(k);
				//System.out.println("here");
			}
	//System.out.println("see");
	}
	MyLinkedList<WordEntry> getWordEntries()
	{
		//System.out.println(store.size());
		return store;
	}
	
}