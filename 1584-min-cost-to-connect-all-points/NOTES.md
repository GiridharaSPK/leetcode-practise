- use heaps - poll until visited size is equal to total nodes
- priority Queue of 2 elements (2-length array) new PriorityQueue<>((a,b) -> a[0] - b[0])
- create adj list e1-> [(dist, e2), ...] - these elements can be used to offer and pop from min heap
- start iterating over heap by offering and poping elements starting from “[0,0]” ([dist, element])
- each iteration
- check visited (if yes continue to next iteration),
- else update cost, go to further elements
- offer /add adj elements (of prev polled node) to heap after every iteration
​
NOTE: when using int[] to store 2 or 3 integers like a pair be careful when updating an element and reusing, because as it is a change by reference, it would affect the previously added entry as well
​