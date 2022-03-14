package calculator;

import exceptions.MalformedExpressionException;

public interface Calculator
{
  double getResult() throws MalformedExpressionException;
}
