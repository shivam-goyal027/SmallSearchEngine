import java.util.*;
import java.lang.*;
public class AvlTree
{
	
Node root;
public AvlTree()
{
	root=null;
}
public void setRoot(Node r)
{
	root=r;
}
void output(Node r)
	{
		Node a=r;
		if(a.getLeft()!=null)
		output(a.getLeft());
		System.out.println(a.data.getWordIndex());
		if(a.getRight()!=null)
		output(a.getRight());
	}

int max(int x,int y){
        if(x>y) return x;
        else return y;
    }
boolean find(int x ,Node r)
{
	try{
	//Node n=new Node(pos);
	//int flag=0;
	//if(n.data.getPageEntry().name.equals(r.data.getPageEntry().name))
	//	flag=1;
	if(r.data.getWordIndex()==x)
	{
		return true;
	}
	if(r.data.getWordIndex()>x)
	{
		if(r.getLeft()!=null)
		return find(x,r.getLeft());
		else
		return false;
	}
	if(r.data.getWordIndex()<x)
	{
		if(r.getRight()!=null)
		return find(x,r.getRight());
		else
		return false;
	}
return false;
}
catch(Exception e){}
return false;
}
int getHeight(Node a)
{
	if(a==null) return -1;
	else return a.height;
}



void insert(Node n){
        Node temp=root;
        while(temp!=null){
           // System.out.println(temp.data);
        if(n.compareTo(temp)==1){
            if(temp.getRight()!=null)
                temp=temp.getRight();
            else{
                temp.setRight(n);
                n.setParent(temp);
                temp.height=1+max(0,getHeight(temp.getLeft()));
                //temp=n;
    break;
                }
        }
        else{
            if(temp.getLeft()!=null)
                temp=temp.getLeft();
            else{
                temp.setLeft(n);
                n.setParent(temp);
                temp.height=1+max(0,getHeight(temp.getRight()));
                //temp=n;
    break;
                }
        }
        }
        Node temp2=temp;
        while(temp2!=root)
        {
            temp2.height=1+max(getHeight(temp2.getRight()),getHeight(temp2.getLeft()));
            temp2=temp2.getParent();
        }
        temp2.height=1+max(getHeight(temp2.getRight()),getHeight(temp2.getLeft()));
        
        Node temp3=temp;
        while(temp3!=root){
            temp3.balance=getHeight(temp3.getLeft())-getHeight(temp3.getRight());
            temp3=temp3.getParent();
        }
        temp3.balance=getHeight(temp3.getLeft())-getHeight(temp3.getRight());
        
        Node temp4=temp;
        int pin=0;
        while(temp4!=root)
        {
            if(temp4.balance!=0 &&  temp4.balance!=1 && temp4.balance!=-1){
                pin=1;
                break;
            }
            temp4=temp4.getParent();
        }
        if(root.balance!=0 &&  root.balance!=1 && root.balance!=-1 && pin==0){
            temp4=root;
            pin=1;
        }
        if(pin==1){
            if(temp4.balance>1 && temp4.getLeft().compareTo(n)==1){
                Node z = temp4; Node y = z.getLeft(); Node x = y.getLeft();
                Node a = x.getLeft(); Node b = x.getRight(); Node c = y.getRight(); Node d = z.getRight();
                if(z!=root){
                Node par = z.getParent();
               if(a!=null) {
                a.setParent(x);
                x.setLeft(a); 
    }
    else x.setLeft(null);
    if(b!=null){
    b.setParent(x);
                x.setRight(b); 
    } 
        else x.setRight(null);
    if(c!=null){
    c.setParent(z);
                z.setLeft(c); 
    }
        else z.setLeft(null);
    if(d!=null){
    d.setParent(z);
    z.setRight(d); 
    }
        else z.setRight(null);
 z.setParent(y); y.setParent(par);
y.setRight(z);
                
                if(par.getLeft()==z){                
                    par.setLeft(y);
                }else{
                    par.setRight(y);
                }
                }
                else
                {
        
               if(a!=null) {
                a.setParent(x);
                x.setLeft(a); 
    }
    else x.setLeft(null);
    if(b!=null){
    b.setParent(x);
                x.setRight(b); 
    } 
        else x.setRight(null);
    if(c!=null){
    c.setParent(z);
                z.setLeft(c); 
    }
        else z.setLeft(null);
    if(d!=null){
    d.setParent(z);
    z.setRight(d); 
    }
        else z.setRight(null);

                    z.setParent(y); y.setParent(null); y.setRight(z);
                    root=y;
                }
                 
        x.height=1+max(getHeight(x.getRight()),getHeight(x.getLeft()));
        z.height=1+max(getHeight(z.getRight()),getHeight(z.getLeft()));
        Node temp10=x;
        while(temp10!=root)
        {
            temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
            temp10=temp10.getParent();
        }
        temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
        
        Node temp5=z;
        while(temp5!=root)
        {
            temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
            temp5=temp5.getParent();
        }
        temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
                
            }
                
            else if(temp4.balance>1 && temp4.getLeft().compareTo(n)==-1){
                //System.out.println("Hello Wordo0o0");
                //System.out.println("Hello Wordjj "+temp4.data);
                Node z = temp4; Node y = z.getLeft(); Node x = y.getRight();
                //System.out.println("Hello Wordx "+y.getRight().data);
                //System.out.println("Hello Wordy "+y.data);
                //System.out.println("Hello Wordz "+z.data);
                Node a = y.getLeft();
                Node b = x.getLeft(); Node c = x.getRight(); 
                Node d = z.getRight();
                if(z!=root){
                Node par = z.getParent();
                
               if(a!=null) {
                a.setParent(y);
                y.setLeft(a); 
    }
    else y.setLeft(null);
    if(b!=null){
    b.setParent(y);
                y.setRight(b); 
    } 
        else y.setRight(null);
    if(c!=null){
    c.setParent(z);
                z.setLeft(c); 
    }
        else z.setLeft(null);
    if(d!=null){
    d.setParent(z);
    z.setRight(d); 
    }
        else z.setRight(null);

                z.setParent(x); x.setParent(par); y.setParent(x);
                x.setLeft(y); x.setRight(z);                 
                if(par.getLeft()==z){                
                    par.setLeft(x);
                }else{
                    par.setRight(x);
                }
                }
                else
                {
    
               if(a!=null) {
                a.setParent(y);
                y.setLeft(a); 
    }
    else y.setLeft(null);
    if(b!=null){
    b.setParent(y);
                y.setRight(b); 
    } 
        else y.setRight(null);
    if(c!=null){
    c.setParent(z);
                z.setLeft(c); 
    }
        else z.setLeft(null);
    if(d!=null){
    d.setParent(z);
    z.setRight(d); 
    }
        else z.setRight(null);
                    z.setParent(x); x.setParent(null); y.setParent(x);
                x.setLeft(y); x.setRight(z);   
                root=x;
        }
        x.height=1+max(getHeight(x.getRight()),getHeight(x.getLeft()));
        z.height=1+max(getHeight(z.getRight()),getHeight(z.getLeft()));
        Node temp10=x;
        while(temp10!=root)
        {
            temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
            temp10=temp10.getParent();
        }
        temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
        
        Node temp5=z;
        while(temp5!=root)
        {
            temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
            temp5=temp5.getParent();
        }
        temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
        
        
            }
            
            else if(temp4.balance<-1 && temp4.getRight().compareTo(n)==1){
                Node z = temp4; Node y = z.getRight(); Node x = y.getLeft();
                Node a = z.getLeft(); Node b = x.getLeft(); Node c = x.getRight(); Node d = y.getRight();
                if(z!=root){
                Node par = z.getParent();
                
               if(a!=null) {
                a.setParent(z);
                z.setLeft(a); 
    }
    else z.setLeft(null);
    if(b!=null){
    b.setParent(z);
                z.setRight(b); 
    } 
        else z.setRight(null);
    if(c!=null){
    c.setParent(y);
                y.setLeft(c); 
    }
        else y.setLeft(null);
    if(d!=null){
    d.setParent(y);
    y.setRight(d); 
    }
        else y.setRight(null);
    z.setParent(x); x.setParent(par); y.setParent(x);
                x.setLeft(z); x.setRight(y); 
                
                if(par.getLeft()==z){                
                    par.setLeft(x);
                }else{
                    par.setRight(x);
                }
                }
                else
                {
        
               if(a!=null) {
                a.setParent(z);
                z.setLeft(a); 
    }
    else z.setLeft(null);
    if(b!=null){
    b.setParent(z);
                z.setRight(b); 
    } 
        else z.setRight(null);
    if(c!=null){
    c.setParent(y);
                y.setLeft(c); 
    }
        else y.setLeft(null);
    if(d!=null){
    d.setParent(y);
    y.setRight(d); 
    }
        else y.setRight(null);

                     z.setParent(x); x.setParent(null); y.setParent(x);
                x.setLeft(z); x.setRight(y); 
                root=x;
         }
         
         y.height=1+max(getHeight(y.getRight()),getHeight(y.getLeft()));
        z.height=1+max(getHeight(z.getRight()),getHeight(z.getLeft()));
        Node temp10=y;
        while(temp10!=root)
        {
            temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
            temp10=temp10.getParent();
        }
        temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
        
        Node temp5=z;
        while(temp5!=root)
        {
            temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
            temp5=temp5.getParent();
        }
        temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
         
            }
            
            else if(temp4.balance<-1 && temp4.getRight().compareTo(n)==-1){
                Node z = temp4; Node y = z.getRight(); Node x = y.getRight();
                Node a = z.getLeft(); Node b = y.getLeft(); Node c = x.getLeft(); Node d = x.getRight();
                if(z!=root){
                Node par = z.getParent();
                
               if(a!=null) {
                a.setParent(z);
                z.setLeft(a); 
    }
    else z.setLeft(null);
    if(b!=null){
    b.setParent(z);
                z.setRight(b); 
    } 
        else z.setRight(null);
    if(c!=null){
    c.setParent(x);
                x.setLeft(c); 
    }
        else x.setLeft(null);
    if(d!=null){
    d.setParent(x);
    x.setRight(d); 
    }
        else x.setRight(null);
    z.setParent(y); y.setParent(par);
    y.setRight(x); y.setLeft(z);
                
                if(par.getLeft()==z){                
                    par.setLeft(y);
                }else{
                    par.setRight(y);
                }
                }
                else
                {
    
               if(a!=null) {
                a.setParent(z);
                z.setLeft(a); 
    }
    else z.setLeft(null);
    if(b!=null){
    b.setParent(z);
                z.setRight(b); 
    } 
        else z.setRight(null);
    if(c!=null){
    c.setParent(x);
                x.setLeft(c); 
    }
        else x.setLeft(null);
    if(d!=null){
    d.setParent(x);
    x.setRight(d); 
    }
        else x.setRight(null);

               z.setParent(y); y.setParent(null);
                y.setRight(x); y.setLeft(z);
                root=y;
                //z.left=null; z.right=null;x.left=null;x.right=null;
                }
                
                x.height=1+max(getHeight(x.getRight()),getHeight(x.getLeft()));
        z.height=1+max(getHeight(z.getRight()),getHeight(z.getLeft()));
        Node temp10=x;
        while(temp10!=root)
        {
            temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
            temp10=temp10.getParent();
        }
        temp10.height=1+max(getHeight(temp10.getRight()),getHeight(temp10.getLeft()));
        
        Node temp5=z;
        while(temp5!=root)
        {
            temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
            temp5=temp5.getParent();
        }
        temp5.height=1+max(getHeight(temp5.getRight()),getHeight(temp5.getLeft()));
            }
        
        }
    }
}