package sjjg;

public interface Stack<T> {
	public abstract boolean isEmpty();	//�п�
	public abstract void push(T x);		//Ԫ��x��ջ
	public abstract T peek();		//����ջ��Ԫ�أ�����ջ��
	public abstract T pop();		//��ջ
	public abstract String toString();
}
