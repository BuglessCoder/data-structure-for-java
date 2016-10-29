package sjjg;

public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
		BinaryTree<String> bitree = new BinaryTree<String>(prelist);
		System.out.println("先根遍历二叉树： " + bitree.toString());
		System.out.println("中根遍历二叉树： ");
		bitree.inorder();
		System.out.println("后根遍历二叉树： ");
		bitree.postorder();
		bitree.insert(bitree.root.left, "X", true);
		bitree.insert(bitree.root.right, "Y", false);
		bitree.insert("Z");

	}

}
