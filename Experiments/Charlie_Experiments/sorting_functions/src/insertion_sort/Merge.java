package insertion_sort;

//import java.util.ArrayList;

public class Merge {
	
	public static void MergeSort(int[] a){
		
		int n = a.length;
		if (n <= 1) {
			return;
		}
		int m = n/2;
		int o = n/2;
		if(n%2 == 1) {
			o++;
		}
		int[] left = new int[o];
		int[] right = new int[m];
		for(int i = 0; i < o; i++) {
			left[i] = a[i];
		}
		for(int i = 0; i < m; i++) {
			right[i] = a[i+o];
		}
		MergeSort(left);
		MergeSort(right);
		int[] temp = Merge(left, right);
		for(int i = 0; i < temp.length; i++) {
			a[i] = temp[i];
		}
	}
	
	public static int[] Merge(int[] b, int[] c) {
		int p = b.length;
		int q = c.length;
		int[] d = new int[p+q];
		int i = 0;
		int j = 0;
		while(i < p && j < q) {
			if(b[i] <= c[j]) {
				d[i+j] = b[i];
				i++;
			}
			else {
				d[i+j] = c[j];
				j++;
			}
		}
		if (i >= p) {
			for(j = j; j < q; j++) {
				d[j+i] = c[j];
			}
		}
		else {
			for(i = i; i < p; i++) {
				d[i+j] = b[i];
			}
		}
		return d;
	}
}
