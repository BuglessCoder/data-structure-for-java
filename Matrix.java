package sjjg;

public class Matrix {
	private int rows, columns;		//矩阵的行与列
	private int [][] element;		//二维数组存储矩阵元素
	
	public Matrix(int m, int n) {		//构造方法（构造m*n矩阵，初值为零）
		this.element = new int[m][n];
		this.rows = m;
		this.columns = n;
	}
	
	public Matrix(int n){ 		//构造方法（构造n阶方阵，初值为0）
		this(n,n);
	}
	
	public Matrix(int m, int n, int[][] value) {		//构造方法（构造m*n矩阵，又二维数组value提供元素）
		this(m,n);
		for(int i=0;i<value.length && i<m;i++){
			for(int j=0;j<value[i].length && j<n;j++){
				this.element[i][j] = value[i][j];
			}
		}
		
	}

	public int getRows() {		//返回行数
		return this.rows;
	}

	public int getColumns() {		//返回列数
		return this.columns;
	}

	public int get(int i, int j){		//返回某行某列的某个元素
		if(i>=0 && i<this.rows && j>=0 && j<this.columns) 
			return this.element[i][j];
		throw new IndexOutOfBoundsException("i=" + i + "j=" + j);
	}
	
	public void set(int i, int j, int x){		//替换某行某列的某个元素
		if(i>=0 && i<this.rows && j>=0 && j<this.columns)
			this.element[i][j] = x;
		else throw new IndexOutOfBoundsException("i=" + i + "j=" + j);
	}

	@Override
	public String toString() {					//toString方法
		String str = "矩阵（" + this.rows + "*" + this.columns + "):\n";
		for(int i=0;i<this.rows;i++){
			for(int j=0;j<this.columns;j++){
				str+="   " + this.element[i][j];
			}
			str+="\n";
		}
		
		return str;
	}
	
	public void setRowsColumns(int m, int n){			//设置新的行数与列数
		if(m>0 && n>0){
			if(m>this.element.length || n>this.element[0].length){		//若给定参数大于原来行/列则对数组扩容
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
		else throw new IllegalArgumentException("矩阵行列数不能<=0,m=" + m + "n=" + n);
		
	}
	
	
	
	
	
	
	
	
	

}
