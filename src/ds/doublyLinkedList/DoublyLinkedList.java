package ds.doublyLinkedList;

import java.util.Random;

public class DoublyLinkedList {
  Node head;
  Node last;
  int size = 0;

  public DoublyLinkedList() {
    this.size = 0;
    this.head = null;
    this.last = null;
  }

  /**
   * PRE: The list must exist.
   * 
   * @return the size of the list
   */
  public int size() {
    System.out.println("The list size is " + size);
    return this.size;
  }

  public void updateSize() {
    if (isEmpty()) {
      return;
    }
    int newSize = 0;
    Node temp = head;
    while (temp != null) {
      temp = temp.next;
      newSize++;
    }
    this.size = newSize;
  }

  /**
   * return boolean of team is empty.
   */
  public boolean isEmpty() {
    return size == 0 && head == null && last == null;
  }

  /**
   * print the list data in forward
   */
  public void traversalPrintListForward() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + ", ");
      temp = temp.next;
    }
    System.out.println();
  }

  /**
   * print the list data in backward
   */
  public void traversalPrintListBackward() {
    if (isEmpty()) {
      System.out.println("List is empty");
      return;
    }
    System.out.println("List contents (backward)");
    Node temp = last;
    System.out.println("The data of this list is: ");
    while (temp != null) {
      System.out.print(temp.data + ", ");
      temp = temp.prev;
    }
    System.out.println();
  }

  /**
   * Basic Operation
   */

  public void addToFront(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      head = last = newNode;
    } else {
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
    }
    size++;
  }

  public void addToEnd(int data) {
    Node newNode = new Node(data);
    if (isEmpty()) {
      head = last = newNode;
    } else {
      last.next = newNode;
      newNode.prev = last;
      last = newNode;
    }
    size++;
  }

  public void addToIndex(int data, int index) {
    if (index > size || index < 0) {
      System.out.println("Invalid index");
      return;
    }
    Node newNode = new Node(data);
    if (index == 0) {
      addToFront(data);
    } else if (index == size) {
      addToEnd(data);
    } else {
      Node temp = head;
      for (int i = 0; i < index - 1 && temp != null; i++) {
        temp = temp.next;
      }
      newNode.next = temp.next;
      if (temp.next != null) {
        temp.next.prev = newNode;
      }
      newNode.prev = temp;
      temp.next = newNode;
      size++;
    }
  }

  public void removeFromFront() {
    if (isEmpty()) {
      System.out.println("list is empty, do nothing");
      return;
    } else if (head == last) {
      head = last = null;
    } else {
      head = head.next;
      head.prev = null;
    }
    size--;

  }

  public void removeFromEnd() {
    if (isEmpty()) {
      System.out.println("list is empty");
      return;
    } else if (head == last) {
      head = last = null;
    } else {
      last = last.prev;
      last.next = null;
    }
    size--;
  }

  public void removeAtIndex(int index) {
    if (isEmpty()) {
      System.out.println("list is empty, do nothing");
      return;
    }
    if (index == 0) {
      removeFromFront();
    } else if (index == size - 1) {
      removeFromEnd();
    } else {
      Node temp = head;
      for (int i = 0; i < index - 1 && temp != null; i++) {
        temp = temp.next;
      }
      temp.next = temp.next.next;
      temp.next.prev = temp;
      size--;
    }
  }

  public void removeAllValueOf(int x) {
    if (isEmpty()) {
      System.out.println("List is empty, invalid call");
      return;
    }

  }

  /**
   * Search and Retrieval
   */

  /**
   * Pre-condition: list must not be empty
   * Post-condition return boolean value if the target exists in the list or not
   * 
   * @param target
   * @return boolean target==exist in list
   */
  public boolean search(int target) {
    if (isEmpty()) {
      System.out.println("list is empty");
      return false;
    }
    Node temp = head;
    while (temp != null) {
      if (temp.data == target) {
        System.out.println("Value exists in the list");
        return true;
      }
      temp = temp.next;
    }
    System.out.println("Value does not exist in the list");
    return false;
  }

  public int indexOf(int data) {
    if (isEmpty()) {
      System.out.println("list is empty");
      return -1;
    }
    Node temp = head;
    for (int i = 0; temp != null; i++) {
      if (temp.data == data) {
        return i;
      }
      temp = temp.next;
    }
    System.out.println("value does not exist");
    return -1;
  }

  public int lastIndexOf(int data) {
    if (isEmpty()) {
      System.out.println("List is empty, invalid call");
      return -1;
    }
    int result = -1;
    Node temp = head;
    for (int i = 0; temp != null; i++) {
      if (temp.data == data) {
        result = i;
      }
      temp = temp.next;
    }
    System.out.println("value does not exist");
    return result;
  }

  public Node getNodeAtIndex(int index) {
    if (index < 0 || index >= size) {
      System.out.println("invalid index");
      return null;
    }
    Node temp = head;
    int indexPtr = 0;
    while (indexPtr != index) {
      temp = temp.next;
      indexPtr++;
    }
    System.out.println("Node at index " + index + " has the value of " + temp.data);
    return temp;
  }

  /**
   * Advanced Operation
   */

  public void clear() {
    head = last = null;
    size = 0;
  }

  public boolean contains(int data) {
    if (isEmpty()) {
      System.err.println("Empty list invalid call");
    }
    Node temp = head;
    while (temp != null) {
      if (temp.data == data) {
        return true;
      }
    }
    System.out.println("No value found");
    return false;
  }

  public void reverse() {
    if (isEmpty()) {
      System.err.println("list empty invalid call");
      return;
    }
    Node temp = head;
    Node prevPtr = null;
    while (temp != null) {
      prevPtr = temp.prev;
      temp.prev = temp.next;
      temp.next = prevPtr;
      temp = temp.prev;
    }
    head = prevPtr.prev;

  }

  public DoublyLinkedList clone() {
    if (isEmpty()) {
      System.out.println("Its bad bro");
      return null;
    }
    Node temp = head;
    DoublyLinkedList result = new DoublyLinkedList();
    while (temp != null) {
      result.addToEnd(temp.data);
      temp = temp.next;
    }
    return result;
  }

  // Advanced Algorithm
  static void swap(Node a, Node b) {
    int temp = a.data;
    a.data = b.data;
    b.data = temp;
  }

  public static Node partition(Node first, Node last) {
    int pivot = last.data; // set the pivot as the last node dat
    Node i = first.prev; // set pointer i to first.prev which is == null as of declaration point
    for (Node j = first; j != last; j = j.next) { // traverse from first to last node
      if (j.data <= pivot) { // if any data during traverse smaller then the pivot
        i = (i == null) ? first : i.next; // if i==null, i==first if true, i=i.next if false
                                          // move pointer i to the next
        swap(i, j);
      }
    }
    i = (i==null) ? first : i.next;
    swap(i,last);
    return i;
  }

  public static void quickSort(Node low, Node high) {

    // Base case: stop recursion when invalid range
    if (low != null && high != null &&
        low != high && low != high.next) {

        // Partition the list and get the pivot node
        Node pivot = partition(low, high);

        // Recursively sort the left half
        quickSort(low, pivot.prev);

        // Recursively sort the right half
        quickSort(pivot.next, high);
    }
}

  public static void main(String[] args) {
    
  }

}
