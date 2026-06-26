class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0)return 0;
        int currentlength=1;
        int maxlength=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]==nums[i]+1){
                currentlength++;
                maxlength=Math.max(currentlength,maxlength);
            }else if(nums[i]==nums[i+1]){
                continue;
            }else{
        currentlength=1;
            }}
        
        return maxlength;
    }}