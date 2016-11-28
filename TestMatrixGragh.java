package sjjg;

public class TestMatrixGragh {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String[] s = {"A","B","C","D","E"};
		
		Triple edges[] = {new Triple(0,1,45),new Triple(0,2,28),new Triple(0,3,10),new Triple(1,0,45),new Triple(1,2,12),
				new Triple(1,4,21),new Triple(2,0,28),new Triple(2,1,12),new Triple(2,3,17),new Triple(2,4,26),
				new Triple(3,0,10),new Triple(3,2,17),new Triple(3,4,15),new Triple(4,1,21),new Triple(4,2,26),
				new Triple(4,3,15)};
		
		MatrixGragh<String> g = new	MatrixGragh<String>(s,edges);
		System.out.println("带权无向图G3（除顶点F）：\n" + g.toString());
		
		int i = g.insertV("F");
		g.insertEdge(3,i,13);
		g.insertEdge(i,3,13);
		g.insertEdge(4,i,11);
		g.insertEdge(i,4,11);
		System.out.println("带权无向图G3（加顶点F）：\n" + g.toString());
		
		System.out.println("DFS遍历：");		//测试DFS
		for(int j=0;j<g.count();j++){
			g.DFSTraverse(j);			
		}
		
		System.out.println();
		
		System.out.println("BFS遍历：");		//测试BFS
		for(int j=0;j<g.count();j++){
			g.BFSTraverse(j);			
		}
		
		System.out.println();			
		g.minSpanTree();					//测试最小生成树
		
		System.out.println();
		for(int j=0;j<g.count();j++){
			g.shortestPath(j);				//测试单源最短路径
		}
		
		
		
		
	}

}
