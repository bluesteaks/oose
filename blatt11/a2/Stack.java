import java.util.*;

interface StackInterface<T> extends List<T>{
	public void push();
	public T pop();
}

public class Stack<T> implements StackInterface<T>{
	public void push(){}
	public T pop(){}
	public List<T> subList(int a, int b){}

}