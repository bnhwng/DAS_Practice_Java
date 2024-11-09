
Partitioning is placing a pivot value into its correct position on the list.
Anything on the left is smaller than the pivot point and anything on the right is larger than the pivot point.

Partitioning algorithm is essential for quicksort (handling all the sorting)

Step 1: 

Pivot=last; 
i pointer to the a position before the first element.

Step 2:

Create a loop to traverse from the first element to the last element (loop breaks when it reaches the last element)

Create a condition within the loop(if(loop-pointer < last)){
if(i pointer==null){
  i pointer = first;
} else {
  i pointer= next;
}
swap(i,j);
}

=> This will traverse the list and help to reach on step before placing the pivot into the correct order.

Step 3
  Call i.next
  and swap i with last as it is the last step
  return the index or the Node
  
  public static Node partition(Node first, Node last) {
    int pivot = last.data; // set the pivot as the last node data
    Node i = first.prev; // initially, i is set to null
    for (Node j = first; j != last; j = j.next) { // traverse from first to last node
      if (j.data <= pivot) { 
        i = (i == null) ? first : i.next; // move i to first if null, otherwise i = i.next
        swap(i, j);
      }
    }
    i = (i==null) ? first : i.next; // move i to the correct pivot position
    swap(i,last); // final swap with the pivot
    return i;
}










So quicksort is a three step process.
Partitioning a pivot point for the entire list
Sort first-pivot.prev using partition function
Sort pivot.next-last using partition function