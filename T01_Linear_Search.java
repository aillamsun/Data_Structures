public class T01_Linear_Search {
	public static void main(String[] args) {
		int unsorted[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int search = 5;

		for (int i = 0; i < unsorted.length - 1; i++) {
			if (unsorted[i] == search) {
				System.out.println("Search done! " + "Value "+ search + " at Index " + i);
			}
		}
	}
}
