package sjjg;

public class MatrixGragh<T> extends AbstractGraph<T> {
	
	protected Matrix m;			//矩阵m作为图的邻接矩阵
	

	public MatrixGragh(int length) {		//构造方法
		super(length);						//继承，生成容量为length的空表，顶点数为0
		this.m = new Matrix(length);		//构造length*length的矩阵，初值为0
	}

	public MatrixGragh(){					//构造空图（顺序表跟邻接矩阵的默认容量都为10，顶点数和边数都为0）
		this(10);
	}
	
	public MatrixGragh(T[] v){				//构造只有顶点（v数组）没有边的图
		this(v.length);
		for(int i=0;i<v.length;i++){
			this.insertV(v[i]);
		}
	}
	
	public MatrixGragh(T[] v, Triple[] edges){		//构造既有顶点（v数组）又有边（edges三元组）的图
		this(v);
		for(int j=0;j<edges.length;j++){
			this.insertEdge(edges[j]);
		}
	}
	
	@Override
	public String toString() {						//toString方法
		String str = super.toString() + "邻接矩阵：  \n";
		int n = this.count();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(this.m.get(i, j) == MAX){
					str+="     ∞";
				}
				else str+=String.format("%6d", this.m.get(i, j));
			}
			str+="\n";
		}
		return str;
	}

	@Override
	public int insertV(T x) {				//插入元素x为顶点
		// TODO 自动生成的方法存根
		int i = this.v.insert(x);			//顺序表尾插入x，返回x的序号i
		if(i>=this.m.getRows()){
			this.m.setRowsColumns(i+1, i+1);	//若i大于当前行数，矩阵扩容（使矩阵的行列数与图的顶点数始终保持相等）
		}
		for(int j=0;j<i;j++){				//初始化第i行跟第i列，使元素都为MAX
			this.m.set(i, j, MAX);
			this.m.set(j, i, MAX);
		}
		return i;							//返回x的序号i
	}
	

	@Override
	public void removeV(int i) {			//删除某顶点Vi以及其所关联的边
		// TODO 自动生成的方法存根
		int n = this.count();
		this.v.remove(i);					//删除顺序表第i个元素，顶点数减1
		for(int j=i+1;j<n;j++){
			for(int k=0;k<n;k++){
				this.m.set(j-1, k, this.m.get(j, k));		//把(j,k)上的元素放进(j-1,k),即上移一行
			}
		}
		for(int j=0;j<n;j++){
			for(int k=i+1;k<n;k++){
				this.m.set(j, k-1, this.m.get(j, k));		//把(j,k)上的元素放进(j,k-1),即左移一行
			}
		}
		this.m.setRowsColumns(n-1, n-1);			//删除一行一列
		
	}
	
	public void insertEdge(int i, int j, int weight){		//插入权值为weight的边<Vi,Vj>
		this.m.set(i, j, weight);							//相当于只加了权值
	}
	
	public void insertEdge(Triple edge){					//插入一条边
		this.insertEdge(edge.row, edge.column, edge.value);
	}
	
	public void removeEdge(int i, int j){					//删除边<Vi,Vj>（使其权值变为MAX）
		if(i!=j){
			this.m.set(i, j, MAX);		
		}
	}
	
	public void removeEdge(Triple edge){					//删除一条边，忽略权值
		this.removeEdge(edge.row, edge.column);
	}
	

	@Override
	public int weight(int i, int j) {						//返回边<Vi,Vj>的权值
		// TODO 自动生成的方法存根
		return this.m.get(i, j);
	}

	@Override
	protected int next(int i, int j) {
		// TODO 自动生成的方法存根
		int n = this.count();
		if(i>=0 && i<n && j>=-1 && j<n && i!=j){
			for(int k=j+1;k<n;k++){
				if(this.m.get(i, k)>0 && this.m.get(i, k)<MAX){
					return k;
				}
			}
		}
		return -1;
	}

	
	
	
}
