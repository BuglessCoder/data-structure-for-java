package sjjg;

public interface Stack<T> {
	public abstract boolean isEmpty();	//判空
	public abstract void push(T x);		//元素x入栈
	public abstract T peek();		//返回栈顶元素（不出栈）
	public abstract T pop();		//出栈
	public abstract String toString();
}
