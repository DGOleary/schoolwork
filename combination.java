
public class combination {
	
	public static int combinationRecursive(int n, int r){
		if(r>n) {
			return 0;
		}else if(r==0||r==n) {
			return 1;
		}
		return combinationRecursive(n-1, r)+combinationRecursive(n-1, r-1);
	}
	
	
	public static int combinationDynamic(int n, int r) {
		if(r>n) {
			return 0;
		}
		if(n==r||n==0) {
			return 1;
		}
		int[][] nums=new int[n+1][r+1];
		for(int i=0;i<n+1;i++) {
			nums[i][0]=1;
		}
		for(int i=0;i<Math.min(n+1, r+1);i++) {
			nums[i][i]=1;
		}
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<n-1;j++) {
				nums[i+1][j+1]=nums[i][j]+nums[i][j+1];
			}
		}
		for(int[] x:nums) {
			for(int y: x) {
				System.out.print(y);
			}
			System.out.println();
		}
		return nums[n+1][r+1];
	}
	
public static void main(String[] args) {
	//System.out.println(combinationRecursive(5,2));
	System.out.println(combinationDynamic(5,2));
}
}
