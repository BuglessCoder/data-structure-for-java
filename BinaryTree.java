package sjjg;

public class BinaryTree<T> {
	public BinaryNode<T> root;		//根节点
	
	public BinaryTree(){	//空构造方法（可用来构造空的二叉树）
		this.root = null;
	}

	public BinaryTree(T[] prelist){		//以prelist数组为参数构造二叉树
		this.root = create(prelist);
	}
	
	private int i = 0;
	
	private BinaryNode<T> create(T[] prelist) {		//prelist数组指定二叉树表明空子树的先根遍历序列
		// TODO 自动生成的方法存根
		BinaryNode<T> p = null;
		if(i<prelist.length){
			T e = prelist[i];
			i++;
			if(e!=null){
				p = new BinaryNode<T>(e);
				p.left = create(prelist);
				p.right = create(prelist);
			}
			return p;
		}
		
		return null;
	}

	public boolean isEmpty(){		//判空
		return this.root == null;
	}
	
	public BinaryNode<T> insert(T x){		//插入x作为根节点
		return this.root = new BinaryNode<T>(x, this.root, null);
		
	}
	
	public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild){		//插入x作为parent节点的左/右孩子
		if(x == null){
			return null;
		}
		if(leftChild){
			return parent.left = new BinaryNode<T>(x, parent.left, null);
		}
		return parent.right = new BinaryNode<T>(x, null, parent.right);
		
	}
	
	public void remove(BinaryNode<T> parent, boolean leftChild){	//删除parent节点的左/右子树
		if(leftChild){
			parent.left = null;
		}
		else parent.right = null;
	}
	
	public void clear(){		//清空二叉树（删除所有节点）
		this.root = null;
	}
	
	public void preorder(){		//输出先根遍历
		preorder(this.root);
		System.out.println();
	}
	
	private void preorder(BinaryNode<T> p){		//递归实现先根遍历
		if(p!=null){
			System.out.println(p.data.toString() + " ");
			preorder(p.left);
			preorder(p.right);
		}
	}
	
	public String toString(){
		return toString(this.root);
	}
	
	private String toString(BinaryNode<T> p){
		if(p == null){
			return "^";
		}
		return p.data.toString() + " " + toString(p.left) + toString(p.right);
	}
	
	public void inorder(){		//输出中根遍历
		inorder(this.root);
		System.out.println();
	}
	
	private void inorder(BinaryNode<T> p){		//递归实现中根遍历
		if(p!=null){
			inorder(p.left);
			System.out.println(p.data.toString() + " ");
			inorder(p.right);
		}
	}
	
	public void postorder(){		//输出后根遍历
		postorder(this.root);
		System.out.println();
	}
	
	private void postorder(BinaryNode<T> p){		//递归实现后根遍历
		if(p!=null){
			postorder(p.left);
			postorder(p.right);
			System.out.println(p.data.toString() + " ");
		}
	}
	
	public int size(){		
		return count(root);		
	}
	
	public int count(BinaryNode<T> p){		//求节点总数（遍历）
		if(p!=null){
			return count(p.left) + count(p.right) + 1;
		}
		return 0;
		
	}
	
	public int herght(){
		return 0;
		
	}
	
	public int height(BinaryNode<T> p){		//求树高（遍历）
		if(p!=null){
			return (height(p.left) >= height(p.right)) ? height(p.left)+1 : height(p.left)+1;
		}
		return 0;
	}
	
	public BinaryNode<T> search(BinaryNode<T> p, T x){		//查找数据域为x的节点
		BinaryNode<T> find = null;
		if(p!=null && x!=null){
			if(p.data.equals(x)){
				find = p;
			}
			else{
				find = search(p.left, x);
				if(find == null){
					find = search(p.right, x);
				}
			}
		}
		return find;
	}
	
	public BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node){		//获取node节点的父母节点
		BinaryNode<T> find = null;
		if(p!=null){
			if(p.left == node || p.right == node){
				find = p;
			}
			else{
				find = getParent(p.left, node);
				if(find == null){
					find = getParent(p.right, node);
				}
			}
		}
		return find;
	}
	
	
	
	
	
	
	
	
	
					
		
}


