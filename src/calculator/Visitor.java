package calculator;

import calculatorImpl.Operand;
import calculatorImpl.Operator;

public interface Visitor
{
  void visit(Operand operand);
  void visit(Operator operator);
}
