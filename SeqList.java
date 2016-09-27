package sjjg;

public class SeqList<T> extends Object {
	protected Object[] element;		//��������element�洢����Ԫ��
	protected int n;				//˳�����n��˳����Ԫ�ظ�����
	public SeqList(int length)		//���췽��  ����Ϊlength�Ŀձ�
	{
		this.element = new Object[length];		//��������洢�ռ䣨Ԫ��Ϊnull��
		this.n = 0;
	}
	
	public SeqList(){		//���췽�������أ�  Ĭ�������Ŀձ�
		this(64);			//
	}
	
	public SeqList(T[] values){
		this(values.length);
		for(int i=0;i<values.length;i++)
			this.element[i] = values[i];
		this.n = values.length;
	}
	
	public boolean isEmpty(){
		return this.n == 0;
		
	}
	
	public int size(){
		return this.n;
	}
	
	public T get(int i){
		if(i>=0&&i<this.n)
			return (T)this.element[i];
		return null;
	}
	
	public void set(int i, T x){
		if(x == null)
			throw new NullPointerException("x==null");
		if(i>=0&&i<this.n)
			this.element[i] = x;
		else throw new java.lang.IndexOutOfBoundsException(i+"");
	}
	
	public String toString(){
		String str = "(";
		if(this.n>0)
			str+=this.element[0].toString();
		for(int i=1;i<this.n;i++)
			str+=","+this.element[i].toString();
		return str+")";
	}
	
	
	public int insert(int i, T x){
		if(x == null)
			throw new NullPointerException("x==null");
		if(i<0)
			i=0;
		if(i>this.n)
			i=this.n;
		Object[] source = this.element;
		if(this.n == element.length){
			this.element = new Object[source.length*2];
			for(int j=0;j<i;j++)
				this.element[j] = source[i];
		}
		for(int j=this.n-1;j>=i;j--){
			this.element[j+1] = source[j];
		}
		this.element[i] = x;
		this.n++;
		return i;
			
	}
	
	public int insert(T x){
		return this.insert(this.n, x);
		
	}
	
	
	public T remove(int i){
		if(this.n>0&&i>=0&&i<this.n){
			T old = (T)this.element[i];
			for(int j=i;j<this.n-1;j++)
				this.element[j] = this.element[j+1];
			this.element[this.n-1] = null;
			this.n--;
			return old;
			
		}
		return null;	
	}
	public void clear(){
		this.n=0;
	}
	
	
}
