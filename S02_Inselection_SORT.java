/* Inselection sort */

public class S02_Inselection_SORT
{
	public static void main(String[]args)
	{
		int array[] = {5, 8, 2, 6, 9, 4, 3, 7, 1};
		
		System.out.println("Unsorted array:");
		print_array(array);
		  
		inselectSort(array);
		  
		System.out.println("\nSorted array");
		print_array(array);
	}
	 

 
  
	/************************/
	/*** inselection sort ***/
	/************************/
  public static void inselectSort(int array[])
  {
	  int j; // counter for inner loop
	  int k; // starts index of minimum value
	  int min; // stores minimun value

	  
	  for(int i = 0; i < array.length; i++)
	  {
		  min = array[i];
		  
		  for(j = i + 1, k = i; j < array.length; j++)
		  {
			  if(array[j] < min)
			  {
				  min = array[j];
				  k = j;
			  }
		  }
		  if(k < array.length)
		  {
			  swap(array, i, k); 
			  System.out.println(); 
			  print_array(array);
		  }
	  }
  }

  
  
  /************/
  /*** swap ***/
  /************/
  public static void swap(int [] array, int i, int k)
  {
    int temp = array[i];
    array[i] = array[k];
    array[k] = temp;
  } 
  
  
  /*******************/
  /*** print array ***/
  /*******************/
  public static void print_array(int array[])
  {
	  for(int s = 0; s < array.length; s++)
		{
			System.out.print(array[s] + " ");
		}
  }
}