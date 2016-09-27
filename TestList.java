package sjjg;

public class TestList {
	public static void main(String a[]){
		
		String[] values = {"A","B","C","D"};
		
		//TestSeqList		
		/*SeqList<String> t1 = new SeqList<String>(values);
		
		System.out.println(t1.get(0)); //≤‚ ‘get∑Ω∑®
		t1.set(0, "a");
		System.out.println(t1.get(0));	//≤‚ ‘set∑Ω∑®
		
		System.out.println(t1.toString()); //≤‚ ‘toString∑Ω∑®
		
		t1.insert(1, "b");		//≤‚ ‘≤Â»Î
		System.out.println(t1.toString());
		
		t1.remove(1);		//≤‚ ‘…æ≥˝
		System.out.println(t1.toString());
		
		t1.clear();		//≤‚ ‘«Âø’
		System.out.println(t1.toString());
		
		System.out.println("\n");*/
		
		//TestSinglyList
		SinglyList<String> t2 = new SinglyList<String>(values);
		
		System.out.println(t2.get(0)); //≤‚ ‘get∑Ω∑®
		t2.set(0, "a");
		System.out.println(t2.get(0));	//≤‚ ‘set∑Ω∑®
		
		System.out.println(t2.toString()); //≤‚ ‘toString∑Ω∑®
		
		t2.insert(1, "b");		//≤‚ ‘≤Â»Î
		System.out.println(t2.toString());
		
		t2.remove(1);		//≤‚ ‘…æ≥˝
		System.out.println(t2.toString());
		
		t2.clear();		//≤‚ ‘«Âø’
		System.out.println(t2.toString());
		
	}
	
}
