/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 */
var FindSumPairs = function(nums1, nums2) {
    this.nums1 = nums1;
    this.nums2 = nums2;   
    this.map = new Map();
    
    
    this.nums2.forEach((num) => {
       this.map.set(num, (!this.map.has(num))?1:this.map.get(num)+1); 
    });
    
};

/** 
 * @param {number} index 
 * @param {number} val
 * @return {void}
 */
FindSumPairs.prototype.add = function(index, val) {
    let prevValue = this.nums2[index];
    this.nums2[index] += val;
    let value = this.nums2[index];
    this.map.set(prevValue, this.map.get(prevValue)-1);
    this.map.set(value, (!this.map.has(value))?1:this.map.get(value)+1); 
};

/** 
 * @param {number} tot
 * @return {number}
 */
FindSumPairs.prototype.count = function(tot) {

    let count = 0;
    
    this.nums1.forEach((num) => {
        if(this.map.has(tot - num)){
            count += Math.max(0,this.map.get(tot - num));
        }
    })
    
    return count;
};

/** 

[1,1,2,2,2,3]
       i
[1,4,5,2,5,4]

4 - 2
5 - 2
1 - 1
2 - 1

8



 * Your FindSumPairs object will be instantiated and called as such:
 * var obj = new FindSumPairs(nums1, nums2)
 * obj.add(index,val)
 * var param_2 = obj.count(tot)
 */