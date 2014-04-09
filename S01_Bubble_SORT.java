/* BUBBLE SORT
 * [2  4] 6  1  9  2  0
 *  2 [4  6] 1  9  2  0
 *  2  4 [6  1] 9  2  0
 *  2  4  1 [6  9] 2  0
 *  2  4  1  6 [9  2] 0
 *  2  4  1  6  2 [9  0]
 *  2  4  1  6  2  0 |9
 *  
 * [2  4] 1  6  2  0 |9
 *  2 [4  1] 6  2  0 |9
 *  2  1 [4  6] 2  0 |9
 *  2  1  4 [6  2] 0 |9
 *  2  1  4  2 [6  0]|9
 *  2  1  4  2  0 |6  9
 *  
 * [2  1] 4  2  0 |6  9
 *  1 [2  4] 2  0 |6  9
 *  1  2 [4  2] 0 |6  9
 *  1  2  2 [4  0]|6  9
 *  1  2  2  0 |4  6  9
 *  
 * [1  2] 2  0 |4  6  9
 *  1 [2  2] 0 |4  6  9
 *  1  2 [2  0]|4  6  9
 *  1  2  0 |2  4  6  9
 *  
 * [1  2] 0 |2  4  6  9
 *  1  0 |2  2  4  6  9
 *  
 * [1  0]|2  2  4  6  9
 * |0  1  2  2  4  6  9
 */

public class S01_Bubble_SORT {
	public static void main(String[] args) {
		int unsorted[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		/** Print unsorted array ***/
		System.out.println("UNSORTED ARRAY: ");
		print_array(unsorted);

		bubble_sort(unsorted);

		/*** Print sorted array ***/
		System.out.println("Sorted array: ");
		print_array(unsorted);
	}

	/*******************/
	/*** bubble_sort ***/
	/*******************/
	public static void bubble_sort(int unsorted[]) {
		int i = 0;
		int j = 0;
		boolean sort = false;

		while (sort == false) {
			sort = true;
			for (i = 0; (i + 1) < unsorted.length; i++) {
				if (unsorted[i] > unsorted[i + 1]) {
					swap(unsorted, i);
					sort = false;
					System.out.println();
					print(unsorted, i);
				}
			}
			System.out.println();
		}
	}

	/************/
	/*** SWAP ***/
	/************/
	public static void swap(int unsorted[], int i) {
		int temp = unsorted[i];
		unsorted[i] = unsorted[i + 1];
		unsorted[i + 1] = temp;
	}

	/*******************/
	/*** print array ***/
	/*******************/
	public static void print_array(int unsorted[]) {
		for (int i = 0; i < unsorted.length; i++) {
			System.out.print(unsorted[i] + " ");
		}
	}

	//
	public static void print(int unsorted[], int sp) {
		// flag = when you open [
		// first = "[8 " --8 is first
		boolean flag = false;
		boolean first = false;

		for (int i = 0; i < unsorted.length; i++) {

			// first "[" if index is equal to swap index
			if (i == sp) {
				System.out.print("[");
				flag = true;
			}

			if (flag == true && first == true) {
				System.out.print(unsorted[i]);
			} else {
				System.out.print(unsorted[i] + " ");
				if (flag == true)
					first = true;
			}

			// print "]" if index is equal to swap+1
			if (i == sp + 1) {
				System.out.print("] ");
				flag = false;
				first = false;
			}
		}
	}
}
