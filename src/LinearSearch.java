public class LinearSearch {

	public static void main(String[] args) {

		int[] F = { 2, 4, 5, 6, 7, 8, 9, 11 };
		int k = 5;

		long before = System.currentTimeMillis();
		int result = Search(F, k);
		long after = System.currentTimeMillis();
		double durationMS = after - before;

		System.out.println("Zeit: " + durationMS + " ms");
		System.out.println(result);
	}

	public static int Search(int[] F, int k) {
		for (int i = 0; i < F.length; i++) {
			if (F[i] == k) {
				return i;
			}
		}
		return -1;
	}
}