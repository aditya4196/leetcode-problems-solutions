/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function(arr, size) {
    const chunked = [];
    let i=0;
    
    for(i=0; i<=arr.length-size; i+=size){
        chunked.push(arr.slice(i, i+size));
    }
    
    if(arr.length%size != 0){
        chunked.push(arr.slice(i));
    }
    
    return chunked;
    
}