class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        int i = nums1.length-1;
        int j = m-1;
        while(j >= 0){
            nums1[i] = nums1[j];
            nums1[j] = 0;
            j--;
            i--;
        }
        //j is 0 and i = first element of nums1
        int k = 0;
        j = 0;
        i = nums1.length - m;
        while(i < nums1.length && j < n){
            if(nums1[i] <= nums2[j]){
                nums1[k] = nums1[i];
                nums1[i] = 0;
                i++;
            }else{
                nums1[k] = nums2[j];
                nums2[j] = 0;
                j++;
            }
            print(nums1);
            k++;
        }

        while(j < n){
            nums1[k] = nums2[j];
            k++;
            j++;
        }
    }

    void print(int[] ar){
        for(int i : ar){
            System.out.print(i);
        }
        System.out.println();
    }
}