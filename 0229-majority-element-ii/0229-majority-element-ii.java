class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count=0;
        List<Integer> map=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int element=nums[i];
            count=0;
            if(map.contains(nums[i])){
                continue;
            }
            for(int j=0;j<nums.length;j++){
                if(nums[j]==element){
                    count++;
                }
            }
            if(count>nums.length/3){
                map.add(nums[i]);
                
            }
        }
return map;
        
    }
}
