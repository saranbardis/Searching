public class LinearSearch {

	public static void main(String[] args) {

		int[] F = { 2, 4, 5, 6, 7, 8, 9, 11 };
		int k = 5;

		long before = System.currentTimeMillis();
		int result = Search(F, k);
		long after = System.currentTimeMillis();
		double durationMS = after - before;

		System.out.println("time: " + durationMS + " ms");

		long before2 = System.currentTimeMillis();
		int result2 = SearchRec(F, k, 0);
		long after2 = System.currentTimeMillis();
		double durationMS2 = after2 - before2;

		System.out.println("time2: " + durationMS2 + " ms");

		System.out.println((result + 1) + " " + (result2 + 1));
	}

	public static int Search(int[] F, int k) {
		for (int i = 0; i < F.length; i++) {
			if (F[i] == k) {
				return i;
			}
		}
		return -1;
	}

	public static int SearchRec(int[] F, int k, int startingIndex) {
		if (k == F[startingIndex])
			return startingIndex;
		if (startingIndex + 1 < F.length)
			return SearchRec(F, k, startingIndex + 1);
		return -1;
	}
}