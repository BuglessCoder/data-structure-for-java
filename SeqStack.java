package sjjg;

public class SeqStack<T> implements Stack<T>{
	
	private SeqList<T> list;
	
	public SeqStack(int length){
		this.list = new SeqList<T>(length);
	}
	
	public SeqStack(){
		this(64);
	}

	@Override
	public boolean isEmpty() {
		// TODO �Զ����ɵķ������	
		return this.list.isEmpty();
	}

	@Override
	public void push(T x) {
		// TODO �Զ����ɵķ������
		this.list.insert(x);
		
	}

	@Override
	public T peek() {
		// TODO �Զ����ɵķ������
		return this.list.get(list.size()-1);
	}

	@Override
	public T pop() {
		// TODO �Զ����ɵķ������
		return list.remove(list.size()-1);
	}
	
	public String toString(){
		return list.toString();
		
	}

}
