package sjjg;

public class Josephus {
	/*public Josephus(int number,int start, int distance){
		System.out.println("Josephus("+number+","+start+","+distance+"),");
		SeqList<String> list = new SeqList<String>(number);
		for(int i=0;i<number;i++){
			list.insert(i,(char)('A'+i)+"");	
		}
		System.out.println(list.toString());
		int i = start;
		while(list.size()>1){
			i = (i+distance-1)%list.size();
			System.out.println("ɾ��"+list.remove(i).toString()+"��");
			System.out.println(list.toString());
		}	
		System.out.println("����������"+list.get(0).toString());
	}
	
	public static void main(String a[]){
		new Josephus(5,0,2);
	}	*/
	
	
	public Josephus(int number,int start, int distance){
		System.out.println("Josephus("+number+","+start+","+distance+"),");
		SinglyList list = new SinglyList();
		for(int i=0;i<number;i++){
			list.insert(i,(char)('A'+i)+"");
		}
		System.out.println(list.toString());
		int i = start;
		while(list.size()>1){
			i = (i+distance-1)%list.size();
			System.out.println("ɾ��"+list.remove(i).toString()+"��");
			System.out.println(list.toString());
		}	
		System.out.println("����������"+list.get(0).toString());
	}
	
	public static void main(String a[]){
		new Josephus(5,0,2);
	}

}

