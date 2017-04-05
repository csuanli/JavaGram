package cn.csu.Gram.Detail;

/**
 * @file Sequence.java
 * @author 李岸
 * @version 1.0
 * @since Apr 26, 2010
 */
public class Sequence {

	public static void main(String[] args) {
		char[] in = "abc".toCharArray();
		new Sequence().sequence(in, in.length, 0);
	}

	private void sequence(char[] array, int n, int k) {
		if (n == k) {
			char[] out = new char[n];
			for (int i = 0; i < array.length; i++) {
				out[i] = array[i];
			}
			System.out.println(new String(out));
		} else {
			for (int i = k; i < n; i++) {
				swap(array, k, i);
				sequence(array, n, k + 1);
				swap(array, i, k);
			}
		}
	}

	private void swap(char[] a, int x, int y) {
		char temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}