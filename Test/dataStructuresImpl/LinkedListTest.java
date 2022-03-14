package dataStructuresImpl;

import exceptions.EmptyListException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest
{
  LinkedList<Node<Integer>> linkedList;

  @BeforeEach void setUp()
  {
    linkedList = new LinkedList<>();
  }

  @Test void isEmpty()
  {
    assertTrue(linkedList.isEmpty());
  }

  @Test void size()
  {
    assertEquals(0, linkedList.size());
  }

  @Test void addToFront() throws EmptyListException
  {
    Node<Integer> node = new Node<>();
    node.setData(12);
    Node<Integer> node1 = new Node<>();
    node1.setData(16);
    linkedList.addToFront(node);
    linkedList.addToFront(node1);
    assertEquals(node1, linkedList.removeFirst());
  }

  @Test void removeFirstException()
  {
    assertThrows(EmptyListException.class, () -> {
      linkedList.removeFirst();
    });
  }

  @Test void removeFirst() throws EmptyListException
  {
    Node<Integer> node = new Node<>();
    linkedList.addToFront(node);
    assertEquals(1, linkedList.size());

    assertEquals(node, linkedList.removeFirst());
    assertTrue(linkedList.isEmpty());
  }
}