import calculatorImpl.Operand;
import calculatorImpl.Operation;
import calculatorImpl.Operator;
import calculatorImpl.Token;
import client.Client;
import exceptions.MalformedExpressionException;

import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
      throws MalformedExpressionException
  {
    Client client = new Client();
    ArrayList<Token> list = new ArrayList<>();
    list.add(new Operand(7));
    list.add(new Operand(4));
    list.add(new Operator(Operation.MULTIPLY));
    list.add(new Operand(20));
    list.add(new Operator(Operation.MINUS));

    double result = client.evaluateExpression(list);
    System.out.println(result);
  }
}
