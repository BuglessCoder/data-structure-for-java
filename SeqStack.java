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
		// TODO 自动生成的方法存根	
		return this.list.isEmpty();
	}

	@Override
	public void push(T x) {
		// TODO 自动生成的方法存根
		this.list.insert(x);
		
	}

	@Override
	public T peek() {
		// TODO 自动生成的方法存根
		return this.list.get(list.size()-1);
	}

	@Override
	public T pop() {
		// TODO 自动生成的方法存根
		return list.remove(list.size()-1);
	}
	
	public String toString(){
		return list.toString();
		
	}

}
