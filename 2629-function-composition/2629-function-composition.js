/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {

        return function(x){
            const result = functions.reverse().reduce((a,func) => func(a),x);
            return result;
        }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */