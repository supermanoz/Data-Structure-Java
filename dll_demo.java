class Node 
{
	int info; Node next; Node previous; 
	public Node()
	{
		//info =0;
		next = null; previous = null; 
	}
	public Node(int el)
	{ 
		info = el;
		next = null; previous = null;
	}
	public Node(int el,Node n, Node p)
	{ 
		info = el;
		next = n; previous =p;
	}
}
class DLinkList 
{
	Node head; Node tail; 
	public DLinkList()
	{
		head = tail = null; 
	}
	public boolean isEmpty()
	{ 
		return tail==null;
	}
	public void addToHead(int el) 
	{
		Node newNode = new Node (el);
		if (isEmpty())                    //if list is empty
		{
			head = tail = newNode;
		}
		else
		{
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		}
	}
	public void addToLast (int el)
	{
		Node newNode = new Node (el); 
		Node current = tail;
		if (isEmpty())                    //if list is empty
		{
			head = tail = newNode;
		}
		newNode.next = null;
		tail = newNode;
		newNode.previous = current;
		current.next = newNode;
	}

	void delete_first()
	{
		Node temp = head;
		if(head == tail)
			head = tail =null;
		else
		{
			head = head.next;
			temp.next = null;
			head.previous = null;
		}
	}

	void delete_last()
	{
		Node temp = tail;
		if(head == tail)
			head = tail =null;
		else
		{
			tail = tail.previous;
			tail.next = null;
			temp.previous = null;
		}
	}


	public void printAll()
	{
		Node temp = head;
		while(temp.next!=null)
		{
			System.out.print(temp.info+"<-->"); 
			temp = temp.next;		
		}	
		System.out.println(temp.info);
	}
}
class dll_demo
{
	public static void main(String[] args) 
	{
		DLinkList list = new DLinkList();
		list.addToHead(40);
		list.printAll();
		list.addToHead(30);
		list.printAll();
		list.addToHead(20);
		list.printAll();
		list.addToLast(15);
		list.printAll();
		list.addToHead(10);
		list.printAll();
		list.addToLast(50);
		list.printAll();
		list.delete_first();
		list.printAll();
		list.delete_last();
		list.printAll();

	}
}


