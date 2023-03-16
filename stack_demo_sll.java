class Node
{
	Node next;
	int data;
	Node()
	{
		next=null;
	}
	Node(int el)
	{
		data=el;
		next=null;
	}
	Node(int el, Node n)
	{
		data=el;
		next=n;
	}
}

class stack_sll
{
	Node top; int size;
	stack_sll()
	{
		top=null;
		size=0;
	}
	boolean isEmpty()
	{
		return top==null;
	}
	public int getSize()
	{
		return size;
	}
	void push(int data)
	{
		Node abc=new Node(data);
		if(isEmpty()){
			top=abc;
		}
		else{
			abc.next=top;
			top=abc;
		}
		size++;
	}
	int pop()
	{
		if(isEmpty())
		{
			return 0;
		}
		Node abc=top;
		top=abc.next;
		size--;
		return abc.data;
	}
	void display()
	{
		Node abc=top;
		if(size==0)
		{
			System.out.println("Empty Stack!");
		}
		while(abc!=null)
		{
			System.out.println(abc.data);
			abc=abc.next;
		}
	}
}
class stack_demo_sll
{
	public static void main(String args[])
	{
		stack_sll ob=new stack_sll();
		ob.push(10);
		ob.push(20);
		ob.push(30);
		ob.display();
		System.out.println("Size: "+ob.getSize());
		ob.pop();
		ob.display();
	}
}