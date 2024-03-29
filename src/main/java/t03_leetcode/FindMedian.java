package t03_leetcode;

/**
 * @description: <p></p>
 * @author: terui
 * @date: 2019/9/10 8:45 下午
 */
public class FindMedian {
    /**
     * 找出中位数
     * 时间/空间复杂度都为O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int nums[] = new int[m + n];

        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }

        if(n == 0){
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)){
            if(i == m){
                while (j != n){
                    nums[count++] = nums2[j++];
                }
                break;
            }

            if(j == n){
                while (i!=m){
                    nums[count++] = nums1[i++];
                }
                break;
            }

            if(nums1[i] < nums2[j]){
                nums[count ++] = nums1[i++];
            }else {
                nums[count++] = nums2[j++];
            }
        }
        if(count % 2 == 0){
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        }else {
            return nums[count / 2];
        }
    }

    /**
     * 空间复杂度为O1
     * 时间复杂度为O(M+N)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1;
        int right = -1;
        int aStart = 0;
        int bStart = 0;
        for(int i = 0; i < len/2; i++){
            left = right;
            if(aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])){
                right = nums1[aStart++];
            }else {
                right = nums2[bStart++];
            }
        }
        if((len & 1) == 0){
            return (left + right) / 2.0;
        }else {
            return right;
        }

    }

    public static void main(String[] args) {
        System.out.println(new FindMedian().findMedianSortedArrays(new int[]{3,5},new int[]{4}));
    }
}
