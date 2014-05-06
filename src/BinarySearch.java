public class BinarySearch {

	public static void main(String[] args) {

		int[] F = { 2, 4, 5, 6, 7, 8, 9, 11 };
		int k = 5;

		long before = System.currentTimeMillis();
		int result = Search(F, k);
		long after = System.currentTimeMillis();
		double durationMS = after - before;

		System.out.println("time: " + durationMS + " ms");

		long before2 = System.currentTimeMillis();
		int result2 = SearchRec(F, k, 0, F.length - 1);
		long after2 = System.currentTimeMillis();
		double durationMS2 = after2 - before2;

		System.out.println("time2: " + durationMS2 + " ms");

		System.out.println((result + 1) + " " + (result2 + 1));
	}

	public static int Search(int[] F, int k) {
		int down = 0;
		int up = F.length - 1;
		int middle;
		while (down <= up) {
			middle = (down + up) / 2;
			if (F[middle] == k)
				return middle;
			else if (k < F[middle])
				up = middle - 1;
			else
				down = middle + 1;
		}
		return -1;
	}

	public static int SearchRec(int[] F, int k, int down, int up) {
		int middle = (down + up) / 2;
		if (F[middle] == k)
			return middle;
		if (down == up)
			return -1;
		if (F[middle] > k)
			return SearchRec(F, k, down, middle - 1);
		return SearchRec(F, k, middle + 1, up);
	}
}
