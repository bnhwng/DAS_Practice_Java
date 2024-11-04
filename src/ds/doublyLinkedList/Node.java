package ds.doublyLinkedList;

public class Node{
  int data;
  Node next;
  Node prev;
  public Node(int data){
    this.data=data;
    this.next=null;
    this.prev=null;
  }

  public int data() {
    return data;
  }
}