package ds.Stack;

import java.util.Random;

public class StackList {

  Node root;
  int size;

  static class Node{
    int data;
    Node next;
    public Node(int data){
      this.data=data;
      this.next=null;
    }
  }

  public boolean isEmpty(){
    return root==null && size ==0;
  }

  public void push(int data){
    Node newNode = new Node(data);
    Node temp=root;
    root=newNode;
    newNode.next=temp;
    size++;
    System.out.println("node pushed to stack");
  }

  public int pop(){
    if(isEmpty()){
      System.out.println("stack is empty");
      return -1;
    }
    int popped=root.data;
    root=root.next;
    size--;
    System.out.println("Popped item " + popped);
    return popped;
  }

  public int peek(){
    if(isEmpty()){
      System.out.println("Stack is empty");
      return -1;
    }
    System.out.println("Top node is " + root.data);
    return root.data;
  }

  public void print(){
    if(isEmpty()){
      System.out.println("stack is empty");
      return;
    }

    Node temp=root;
    System.out.println("The stack is:");
    while(temp!=null){
      System.out.println(temp.data);
      temp=temp.next;
    }
    System.out.println();
  }

  public static void main(String[]args){
    StackList stack = new StackList();
    int i = 0;
    Random rand = new Random();
    while(i<10){
      stack.push(rand.nextInt(10));
      i++;
    }
    stack.print();
    stack.pop();
    stack.print();
  }

  
}
