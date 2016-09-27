package sjjg;

public class CheckBracket {
	
	public static String isMarched(String str){
		
		SeqStack<String> s1 = new SeqStack<String>(str.length());
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			
			//����һ������!equals��Ϊ!=�����  why(��ϵ���ߵ�����)
			switch(ch)
			{
				case'(': s1.push(ch+"");
							break;
				case')': if(s1.isEmpty()||!s1.pop().equals("("))
							return "���Ų�ƥ�䣬ȱ��(";
			}		
			
			
			//�������Ϊ�����´����в�ͨ��
			/*if(ch=='(')
				s1.push(ch+"");			
			else if(ch==')')
				s1.pop();			
			else if(s1.isEmpty()||!s1.pop().equals("("))
				return "���Ų�ƥ�䣬ȱ��(";	*/	
		}
		
		return (s1.isEmpty())?"����ƥ����ȷ":"���Ų�ƥ�䣬ȱ��)";
		
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		String str1 = "(1+2)*6-(5+8)/2";
		String str2 = "((1+2)*6-(5+8)/2";
		String str3 = "(1+2)*6-(5+8))/2";
		
		System.out.println("�����ַ���" + str1 + "  " + CheckBracket.isMarched(str1));
		System.out.println("�����ַ���" + str2 + "  " + CheckBracket.isMarched(str2));
		System.out.println("�����ַ���" + str3 + "  " + CheckBracket.isMarched(str3));
		

	}

}
