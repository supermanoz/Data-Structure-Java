class node
{
	int data;
	node left;
	node right;
	public node()
	{
		data=0;
		left=null;
		right=null;
	}
	public node(int el)
	{
		data=el;
		left=null;
		right=null;
	}
}

class tree
{
	node head=null,ptr=null,prev=null;
	boolean isEmpty()
	{
		if(head==null)
			return true;
		else
			return false;
	}
	void insert(int n)
	{
		node newnode=new node(n);
		if(isEmpty())
		{	
			head=newnode;
			head.right=null;
			head.left=null;
		}
		else{
			ptr=head;
			while(ptr!=null)
			{
				if(newnode.data>ptr.data)
				{
					prev=ptr;
					ptr=ptr.right;
				}
				else
				{
					prev=ptr;
					ptr=ptr.left;
				}
			}
			if(newnode.data>prev.data)
				prev.right=newnode;
			else
				prev.left=newnode;
		}
	}

	void preorder(node ptr)
	{
		if(ptr!=null){
			visit(ptr);
			preorder(ptr.left);
			preorder(ptr.right);
		}
	}

	void inorder(node ptr)
	{
		if(ptr!=null){		
			inorder(ptr.left);
			visit(ptr);
			inorder(ptr.right);
		}
	}

	void postorder(node ptr)
	{
		if(ptr!=null){
			postorder(ptr.left);
			postorder(ptr.right);	
			visit(ptr);
		}
	}

	static void visit(node p)
	{
		System.out.print(p.data+", ");
	}

	node search(int el)
	{
		ptr=head;
		int lvl=0;
		while(ptr!=null)
		{
			if(el==ptr.data)
			{
				System.out.println(el+" Found in "+lvl+"th level!");
				return ptr;	
			}
			else if(el>ptr.data)
			{
				ptr=ptr.right;
				lvl++;
			}
			else
			{
				ptr=ptr.left;
				lvl++;
			}

		}
		System.out.println(el+" Not Found!");
		return null;
	}
}

class binarytree
{
	public static void main(String args[])
	{
		tree ob= new tree();
		ob.insert(70);
		ob.insert(40);
		ob.insert(90);
		ob.insert(20);
		ob.insert(65);
		ob.insert(5);
		ob.insert(30);
		ob.insert(80);
		ob.insert(105);
		ob.insert(77);
		ob.insert(85);
		System.out.print("Preorder: ");
		ob.preorder(ob.head);
		System.out.println();
		System.out.print("Inorder: ");
		ob.inorder(ob.head);
		System.out.println();
		System.out.print("Postorder: ");
		ob.postorder(ob.head);
		System.out.println();
		ob.search(80);
		ob.search(10);
	}
}