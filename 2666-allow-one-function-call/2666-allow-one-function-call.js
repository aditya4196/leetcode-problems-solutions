/**
 * @param {Function} fn
 * @return {Function}
 */
var once = function(fn) {

    this.isCalled =false;
    return function(...args){
     if(!this.isCalled){
         this.isCalled = true;
         return fn.apply(this,args);
     } 
    }
};

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
