package sjjg;

public class TestStack {
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		//TestSeqStack
		String[] values1 = {"A","B","C","D"};
		SeqStack<String> list1 = new SeqStack<String>();
		
		list1.push(values1[0]);		//������ջ
		System.out.println(list1.toString());
		list1.push(values1[2]);
		System.out.println(list1.toString());
		list1.push(values1[1]);
		System.out.println(list1.toString());			
		System.out.println(list1.peek());		//���Է���ջ��Ԫ��
		list1.pop();							//���Գ�ջ
		System.out.println(list1.toString());	
		list1.pop();
		System.out.println(list1.toString());
		System.out.println("\n");
		
		
		
		//TestLinkedStack
		LinkedStack<String> list2 = new LinkedStack<String>();
		
		list2.push(values1[0]);		//������ջ
		System.out.println(list2.toString());
		list2.push(values1[2]);
		System.out.println(list2.toString());
		list2.push(values1[1]);
		System.out.println(list2.toString());			
		System.out.println(list2.peek());		//���Է���ջ��Ԫ��
		list2.pop();							//���Գ�ջ
		System.out.println(list2.toString());	
		list2.pop();
		System.out.println(list2.toString());
		
		

	}

}
