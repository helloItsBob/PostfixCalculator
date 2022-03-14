package calculatorImpl;

public class Operand extends Token
{
  private double value;

  public Operand(double value)
  {
    this.value = value;
  }

  @Override public void accept(CalculatorVisitor visitor)
  {
    visitor.visit(this);
  }

  public double getValue()
  {
    return value;
  }

  @Override public String toString()
  {
    return "Operand{" + "value=" + value + '}';
  }
}
