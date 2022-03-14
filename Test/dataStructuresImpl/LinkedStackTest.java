package dataStructuresImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest
{
  LinkedStack<Integer> linkedStack;

  @BeforeEach void setUp()
  {
    linkedStack = new LinkedStack<>();
  }

  @Test void isEmpty()
  {
    assertTrue(linkedStack.isEmpty());

    linkedStack.push(34);
    assertFalse(linkedStack.isEmpty());
  }

  @Test void push()
  {
    // already tested above
  }

  @Test void pop()
  {
    linkedStack.push(12);
    linkedStack.push(37);
    assertEquals(37, linkedStack.pop());
    assertDoesNotThrow(() -> linkedStack.pop());
  }

  @Test void popException()
  {
    assertThrows(EmptyStackException.class, () -> {
      linkedStack.pop();
    });
  }
}