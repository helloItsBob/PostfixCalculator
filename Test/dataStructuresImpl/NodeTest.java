package dataStructuresImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest
{
  Node<Integer> node;

  @BeforeEach void setUp()
  {
    node = new Node<>();
    node.setData(16);
  }

  @Test void setData()
  {
    assertEquals(16, node.getData());
  }

  @Test void getData()
  {
    // already tested above
  }

  @Test void setNext()
  {
    Node<Integer> newNode = new Node<>();
    newNode.setData(19);
    node.setNext(newNode);
    assertEquals(19, node.getNode().getData());
  }

  @Test void getNode()
  {
    // already tested above
  }


}