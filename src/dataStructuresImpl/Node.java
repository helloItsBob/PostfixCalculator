package dataStructuresImpl;

public class Node<T>
{
  private T data;
  private Node<T> next;

  public void setData(T data)
  {
    this.data = data;
  }

  public T getData()
  {
    return data;
  }

  public void setNext(Node<T> node)
  {
    this.next = node;
  }

  public Node<T> getNode()
  {
    return this.next;
  }

  @Override public String toString()
  {
    return "dataStructuresImpl.Node{" + "data=" + data + ", next=" + next + '}';
  }
}
