package ds.doublyLinkedList;

public class DoublyLinkedList {
  Node head;
  Node last;
  int size=0;

  public DoublyLinkedList(){
    this.size=0;
    this.head=null;
    this.last=null;
  }
  
  /**
   * PRE: The list must exist.
   * @return the size of the list
   */
  public int size(){
    System.out.println("The list size is " + size);
    return this.size;
  }  

  /**
   * return boolean of team is empty.
   */
  public boolean isEmpty(){
    return size==0 && head==null && last==null;
  }

  /**
   *  print the list data in forward
   */
  public void traversalPrintListForward(){
    if(isEmpty()){
      System.out.println("List is empty");
      return;
    }
    Node temp=head;
    while(temp!=null){
      System.out.print(temp.data + ", ");
      temp=temp.next;
    }
    System.out.println();
  }

  /**
   * print the list data in backward
   */
  public void traversalPrintListBackward(){
    if(isEmpty()){
      System.out.println("List is empty");
      return;
    }
    System.out.println("List contents (backward)");
    Node temp=last;
    System.out.println("The data of this list is: ");
    while(temp!=null){
      System.out.print(temp.data + ", ");
      temp=temp.prev;
    }
    System.out.println();
  }

  /**
   * Basic Operation
   */

   public void addToFront(int data){
    Node newNode = new Node(data);
    if(isEmpty()){
      head=last=newNode;
    } else {
      newNode.next=head;
      head.prev=newNode;
      head=newNode;
    }
    size++;
   }

   public void addToEnd(int data){
    Node newNode = new Node(data);
    if(isEmpty()){
      head=last=newNode;
    } else {
      last.next=newNode;
      newNode.prev=last;
      last=newNode;
    }
    size++;
   }

   public void addToIndex(int data, int index){
    if(index>size || index <0){
      System.out.println("Invalid index");
      return;
    }
    Node newNode= new Node(data);
    if(index==0){
      addToFront(data);
    } else if(index==size){
      addToEnd(data);
    } else {
      Node temp=head;
      for(int i = 0; i<index-1 && temp!=null;i++){
        temp=temp.next;
      }
      newNode.next=temp.next;
      if(temp.next!=null){
        temp.next.prev=newNode;
      }
      newNode.prev=temp;
      temp.next=newNode;
      size++;
    }
   }

   public void removeFromFront(){
    if(isEmpty()){
      System.out.println("list is empty, do nothing");
      return;
    } else if(head==last) {
      head=last=null;
    } else {
      head=head.next;
      head.prev=null;
    }
    size--;

   }

   public void removeFromEnd(){
    if(isEmpty()){
      System.out.println("list is empty");
      return;
    } else if (head==last){
      head=last=null;
    } else {
      last=last.prev;
      last.next=null;
    }
    size--;
   }

   public void removeAtIndex(int index){
    if(isEmpty()){
      System.out.println("list is empty, do nothing");
      return;
    } 
    if(index==0){
      removeFromFront();
    } else if(index==size-1){
      removeFromEnd();
    } else {
      Node temp=head;
      for(int i = 0; i<index-1 && temp!=null;i++){
        temp=temp.next;
      }
        temp.next=temp.next.next;
        temp.next.prev=temp;
        size--;
      }
    }
   
   /**
    * Search and Retrieval
    */

    public boolean search(int target){
      return false;
    }

    public int indexOf(int data){
      return 1;
    }

    public int lastIndexOf(int data){
      return 1;
    }

    public Node getNodeAtIndex(int index){
      return null;
    }

    /**
     * Advanced Operation
     */

     public void clear(){

     }

     public boolean contains(int data){
      return false;
     }

     public void reverse(){

     }

     public DoublyLinkedList clone(){
      return null;
     }



}
