import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	 static int n;
	static int[] sortedArr,array;

	public static void main(String[] args) throws IOException {
		// 병합정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=1000000;
		array = new int[n];
		sortedArr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료

		mergeSort(0, n-1);
		System.out.print(array[500000]);

	}// main end

	public static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}// mergesort method end

	public static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;

		while (L <= mid && R <= right) {
			if (array[L] <= array[R])
				sortedArr[idx++] = array[L++];
			else
				sortedArr[idx++] = array[R++];
		} // while end

		if (L <= mid) {
			for (int i = L; i <= mid; i++)
				sortedArr[idx++] = array[i];
		} else {
			for (int j = R; j <= right; j++)
				sortedArr[idx++] = array[j];
		}
		for (int i = left; i <= right; i++) {
			array[i] = sortedArr[i];
		}
	}
}
