import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	/*
	 * Tp 1 : Problem of Hanoi
	 */
	public static void hanoi(int n, char from, char temp, char to) {
		if (n == 0)
			return;
		hanoi(n - 1, from, to, temp);
		//System.out.println("Move the disk " + n + " from " + from + " to " + to);
		hanoi(n - 1, temp, from, to);
	}
	
	/*
	 * Tp 1 : Value container
	 */
	public static void hanoiContainer(int n, char from, char temp, char to) {
		
		List<Long> listTpsHanoi = new ArrayList<Long>();
		
		for(int i = 1; i < n; i++) {
			long moyenneTemps = 0;
			for(int j = 0; j < 5; j++) {
				
				long start = System.nanoTime();
				hanoi(n, from, temp, to);
				long duration = (System.nanoTime()-start);
				moyenneTemps+=duration;
			}
			moyenneTemps = moyenneTemps/5;
			listTpsHanoi.add(moyenneTemps);
		}
		
		for(int k = 0; k < n; k++) {
			
			System.out.print("Execution time for "+(k+1)+" disk(s) : ");
			long temps = listTpsHanoi.get(k).longValue();
			double second = (double)temps / 1000000000.0;
			
			System.out.println(second+" seconds.");
		}
	}
	
	/*
	 * Tp 1 : Fibonacci Iterative
	 */
	public static int fiboIterative(int n) {
		if(n <= 1) {
			return n;
		}
		int fib = 1;
		int previousFib = 1;
		
		for(int i=2; i<n; i++) {
			int temp = fib;
			fib+= previousFib;
			previousFib = temp;
		}
		return fib;
}
	
	/*
	 * Tp 1 : Fibonacci recursive
	 */
	public static int fiboRecursive(int n) {
		if(n <= 1) {
			return n;
		}
		return fiboRecursive(n-1) + fiboRecursive(n-2);
}
	
	/*
	 * Tp 1 : Fibonacci logarithm
	 */
	public static int fiboLogarithm(int n) {
	    if (n == 0) return 0;
	    if (n == 1) return 1;
	    int a = 0;
	    int b = 1;
	    int sum = 0;
	    for (int i = 2; i < n; i++) {
	        sum = a + b;
	        a = b;
	        b = sum;
	    }
	    return b;
	}
	
	/*
	 * Tp 2 : Maximum between two integer
	 */
	public static int max(int tab[], int length) {

		int i = 0, i_max = 0;
		while (i < length) {
			if (tab[i] > tab[i_max])
				i_max = i;
			i++;
		}
		return i_max;
	}

	/*
	 * Tp 2 : Switch two integer in an array
	 */
	public static void switcher(int tab[], int x, int y) {

		int tmp;
		tmp = tab[x];
		tab[x] = tab[y];
		tab[y] = tmp;
	}

	/*
	 * Tp 2 : Selective sort
	 */
	public static void selectiveSort(int tab[], int length) {

		int i_max;
		for (; length > 1; length--) {
			i_max = max(tab, length);
			switcher(tab, length - 1, i_max);
		}
	}

	/*
	 * Tp 2 : Insertion sort
	 */
	public static void insertionSort(int tab[], int length) {

	   int i, j;
	   for (i = 1; i < length; ++i) {
	       int elem = tab[i];
	       for (j = i; j > 0 && tab[j-1] > elem; j--)
	           tab[j] = tab[j-1];
	       tab[j] = elem;
	   }
	}
	
	/*
	 * Tp 2 : Bubble sort
	 */
	public static void bubbleSort(int array[], int n) {
		
		boolean inversion;
		do {
			inversion = false;

			for (int i = 0; i < n - 1; i++) {
				if (array[i] > array[i + 1]) {
					switcher(array, i, i + 1);
					inversion = true;
				}
			}
		} while (inversion);
	}
	
	/*
	 * Tp 2 : Merge sort
	 */
	// Merges two subarrays of arr[].
	static void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second sub arrays
		int i = 0, j = 0;

		// Initial index of merged sub array array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	static void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	
	//Useful functions :
	
	/* A utility function to print array of size n */
	public static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	/* A utility function to create an array of size n */
	public static int[] buildUpArray(int n) {
		
		int[] array = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; i++) {
			array[i] = r.nextInt(100);
		}
		
		return array;
	}
	
	/* A utility function to copy an array */
    public static int[] copy(int[] array, int n) {
    	int[] arrayTmp = new int[n];
    	for(int i=0;i<n;i++) {
    		arrayTmp[i] = array[i];
    	}
    	return arrayTmp;
    }
	
    /**
     * Main function
     * @param args
     */
	public static void main(String[] args) {
		
		/*Initialization*/
		long start;
		double second;
		long duration;
		
		/*TP n:1*/
		
		//Hanoi part :
		//maximum number of disk before it's way too long = 23
		int n = 10; //Number of disk
//		start = System.nanoTime();
//		hanoi(n, 'A', 'B', 'C');
//		duration = (System.nanoTime()-start);
//		second = (double)duration / 1000000000.0;
//		System.out.println(second+" seconds");
//		//Fibonacci
//		n = 1000000000;
//		start = System.nanoTime();
//		fiboIterative(n);
//		duration = (System.nanoTime()-start);
//		second = (double)duration / 1000000000.0;
//		System.out.println("Fibonacci Iterative : (for n = "+n+")");
//		System.out.println(second+" seconds");
//		
		n = 50;
		start = System.nanoTime();
		fiboRecursive(n); //Maximum 45 !
		duration = (System.nanoTime()-start);
		second = (double)duration / 1000000000.0;
		System.out.println("Fibonacci Recursive : (for n = "+n+")");
		System.out.println(second+" seconds");
//		
//		n = 1000000;
//		start = System.nanoTime();
//		fiboLogarithm(n);
//		duration = (System.nanoTime()-start);
//		second = (double)duration / 1000000000.0;
//		System.out.println("Fibonacci Logarithm : (for n = "+n+")");
//		System.out.println(second+" seconds");
		/*TP n:1 FIN*/
		
		/*TP n:2*/
		
//		//length of our array
//		//array of small size = 1_000
//		int small = 1000;
//		//array of medium size = 10_000
//		int medium = 10_000;
//		//array of large size = 100_000
//		int large = 150_000;
//		
//		int arrayLength = small;
//		//creation of the array that will be used for tests
//		int[] array = buildUpArray(arrayLength);
//		//creation of a temporary array to keep in memory the initial array
//		int[] arrayTmp = copy(array, arrayLength);
//		
//		printArray(arrayTmp);
//		System.out.println("Length of the array : "+arrayLength);
//		System.out.println();
//		//Beginning of the test for : selectiveSort
//		start = System.nanoTime();
//		selectiveSort(arrayTmp, arrayLength);
//		duration = (System.nanoTime()-start);
//		//End
//		second = (double)duration / 1000000000.0;
//		System.out.println("Beginning of the test for : selectiveSort");
//		System.out.print("Made in : ");
//		System.out.println(second+" seconds");
//		arrayTmp = copy(array, arrayLength);
//		System.out.println();
//		//Beginning of the test for : insertionSort
//		start = System.nanoTime();
//		insertionSort(arrayTmp, arrayLength);
//		duration = (System.nanoTime()-start);
//		//End
//		second = (double)duration / 1000000000.0;
//		System.out.println("Beginning of the test for : insertionSort");
//		System.out.print("Made in : ");
//		System.out.println(second+" seconds");
//		arrayTmp = copy(array, arrayLength);
//		System.out.println();
//		//Beginning of the test for : bubbleSort
//		start = System.nanoTime();
//		bubbleSort(arrayTmp, arrayLength);
//		duration = (System.nanoTime()-start);
//		//End
//		second = (double)duration / 1000000000.0;
//		System.out.println("Beginning of the test for : bubbleSort");
//		System.out.print("Made in : ");
//		System.out.println(second+" seconds");
//		arrayTmp = copy(array, arrayLength);
//		System.out.println();
//		//Beginning of the test for : mergeSort
//		start = System.nanoTime();
//		//void mergeSort(int arr[], int l, int r) {
//		mergeSort(arrayTmp, 0, arrayLength-1);
//		duration = (System.nanoTime()-start);
//		//End
//		second = (double)duration / 1000000000.0;
//		System.out.println("Beginning of the test for : mergeSort");
//		System.out.print("Made in : ");
//		System.out.println(second+" seconds");
//		arrayTmp = copy(array, arrayLength);
		
		
	}
}