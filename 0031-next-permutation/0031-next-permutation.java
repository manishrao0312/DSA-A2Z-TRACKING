class Solution {
    public void nextPermutation(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int pivot=-1;
        for(int i=end;i>start;i--){
            if(nums[i]>nums[i-1]){
            pivot=i-1;
            break;
        }}if (pivot != -1) {
            for(int i=end;i>pivot;i--){
                if(nums[i]>nums[pivot]){
        int temp=nums[pivot];
        nums[pivot]=nums[i];
        nums[i]=temp;
        break;
                }}}
int left = pivot + 1;
        int right = end;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
            }
