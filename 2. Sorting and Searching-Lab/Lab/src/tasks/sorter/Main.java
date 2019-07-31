package tasks.sorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[] arr;
	public static int[] auxArr;
	
	public static void main(String[] args) throws IOException {
		
		arr = readArray();
		auxArr = new int[arr.length];
		
		mergeSort(0, arr.length - 1);
//		impossible to beat judge with quick sort 
//		quickSort(0, arr.length - 1);
		printOutput();
	}

//	private static void quickSort(int low, int high) {
//		int pivot;
//		
//		if (low > high) {
//			return;
//		}
//		
//		pivot = partArr(low, high);
//		quickSort(low, pivot - 1);
//		quickSort(pivot + 1, high);
//	}

//	private static int partArr(int low, int high) {
//		int pivot = arr[low];
//		
//		while (low < high) {
//			while (low < high && arr[high] >= pivot) {
//				high--;
//			}
//			
//			swap(low, high);
//			
//			while (low < high && arr[low] <= pivot) {
//				low++;
//			}
//			swap(low, high);
//		}
//		
//		return low;
//	}
//
//	private static void swap(int i, int j) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}

	private static void printOutput() {
		StringBuilder sBuilder = new StringBuilder();
		for (int i : arr) {
			sBuilder.append(i).append(" "); 
		}
		
		System.out.println(sBuilder);
	}

	private static int[] readArray() throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		String[] inputs = bReader.readLine().split(" ");
		int[] arr = new int[inputs.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(inputs[i]);
		}
		
		return arr;
	}
	
	private static void mergeSort(int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		
		int mid = lo + (hi - lo) / 2;
		
		mergeSort(lo, mid);
		mergeSort(mid + 1, hi);
		merge(lo, mid, hi);	
	}

	private static void merge(int lo, int mid, int hi) {
		
		if (arr[mid] < arr[mid + 1]) {
			return;
		}
	
		for (int index = lo; index < hi + 1; index++) {
			auxArr[index] = arr[index];
		}
	
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = auxArr[j++];
			} else if (j > hi) {
				arr[k] = auxArr[i++];
			} else if (auxArr[i] < auxArr[j]) {
				arr[k] = auxArr[i++];
			} else {
				arr[k] = auxArr[j++];
			}
		}		
	}
}