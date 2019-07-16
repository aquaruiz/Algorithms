package inversionCount;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		scanner.close();
		
        System.out.println(mergeSort(arr));
    }

    private static int mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        return sort(arr, temp, 0, arr.length - 1);
    }

    private static int sort(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;

        if(right > left) {
            mid = (right + left) / 2;

            invCount = sort(arr, temp, left, mid);
            invCount += sort(arr, temp, mid + 1, right);

            invCount += merge(arr, temp, left, mid + 1, right);
        }

        return invCount;
    }

    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i, j, k;

        int invCount = 0;

        i = left;
        j = mid;
        k = left;

        while((i <= mid - 1) && (j<= right)) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += mid - i;
            }
        }

        while(i <= mid - 1) {
            temp[k++] = arr[i++];
        }

        while(j <= right) {
            temp[k++] = arr[j++];
        }

        for(i=left; i<= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}