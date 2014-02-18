public class MedianOfTwoSortedArray{
	private static int findKthHelper(int[] a, int[] b, int l, int r, int k){
		if(l > r) {
			return findKthHelper(b, a, Math.max(0, k - a.length - 1), Math.min(b.length - 1, k - 1), k);
		}
		int m = (l + r)/2;
		int j = k - m - 1;
		if((j == 0 || a[m] >= b[j - 1]) && (j == b.length || a[m] <= b[j])){
			return a[m];
		}else if(j!=0 && a[m] < b[j - 1]){
			return findKthHelper(a, b, m + 1, r, k);
		}else{
			return findKthHelper(a, b, l, m - 1, k); 
		}
	}
	public static int findKth(int[] a, int[] b, int k){
		int len_a = a.length;
		int len_b = b.length;
		if(k <= 0 || len_a + len_b < k) throw new IndexOutOfBoundsException();
		else{
			return findKthHelper(a, b, Math.max(0, k - b.length - 1), Math.min(a.length - 1, k - 1), k);	
		}
	}
	public static double findMedian(int[] a, int[] b){
		int len_a = a.length;
		int len_b = b.length;
		int k = len_a + len_b;
		if(k%2 == 0){
			int m1 = findKth(a, b, k/2);
			int m2 = findKth(a, b, k/2 + 1);
			return (double) (m1 + m2)/2;
		}
		else return findKth(a, b, k/2 + 1); 
	}
	public static void main(String[] args){
		int[] a = {1, 3, 4};
		int[] b = {1, 1, 3};
		double m = findMedian(a, b);
		System.out.println(m);
	}
}