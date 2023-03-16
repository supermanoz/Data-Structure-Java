/*Assignment as per Java to Create a Singly linked List by addind 5 nodes at different positions and then search a node having value of info or data field 25. If the element is found then prints "Search is Successful" otherwise prints "Sorry, the element you have searched is not in the list."
Note: Compile and run the code in command line or terminal(in mac) and then submit it in pdf file.*/

class Node
{
	public Node head;
	public Node tail;
	public int info;
	public Node next;
	public Node()
	{
		next=null;
	}
	public Node(int el)
	{
		info=el;
		next=null;
	}
	public Node(int el,Node n)
	{
		info=el;
		next=n;
	}
}

class SLL
{
	Node head,tail;
	public SLL()
	{
		head=tail=null;
	}
	public boolean isEmpty()
	{
		return tail==null;
	}

	public void insertAtHead(int el){
		Node newnode= new Node(el);
		if(isEmpty())
			head=tail=newnode;
		else{
			newnode.next=head;
			head=newnode;
		}
	}

	public void insertAtTail(int el){
		Node newnode=new Node(el);
		Node temp=head;
		if(isEmpty())
			head=tail=newnode;
		else{
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				temp.next=newnode;
				newnode.next=null;
		}
	}

	public void insertAtAny(int el,int pos)
	{
		Node newnode=new Node(el);
		int count=1,position=pos;	
		Node temp=head;			
		while(count<position-1)
		{
			temp=temp.next;
			count++;
		}
		Node temp1=temp.next;
		newnode.next=temp1;
		temp.next=newnode;

	}

	public void deleteAtHead()
	{
		Node temp=head;
		head=temp.next;
		temp.next=null;
	}

	public void deleteAtTail()
	{
		Node temp=head;
		Node previous=null;
		while(temp.next!=null)
		{
			previous=temp;
			temp=temp.next;
		}
		previous.next=null;
	}

	public void deleteAtAny(int pos)
	{
		Node temp=head;
		int count=1,position=pos;
		while(count<position-1)
		{
			temp=temp.next;
			count++;
		}
		Node del=temp.next;
		Node temp1=del.next;
		temp.next=temp1;
		del.next=null;
	}

	public void display()
	{
		Node temp=head;
		while(temp.next!=null)
		{
			System.out.print(temp.info+"--> ");
			temp=temp.next;
		}
		System.out.print(temp.info);
		System.out.println();
	}

	public void search(int el)
	{
		int query=el;
		boolean found=false;
		int count=1;
		Node temp=head;
		while(temp.next!=null)
		{
			if(query==temp.info){
				found=true;
				System.out.println("Search is successful at position "+count);
			}

			temp=temp.next;
			count++;
		}
		if(!found){
				System.out.println("Sorry, the element you have searched is not in the list!");
		}
	}
}

class slldemo
{
	public static void main(String args[])
	{
		SLL ob=new SLL();
		ob.insertAtHead(25);
		ob.display();
		ob.insertAtHead(10);
		ob.display();
		ob.insertAtTail(15);
		ob.display();
		ob.deleteAtHead();
		ob.display();
		ob.insertAtAny(50,3);
		ob.display();
		ob.insertAtHead(10);
		ob.display();
		ob.deleteAtTail();
		ob.display();
		ob.insertAtAny(75,2);
		ob.display();
		ob.insertAtHead(55);
		ob.display();
		ob.insertAtTail(35);
		ob.display();
		ob.deleteAtAny(4);
		ob.display();
		ob.search(25);
	}
}