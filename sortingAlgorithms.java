import java.util.Locale;
import java.lang.System;
import java.text.NumberFormat;

public class sortingAlgorithms {
	static NumberFormat nu = NumberFormat.getInstance(Locale.US);

//////////////////////////////////////BubbleSort///////////////////////////////////////////////////////////////////////////////////////////////
	// CREDIT: https://www.geeksforgeeks.org/bubble-sort/

	public static class BubbleSort {

		private long timeStart;
		private long timeEnd;
		private int size;
		private int[] bubArr;

		public int getSize() {

			return this.size;

		}

		public BubbleSort(int arr[]) {

			this.size = arr.length;
			this.bubArr = arr;

		}

		public void sort() {

			this.timeStart = System.nanoTime();
			int n = bubArr.length;
			
			for (int i = 0; i < n - 1; i++) {

				for (int j = 0; j < n - i - 1; j++) {

					if (bubArr[j] > bubArr[j + 1]) {

						// swap arr[j+1] and arr[j]
						int temp = bubArr[j];
						bubArr[j] = bubArr[j + 1];
						bubArr[j + 1] = temp;

					}
				}
				
				this.timeEnd = (System.nanoTime() - timeStart);
				
			}
		}

		public void printTime() {
			
			System.out.println("Total Runtime: " + (nu.format(timeEnd) + " nanoseconds"));
			
		}
	}

//////////////////////////////////////SelectionSort///////////////////////////////////////////////////////////////////////////////////////////////
	// CREDIT: https://www.geeksforgeeks.org/selection-sort/
	
	public static class SelectionSort {
		
		long timeStart;
		long timeEnd;
		int size = 0;
		int[] selArr;

		public int getSize() {
			
			return this.size;
			
		}

		public SelectionSort(int arr[]) {
			
			this.size = arr.length;
			this.selArr = arr;
			
		}

		public void sort() {
			
			timeStart = System.nanoTime();
			int n = this.selArr.length;

			// One by one move boundary of unsorted subarray
			for (int i = 0; i < n - 1; i++) {
				// Find the minimum element in unsorted array
				int min_idx = i;
				
				for (int j = i + 1; j < n; j++) {
					
					if (selArr[j] < selArr[min_idx])
						min_idx = j;
					
				}
				// Swap the found minimum element with the first
				// element
				int temp = selArr[min_idx];
				selArr[min_idx] = selArr[i];
				selArr[i] = temp;
			}
			
			timeEnd = (System.nanoTime() - timeStart);
			
		}

// Prints the time to sort in nanoseconds
		public void printTime() {
			
			System.out.println("Total Runtime: " + (nu.format(timeEnd) + " nanoseconds"));

		}
	}

//////////////////////////////////////InsertionSort///////////////////////////////////////////////////////////////////////////////////////////////
	// CREDIT: https://www.geeksforgeeks.org/insertion-sort/
	
	public static class InsertionSort {
		
		long timeStart;
		long timeEnd;
		int size;
		int[] insertion;

		public int getSize() {
			
			return this.size;
			
		}

		public InsertionSort(int arr[]) {
			
			this.size = arr.length;
			this.insertion = arr;
			
		}

		public void sort() {
			
			timeStart = System.nanoTime();
			int n = insertion.length;
			
			for (int i = 1; i < n; ++i) {
				
				int key = insertion[i];
				int j = i - 1;

				/*
				 * Move elements of arr[0..i-1], that are greater than key, to one position
				 * ahead of their current position
				 */
				while (j >= 0 && insertion[j] > key) {
					
					insertion[j + 1] = insertion[j];
					j = j - 1;
					
				}
				
				insertion[j + 1] = key;
			}
			
			timeEnd = (System.nanoTime() - timeStart);
			
		}

		public void printTime() {
			
			System.out.println("Total Runtime: " + (nu.format(timeEnd) + " nanoseconds"));

		}

	}

//////////////////////////////////////MergeSort///////////////////////////////////////////////////////////////////////////////////////////////
	// CREDIT: https://www.geeksforgeeks.org/merge-sort/
	
	public static class MergeSort {

		long timeStart;
		long timeEnd;
		int size = 0;
		int[] mergeArr;

		public int getSize() {
			
			return this.size;
			
		}

		public MergeSort(int arr[]) {
			
			this.size = arr.length;
			this.mergeArr = arr;
			
		}

