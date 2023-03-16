class Node
{
	int info;
	Node next,prev;
	public Node()
	{
		info=0;
		next=prev=null;
	}
	public Node(int el)
	{
		info=el;
		next=prev=null;
	}
	public Node(int el,Node p,Node n)
	{
		info=el;
		next=n;
		prev=p;
	}
}
class doublyLL
{
	Node head,tail;
	public doublyLL(){
		head=tail=null;
	}
	public boolean isEmpty()
	{
		return head==null;
	}
	public void addToHead(int el)
	{
		Node newnode=new Node(el);
		if(isEmpty())
			head=tail=newnode;
		else{
			head.prev=newnode;
			newnode.next=head;
			head=newnode;
		}
	}
	public void addToTail(int el)
	{
		Node newnode=new Node(el);
		if(isEmpty())
			head=tail=newnode;
		else{
			tail.next=newnode;
			newnode.prev=tail;
			tail=newnode;
			newnode.next=null;
		}
	}
	public void addToAny(int el, int position)
	{
		Node newnode=new Node(el);
		int count=1,pos=position;
		Node temp=head;
		while(count<pos-1)
		{
			temp=temp.next;
			count++;
		}
		Node sec=temp.next;	
		newnode.next=sec;
		sec.prev=newnode;
		temp.next=newnode;
		newnode.prev=temp;
	}
	public void deleteAtHead()
	{
		Node temp=head;
		if(head==tail)
			head=tail=null;
		else{	
			head=head.next;
			temp.next=null;
			head.prev=null;
		}
	}
	public void deleteAtTail()
	{
		Node temp=tail;
		if(head==tail)
			head=tail=null;
		else{
			tail=tail.prev;
			tail.next=null;
			temp.prev=null;
		}
	}
	public void deleteAtAny(int position)
	{
		int count=1,pos=position;
		Node temp=head;
		while(count<pos-1)
		{
			temp=temp.next;
		}
		Node del=temp.next;
		Node sec=del.next;
		temp.next=sec;
		sec.prev=temp;
	//	del.prev=null;del.next=null;
	}
	public void display()
	{
		Node temp=head;
		System.out.println();
		System.out.print("Head -->");
		while(temp.next!=null)
		{
			System.out.print(temp.info+" <--> ");
			temp=temp.next;
		}
		System.out.print(temp.info+" <-- Tail");
	}
}
class Nodes
{
	public static void main(String args[])
	{
		doublyLL ob=new doublyLL(); 
		ob.addToHead(30);
		ob.deleteAtHead();
		ob.addToHead(20);
		ob.addToHead(10);
		ob.addToAny(23,2);
		ob.addToAny(29,3);
		ob.addToTail(40);
		ob.addToTail(50);
		ob.addToTail(60);
		ob.addToAny(55,7);
		ob.display();
		ob.deleteAtHead();
		ob.deleteAtAny(2);
		ob.deleteAtTail();
		ob.display();
	}
}