/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    var ar = [];
    for(var i = 0; i <= n; i++) ar.push(i);

    for(var i = 0; i <=n; i++){
        for (var j = 0; j*j <= i; j++){
            ar[i] = Math.min(ar[i], ar[i - (j*j)]+1);
            // console.log(ar);
        }
    }
    return ar[n];
};