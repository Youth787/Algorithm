import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n;
	static int[] array;

	public static void main(String[] args) throws IOException {
		// 퀵정렬 - 호어파티션
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = 1000000;
		array = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		} // 입력받기 완료

		quickSort(0, n - 1);
		System.out.print(array[500000]);

	}// main end

	public static void quickSort(int l, int r) {
		if (l < r) {
			int pivot = Partition(l, r);
			quickSort(l, pivot - 1);
			quickSort(pivot + 1, r);
		}
	}

	public static int Partition(int left, int right) {
		int pivot = array[left];
		int L = left + 1;
		int R = right;
		while (L <= R) {
			while (L <= R && array[L] <= pivot)
				L++;
			while (array[R] > pivot)
				R--;
			if (L < R) {
				swap(array,L,R);
			}
		}
		swap(array,left,R);
		return R;
	}

	public static void swap(int[] array , int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
