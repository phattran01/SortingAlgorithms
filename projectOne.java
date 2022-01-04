import java.util.Random;
import java.util.Scanner;

public class projectOne {
	static int file1[] = new int[15000];
	static int file2[] = new int[30000];
	static int file3[] = new int[70000];
	static int file4[] = new int[130000];
	static int file5[] = new int[250000];

	public static void main(String args[]) {
		Randomizer(file1);
		Randomizer(file2);
		Randomizer(file3);
		Randomizer(file4);
		Randomizer(file5);

		boolean flag = true;

		while (flag == true) {
			int selection1 = menu();
			if (selection1 == 1) {
				fileSort(file1);
			}
			if (selection1 == 2) {
				fileSort(file2);
			}
			if (selection1 == 3) {
				fileSort(file3);
			}
			if (selection1 == 4) {
				fileSort(file4);
			}
			if (selection1 == 5) {
				fileSort(file5);
			}
			if (selection1 == 0) {
				flag = false;
			}
		}

	}

	public static int menu() {
		int selection;
		Scanner in = new Scanner(System.in);
		System.out.println("====================================================================================================================");
		System.out.println("====================================================================================================================");
		System.out.println("Choose file 1-5 to sort. (Input 0 to break)");
		System.out.println("1 - File 1: 15,000 items.");
		System.out.println("2 - File 2: 30,000 items.");
		System.out.println("3 - File 3: 70,000 items.");
		System.out.println("4 - File 4: 130,000 items.");
		System.out.println("5 - File 5: 250,000 items.");
		System.out.println("0 - Quit.");
		System.out.println("====================================================================================================================");
		System.out.print("Input: ");
		selection = in.nextInt();
		System.out.println("====================================================================================================================");

		return selection;
	}

	public static int sortMenu() {
		int selection;
		Scanner in = new Scanner(System.in);
		System.out.println("====================================================================================================================");
		System.out.println("====================================================================================================================");
		System.out.println("What sort would you want to test for this file?");
		System.out.println("1 - Bubble Sort.");
		System.out.println("2 - Selection Sort.");
		System.out.println("3 - Insertion Sort.");
		System.out.println("4 - Merge Sort.");
		System.out.println("5 - Quick Sort.");
		System.out.println("6 - Shell Sort.");
		System.out.println("7 - Print Data set.");
		System.out.println("====================================================================================================================");
		System.out.print("Input: ");
		selection = in.nextInt();
		System.out.println("====================================================================================================================");

		return selection;
	}

	public static void Randomizer(int arr[]) {
		Random randNum = new Random();
		for (int i = 0; i < arr.length; i++) {

			arr[i] = randNum.nextInt(5000000);
		}
	}

	public static void printData(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("item %d: %d\n", i+1, arr[i]);
		}
	}

	public static void fileSort(int arr[]) {
		int temp[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		int selection2 = sortMenu();
		if (selection2 == 1) {
			sortingAlgorithms.BubbleSort b = new sortingAlgorithms.BubbleSort(temp);
			b.sort();
			b.printTime();
			System.out.println("====================================================================================================================");
			System.out.println("Would you like to generate the data set? Y or N.");
			System.out.print("Input: ");
			Scanner in = new Scanner(System.in);
			String selection3 = in.next();
			if(selection3.equals("Y") ) {
				for (int i = 0; i < temp.length; i++) {
					System.out.printf("item %d: %d\n", i+1, temp[i]);
				}
			}
		}
		if (selection2 == 2) {
			sortingAlgorithms.SelectionSort ss = new sortingAlgorithms.SelectionSort(temp);
			ss.sort();
			ss.printTime();
			System.out.println("====================================================================================================================");
			System.out.println("Would you like to generate the data set? Y or N.");
			System.out.print("Input: ");
			Scanner in = new Scanner(System.in);
			String selection3 = in.next();
			if(selection3.equals("Y") ) {
				for (int i = 0; i < temp.length; i++) {
					System.out.printf("item %d: %d\n", i+1, temp[i]);
				}
			}
		}
		if (selection2 == 3) {
			sortingAlgorithms.InsertionSort i = new sortingAlgorithms.InsertionSort(temp);
			i.sort();
			i.printTime();
			System.out.println("====================================================================================================================");
			System.out.println("Would you like to generate the data set? Y or N.");
			System.out.print("Input: ");
			Scanner in = new Scanner(System.in);
			String selection3 = in.next();
			if(selection3.equals("Y") ) {
				for (int k = 0; k < temp.length; k++) {
					System.out.printf("item %d: %d\n", k+1, temp[k]);
				}
			}
		}
		if (selection2 == 4) {
			sortingAlgorithms.MergeSort m = new sortingAlgorithms.MergeSort(temp);
			m.sort(0, temp.length - 1);
			m.printTime();
			System.out.println("====================================================================================================================");
			System.out.println("Would you like to generate the data set? Y or N.");
			System.out.print("Input: ");
			Scanner in = new Scanner(System.in);
			String selection3 = in.next();
			if(selection3.equals("Y") ) {
				for (int i = 0; i < temp.length; i++) {
					System.out.printf("item %d: %d\n", i+1, temp[i]);
				}
			}
		}
		if (selection2 == 5) {
			sortingAlgorithms.Quicksort q = new sortingAlgorithms.Quicksort(temp);
			q.sort(0, temp.length - 1);
			q.printTime();
			System.out.println("====================================================================================================================");
			System.out.println("Would you like to generate the data set? Y or N.");
			System.out.print("Input: ");
			Scanner in = new Scanner(System.in);
			String selection3 = in.next();
			if(selection3.equals("Y") ) {
				for (int i = 0; i < temp.length; i++) {
					System.out.printf("item %d: %d\n", i+1, temp[i]);
				}
			}
		}
		if (selection2 == 6) {
			sortingAlgorithms.Shellsort sh = new sortingAlgorithms.Shellsort(temp);
			sh.sort();
			sh.printTime();
			System.out.println("====================================================================================================================");
			System.out.println("Would you like to generate the data set? Y or N.");
			System.out.print("Input: ");
			Scanner in = new Scanner(System.in);
			String selection3 = in.next();
			if(selection3.equals("Y") ) {
				for (int i = 0; i < temp.length; i++) {
					System.out.printf("item %d: %d\n", i+1, temp[i]);
				}
			}
		}
		if(selection2 == 7) {
			printData(arr);
		}
	}
}
