package sjjg;

public class BinaryNode<T> {
	
	public T data;		//数据域
	public BinaryNode<T> left, right;		//地址域，指向左右孩子
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {		//含三个参数的构造方法
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(T data) {		//只含data参数的构造方法（可以用来构造叶子节点）
		// TODO 自动生成的构造函数存根
		this(data,null,null);
	}

	@Override
	public String toString() {		//toString方法
		return this.data.toString();
	}
	
	public boolean isLeaf(){		//判断是否是叶子节点
		return this.left==null && this.right==null;
		
	}

}
