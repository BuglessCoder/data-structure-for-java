package sjjg;

public class Matrix {
	private int rows, columns;		//�����������
	private int [][] element;		//��ά����洢����Ԫ��
	
	public Matrix(int m, int n) {		//���췽��������m*n���󣬳�ֵΪ�㣩
		this.element = new int[m][n];
		this.rows = m;
		this.columns = n;
	}
	
	public Matrix(int n){ 		//���췽��������n�׷��󣬳�ֵΪ0��
		this(n,n);
	}
	
	public Matrix(int m, int n, int[][] value) {		//���췽��������m*n�����ֶ�ά����value�ṩԪ�أ�
		this(m,n);
		for(int i=0;i<value.length && i<m;i++){
			for(int j=0;j<value[i].length && j<n;j++){
				this.element[i][j] = value[i][j];
			}
		}
		
	}

	public int getRows() {		//��������
		return this.rows;
	}

	public int getColumns() {		//��������
		return this.columns;
	}

	public int get(int i, int j){		//����ĳ��ĳ�е�ĳ��Ԫ��
		if(i>=0 && i<this.rows && j>=0 && j<this.columns) 
			return this.element[i][j];
		throw new IndexOutOfBoundsException("i=" + i + "j=" + j);
	}
	
	public void set(int i, int j, int x){		//�滻ĳ��ĳ�е�ĳ��Ԫ��
		if(i>=0 && i<this.rows && j>=0 && j<this.columns)
			this.element[i][j] = x;
		else throw new IndexOutOfBoundsException("i=" + i + "j=" + j);
	}

	@Override
	public String toString() {					//toString����
		String str = "����" + this.rows + "*" + this.columns + "):\n";
		for(int i=0;i<this.rows;i++){
			for(int j=0;j<this.columns;j++){
				str+="   " + this.element[i][j];
			}
			str+="\n";
		}
		
		return str;
	}
	
	public void setRowsColumns(int m, int n){			//�����µ�����������
		if(m>0 && n>0){
			if(m>this.element.length || n>this.element[0].length){		//��������������ԭ����/�������������
				int[][] temp = this.element;
				this.element = new int[m][n];
				for(int i=0;i<this.rows;i++){
					for(int j=0;j<this.columns;j++){
						this.element[i][j] = temp[i][j];
					}
				}
			}
			this.rows = m;
			this.columns = n;
		}
		else throw new IllegalArgumentException("��������������<=0,m=" + m + "n=" + n);
		
	}
	
	
	
	
	
	
	
	
	

}
