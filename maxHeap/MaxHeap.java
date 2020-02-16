package practice.maxHeap;

import java.util.Arrays;

public class MaxHeap {
	private int[] arr;
	private int heapSize;
	private int capacity = 100;

	MaxHeap(int[] data) {
		arr = new int[capacity];
		heapSize = data.length;
		
		for (int i = 1; i <= data.length; i++) {
			arr[i] = data[i-1];
		}
		buildMaxHeap();
	}

	public int getHeapSize() {
		return heapSize;
	}

	public int getCapacity() {
		return capacity;
	}

	public void buildMaxHeap() {
		for (int i = heapSize/2; i >= 1; i--) {
			maxHeapify(i);
		}
	}

	public void maxHeapify(int idx) {
		int leftIdx = 2 * idx;
		int rightIdx = 2 * idx + 1;
		int largestIdx = idx;
		
		// find the largest index
		if (leftIdx <= heapSize && arr[leftIdx] > arr[idx]) {
			largestIdx = leftIdx;
		}
		if (rightIdx <= heapSize && arr[rightIdx] > arr[largestIdx]) {
			largestIdx = rightIdx;
		}

		// if parent does not have the largest value
		if (largestIdx != idx) {
			// swap
			int tmp = arr[idx];
			arr[idx] = arr[largestIdx];
			arr[largestIdx] = tmp;

			maxHeapify(largestIdx);
		}
	}

	public void print() {
		for (int i = 1; i <= heapSize; i++) {
			System.out.printf("  %d", arr[i]);
		}
		System.out.println();
	}

	// from small value to large value
 	public void sort() {
 		int actualHeapSize = heapSize;
 		while(heapSize > 0) {
 			int tmp = arr[1];
	 		arr[1] = arr[heapSize];
	 		arr[heapSize] = tmp;

	 		heapSize--;
	 		maxHeapify(1);
 		}
 		heapSize = actualHeapSize;
	}

	// insert
	public void push(int val) {
		if (heapSize + 1 == capacity) {
			int[] extend_arr = Arrays.copyOf(arr, arr.length + 1);
			capacity++;
		}
		heapSize++;
		arr[heapSize] = val;

		int currentIdx = heapSize;
		int parentIdx = currentIdx / 2;
		while (currentIdx > 1) {
			if (arr[currentIdx] > arr[parentIdx]) {
				int tmp = arr[currentIdx];
				arr[currentIdx] = arr[parentIdx];
				arr[parentIdx] = tmp;

				currentIdx = parentIdx;
				parentIdx /= 2;
			}
			else {
				break;
			}
		}
	}

	// extractMax
	public int pop() {
		int tmp = arr[1];
		arr[1] = arr[heapSize];
		heapSize--;
		maxHeapify(1);

		return tmp;
	}
}