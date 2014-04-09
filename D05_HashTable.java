import java.util.ArrayList;
import java.util.Arrays;

//two ways to make hash function  better
//1-make sure orgarray size is prime - it will make the alg faster if its prime
//2-clutering. when collision it put in next index, 
//  which case bunch of numbers than bunch of space etc.. to fix we put in random place.

public class D05_HashTable 
{
	String orgArray[];
	int arraySize;
	int itemsInArray = 0;
	
	/*** create array wilth all '0's in it ***/
	public D05_HashTable(int size)
	{
		arraySize = size;
		orgArray = new String[size];
		Arrays.fill(orgArray, "0");
	}
	
	
	
	public static void main(String[] args)
	{
		D05_HashTable m = new D05_HashTable(30); //create array with all 0's in it
		
		String addArray[] = {"3", "1", "5", "7", "7", "2", "9"}; 
		
		
		m.increaseArraySize(31);                //make sure size of array is prime number  
		m.doubleHashFunction(addArray, m.orgArray);  //use hashfunction
		m.display(m.orgArray);                  //print array
	}
	

	
	
	/*** increse array size ***/
	public void increaseArraySize(int minArraySize)
	{
		int newArraySize = getNextPrime(minArraySize);
		moveOldArray(newArraySize);
	}

	
	
	
	/*** enter a number and it will find next prime number ***/
	public int getNextPrime(int minNumberToCheck)
	{
		for(int i = minNumberToCheck; true; i++)
		{
			if(isPrime(i))  //if its prime number than return it
				return i;
		}
	}
	
	
	/*** check if its prime number ***/
	public boolean isPrime(int number)
	{
		if(number % 2 == 0)
			return false;
		for(int i = 3; i*i <= number; i+=2)
		{
			if(number % i == 0)
				return false;
		}
		return true;
	}
	
	
	public void moveOldArray(int newArraySize)
	{
		String[] cleanArray = removeEmptySpaceInArray(orgArray); //no empty space
		orgArray = new String[newArraySize];
		arraySize = newArraySize;
		Arrays.fill(orgArray, "0"); 
		doubleHashFunction(cleanArray, orgArray);
	}
	
	
	/*** remove empty spaces ***/
	public String[] removeEmptySpaceInArray(String[] arrayToClean)
	{
		ArrayList<String> stringList = new ArrayList<String>();
		for(String theString: arrayToClean)
		{
			if(!theString.equals("0") && !theString.equals(""))
				stringList.add(theString);
		}
		return stringList.toArray(new String[stringList.size()]);
	}

	
	
	/*** ***/
	// store values between 0 to 999 in array size 30.
	//we plan on not having more than 15 values in array.
	//cant user last function bc you will have to create array size 999
	public static void doubleHashFunction(String[] addArray, String[] orgArray)
	{	
		int arraySize = orgArray.length-1;
		for(int n = 0; n < addArray.length; n++)
		{
			String addArray_temp = addArray[n];               
			int arrayIndex = Integer.parseInt(addArray_temp) % arraySize;  //make sure it index not bigger than orarray size
			int stepDistance = 7 - (Integer.parseInt(addArray_temp) % 7);
			
			System.out.println("Modulus Index= "+arrayIndex +" for value "+ addArray_temp);
			while(orgArray[arrayIndex] != "0")   //if there is collision. move over right
			{
				arrayIndex += stepDistance;  //random
				System.out.println("\t Collision Try "+arrayIndex+" Insted"); 
				arrayIndex %= arraySize;  //if you get end of array than circle back
			}
			orgArray[arrayIndex] = addArray_temp; // store in value
		}
	}
	
	
	/*** display ***/
	public static void display(String[] orgArray)
	{
		for(int n = 0; n < orgArray.length; n++)
		{
			System.out.print(n + " | ");
		}
		System.out.println();
		
		for(int n = 0; n < orgArray.length; n++)
		{
			if(n < 10)
				System.out.print(orgArray[n] + " | ");
			else
				System.out.print(orgArray[n] + "  | ");
		}
		System.out.println();
	}	
}
