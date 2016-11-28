package sjjg;

public class TestMatrixGragh {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		String[] s = {"A","B","C","D","E"};
		
		Triple edges[] = {new Triple(0,1,45),new Triple(0,2,28),new Triple(0,3,10),new Triple(1,0,45),new Triple(1,2,12),
				new Triple(1,4,21),new Triple(2,0,28),new Triple(2,1,12),new Triple(2,3,17),new Triple(2,4,26),
				new Triple(3,0,10),new Triple(3,2,17),new Triple(3,4,15),new Triple(4,1,21),new Triple(4,2,26),
				new Triple(4,3,15)};
		
		MatrixGragh<String> g = new	MatrixGragh<String>(s,edges);
		System.out.println("��Ȩ����ͼG3��������F����\n" + g.toString());
		
		int i = g.insertV("F");
		g.insertEdge(3,i,13);
		g.insertEdge(i,3,13);
		g.insertEdge(4,i,11);
		g.insertEdge(i,4,11);
		System.out.println("��Ȩ����ͼG3���Ӷ���F����\n" + g.toString());
		
		System.out.println("DFS������");		//����DFS
		for(int j=0;j<g.count();j++){
			g.DFSTraverse(j);			
		}
		
		System.out.println();
		
		System.out.println("BFS������");		//����BFS
		for(int j=0;j<g.count();j++){
			g.BFSTraverse(j);			
		}
		
		System.out.println();			
		g.minSpanTree();					//������С������
		
		System.out.println();
		for(int j=0;j<g.count();j++){
			g.shortestPath(j);				//���Ե�Դ���·��
		}
		
		
		
		
	}

}
