public class WordEntry
{
	String str;
	MyLinkedList<Position> llist=new MyLinkedList<>( );
	AvlTree avl=new AvlTree();
	WordEntry(String word)
	{
		str=word;
	}
	void addPosition(Position position)
	{
		try{
		llist.addLast(position);
		if(llist.size()==1)
		{
			//System.out.println("1");
			Node n=new Node(position);
			//System.out.println("111111111111");
			avl.setRoot(n);
			//System.out.println("2");
		}
		else
		{
			//System.out.println("3");
			Node b=new Node(position);
			//System.out.println("4");
			avl.insert(b);
			//avl.output(avl.root);
		}
		}catch(Exception en){System.out.println("catch");}
	}
	
	void addPositions(MyLinkedList<Position> positions)
	{
		int i=positions.size();
		int j;
		for(j=0;j<i;j++)
		{
			llist.addLast(positions.get(j));
		}
	}
	MyLinkedList<Position> getAllPositionsForThisWord()
	{
		//avl.output(avl.root);
		return llist;
	}
}