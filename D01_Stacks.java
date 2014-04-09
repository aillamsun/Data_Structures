import java.util.Arrays;

/* DATA STRUCTURES
 * FIRST IN LAST OUT
 * FILO
 * */

public class D01_Stacks
{
	String[] stackArray;
	int stackSize;
	int topOfStack = -1;  //empty
	
	public D01_Stacks(int size) 
	{
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1"); //fill the array with -1's
	}
	
	
	//put on top
	public void push(String input)
	{
		 //make sure there is room before you put something on it
		if(topOfStack+1 < stackSize) 
		{
			topOfStack++;                    //there is room so go up
			stackArray[topOfStack] = input;  //put input 
		}
		else  //no room
		{
			System.out.println("Sorry but the stack is full!");
		}
		System.out.println("PUSH " + input + " was added to the Stack");
		displayArray();
	}
	
	
	
	//remove from top
	public void pop()
	{
		if(topOfStack >= 0)  //there is room
		{
			//print array
			System.out.println("POP " + stackArray[topOfStack] + " was removed");
			stackArray[topOfStack] = "-1"; //remove top of stack
			topOfStack--;     //top is empty so move it down
		}
		else  //stack is empty
		{
			System.out.println("Sorry but the stack is empty");
		}
		displayArray();
	}
	
	
	
	//look at top of stack but dont remove or add
	public void peek()
	{
		System.out.println("PEEK " + stackArray[topOfStack] + " is at the top");
		displayArray();
	}
	
	
	//display Array - mini method
	public void displayArray()
	{
		for(int i = 0; i < stackArray.length; i++)
		{
			System.out.print(stackArray[i] + " ");
		}
		System.out.println("\n");
	}
	
	
	public static void main(String[] args)
	{
		D01_Stacks m = new D01_Stacks(10);
		
		//test case
		m.push("10");
		m.peek();
		m.push("20");
		m.push("30");
		m.push("40");
		m.pop();
		m.pop();
		m.pop();
		m.pop();
		m.pop();
	}

}
