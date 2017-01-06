package sjjg;

public class Array9 {
	
	public static void print(int[] table){
		for(int i=0;i<table.length;i++){
			System.out.print(table[i] + " ");
		}
		
	}
	
	//直接插入排序
	public static void insertSort(int[] table){
		for(int i=1;i<table.length;i++){			//i初始指向第二个元素，然后向后移动
			int temp = table[i];					//temp初始指向第二个元素，然后向后移动
			int j;
			for(j=i-1;j>-1 && temp<table[j];j--){	//temp和前边若干元素一一比较
				table[j+1] = table[j];				//前边比temp大的元素一一后移
			}
			table[j+1] = temp;						//temp最终插入的位置
			System.out.print("第" + i + "趟：");
			print(table);
			System.out.println();
		}
	}
	
	//希尔排序
	public static void shellSort(int[] table){
		for(int delta=table.length/2;delta>0;delta/=2){
			for(int i=delta;i<table.length;i++){
				int temp = table[i];
				int j = i-delta;
				while(j>=0 && temp<table[j]){
					table[j+delta] = table[j];
					j-=delta;
				}
				table[j+delta] = temp;
			}
			print(table);
			System.out.println();
		}
	}
	
	//冒泡排序
	public static void bubbleSort(int[] table){			
		boolean exchange = true;						//是否交换标的记（默认当前是已经交换过的）
		for(int i=1;i<table.length && exchange;i++){	//有交换时才进行下一趟比较
			exchange = false;							//假定元素未交换
			for(int j=0;j<table.length-i;j++){			
				if(table[j]>table[j+1]){				//如果第一个元素大于第二个，交换两元素位置
					int temp = table[j];
					table[j] = table[j+1];
					table[j+1] = temp;
					exchange = true;					//有交换，标记为true
				}
			}
			print(table);
			System.out.println();
		}
		print(table);
	}
	
	//快排
	public static void quickSort(int[] table, int low, int high){		
		if(low<high){							//low和high制定上下界（使序列是有效的）
			int i = low;						
			int j = high;
			int vot = table[i];					//取第一个元素作为基准值vot
			while(i!=j){						//在i与j不相等的情况下循环	
				while(i<j && vot<=table[j]){	//当j指向的元素（从后往前）大于vot时，元素不移动									
					j--;						//使j向前移一位
				}
				if(i<j){
					table[i] = table[j];		//当j指向的元素小于vot时，将该元素覆盖i指向的元素
					i++;						//i向后移动一位
				}
				while(i<j && vot>table[i]){		//当i指向的元素（从前往后）小于vot时，元素不移动
					i++;						//使i向后移一位
				}
				if(i<j){
					table[j] = table[i];		//当i指向的元素大于vot时，将该元素覆盖j指向的元素
					j--;						//使j向前移一位
				}
			}
			table[i] = vot;						//使基准值覆盖i当前指向的元素
			print(table);
			System.out.println();
			quickSort(table,low,j-1);
			quickSort(table,i+1,high);
		}
	}
	
	//直接选择排序
	public static void selectSort(int[] table){
		for(int i=0;i<table.length-1;i++){			//n-1趟排序
			int min = i;							//设第i个元素最小（默认第一个元素最小）
			for(int j=i+1;j<table.length;j++){		//在剩下的子序列中查找最小值（j从第二个元素开始取）
				if(table[j]<table[min]){			
					min = j;						//记住最小元素下标
				}
			}
			if(min!=i){								//将最小元素交换到最前边		
				int temp = table[min];
				table[min] = table[i];
				table[i] = temp;
			}
			System.out.print("第" + i + "趟：");
			print(table);
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int[] a = {38,26,97,19,66,1,5,49};
		int[] b = {38,26,97,19,66,1,5,49};
		int[] c = {38,26,97,19,66,1,5,49};
		int[] d = {38,26,97,19,66,1,5,49};
		int[] e = {38,26,97,19,66,1,5,49};
		System.out.println("直接插入排序：");
		insertSort(a);
		System.out.println("\n");
		
		System.out.println("希尔排序：");
		shellSort(b);
		System.out.println("\n");
		
		System.out.println("冒泡排序：");
		bubbleSort(c);
		System.out.println("\n");
		
		System.out.println("快速排序：");
		quickSort(d,0,3);
		System.out.println("\n");
		
		System.out.println("直接选择排序：");
		selectSort(e);
		System.out.println("\n");
	}

}
