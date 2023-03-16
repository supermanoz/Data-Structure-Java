class node
{
	public int data;
	public node next;
	public node()
	{
		data=0;
		next=null;
	}
	public node(int dat)
	{
		data=dat;
		next=null;
	}
	public node(int dat, node link)
	{
		data=dat;
		next=link;
	}
}

class operation
{
	node head,tail;
	boolean isEmpty(){
		if(head==null)
			return true;
		else
			return false;
	}
	void addToHead(int el)
	{
		node n=new node(el);
		if(isEmpty())
		{
			head=tail=n;
		}
		else{
			n.next=head;
			head=n;
		}
	}
	void addToTail(int el)
	{
		node n=new node(el);
		if(isEmpty())
		{
			head=tail=n;
		}
		else
		{
			node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=n;
			n.next=null;
		}
	}
	void addToAny(int el,int pos)
	{
		node n=new node(el);
		if(isEmpty())
		{
			System.out.println("The list is Empty, so adding new node in the first position!");
			head=tail=n;
		}
		else
		{
			node temp=head;
			node prev=null;
			int i=1;
			while(i<pos)
			{
				prev=temp;
				temp=temp.next;
				i++;
			}
			prev.next=n;
			n.next=temp;
		}
	}
	void display()
	{
		node temp=head;
		System.out.println();
		while(temp.next!=null)
		{
			System.out.print(temp.data+" -->");
			temp=temp.next;
		}
		System.out.print(temp.data);
	}
	void deleteAtHead()
	{
		node temp=head;
		head=head.next;
		temp.next=null;	
	}

	void deleteAtTail()
	{
		node temp=head;
		node prev=null;
		while(temp.next!=null)
		{
			prev=temp;
			temp=temp.next;
		}
		prev.next=null;
	}
	void deleteAtAny(int pos)
	{
		node temp=head;
		node prev=null;
		int j=1;
		while(j<pos)
		{
			j++;
			prev=temp;
			temp=temp.next;
		}
		prev.next=temp.next;
		temp.next=null;
	}
}

class singlytest
{
	public static void main(String args[])
	{
		operation list=new operation();
		list.addToHead(15);
		list.addToHead(20);
		list.addToHead(25);
		list.addToHead(30);
		list.addToHead(35);
		list.addToHead(40);
		list.addToTail(10);
		list.addToAny(38,2);
		list.display();
		list.deleteAtAny(2);
		list.deleteAtHead();
		list.deleteAtTail();
		list.display();
	}
}