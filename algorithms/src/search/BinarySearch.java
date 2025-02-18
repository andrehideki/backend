package search;

public class BinarySearch {
	
	public static int search(int val, int[] arr, int start, int end) {
		if (start > end) return -1;
		
		int mid = (int) Math.floor((start + end) / 2);
		System.out.println(start + " : " + end);
		
		if (val == arr[mid]) return mid;
		
		if (val > arr[mid]) {
			return search(val, arr, mid + 1, end);
		}
		if (val < arr[mid]) {
			return search(val, arr, start, mid - 1);
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int [] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(search(1, arr, 0, arr.length));
	}
}
