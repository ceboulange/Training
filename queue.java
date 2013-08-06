import static java.lang.System.out;


public class queue{
	int n;
	final int size = 200;
	int[] arr = new int[size];
	
	public queue(int[] array,int nb){
		n = nb;
		for(int i = 0; i < n; i++){
			arr[i+1] = array[i];
		}
		
		for(int j = n; j >= 1; j--){
			this.bubbleDown(j);
		}
	}
	
	public void displayArr(){
		String str = "";
		if(n > 0){
			str = Integer.toString(arr[1]);
			for(int i=2; i <= n; i++){
				str+= "-" + Integer.toString(arr[i]);
			}
		}
		out.println(str);
	}
	
	public int firstChild(int k){
		return 2*k;
	}
	
	public int parent(int k){
		if(k == 1) return -1;
		else return k/2;
	}
	
	public void insert(int x){
		if(n < size) {
			n++;
			arr[n] = x;
			this.bubbleUp(n);
		}
	}
	
	public void swap(int i,int j){
		if(i > 0 && i <= n && j > 0 && j <= n){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	public void bubbleUp(int k){
		if(k > 1){
			int par = this.parent(k);
			if(arr[par] > arr[k]){
				this.swap(k,par);
				this.bubbleUp(par);
			}
		}
	}
	
	public void bubbleDown(int k){
		int c = this.firstChild(k); //We test if c < n later in the loop		
		int min = k;
		
		for(int i=0; i<=1; i++){
			if(c+i <= n){
				if(arr[c+i] < arr[min]){
					min = c+i;
				}
			}
		}
		
		if(min != k){
			this.swap(k,min);
			this.bubbleDown(min);
		}
	}
	
	public int extractMin(){
		int min = -1;
		if(n > 0){
			min = arr[1];
			arr[1] = arr[n];
			n = n-1;
			this.bubbleDown(1);
		}
		return min;
	}
}