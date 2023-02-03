package insertion_sort;

public class SortingTests extends Quick{
	
	public static void main(String[] args) {
		int[] A = {3,34,7,2,33,78,6,9,14,35,52,12};
	
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ",");
		}
		System.out.println();
		
		// InsertionSort(A);
		//MergeSort(A);
		quicksort(A);
		
		for(int i = 0; i < A.length; i++) {
			System.out.print(A[i] + ",");
		}
	}
}
