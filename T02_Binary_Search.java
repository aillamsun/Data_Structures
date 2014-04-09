/* BINARY SEARCH
 * 1st - use a sorting algorithm on array(or it wont work)
 * 
 *  target value: {14}
 * array: 1 9 14 15 25 30 39 48
 * 
 * find middle value
 * 1 9 14 15 [25] 30 39 48 
 * 
 * compare target with middle value.
 * 14 < 25 
 * if true value has to be on left. dont worry about right side
 * if false vale has to be on right. dont worry about left side
 * 
 * middle value
 *  1 9 [14] 15  25
 *  
 *  compare target with middle value.
 *  14 < 14
 * if true value has to be on left. dont worry about right side
 * if false vale has to be on right. dont worry about left side
 * 
 * middle value
 * [14] 15
 * 
 * compare
 * 14 < 15
 * 
 * middle value
 * [14]
 * 
 * last value so 
 * 14 = 14
 * */

/* binary search are faster than linear search
 * bugs
 * 1. multiple: search and find only find one 
 * 2. 
 * */

public class T02_Binary_Search {

	public static void main(String[] args) {
		int sorted[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int search = 5;

		int lowIndex = 0;
		int heighIndex = sorted.length - 1; // sorted.length = 9 so minus 1
		while (lowIndex <= heighIndex) {
			int middleIndex = (lowIndex + heighIndex) / 2; // find middle index

			if (sorted[middleIndex] < search) {
				lowIndex = middleIndex + 1;
			} else if (sorted[middleIndex] > search) {
				heighIndex = middleIndex - 1;
			} else // found number
			{
				System.out.println("Search done! " + search + " at Index "
						+ middleIndex);
				break; // exit loop
			}
		}
	}
}
