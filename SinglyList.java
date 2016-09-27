package sjjg;

public class SinglyList<T> extends Object{
	
	public Node<T> head = new Node<T>();		//头指针head（指向单链表头结点）
	
	public SinglyList() {		//空构造方法
	
	}

	public SinglyList(T[] values){		//values数组作参数
		this();
		Node<T>rear = this.head;
		for(int i=0;i<values.length;i++){
			rear.next = new Node<T>(values[i],null);
			rear = rear.next;
		}
	}
	
	public boolean isEmpty(){		//判空
		return this.head.next == null;
	}
	
	public T get(int i){	//get方法
		Node<T> p = this.head.next;
		for(int j=0;p!=null&&j<i;j++){
			p = p.next;
		}
		return (i>=0&&p!=null)?p.data:null;
		
	}
	
	public void set(int i,T x){		//set方法
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
	
	public String toString(){		//toString方法
		String str = "(";
		for(Node<T> p=this.head.next;p!=null;p=p.next){
			str+=p.data.toString();
			if(p.next!=null)
				str+=",";
		}	
		return str + ")";
	}
	
	public Node<T>insert(int i,T x){		//insert方法（插入元素x到位置i）
		if(x==null)
			throw new NullPointerException("x==null");
		Node<T>front = this.head;
		for(int j=0;front.next!=null&&j<i;j++){
			front = front.next;
		}
		front.next = new Node<T>(x,front.next);		
		return front.next;
		
	}
	
	public Node<T>insert(T x){			//insert方法（在单链表最后插入元素x）
		return insert(Integer.MAX_VALUE,x);
	}
	
	
	public T remove(int i){				//remove方法（删除第i个元素，返回被删除元素）
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
	
	public void clear(){			//clear方法（清空单链表）
		this.head.next = null;
	}

	public int size() {				//size方法（返回单链表的长度）
		// TODO 自动生成的方法存根
		Node<T>front = this.head;
		int n = 0;
		for(int j=0;front.next!=null;j++){
			front = front.next;
			n++;
		}
		
		return n;
	}
		
}
