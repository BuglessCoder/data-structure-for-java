package sjjg;

public class BinaryTree<T> {
	public BinaryNode<T> root;		//���ڵ�
	
	public BinaryTree(){	//�չ��췽��������������յĶ�������
		this.root = null;
	}

	public BinaryTree(T[] prelist){		//��prelist����Ϊ�������������
		this.root = create(prelist);
	}
	
	private int i = 0;
	
	private BinaryNode<T> create(T[] prelist) {		//prelist����ָ���������������������ȸ���������
		// TODO �Զ����ɵķ������
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

	public boolean isEmpty(){		//�п�
		return this.root == null;
	}
	
	public BinaryNode<T> insert(T x){		//����x��Ϊ���ڵ�
		return this.root = new BinaryNode<T>(x, this.root, null);
		
	}
	
	public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild){		//����x��Ϊparent�ڵ����/�Һ���
		if(x == null){
			return null;
		}
		if(leftChild){
			return parent.left = new BinaryNode<T>(x, parent.left, null);
		}
		return parent.right = new BinaryNode<T>(x, null, parent.right);
		
	}
	
	public void remove(BinaryNode<T> parent, boolean leftChild){	//ɾ��parent�ڵ����/������
		if(leftChild){
			parent.left = null;
		}
		else parent.right = null;
	}
	
	public void clear(){		//��ն�������ɾ�����нڵ㣩
		this.root = null;
	}
	
	public void preorder(){		//����ȸ�����
		preorder(this.root);
		System.out.println();
	}
	
	private void preorder(BinaryNode<T> p){		//�ݹ�ʵ���ȸ�����
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
	
	public void inorder(){		//����и�����
		inorder(this.root);
		System.out.println();
	}
	
	private void inorder(BinaryNode<T> p){		//�ݹ�ʵ���и�����
		if(p!=null){
			inorder(p.left);
			System.out.println(p.data.toString() + " ");
			inorder(p.right);
		}
	}
	
	public void postorder(){		//����������
		postorder(this.root);
		System.out.println();
	}
	
	private void postorder(BinaryNode<T> p){		//�ݹ�ʵ�ֺ������
		if(p!=null){
			postorder(p.left);
			postorder(p.right);
			System.out.println(p.data.toString() + " ");
		}
	}
	
	public int size(){		
		return count(root);		
	}
	
	public int count(BinaryNode<T> p){		//��ڵ�������������
		if(p!=null){
			return count(p.left) + count(p.right) + 1;
		}
		return 0;
		
	}
	
	public int herght(){
		return 0;
		
	}
	
	public int height(BinaryNode<T> p){		//�����ߣ�������
		if(p!=null){
			return (height(p.left) >= height(p.right)) ? height(p.left)+1 : height(p.left)+1;
		}
		return 0;
	}
	
	public BinaryNode<T> search(BinaryNode<T> p, T x){		//����������Ϊx�Ľڵ�
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
	
	public BinaryNode<T> getParent(BinaryNode<T> p, BinaryNode<T> node){		//��ȡnode�ڵ�ĸ�ĸ�ڵ�
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
	
	public void prefeidigui(){											//ǰ���������ǵݹ飩
		LinkedStack<BinaryNode<T>> s = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> p = this.root;
		
		while(p!=null || !s.isEmpty()){
			if(p!=null){
				System.out.println(p.data + " ");
				s.push(p);
				p = p.left;
			}
			else{
				System.out.println("^");
				p = s.pop();
				p = p.right;
			}
		}
	}
	
	public void infeidigui(){												//�и��������ǵݹ飩
		LinkedStack<BinaryNode<T>> s = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> p = this.root;
		
		while(p!=null || !s.isEmpty()){
			if(p!=null){				
				s.push(p);
				p = p.left;
			}
			else{
				p = s.pop();
				System.out.println(p.data + " ");
				p = p.right;
			}
		}
	}
	
	public void postfeidigui(){												//����������ǵݹ飩
		LinkedStack<BinaryNode<T>> s = new LinkedStack<BinaryNode<T>>();
		BinaryNode<T> current;		//��ǰ�ڵ�
		BinaryNode<T> pre= null;	//ǰһ���ڵ�
		s.push(root);				//ֱ����ջ
		
		while(!s.isEmpty()){
			current = s.peek();
			if((current.left == null && current.right == null) || (pre!=null && (pre == current.left || pre == current.right)))
			{		
				//�����ǰ���û�����Һ��ӻ��ߺ��ӽڵ㶼�ѱ����ʹ� 
				System.out.println(current.data + " ");
				s.pop();
				pre = current;
				
			}
			else{		//��������� ���Һ���ֱ����ջ										
				if(current.right!=null){
					s.push(current.right);
				}
				if(current.left!=null){
					s.push(current.left);
				}	
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


