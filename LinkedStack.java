package sjjg;

public class LinkedStack<T> implements Stack<T> {
	
	private SinglyList<T> list;
	
	public LinkedStack(){
		this.list = new SinglyList<T>();
	}

	@Override
	public boolean isEmpty() {
		// TODO 自动生成的方法存根
		return this.list.isEmpty();
	}

	@Override
	public void push(T x) {
		// TODO 自动生成的方法存根
		this.list.insert(0,x);
		
	}

	@Override
	public T peek() {
		// TODO 自动生成的方法存根
		return this.list.get(0);
	}

	@Override
	public T pop() {
		// TODO 自动生成的方法存根
		return list.remove(0);
	}
	
	public String toString(){
		return list.toString();
		
	}

}
