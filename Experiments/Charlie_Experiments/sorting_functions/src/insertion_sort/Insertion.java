package insertion_sort;

public class Insertion {

	public static void InsertionSort(int[] A) {
		int n = A.length;
		for(int i = 1; i <= n-1; ++i) {
			int temp = A[i];
			int j = i - 1;
			while(j > -1  && A[j] > temp) {
				A[j+1] = A[j];
				--j;
			}
			A[j+1] = temp;
		}
	}
}
