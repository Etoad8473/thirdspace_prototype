package insertion_sort;



public class Selection {

	public static void SelectionSort(int[] A) {
		
		int n = A.length;
		for(int i = 0; i <= n-1; i++) {
			int min = i;
			for(int j = i+1; j <= n-1; j++) {
				if(A[j] < A[min]) {
					min = j;
				}
			}
			int temp = A[i];
			A[i] = A[min];
			A[min] = temp;
		}
	}
}
