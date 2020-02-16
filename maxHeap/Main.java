package practice.maxHeap;

import practice.maxHeap.MaxHeap;

public class Main {
	public static void main(String[] args) {
		int[] data = {15, 1, 16, 7, 22, 19, 34, 28, 31, 11};
		
		System.out.printf("Array before max heapifying:");
		printArray(data);

		System.out.printf("Array after max heapifying:");
		MaxHeap heap = new MaxHeap(data);
		heap.print();

		// test
		System.out.println(heap.getHeapSize());
		heap.push(29);
		heap.push(35);
		System.out.println(heap.pop());
		heap.print();
		System.out.println(heap.getHeapSize());
		heap.sort();
		heap.print();
		System.out.println(heap.getHeapSize());
		heap.buildMaxHeap();
		heap.print();
	}

	public static void printArray (int[] data) {
		for(int element : data) {
			System.out.printf("  %d", element);
		}
		System.out.println();
	}
}