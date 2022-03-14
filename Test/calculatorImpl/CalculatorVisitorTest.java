package calculatorImpl;

import dataStructuresImpl.LinkedStack;
import exceptions.MalformedExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorVisitorTest
{
  CalculatorVisitor calculatorVisitor;
  LinkedStack<Token> linkedStack;

  @BeforeEach void setUp()
  {
    calculatorVisitor = new CalculatorVisitor();
    linkedStack = new LinkedStack<>();
    Operand operand = new Operand(12);
    linkedStack.push(operand);
    Operand operand1 = new Operand(8);
    linkedStack.push(operand1);
    Operator operator = new Operator(Operation.PLUS);
    linkedStack.push(operator);

    calculatorVisitor.visit(operand1);
    calculatorVisitor.visit(operand);
    calculatorVisitor.visit(operator);
  }

  @Test void getResult() throws MalformedExpressionException
  {
    assertEquals(20, calculatorVisitor.getResult());
  }

  @Test void getResultException()
  {
    // should not throw
    assertDoesNotThrow(() -> calculatorVisitor.getResult());

    // should throw
    assertThrows(MalformedExpressionException.class, () -> {
      calculatorVisitor.getResult();
    });
  }
}