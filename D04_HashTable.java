import java.util.ArrayList;
import java.util.Arrays;

//hashFunction1 - hash function but not good
//hashFunction2 - hash function, its ok but not good
public class D04_HashTable 
{
	String orgArray[];
	int arraySize;
	int itemsInArray = 0;
	
	/*** create array wilth all '0's in it ***/
	public D04_HashTable(int size)
	{
		arraySize = size;
		orgArray = new String[size];
		Arrays.fill(orgArray, "0");
	}
	
	
	
	public static void main(String[] args)
	{
		D04_HashTable m = new D04_HashTable(30); //create array with all 0's in it
		
		String addArray[] = {"3", "1", "5", "7", "7", "2", "9"}; 
		
		hashFunction1(addArray, m.orgArray);   //hash function but not good
		//hashFunction2(addArray, m.orgArray);   //has function its ok but not perfect
		m.findKey("3", m.orgArray);
		m.display(m.orgArray);
	}
	
	
	
	/*** put value in same index  ***/
	//bug: no duplicate values in this function
	//index = 0 1 2 3 4 5 6 7 8 9...
	//value =   1 2 3   5  6    9 
	public static void hashFunction1(String[] addArray, String[] orgArray)
	{
		for(int n = 0; n < addArray.length; n++)
		{
			String addArray_temp = addArray[n];
			orgArray[Integer.parseInt(addArray_temp)] = addArray_temp;
		}
	}
	

	
	
	/*** ***/
	// store values between 0 to 999 in array size 30.
	//we plan on not having more than 15 values in array.
	//cant user last function bc you will have to create array size 999
	public static void hashFunction2(String[] addArray, String[] orgArray)
	{	
		int arraySize = orgArray.length-1;
		for(int n = 0; n < addArray.length; n++)
		{
			String addArray_temp = addArray[n];               
			int arrayIndex = Integer.parseInt(addArray_temp) % arraySize;  //make sure it index not bigger than orarray size
			
			System.out.println("Modulus Index= "+arrayIndex +" for value "+ addArray_temp);
			while(orgArray[arrayIndex] != "0")   //if there is collision. move over right
			{
				++arrayIndex;  //move over right
				System.out.println("\t Collision Try "+arrayIndex+" Insted"); 
				arrayIndex %= arraySize;  //if you get end of array than circle back
			}
			orgArray[arrayIndex] = addArray_temp; // store in value
		}
	}
	
	

	

	/*** find information in hashtable ***/
	public static void findKey(String key, String[] orgArray)
	{
		int arraySize = orgArray.length-1;
		int arrayIndexHash = Integer.parseInt(key) % arraySize; //go direct to index
		while(orgArray[arrayIndexHash] != "0") //while its not empty
		{
			if(orgArray[arrayIndexHash] == key)
			{
				System.out.println(key+" was Found in Index "+arrayIndexHash );
				break;
			}
			else
			{
				++arrayIndexHash; //if didnt match than look at next index
			}
			arrayIndexHash %= arraySize; //if end of array circle back
		}
		System.out.println("Not found!");
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
