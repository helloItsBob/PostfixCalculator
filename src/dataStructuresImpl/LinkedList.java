package dataStructuresImpl;

import dataStructures.List;
import exceptions.EmptyListException;

public class LinkedList<T> implements List<T>
{
  private Node<T> head;
  private int size;

  @Override public boolean isEmpty()
  {
    return size == 0;
  }

  @Override public int size()
  {
    return size;
  }

  @Override public void addToFront(T data)
  {
    Node<T> addNode = new Node<>();
    addNode.setData(data);
    addNode.setNext(head);
    head = addNode;
    size++;
  }

  @Override public T removeFirst() throws EmptyListException
  {
    if (size == 0)
      throw new EmptyListException("The list is empty!");
    Node<T> node = head;
    head = head.getNode();
    size--;
    return node.getData();
  }

  @Override public String toString()
  {
    return "list - " + head;
  }
}
