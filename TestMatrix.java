package sjjg;

public class TestMatrix {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int a[][] = {{1,2,3},{4,5,6,7,8},{9}};
		Matrix m = new Matrix(3,4,a);
		System.out.println(m.toString());
		m.set(2, 3, 10);
		System.out.println("修改后矩阵为：" + m.toString());

	}

}
