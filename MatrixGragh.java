package sjjg;

public class MatrixGragh<T> extends AbstractGraph<T> {
	
	protected Matrix m;			//����m��Ϊͼ���ڽӾ���
	

	public MatrixGragh(int length) {		//���췽��
		super(length);						//�̳У���������Ϊlength�Ŀձ�������Ϊ0
		this.m = new Matrix(length);		//����length*length�ľ��󣬳�ֵΪ0
	}

	public MatrixGragh(){					//�����ͼ��˳�����ڽӾ����Ĭ��������Ϊ10���������ͱ�����Ϊ0��
		this(10);
	}
	
	public MatrixGragh(T[] v){				//����ֻ�ж��㣨v���飩û�бߵ�ͼ
		this(v.length);
		for(int i=0;i<v.length;i++){
			this.insertV(v[i]);
		}
	}
	
	public MatrixGragh(T[] v, Triple[] edges){		//������ж��㣨v���飩���бߣ�edges��Ԫ�飩��ͼ
		this(v);
		for(int j=0;j<edges.length;j++){
			this.insertEdge(edges[j]);
		}
	}
	
	@Override
	public String toString() {						//toString����
		String str = super.toString() + "�ڽӾ���  \n";
		int n = this.count();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(this.m.get(i, j) == MAX){
					str+="     ��";
				}
				else str+=String.format("%6d", this.m.get(i, j));
			}
			str+="\n";
		}
		return str;
	}

	@Override
	public int insertV(T x) {				//����Ԫ��xΪ����
		// TODO �Զ����ɵķ������
		int i = this.v.insert(x);			//˳���β����x������x�����i
		if(i>=this.m.getRows()){
			this.m.setRowsColumns(i+1, i+1);	//��i���ڵ�ǰ�������������ݣ�ʹ�������������ͼ�Ķ�����ʼ�ձ�����ȣ�
		}
		for(int j=0;j<i;j++){				//��ʼ����i�и���i�У�ʹԪ�ض�ΪMAX
			this.m.set(i, j, MAX);
			this.m.set(j, i, MAX);
		}
		return i;							//����x�����i
	}
	

	@Override
	public void removeV(int i) {			//ɾ��ĳ����Vi�Լ����������ı�
		// TODO �Զ����ɵķ������
		int n = this.count();
		this.v.remove(i);					//ɾ��˳����i��Ԫ�أ���������1
		for(int j=i+1;j<n;j++){
			for(int k=0;k<n;k++){
				this.m.set(j-1, k, this.m.get(j, k));		//��(j,k)�ϵ�Ԫ�طŽ�(j-1,k),������һ��
			}
		}
		for(int j=0;j<n;j++){
			for(int k=i+1;k<n;k++){
				this.m.set(j, k-1, this.m.get(j, k));		//��(j,k)�ϵ�Ԫ�طŽ�(j,k-1),������һ��
			}
		}
		this.m.setRowsColumns(n-1, n-1);			//ɾ��һ��һ��
		
	}
	
	public void insertEdge(int i, int j, int weight){		//����ȨֵΪweight�ı�<Vi,Vj>
		this.m.set(i, j, weight);							//�൱��ֻ����Ȩֵ
	}
	
	public void insertEdge(Triple edge){					//����һ����
		this.insertEdge(edge.row, edge.column, edge.value);
	}
	
	public void removeEdge(int i, int j){					//ɾ����<Vi,Vj>��ʹ��Ȩֵ��ΪMAX��
		if(i!=j){
			this.m.set(i, j, MAX);		
		}
	}
	
	public void removeEdge(Triple edge){					//ɾ��һ���ߣ�����Ȩֵ
		this.removeEdge(edge.row, edge.column);
	}
	

	@Override
	public int weight(int i, int j) {						//���ر�<Vi,Vj>��Ȩֵ
		// TODO �Զ����ɵķ������
		return this.m.get(i, j);
	}

	@Override
	protected int next(int i, int j) {						//����vi��vj��ߵĺ���ڽӶ������
		// TODO �Զ����ɵķ������
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
	
	public void DFSTraverse(int i){							//���������������
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
	
	public void BFSTraverse(int i){						//���������������
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
	
	public void minSpanTree(){							//��Prim�㷨������С������
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
		System.out.print("��С�������ı߼��ϣ�");
		int mincost = 0;
		for(int i=0;i<mst.length;i++){
			System.out.print(mst[i] + "  ");
			mincost+=mst[i].value;
		}
		System.out.println("\n��С����Ϊ��" + mincost);
	}
	
	
	public void shortestPath(int i){				//��Dijkstra�㷨��ô�ĳ�����㵽��������ĵ�Դ���·��
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
		System.out.println(this.getV(i) + "��ĵ�Դ���·����");
		for(int j=0;j<n;j++){
			if(j!=i){
				SinglyList<T> pathlink = new SinglyList<T>();
				pathlink.insert(0, this.getV(j));
				for(int k=path[j];k!=i && k!=j && k!=-1;k=path[k]){
					pathlink.insert(0, this.getV(k));
				}
				pathlink.insert(0, this.getV(i));
				System.out.println(pathlink.toString() + "����" + (dist[j] == MAX ? "��" : dist[j]) + ",");
				
			}
		}
		System.out.println();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
