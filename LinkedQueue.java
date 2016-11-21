package sjjg;

public class LinkedQueue<T> implements Queue {
	
	private Node<T> front , rear;

	public LinkedQueue() {
		this.front = this.rear = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO 自动生成的方法存根
		return this.front == null && this.rear == null;
	}

	@Override
	public boolean add(Object x) {
		// TODO 自动生成的方法存根
		if(x == null)
			return false;
		Node<T> q = new Node<T>((T) x,null);
		if(this.front == null)
			this.front = q;
		else this.rear.next = q;
		this.rear = q;
		return true;
	}
	
	@Override
	public Object peek() {
		// TODO 自动生成的方法存根
		return this.isEmpty()?null:this.front.data;
	}

	@Override
	public Object poll() {
		// TODO 自动生成的方法存根
		if(isEmpty())
			return null;
		T x = this.front.data;
		this.front = this.front.next;
		if(this.front == null)
			this.rear = null;
		return x;
	}

}
