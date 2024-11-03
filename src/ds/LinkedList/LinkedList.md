# Array vs Linked List

## Array: 
+ Cost of accessing an element: Constant time. For instance the base of the address is 200 (index 0), caculate address of A[i] = 200 + i*4 (4 bytes for integer), for instance index 6 costs: 200+6*4=224. => BigO(1).
+ Memory requirements: fixed size, there is unused of memory. For instance, an array of 7 elements: 7 * 4 bytes(integer) = 28 bytes, for instance of complex data type= 7*16=112 bytes. Memory may not be available as one large block. 
+ Cost of inserting of an element: 
a- at begininning - O(n) shift each element by one.
b- at end - O(1) if array is not full, O(n) if array is full
c- at the middle/n th position - O(n)
+ Ease of use: easy


## LinkedList 
+  Cost of accessing an element: Have multiple block of memory connected to each other (Node (data,address of the block)). Therefore, to access an element of an linkedlist is BigO(n);
+ Memory requirements: no unused memory, extra memory for pointer variables. 4 Nodes created = 8*4 = 32 bytes., however for complex: 4*20=80 bytes. Memory may be available as multiple small blocks.
+ Cost of inserting of an element:
a- at beginning - O(1) 
b- at end - O(n)
c- at middle - O(n)
+ Ease of use: a lot of error handling (memory leak)

### Result of comparision (win)
+ Cost of accessing an element: array.
+ Memory requirements: ll