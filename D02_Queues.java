import java.util.Arrays;


/* DATA STRUCTURES
 * FIRST IN FIRST OUT
 * FIFO
 * */

public class D02_Queues 
{
	 String[] queueArray;
	int queueSize;
	int front;
	int last;
	int numberOfItem = 0;
	
	public D02_Queues(int size) 
	{
		queueSize = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");
	}

	
	//insert - add end of list
	public void insert(String input)
	{
		//get number of items, plus 1
		if(numberOfItem+1 <= queueSize) //test if there is room
		{
			queueArray[last] = input;
			last++;
			numberOfItem++;
			System.out.println("INSERT: " + input + " Was addded");
		}
		else  //no room
		{
			System.out.println("Sorry but the queue if full");
		}
		displayArray();
	}
	
	
	//delete 
	public void remove()
	{
		if(numberOfItem > 0)
		{
			System.out.println("REMOVE: " + queueArray[front] + " was remove");
			queueArray[front] = "-1";
			front++;
			numberOfItem--;
		}
		else
		{
			System.out.println("Sorry but the queue is EMPTY");
		}
		displayArray();
	}
	
	
	//1st element
	public void peek()
	{
		System.out.println("PEEK: The first Element is " + queueArray[front]);
		displayArray();
	}
	
	
	
	//display array
	public void displayArray()
	{
		for(int i = 0; i < queueArray.length; i++)
		{
			System.out.print(queueArray[i] + " ");
		}
		System.out.println("\n");
	}
	
	
	
	
	public static void main(String[] args)
	{
		D02_Queues m = new D02_Queues(6);
		
		m.peek();
		m.insert("2");
		m.insert("34");
		m.remove();
		
	}
}
