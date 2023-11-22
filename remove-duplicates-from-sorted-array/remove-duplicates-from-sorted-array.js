/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    
    let i = 0;
    
    for(j=0; j<nums.length; j++){
        if(nums[j] !== nums[i]){
            nums[i+1]  = nums[j];
            i += 1;
        }
    }
    
    return i+1;
    
};