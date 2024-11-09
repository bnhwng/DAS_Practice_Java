package ds.Queue;

public class Queue {
  Node root;
  int size;
  Node rear;
  public Queue(){
    this.root=null; //root is a pointer to the element in the front of the queue
    this.rear=null;
    size=0;
  }

  static class Node{
    int data;
    Node next;
    public Node(int data){
      this.data=data;
      this.next=null;
    }
  }

  public boolean isEmpty(){
    return root==null && size==0;
  }

  public void enqueue(int data){  
    Node newNode = new Node(data);
    if(isEmpty()){
      rear=root=newNode;
    }
    rear.next=newNode;
    rear=newNode;
    size++;
    System.out.println("new Node has been added " + data);
  }

  public int dequeue(){
    if(isEmpty()){
      System.err.println("Queue is empty");
      return -1;
    }
    int deQueued = root.data;
    root=root.next;
    if(root==null){
      root=rear=null;
    }
    size--;
    System.out.println("Node has been dequeued: " + deQueued);
    return deQueued;
  }

  public int peek(){
    if(isEmpty()){
      System.err.println("Queue is empty");
      return -1;
    }
    System.out.println("Front of the queue is " + root.data);
    return root.data;
  }

  public int size(){
    return this.size;
  }

  public void printQueue() {
    if (isEmpty()) {
        System.out.println("Queue is empty.");
        return;
    }
    System.out.print("Queue elements: ");
    Node temp = root;
    while (temp != null) {
        System.out.print(temp.data + " ");
        temp = temp.next;
    }
    System.out.println();
}
}
