package ds.LinkedList;


public class Node {
  public int data;
  public Node next;

  public Node(int data){
    this.data = data;
    this.next = null;
  }

  public Node(int data, Node next){
    this.data = data;
    this.next = next;
  }
  
  public int returnNextNodeData(){
    return this.next.data;
  }


  public int data(){
    return this.data;
  }

}
