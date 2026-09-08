class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        ans=0
        for i in range(n):
            ans=ans+nums[i]
        total=n*(n+1)//2
        missing=total-ans
        return missing
        