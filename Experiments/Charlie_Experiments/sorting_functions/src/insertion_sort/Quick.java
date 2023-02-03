package insertion_sort;

public class Quick {

	private static void QuickSortRec (int[] arr, int first, int last) {
		if(first >= last) {
			return;
		}
		int p = partition(arr, first, last);
		QuickSortRec(arr, first, p-1);
		QuickSortRec(arr, p + 1, last);
	}
	
	public static void quicksort(int[] arr) {
		QuickSortRec(arr, 0, arr.length -1);
	}
	
	private static int partition(int[] arr, int first, int last){
		int pivot = arr[last];
		int i = first -1;
		for(int j = first; j < last; j++) {
			if(arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[last];
		arr[last] = temp;
		return i + 1;
	}
}
