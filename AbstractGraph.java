package sjjg;

public abstract class AbstractGraph<T> {
	protected static final int MAX = 0x0000ffff;		//MAX��ʾ���Ȩֵ
	public SeqList<T> v;								//˳���v�洢ͼ�Ķ���
	
	public AbstractGraph(int length) {					//���췽������������Ϊlength�Ŀձ�������Ϊ0��
		this.v = new SeqList<T>(length);
		// TODO �Զ����ɵĹ��캯�����
	}

	public AbstractGraph() {							//���췽��������Ĭ������Ϊ10�Ŀձ�������Ϊ0��
		this(10);
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public int count(){									//���ض���ĸ���
		return this.v.size();
		
	}
	

	public T getV(int i) {								//���ض���Ԫ��Vi
		return v.get(i);
	}

	public void setV(int i, T x) {						//���ö���Ԫ��ViΪx
		this.v.set(i, x);
	}
	
	
	
	@Override
	public String toString() {							//toString����
		return "���㼯�ϣ�" + this.v.toString() + "\n";
	}

	public abstract int insertV(T x);
	
	public abstract void removeV(int i);
	
	public abstract int weight(int i,int j);
	
	protected abstract int next (int i, int j);
	
	
	

}
