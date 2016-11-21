package sjjg;

public abstract class AbstractGraph<T> {
	protected static final int MAX = 0x0000ffff;		//MAX表示最大权值
	public SeqList<T> v;								//顺序表v存储图的顶点
	
	public AbstractGraph(int length) {					//构造方法（生成容量为length的空表，顶点数为0）
		this.v = new SeqList<T>(length);
		// TODO 自动生成的构造函数存根
	}

	public AbstractGraph() {							//构造方法（生成默认容量为10的空表，顶点数为0）
		this(10);
		// TODO 自动生成的构造函数存根
	}
	
	public int count(){									//返回顶点的个数
		return this.v.size();
		
	}
	

	public T getV(int i) {								//返回顶点元素Vi
		return v.get(i);
	}

	public void setV(int i, T x) {						//设置顶点元素Vi为x
		this.v.set(i, x);
	}
	
	
	
	@Override
	public String toString() {							//toString方法
		return "顶点集合：" + this.v.toString() + "\n";
	}

	public abstract int insertV(T x);
	
	public abstract void removeV(int i);
	
	public abstract int weight(int i,int j);
	
	protected abstract int next (int i, int j);
	
	
	

}
