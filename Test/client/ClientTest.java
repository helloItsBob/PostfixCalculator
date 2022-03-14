package client;

import calculatorImpl.Operand;
import calculatorImpl.Operation;
import calculatorImpl.Operator;
import calculatorImpl.Token;
import exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest
{
  Client client;

  @BeforeEach void setUp()
  {
    client = new Client();
  }

  @Test void evaluateExpression() throws MalformedExpressionException
  {
    ArrayList<Token> list = new ArrayList<>();
    list.add(new Operand(5));
    list.add(new Operand(3));
    list.add(new Operator(Operation.MULTIPLY));

    assertEquals(15, client.evaluateExpression(list));
  }

  @Test void evaluateExpressionEmptyListException()
  {
    // empty list
    ArrayList<Token> list = new ArrayList<>();
    assertThrows(MalformedExpressionException.class, () -> {
      client.evaluateExpression(list);
    });
  }

  @Test void evaluateExpressionExceptionExtraOperand()
  {
    ArrayList<Token> list = new ArrayList<>();
    list.add(new Operand(14));
    list.add(new Operand(7));
    list.add(new Operator(Operation.DIVIDE));
    list.add(new Operand(5));

    assertThrows(MalformedExpressionException.class, () -> {
      client.evaluateExpression(list);
    });
  }

  @Test void evaluateExpressionExceptionExtraOperator()
  {
    ArrayList<Token> list = new ArrayList<>();
    list.add(new Operand(9));
    list.add(new Operand(54));
    list.add(new Operator(Operation.PLUS));
    list.add(new Operator(Operation.MINUS));

    assertThrows(MalformedExpressionException.class, () -> {
      client.evaluateExpression(list);
    });
  }
}