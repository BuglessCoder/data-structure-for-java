package sjjg;

public class Triple implements Comparable<Triple>, Addible<Triple>{
	
	int row, column, value;			//�С��С�Ԫ��ֵ
	
	public Triple(int row, int column, int value) {		//�����������Ĺ��췽��
		this.row = row;
		this.column = column;
		this.value = value;
	}
	
	public Triple(Triple tri){					//���췽��������һ��Triple��
		this(tri.row, tri.column, tri.value);
	}

	
	@Override
	public String toString() {				//toString����
		return "(" + row + "," + column + "," + value + ")";
	}

	@Override
	public int compareTo(Triple o) {		//���������е�λ�ñȽϴ�С
		// TODO �Զ����ɵķ������
		if(this.row<=o.row && this.column<o.column){
			return 0;
		}
		return (this.row<=o.row && this.column<o.column)?-1:1;
	}
	
	public boolean equals(Object obj){		//ͨ���Ƚ�����λ�ú͸�λ���ϵ�Ԫ��ֵ���ж�����Triple�Ƿ����
		if(this.equals(obj)){
			return true;
		}
		return false;
		
	}

	@Override
	public void add(Triple t) {				//�ӷ�����
		// TODO �Զ����ɵķ������
		this.value+=t.value;
	}

	@Override
	public boolean removable() {			//Լ��ɾ��Ԫ�ص�������Ԫ��Ϊ0��
		// TODO �Զ����ɵķ������
		return this.value == 0;
	}
	
	public Triple toSymmetry(){				//���ضԳ�λ�õ�Ԫ�ص�Triple
		return new Triple(this.column, this.row, this.value);
		
	}
	
	
	
	
	
	
	
	
	

}
