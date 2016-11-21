package sjjg;

public class Triple implements Comparable<Triple>, Addible<Triple>{
	
	int row, column, value;			//行、列、元素值
	
	public Triple(int row, int column, int value) {		//含三个参数的构造方法
		this.row = row;
		this.column = column;
		this.value = value;
	}
	
	public Triple(Triple tri){					//构造方法（复制一个Triple）
		this(tri.row, tri.column, tri.value);
	}

	
	@Override
	public String toString() {				//toString方法
		return "(" + row + "," + column + "," + value + ")";
	}

	@Override
	public int compareTo(Triple o) {		//根据行与列的位置比较大小
		// TODO 自动生成的方法存根
		if(this.row<=o.row && this.column<o.column){
			return 0;
		}
		return (this.row<=o.row && this.column<o.column)?-1:1;
	}
	
	public boolean equals(Object obj){		//通过比较行列位置和该位置上的元素值来判断两个Triple是否相等
		if(this.equals(obj)){
			return true;
		}
		return false;
		
	}

	@Override
	public void add(Triple t) {				//加法运算
		// TODO 自动生成的方法存根
		this.value+=t.value;
	}

	@Override
	public boolean removable() {			//约定删除元素的条件（元素为0）
		// TODO 自动生成的方法存根
		return this.value == 0;
	}
	
	public Triple toSymmetry(){				//返回对称位置的元素的Triple
		return new Triple(this.column, this.row, this.value);
		
	}
	
	
	
	
	
	
	
	
	

}
