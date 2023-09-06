package 자료구조3장검색;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{
	
	String name;
	int height;
	double vision;
	
	@Override
	public int compareTo(PhyscData p) {
		//System.out.println("compereTo");
		int result = name.compareTo(p.name);
		if(result != 0 ) return result;
				
		int resultHeight = height - p.height;
				
		return resultHeight;
	}
	
	public PhyscData(String name, int height, double vision) {
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
	
	@Override
	public String toString() {
		return "name is " + this.name + " height is " +  this.height + " vision is " + this.vision;
	}
	
}

public class Test_실습3_6_1객체배열이진탐색 {

	public static void main(String[] args) {
		
		
		PhyscData[] data = {
				new PhyscData("홍길동", 162, 0.3),
				new PhyscData("홍동", 164, 1.3),
				new PhyscData("홍길", 152, 0.7),
				new PhyscData("김홍길동", 172, 0.3),
				new PhyscData("길동", 182, 0.6),
				new PhyscData("길동", 167, 0.2),
				new PhyscData("길동", 167, 0.5),
		};
		showData(data);
		//Arrays.sort(data);
		sortData(data);
		//Arrays.binarySearch(data, key);
		showData(data);
		
		PhyscData key = new PhyscData("길동", 167, 0.2);
		int result = linearSearch(data, key);
		System.out.println("\nlinearSearch(): result = " + result);
		key = new PhyscData("길동", 167, 0.5);

		//result = binarySearch(data, key);
		System.out.println("\nbinarySearch(): result = " + result);
		int idx = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(): result = " + idx);
	}
	
	static void swap(PhyscData[] data, int i, int j) {
		PhyscData tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	static void sortData(PhyscData[] data) {
		for(int i =0; i < data.length; i ++) {
			for(int j = i + 1; j < data.length; j++) {
				if(data[i].compareTo(data[j]) > 0)
					swap(data,i,j);
			}
		}
		//Arrays.sort(data);
		System.out.println("\nSorting is finished!! \n");
	}
	
	static int linearSearch(PhyscData[] data, PhyscData key) {
		
		return 0;
	}
	
//	static int binarySearch(PhyscData[] data, PhyscData key) {
//		int pl = 0;
//		int pr = data.length - 1;
//		int pc = pr / 2;
//		
//		do {
//			if(a[])
//		}
//		
//		return 0;
//	}
//	
	static void showData(PhyscData[]arr) {
		for (PhyscData fruit: arr) {
			System.out.println(fruit+" ");
		}
	}


}
