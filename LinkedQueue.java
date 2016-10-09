package sjjg;

public class LinkedQueue<T> implements Queue {
	
	private Node<T> front , rear;

	public LinkedQueue() {
		this.front = this.rear = null;
	}

	@Override
	public boolean isEmpty() {
		// TODO �Զ����ɵķ������
		return this.front == null && this.rear == null;
	}

	@Override
	public boolean add(Object x) {
		// TODO �Զ����ɵķ������
		if(x == null)
			return false;
		Node<T> q = new Node<T>((T) x,null);
		if(this.front == null)
			this.front = q;
		else this.rear.next = q;
		return true;
	}
	
	@Override
	public Object peek() {
		// TODO �Զ����ɵķ������
		return this.isEmpty()?null:this.front.data;
	}

	@Override
	public Object poll() {
		// TODO �Զ����ɵķ������
		if(isEmpty())
			return null;
		T x = this.front.data;
		this.front = this.front.next;
		if(this.front == null)
			this.rear = null;
		return x;
	}

}
