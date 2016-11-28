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
	protected int next(int i, int j) {						//返回vi在vj后边的后继邻接顶点序号
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
	
	public void DFSTraverse(int i){							//深度优先搜索遍历
		boolean[] visited = new boolean[this.count()];
		int j = i;
		do{
			if(!visited[j]){
				System.out.print("{");
				this.depthfs(j, visited);
				System.out.print("}");
			}
			j = (j+1)%this.count();
		}while(j!=i);
		System.out.println();
	}
	
	private void depthfs(int i, boolean[] visited){ 		
		System.out.print(this.getV(i) + "");
		visited[i] = true;
		int j = this.next(i, -1);
		while(j!=-1){
			if(!visited[j]){
				depthfs(j,visited);
			}
			j = this.next(i, j);
		}
	}
	
	public void BFSTraverse(int i){						//广度优先搜索遍历
		boolean[] visited = new boolean[this.count()];	
		int j = i;
		do{
			if(!visited[j]){
				System.out.print("{");
				this.breadthfs(j, visited);
				System.out.print("}");
			}
			j = (j+1)%this.count();
		}while(j!=i);
		System.out.println();
		
	}
	
	private void breadthfs(int i, boolean[] visited){
		System.out.print(this.getV(i) + "");
		visited[i] = true;
		LinkedQueue<Integer> que = new LinkedQueue<Integer>();
		que.add(i);
		while(!que.isEmpty()){
			i = (int) que.poll();
			for(int j=next(i,-1);j!=-1;j=next(i,j)){
				if(!visited[j]){
					System.out.print(this.getV(j) + "");
					visited[j] = true;
					que.add(j);
				}
			}
		}
		
		
	}
	
	public void minSpanTree(){							//用Prim算法构造最小生成树
		Triple[] mst = new Triple[this.count()-1];
		for(int i=0;i<mst.length;i++){
			mst[i] = new Triple(0,i+1,this.weight(0, i+1));
		}
		for(int i=0;i<mst.length;i++){
			int minweight = mst[i].value;
			int min = i;
			for(int j=i+1;j<mst.length;j++){
				if(mst[j].value<minweight){
					minweight = mst[j].value;
					min = j;
				}
			}
			Triple edge = mst[min];
			mst[min] = mst[i];
			mst[i] = edge;
			int tv = edge.column;
			for(int j=i+1;j<mst.length;j++){
				int v = mst[j].column;
				int weight = this.weight(tv, v);
				if(weight<mst[j].value){
					mst[j] = new Triple(tv,v,weight);
				}
			}
		}
		System.out.print("最小生成树的边集合：");
		int mincost = 0;
		for(int i=0;i<mst.length;i++){
			System.out.print(mst[i] + "  ");
			mincost+=mst[i].value;
		}
		System.out.println("\n最小代价为：" + mincost);
	}
	
	
	public void shortestPath(int i){				//用Dijkstra算法获得从某个顶点到其他顶点的单源最短路径
		int n = this.count();
		boolean[] vset = new boolean[n];
		vset[i] = true;
		int[] dist = new int[n];
		int[] path = new int[n];
		
		for(int j=0;j<n;j++){
			dist[j] = this.weight(i, j);
			if(j!=i && dist[j]<MAX){
				path[j] = i;
			}
			else path[j] = -1;
		}
		
		for(int j=(i+1)%n;j!=i;j=(j+1)%n){
			int mindist = MAX;
			int min = 0;
			
			for(int k=0;k<n;k++){
				if(!vset[k] && dist[k]<mindist){
					mindist = dist[k];
					min = k;
				}
			}
			
			if(mindist == MAX){
				break;
			}
			
			vset[min] = true;
			
			for(int k=0;k<n;k++){
				if(!vset[k] && this.weight(min, k)<MAX && dist[min]+this.weight(min, k)<dist[k]){
					dist[k] = dist[min] + this.weight(min, k);
					path[k] = min;
				}
			}
		}
		System.out.println(this.getV(i) + "点的单源最短路径：");
		for(int j=0;j<n;j++){
			if(j!=i){
				SinglyList<T> pathlink = new SinglyList<T>();
				pathlink.insert(0, this.getV(j));
				for(int k=path[j];k!=i && k!=j && k!=-1;k=path[k]){
					pathlink.insert(0, this.getV(k));
				}
				pathlink.insert(0, this.getV(i));
				System.out.println(pathlink.toString() + "长度" + (dist[j] == MAX ? "∞" : dist[j]) + ",");
				
			}
		}
		System.out.println();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
