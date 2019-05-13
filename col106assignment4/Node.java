import java.util.*;
import java.lang.*;
public class Node
	{
		int height,balance;
		Position data;
		 Node left,right,parent;
		Node()
		{
			data=null;
			right=null;
			left=null;
			height=0;
		}
		Node(Position p)
		{
			data=p;
			height=0;
			setLeft(null);
			setRight(null);
		}
		public void setRight(Node a)
		{
			this.right=a;
			//right.setParent(this);	
		}
		public void setLeft(Node a)
		{
			this.left=a;
			//left.setParent(this);	
		}
		public void setParent(Node a)
		{
			this.parent=a;	
		}
		public Node getRight()
		{
			return right;	
		}
		public Node getLeft()
		{
			return left;	
		}
		public Node getParent()
		{
			return parent;	
		}
		public int compareTo(Node b)
		{
			if(this.data.getWordIndex()>b.data.getWordIndex())
			return 1;
		else if(this.data.getWordIndex()< b.data.getWordIndex())
			return -1;
		else
			return 0;

		}
	}