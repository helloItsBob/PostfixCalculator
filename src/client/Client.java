package client;

import calculatorImpl.CalculatorVisitor;
import calculatorImpl.Token;
import exceptions.MalformedExpressionException;

import java.util.ArrayList;

public class Client
{
  private CalculatorVisitor calculatorVisitor;

  public Client()
  {
    calculatorVisitor = new CalculatorVisitor();
  }

  public double evaluateExpression(ArrayList<Token> tokenList)
      throws MalformedExpressionException
  {
    for (Token token : tokenList)
    {
      token.accept(calculatorVisitor);
    }
    return calculatorVisitor.getResult();
  }
}
