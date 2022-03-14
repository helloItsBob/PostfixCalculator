package calculatorImpl;

import calculator.Calculator;
import calculator.Visitor;
import dataStructuresImpl.LinkedStack;
import exceptions.MalformedExpressionException;

import java.util.EmptyStackException;

public class CalculatorVisitor implements Calculator, Visitor
{
  private LinkedStack<Token> tokenStack;

  public CalculatorVisitor()
  {
    tokenStack = new LinkedStack<>();
  }

  private void pushOperand(Operand operand)
  {
    tokenStack.push(operand);
  }

  private void performOperation(Operator operator)
      throws MalformedExpressionException
  {
    try
    {
      Operand right = (Operand) tokenStack.pop();
      Operand left = (Operand) tokenStack.pop();

      double result;
      switch (operator.getOperation())
      {
        case PLUS -> result = left.getValue() + right.getValue();
        case MINUS -> result = left.getValue() - right.getValue();
        case MULTIPLY -> result = left.getValue() * right.getValue();
        case DIVIDE -> result = left.getValue() / right.getValue();
        default -> throw new MalformedExpressionException("Incorrect operator!");
      }
      pushOperand(new Operand(result));
    }
    catch (EmptyStackException e)
    {
      throw new MalformedExpressionException("Leftover operator!");
    }
  }

  @Override public void visit(Operand operand)
  {
    pushOperand(operand);
  }

  @Override public void visit(Operator operator)
  {
    try
    {
      performOperation(operator);
    }
    catch (MalformedExpressionException e)
    {
      e.getLocalizedMessage();
    }
  }

  @Override public double getResult() throws MalformedExpressionException
  {
    try
    {
      Operand result = (Operand) tokenStack.pop();
      if (!tokenStack.isEmpty())
        throw new MalformedExpressionException("Leftover operand!");

      return result.getValue();
    }
    catch (EmptyStackException e)
    {
      throw new MalformedExpressionException(e.getLocalizedMessage());
    }
  }
}
