package task1;

public class MyArray {

	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 45
	// Output: 3
	public int iterativeLinearSearch(int target) {

		for (int i = 0; i <= array.length - 1; i++) {
			if (target == array[i]) {
				return i;

			}
		}
		return -1;
	}

	// To find the index of the target in the array. If the target
	// is not found in the array, then the method returns -1.
	// Input: int[] array = {12, 10, 9, 45, 2, 10, 10, 45}, 15
	// Output: -1
	public int recursiveLinearSearch(int target) {
		return recursiveLinearSearchAdd(target, 0);
		
	}
	public  int  recursiveLinearSearchAdd( int target, int index) {
		if(index == array.length) {
			return -1;
		}else if(array[index] ==target) {
			return index;
		}else {
			return recursiveLinearSearchAdd(target,index +1);
					
		}

	}
	
		
	
		
	

	// To find the index of the target in the sorted array. If the
	// target is not found in the array, then the method returns -1.

	public int iterativeBinarySearch(int target) {
		int left = 0;

		int right = array.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (array[mid] == target) {
				return mid;
			}
			if (array[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
	
	
	public int recursiveBinarySearch(int target) {
		
		return recursiveBinarySearchAdd(target, 0, array.length-1);
		}

	public int recursiveBinarySearchAdd( int target , int left,int right ){
		if(left<= right ) {
			int  mid = left +(right -left)/2;
		
		 if (array[mid] == target) {
	            return mid;
	        }
	        if (array[mid] < target) {
	            return recursiveBinarySearchAdd(target, mid + 1, right);
	        } else {
	            return recursiveBinarySearchAdd(target, left, mid - 1);
	        }
	    }
	
	    return -1;
	}

	public static void main(String[] args) {
		int[] array = { 12, 10, 9, 45, 2, 10, 10, 45 };
		MyArray myArray = new MyArray(array);
		int value1 = myArray.iterativeLinearSearch(45);
		System.out.println(value1);

		
		int value2 = myArray.recursiveLinearSearch(9);
		System.out.println(value2);

		int[] array1 = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		MyArray myArray1 = new MyArray(array1);
		int value3 = myArray1.iterativeBinarySearch(17);
		System.out.println(value3);
		
		int value4 = myArray1.recursiveBinarySearch(12);
		System.out.println(value4);
		
		
	}
}
