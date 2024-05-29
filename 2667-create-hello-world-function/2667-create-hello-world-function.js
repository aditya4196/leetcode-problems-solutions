/**
 * @return {Function}
 */
var createHelloWorld = function() {
    
    return (...args) => {
        return "Hello World";
    }
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */