package sjjg;

public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
		BinaryTree<String> bitree = new BinaryTree<String>(prelist);
		System.out.println("�ȸ������������� " + bitree.toString());
		System.out.println("�и������������� ");
		bitree.inorder();
		System.out.println("��������������� ");
		bitree.postorder();
		bitree.insert(bitree.root.left, "X", true);
		bitree.insert(bitree.root.right, "Y", false);
		bitree.insert("Z");

	}

}
