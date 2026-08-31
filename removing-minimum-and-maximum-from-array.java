class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1)
        {
            return 1;
        }
        int n=nums.length;
        int minin=0;
        int maxin=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[minin]>nums[i])
            {
                minin=i;
            }
            if(nums[maxin]<nums[i])
            {
                maxin=i;
            }            
        }
        int left = Math.min(minin, maxin);
        int right = Math.max(minin, maxin);
         int leftOnly = right + 1;
         int rightOnly=  n - left;
         int both = (left + 1) + (n - right);
        return Math.min(leftOnly,
                Math.min(rightOnly, both));

    }
}
