/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    const val = this[this.length-1];
    return val === undefined ? -1 : val;
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */