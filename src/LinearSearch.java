import java.util.Random;

public class LinearSearch {

	public static void main(String[] args) {

		Random rand = new Random();

		int[] testarray = new int[20]; // create test array

		for (int i = 0; i < testarray.length; i++) {
			int randomInt = rand.nextInt(100) + 1; // create the random number
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

		int status = SearchRec(testarray, element, 0);

		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		double seconds = (double) (duration / 1000000000.0); // measure the time
																// of the
																// recursive
																// algorithm

		long startTime2 = System.nanoTime();

		int status2 = Search(testarray, element);

		long endTime2 = System.nanoTime();

		long duration2 = (endTime2 - startTime2);
		double seconds2 = (double) (duration2 / 1000000000.0); // measure the
																// time of the
																// iterative
																// algorithm

		String output = "(Recursive) The Position of the element in the Array is: "
				+ (status + 1)
				+ ". \r\nThis was computed in "
				+ seconds
				+ " seconds. \r\n"
				+ "(Iterative) The Position of the element in the Array is: "
				+ (status2 + 1)
				+ ". \r\nThis was computed in "
				+ seconds2
				+ " seconds. \r\n";

		System.out.println(output); // print out the result
	}

	public static int Search(int[] array, int element) {

		for (int i = 0; i < array.length; i++) { // iterate over the array

			if (array[i] == element) { // we found the element
				return i;
			}
		}
		return -1; // element not found
	}

	public static int SearchRec(int[] array, int element, int index) {

		if (element == array[index]) // we found the element
			return index;

		if (index + 1 < array.length) // iterate recursively over the array
			return SearchRec(array, element, index + 1);

		return -1; // element not found
	}
}