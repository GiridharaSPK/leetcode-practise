​- Integer.MAX_VALUE = 2^31 - 1
- Integer.MIN_VALUE = - 2^31
- when using java max and java min values check the edge cases
    -- if there is a possibility of input matching with those - then make `int` to `long`
    -- passing Integer.MAX_VALUE + 1 to long value doesnt work (probably becuase it compiles first as int and pass)
    -- also check if there is a possiblity of occuring those in an extended question
- always check input values range check for edge cases
- when it is mentioned "must be less than root" check for equals case ( ===  and 2,2,2,..)
- when you think 2 helper (recursive) functions are needed pass 2 params in helper instead
- * remember that *all* the nodes in left subtree of node in BST has to be less than root and same with right
