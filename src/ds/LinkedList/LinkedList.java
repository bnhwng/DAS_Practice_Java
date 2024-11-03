package ds.LinkedList;

public class LinkedList {
  // singly
  public int size = 0;
  public Node head;

  public LinkedList() {
    this.size = 0;
    this.head = null;
  }

  // Ultility
  public int size() {
    System.out.println("This list size is: " + this.size);
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0 && head == null;
  }

  public void traveralPrintList() {
    if (this.head == null) {
      System.out.println("List is empty");
      return;
    }
    System.out.println("These are the node data of this list");
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + ", ");
      temp = temp.next;
    }
    System.out.println("\nFinished printing");
  }

  public void clear() {
    head = null;
    size = 0;
    return; // straightforward
  }

  // Search and Retrieval
  public boolean search(int target) {
    if (isEmpty()) {
      System.out.println("List is empty");
      return false;
    }
    int position = 0;
    Node temp = head;
    while (temp != null) {
      if (temp.data == target) {
        System.out.println("element found at index: " + position);
        return true;
      }
      temp = temp.next;
      position++;
    }
    System.out.println("No Node found");
    return false;
  }

  /**
   * Precondition: index x must within the list size bound
   * Postcondition: returns the node data at index x
   * 
   * @param x
   * @return the int node data at index x
   */
  public int get(int x) {
    int indexPtr = 0;
    if (x >= size || x < 0) {
      System.out.println("invalid indexes, return -1 as value");
      return -1;
    }
    Node temp = head;
    while (indexPtr != x) {
      temp = temp.next;
      indexPtr++;
    }
    System.out.println("The value at index " + x + " is: " + temp.data);
    return temp.data;
  }

  /**
   * Precondition: data must be an int 
   * Postcondition: returns the first occurence of data at index x
   * @param data data
   * @returnreturns the first occurence of data at index x
   */
  public int indexOf(int data) { 
    int indexPtr=0;
    if(isEmpty()){
      System.out.println("List is empty");
      return -1;
    }
    Node temp=head;
    while(temp!=null){
      if(temp.data==data){
        return indexPtr;
      }
      indexPtr++;
      temp=temp.next;
    }
    System.out.println("Data not found, return -1 as default");
    return -1;
  }

  // Basic and Operation
  public void add(int data) {
    if (isEmpty()) {
      this.head = new Node(data);
    } else {
      Node newNode = new Node(data);
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
    size++;
    System.out.println("New node has been added: " + data);
  }

  public void addToFirst(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
    size++;
    System.out.println("New node has been added");
  }

  public void addAtIndex(int data, int index) {
    int indexPtr = 0;
    if (index > this.size) {
      System.out.println("Invalid indexes");
      return;
    }

    if (index == 0) {
      addToFirst(data);
      System.out.println("Node has been added to the position: " + index);
      return;
    }

    Node newNode = new Node(data);
    Node temp = head;
    while (indexPtr < index - 1) {
      temp = temp.next;
      indexPtr++;
    }
    newNode.next = temp.next;
    temp.next = newNode;
    System.out.println("New node " + data + " has been added to the position: " + index);
    size++;
  }

  // remove method
  public Node removeFirstElement() { // remove the first element and return it
    if (isEmpty()) {
      System.out.println("List is Empty");
      return null;
    }
    Node temp = head;
    head = head.next;
    System.out.println("First node has been removed: " + temp.data);
    size--;
    return temp;
  }

  public Node removeLast() {
    if (isEmpty()) {
      System.out.println("This list is empty");
      return null;
    }

    Node result; // return point
    if (size == 1) {
      result = head;
      head = null;
    } else {
      Node current = head;
      while (current.next.next != null) {
        current = current.next;
      }
      result = current.next;
      current.next = null;
    }

    size--;
    System.out.println("Last node has been removed: " + result.data);
    return result;
  }

  public Node removeAtIndex(int index) {
    int indexPtr = 0;
    Node result;
    // false case
    if (index >= size || index < 0) {
      System.out.println("invalid indices");
      return null;
    }

    if (index == 0) {
      result = removeFirstElement();
      return result;
    }

    Node current = head;
    while (indexPtr < index - 1) {
      current = current.next;
      indexPtr++;
    }
    result = current.next;
    current.next = current.next.next;
    size--;

    return result;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    for (int i = 0; i < 5; i++) {
      list.add(i);
    }

    list.traveralPrintList();
    list.get(4);

  }
}