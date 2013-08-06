import static java.lang.System.*;


public class Sort{
	public static void runMergeSort(int[] array){
		int[] helper = new int[array.length];
		mergesort(array,helper,0,array.length-1);
	}
	
	public static void mergesort(int[] array,int[] helper,int left, int right){
		if(left < right){
			int middle = (left + right)/2;
			mergesort(array,helper,left,middle);
			mergesort(array,helper,middle+1,right);
			merge(array,helper,left,middle,right);
		}
	}
	
	public static void merge(int[] array,int[] helper,int left,int middle,int right){
		for(int i=left; i<=right;i++){
			helper[i] = array[i];
		}
		
		int helperLeft = left;
		int helperRight = middle+1;
		int current = left;
		
		while(helperLeft <= middle && helperRight <= right){
			if(helper[helperLeft] <= helper[helperRight]){
				array[current] = helper[helperLeft];
				helperLeft++;
			}
			else{
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++;
		}
		
		int remaining = middle - helperLeft;
		for(int j=0; j<=remaining; j++){
			array[current +j] = helper[helperLeft+j];
		}
	}
	
	public static void quicksort(int[] array,int left,int right){
		int index = partition(array,left,right);
		
		if(left < index -1){
			quicksort(array,left,index-1);
		}
		if(index < right){
			quicksort(array,index,right);
		}
	}
	
	public static int partition(int[] array, int left, int right){
		int pivot = array[(left+right)/2];
		
		while(left <= right){
			while(array[left] < pivot) left++;
			while(array[right] > pivot) right--;
			
			if(left <= right){
				swap(array,left,right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static void displayArray(int[] arr){
		String str = "";
		if(arr.length > 0){
			str = Integer.toString(arr[0]);
			for(int i=1; i < arr.length; i++){
				str+= "-" + Integer.toString(arr[i]);
			}
		}
		out.println(str);
	}
	
	public static int[] getRandomArray(int size,int max){
		int[] arr = new int[size];
		
		for(int i = 0; i < size; i++){
			arr[i] = (int) (max*Math.random());
        }
		
		return arr;
	}
	
	public static void heapSort(int[] array){
		queue q = new queue(array,array.length);
		
		for(int i=0; i<array.length; i++){
			array[i] = q.extractMin();
		}
	}
	
	public static int[] copyArray(int[] array){
		int[] ret = new int[array.length];
		for(int i=0; i<array.length; i++){
			ret[i] = array[i];
		}
		return ret;
	}
	
	public static void main(String[] args){
		int size = 100;
		int max = 50;
		int[] arr = getRandomArray(size,max);
		displayArray(arr);
		
		//Test quick sort
		out.println("Test quick sort");
		int[] arr1 = copyArray(arr);
		quicksort(arr1,0,arr1.length-1);
		displayArray(arr1);
		
		//Test merge sort
		out.println("Test merge sort");
		int[] arr2 = copyArray(arr);
		runMergeSort(arr2);
		displayArray(arr2);
		
		//Test heap sort
		out.println("Test heap sort");
		int[] arr3 = copyArray(arr);
		heapSort(arr3);
		displayArray(arr3);
	}
}
