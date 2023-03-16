class mergeSort
{
	public static int data[]={5,12,36,11,8,2,3};
	public static int[] helper=new int[data.length];
	public static void mergesort(int arr[],int first, int last)
	{
		if(first<last){
			int mid=(first+last)/2;
			mergesort(arr,first,mid);
			mergesort(arr,mid+1,last);
			merge(arr,first,mid,last);	
		}
	}
	public static void merge(int array[],int first, int mid, int last)
	{
		for(int i=first;i<=last;i++)
		{
			helper[i]=data[i];
			for(int val:helper)
		{
			System.out.print(val+", ");
		}
			System.out.println();
		}

		int i=first;
		int j=mid+1;
		int k=first;

		while(i<=mid && j<=last)
		{
			if(helper[i]<=helper[j])
			{
				data[k]=data[i];
				i++;
			}
			else{
				data[k]=data[j];
				j++;
			}
			k++;
		}

		while(i<=mid)
		{
			data[k]=helper[i];
			k++;
			i++;
		}
	}
	public static void main(String args[])
	{
		int end=data.length-1;
		mergesort(data,0,end);
		for(int i:data)
		{
			System.out.print(i+", ");
		}
	}
}