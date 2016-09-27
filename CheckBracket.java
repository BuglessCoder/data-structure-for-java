package sjjg;

public class CheckBracket {
	
	public static String isMarched(String str){
		
		SeqStack<String> s1 = new SeqStack<String>(str.length());
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			
			//问题一：若将!equals改为!=则出错  why(联系二者的区别)
			switch(ch)
			{
				case'(': s1.push(ch+"");
							break;
				case')': if(s1.isEmpty()||!s1.pop().equals("("))
							return "括号不匹配，缺少(";
			}		
			
			
			//问题二：为何以下代码行不通？
			/*if(ch=='(')
				s1.push(ch+"");			
			else if(ch==')')
				s1.pop();			
			else if(s1.isEmpty()||!s1.pop().equals("("))
				return "括号不匹配，缺少(";	*/	
		}
		
		return (s1.isEmpty())?"括号匹配正确":"括号不匹配，缺少)";
		
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		String str1 = "(1+2)*6-(5+8)/2";
		String str2 = "((1+2)*6-(5+8)/2";
		String str3 = "(1+2)*6-(5+8))/2";
		
		System.out.println("对于字符串" + str1 + "  " + CheckBracket.isMarched(str1));
		System.out.println("对于字符串" + str2 + "  " + CheckBracket.isMarched(str2));
		System.out.println("对于字符串" + str3 + "  " + CheckBracket.isMarched(str3));
		

	}

}
