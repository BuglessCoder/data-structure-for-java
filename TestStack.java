package sjjg;

public class TestStack {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		//TestSeqStack
		String[] values1 = {"A","B","C","D"};
		SeqStack<String> list1 = new SeqStack<String>();
		
		list1.push(values1[0]);		//测试入栈
		System.out.println(list1.toString());
		list1.push(values1[2]);
		System.out.println(list1.toString());
		list1.push(values1[1]);
		System.out.println(list1.toString());			
		System.out.println(list1.peek());		//测试返回栈顶元素
		list1.pop();							//测试出栈
		System.out.println(list1.toString());	
		list1.pop();
		System.out.println(list1.toString());
		System.out.println("\n");
		
		
		
		//TestLinkedStack
		LinkedStack<String> list2 = new LinkedStack<String>();
		
		list2.push(values1[0]);		//测试入栈
		System.out.println(list2.toString());
		list2.push(values1[2]);
		System.out.println(list2.toString());
		list2.push(values1[1]);
		System.out.println(list2.toString());			
		System.out.println(list2.peek());		//测试返回栈顶元素
		list2.pop();							//测试出栈
		System.out.println(list2.toString());	
		list2.pop();
		System.out.println(list2.toString());
		
		

	}

}
