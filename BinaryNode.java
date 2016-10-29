package sjjg;

public class BinaryNode<T> {
	
	public T data;		//������
	public BinaryNode<T> left, right;		//��ַ��ָ�����Һ���
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {		//�����������Ĺ��췽��
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinaryNode(T data) {		//ֻ��data�����Ĺ��췽����������������Ҷ�ӽڵ㣩
		// TODO �Զ����ɵĹ��캯�����
		this(data,null,null);
	}

	@Override
	public String toString() {		//toString����
		return this.data.toString();
	}
	
	public boolean isLeaf(){		//�ж��Ƿ���Ҷ�ӽڵ�
		return this.left==null && this.right==null;
		
	}

}
