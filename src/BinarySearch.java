import java.util.Random;

public class BinarySearch {

	public static void main(String[] args) {

		Random rand = new Random();

		int[] testarray = new int[20]; // create test array

		int randomFact = rand.nextInt(10) + 1; // randomize a number that we use
												// as a factor for the array
												// elements

		for (int i = 0; i < testarray.length; i++) {
			int randomInt = i * randomFact; // create the random number
			testarray[i] = randomInt; // the array is sorted
		}

		int randomIndex = rand.nextInt(20);

		int element = testarray[randomIndex]; // pick a random element as our
												// wanted element

		String stringList = "";
		for (int i = 0; i < testarray.length; i++)
			stringList += testarray[i] + " ";
		System.out.println("The list is: " + stringList + " Our element is: "
				+ element); // print out our test array

		long startTime = System.nanoTime();

		int status = SearchRec(testarray, element, 0, testarray.length - 1);

		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		double seconds = (double) (duration / 1000000000.0); // measure the time
																// of the
																// recursive
																// algorithm

		long startTime2 = System.nanoTime();

		int status2 = Search(testarray, element);

		long endTime2 = System.nanoTime();

		long duration2 = (endTime - startTime);
		double seconds2 = (double) (duration / 1000000000.0); // measure the
																// time of the
																// iterative
																// algorithm

		String output = "(Recursive) The Position of the element in the Array is: "
				+ (status + 1)
				+ ". \r\nThis was computed in "
				+ seconds
				+ " seconds. \r\n"
				+ "(Iterative) The Position of the element in the Array is: "
				+ (status + 1)
				+ ". \r\nThis was computed in "
				+ seconds2
				+ " seconds. \r\n";

		System.out.println(output); // print out the result
	}

	public static int Search(int[] array, int element) {

		int low = 0;
		int high = array.length - 1;
		int mid;

		while (low <= high) {

			mid = (int) Math.floor((low + high) / 2); // split the array in half

			if (array[mid] == element) // we found the element
				return mid;

			else if (element < array[mid]) // if the element is in the lower
											// half
				high = mid - 1; // continue with the lower half

			else
				low = mid + 1; // otherwise continue with the upper half
		}
		return -1;
	}

	public static int SearchRec(int[] array, int element, int low, int high) {

		int mid = (int) Math.floor((low + high) / 2); // split the array in half

		if (array[mid] == element) // we found the element
			return mid;

		if (low == high) // element not found
			return -1;

		if (array[mid] > element) // if it is in the upper half
			return SearchRec(array, element, low, mid - 1); // continue with the
															// upper half

		return SearchRec(array, element, mid + 1, high); // otherwise continue
															// with the lower
															// half
	}
}
