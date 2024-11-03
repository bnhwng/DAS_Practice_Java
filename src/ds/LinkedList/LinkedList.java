package ds.LinkedList;

public class LinkedList{
  //singly
  public int size=0;
  public Node head;

  public LinkedList(){
    this.size=0;
    this.head=null;
    }

  //getter
  public int size(){
    System.out.println("This list size is: " + this.size);
    return this.size;
  }

  public boolean isEmpty(){
    return this.size==0 && head==null;
  }
  
  public void traveralPrintList(){
    if(this.head==null){
      System.out.println("List is empty");
      return;
    }
    System.out.println("These are the node data of this list");
    Node temp = head;
    while(temp!=null){
      System.out.print(temp.data+", ");
      temp=temp.next;
    }
    System.out.println("\nFinished printing");
  }

  //search
  public boolean search(int target){
    if(isEmpty()){
      System.out.println("List is empty");
      return false;
    }
    int position = 0;
    Node temp = head;
    while(temp!=null){
      if(temp.data==target){
        System.out.println("element found at index: " + position);
        return true;
      }
      temp=temp.next;
      position++;
    }
    System.out.println("No Node found");
    return false;
  }

  //add method
  public void add(int data){
    if(isEmpty()){
      this.head = new Node(data);
    } else {
    Node newNode = new Node(data);
    Node temp=head;
    while(temp.next!=null){
      temp=temp.next;
    }
    temp.next=newNode;
  }
    size++;
    System.out.println("New node has been added: " + data);
  }
  
  public void addToFirst(int data){
    Node newNode = new Node(data);
    newNode.next=head;
    head = newNode;
    size++;
    System.out.println("New node has been added");
  }

  public void addAtIndex(int data, int index){
    int indexPtr=0;
    if(index > this.size){
      System.out.println("Invalid indexes");
      return;
    }

    if(index==0){
      addToFirst(data);
      System.out.println("Node has been added to the position: " +index);
      return;
    }
    
    Node newNode= new Node(data);
    Node temp = head;
    while(indexPtr<index-1){
      temp=temp.next;
      indexPtr++;
    }
    newNode.next=temp.next;
    temp.next=newNode;
    System.out.println("New node "+data+" has been added to the position: "+index);
    size++;
  }

  //remove method
  public Node removeFirstElement(){ //remove the first element and return it
    if(isEmpty()){
      System.out.println("List is Empty");
      return null;
    }
    Node temp=head;
    head=head.next;
    System.out.println("First node has been removed: " + temp.data);
    size--;
    return temp;
  }

  public Node removeLast(){
    if(isEmpty()){
      System.out.println("This list is empty");
      return null;
    }

    Node result; //return point
    if(size==1){
      result=head;
      head=null;
    } else {
      Node current = head;
      while(current.next.next!=null){
        current=current.next;
      }
      result=current.next;
      current.next=null;
    }

    size--;
    System.out.println("Last node has been removed: "+result.data);
    return result;
  }



  public static void main(String[]args){
    LinkedList list = new LinkedList();
    for(int i = 0; i < 5; i++){
      list.add(i);
    }
    
  }
}