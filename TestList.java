package sjjg;

public class TestList {
	public static void main(String a[]){
		
		String[] values = {"A","B","C","D"};
		
		//TestSeqList		
		/*SeqList<String> t1 = new SeqList<String>(values);
		
		System.out.println(t1.get(0)); //����get����
		t1.set(0, "a");
		System.out.println(t1.get(0));	//����set����
		
		System.out.println(t1.toString()); //����toString����
		
		t1.insert(1, "b");		//���Բ���
		System.out.println(t1.toString());
		
		t1.remove(1);		//����ɾ��
		System.out.println(t1.toString());
		
		t1.clear();		//�������
		System.out.println(t1.toString());
		
		System.out.println("\n");*/
		
		//TestSinglyList
		SinglyList<String> t2 = new SinglyList<String>(values);
		
		System.out.println(t2.get(0)); //����get����
		t2.set(0, "a");
		System.out.println(t2.get(0));	//����set����
		
		System.out.println(t2.toString()); //����toString����
		
		t2.insert(1, "b");		//���Բ���
		System.out.println(t2.toString());
		
		t2.remove(1);		//����ɾ��
		System.out.println(t2.toString());
		
		t2.clear();		//�������
		System.out.println(t2.toString());
		
	}
	
}
