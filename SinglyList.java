package sjjg;

public class SinglyList<T> extends Object{
	
	public Node<T> head = new Node<T>();		//ͷָ��head��ָ������ͷ��㣩
	
	public SinglyList() {		//�չ��췽��
	
	}

	public SinglyList(T[] values){		//values����������
		this();
		Node<T>rear = this.head;
		for(int i=0;i<values.length;i++){
			rear.next = new Node<T>(values[i],null);
			rear = rear.next;
		}
	}
	
	public boolean isEmpty(){		//�п�
		return this.head.next == null;
	}
	
	public T get(int i){	//get����
		Node<T> p = this.head.next;
		for(int j=0;p!=null&&j<i;j++){
			p = p.next;
		}
		return (i>=0&&p!=null)?p.data:null;
		
	}
	
	public void set(int i,T x){		//set����
		if(x == null)
			throw new NullPointerException("x==null");
		Node<T> p = this.head.next;
		for(int j=0;p!=null&&j<i;j++){
			p = p.next;
		}
		if(i>=0&&p!=null){
			p.data = x;
		}
	}
	
	public String toString(){		//toString����
		String str = "(";
		for(Node<T> p=this.head.next;p!=null;p=p.next){
			str+=p.data.toString();
			if(p.next!=null)
				str+=",";
		}	
		return str + ")";
	}
	
	public Node<T>insert(int i,T x){		//insert����������Ԫ��x��λ��i��
		if(x==null)
			throw new NullPointerException("x==null");
		Node<T>front = this.head;
		for(int j=0;front.next!=null&&j<i;j++){
			front = front.next;
		}
		front.next = new Node<T>(x,front.next);		
		return front.next;
		
	}
	
	public Node<T>insert(T x){			//insert�������ڵ�����������Ԫ��x��
		return insert(Integer.MAX_VALUE,x);
	}
	
	
	public T remove(int i){				//remove������ɾ����i��Ԫ�أ����ر�ɾ��Ԫ�أ�
		Node<T> front = this.head;
		for(int j=0;front.next!=null&&j<i;j++){
			front = front.next;
		}
		if(i>=0&&front.next!=null){
			T old = front.next.data;
			front.next = front.next.next;
			return old;
		}
		return null;
		
	}
	
	public void clear(){			//clear��������յ�����
		this.head.next = null;
	}

	public int size() {				//size���������ص�����ĳ��ȣ�
		// TODO �Զ����ɵķ������
		Node<T>front = this.head;
		int n = 0;
		for(int j=0;front.next!=null;j++){
			front = front.next;
			n++;
		}
		
		return n;
	}
		
}
