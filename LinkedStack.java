package sjjg;

public class LinkedStack<T> implements Stack<T> {
	
	private SinglyList<T> list;
	
	public LinkedStack(){
		this.list = new SinglyList<T>();
	}

	@Override
	public boolean isEmpty() {
		// TODO �Զ����ɵķ������
		return this.list.isEmpty();
	}

	@Override
	public void push(T x) {
		// TODO �Զ����ɵķ������
		this.list.insert(0,x);
		
	}

	@Override
	public T peek() {
		// TODO �Զ����ɵķ������
		return this.list.get(0);
	}

	@Override
	public T pop() {
		// TODO �Զ����ɵķ������
		return list.remove(0);
	}
	
	public String toString(){
		return list.toString();
		
	}

}