		public void merge(int left, int middle, int right) {
			// Find sizes of two subarrays to be merged
			int n1 = middle - left + 1;
			int n2 = right - middle;

			/* Create temp arrays */
			int Left[] = new int[n1];
			int Right[] = new int[n2];

			/* Copy data to temp arrays */
			for (int i = 0; i < n1; ++i) {
				
				Left[i] = mergeArr[left + i];
				
			}
			
			for (int j = 0; j < n2; ++j) {
				
				Right[j] = mergeArr[middle + 1 + j];
				
			}

			/* Merge the temp arrays */

			// Initial indexes of first and second subarrays
			int i = 0, j = 0;

			// Initial index of merged subarray array
			int k = left;
			
			while (i < n1 && j < n2) {
				
				if (Left[i] <= Right[j]) {
					
					mergeArr[k] = Left[i];
					i++;
					
				} else {
					
					mergeArr[k] = Right[j];
					j++;
					
				}
				k++;
			}

			/* Copy remaining elements of L[] if any */
			while (i < n1) {
				
				mergeArr[k] = Left[i];
				i++;
				k++;
				
			}

			/* Copy remaining elements of R[] if any */
			while (j < n2) {
				
				mergeArr[k] = Right[j];
				j++;
				k++;
				
			}
			
		}

		// Main function that sorts arr[l..r] using
		// merge()
		public void sort(int left, int right) {
			
			timeStart = System.nanoTime();
			
			if (left < right) {
				// Find the middle point
				int middle = left + (right - left) / 2;

				// Sort first and second halves
				sort(left, middle);
				sort(middle + 1, right);

				// Merge the sorted halves
				merge(left, middle, right);
			}
			
			timeEnd = (System.nanoTime() - timeStart);
			
		}

		public void printTime() {
			
			System.out.println("Total Runtime: " + (nu.format(timeEnd) + " nanoseconds"));
			
		}
	}

//////////////////////////////////////QuickSort///////////////////////////////////////////////////////////////////////////////////////////////
	// CREDIT: https://www.interviewbit.com/tutorial/quicksort-algorithm/
	// https://www.hackerearth.com/practice/algorithms/sorting/quick-sort/tutorial/

	public static class Quicksort {

		long timeStart;
		long timeEnd;
		int size = 0;
		int[] quickArr;

		public int getSize() {
			
			return this.size;
			
		}

		public Quicksort(int arr[]) {
			
			this.size = arr.length;
			this.quickArr = arr;
			
		}

		public int partition(int start, int end) {
			
			int i = start + 1;
			int piv = start; // make the first element as pivot element.
			
			for (int j = start + 1; j <= end; j++) {
				/*
				 * rearrange the array by putting elements which are less than pivot on one side
				 * and which are greater that on other.
				 */

				if (quickArr[j] < quickArr[piv]) {
					
					swap(i, j);
					i += 1;
				} else if (quickArr[i] == quickArr[j]) {
					
					break;
					
				}
			}
			
			swap(piv, i - 1); // put the pivot element in its proper place.
			return i - 1; // return the position of the pivot
		}

		public void sort(int start, int end) {
			
			timeStart = System.nanoTime();
			
			if (start < end) {
				// stores the position of pivot element
				int piv_pos = partition(start, end);
				sort(start, piv_pos - 1); // sorts the left side of pivot.
				sort(piv_pos + 1, end); // sorts the right side of pivot.
			}
			
			timeEnd = (System.nanoTime() - timeStart);
			
		}

		// A utility function to swap two elements
		public void swap(int i, int j) {
			
			int temp = quickArr[i];
			quickArr[i] = quickArr[j];
			quickArr[j] = temp;
			
		}

		public void printTime() {
			
			System.out.println("Total Runtime: " + (nu.format(timeEnd) + " nanoseconds"));
			
		}
	}

//////////////////////////////////////ShellSort///////////////////////////////////////////////////////////////////////////////////////////////
	/// CREDIT: https://www.geeksforgeeks.org/shellsort/
	public static class Shellsort {
		
		long timeStart;
		long timeEnd;
		int size = 0;
		int[] shellArr;

		public int getSize() {
			
			return this.size;
			
		}

		public Shellsort(int arr[]) {
			
			this.size = arr.length;
			this.shellArr = arr;
			
		}

		/* function to sort shellArr using shellSort */
		public int sort() {
			
			timeStart = System.nanoTime();
			int n = shellArr.length;

			// Start with a big gap, then reduce the gap
			for (int gap = n / 2; gap > 0; gap /= 2) {
				// Do a gapped insertion sort for this gap size.
				// The first gap elements a[0..gap-1] are already
				// in gapped order keep adding one more element
				// until the entire shellArray is gap sorted
				for (int i = gap; i < n; i += 1) {
					// add a[i] to the elements that have been gap
					// sorted save a[i] in temp and make a hole at
					// position i
					int temp = shellArr[i];

					// shift earlier gap-sorted elements up until
					// the correct location for a[i] is found
					int j;
					for (j = i; j >= gap && shellArr[j - gap] > temp; j -= gap) {
						
						shellArr[j] = shellArr[j - gap];
						
					}

					// put temp (the original a[i]) in its correct
					// location
					shellArr[j] = temp;
				}
			}
			
			timeEnd = (System.nanoTime() - timeStart);
			return 0;
			
		}

		public void printTime() {
			
			System.out.println("Total Runtime: " + (nu.format(timeEnd) + " nanoseconds"));
			
		}
	}
}