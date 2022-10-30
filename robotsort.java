
public class robotsort {
	
static int[] colors;
static int robot=0;
public static void moveRight() {
	if(robot>=colors.length) {
		throw new ArrayIndexOutOfBoundsException();
	}else {
		robot++;
	}
}
public static void moveLeft() {
	if(robot<0) {
		throw new ArrayIndexOutOfBoundsException();
	}else {
		robot--;
	}
}
public static void swap() {
	int temp=colors[robot];
	colors[robot]=colors[robot-1];
	colors[robot-1]=temp;
}
public static void main(String[] args) {
colors=new int[1000];
	for(int i=colors.length/2; i<colors.length;i++) {
		colors[i]=1;
	}
	for(int x: colors) {
	System.out.print(x);
}
	System.out.println();
	int n=colors.length/2;
	if(n!=1) {
		int ind=0;
		int mid=n;
	for(int i=0;i<n-1;i++) {
		//System.out.println(mid);
		//System.out.println(robot);
		for(int j=ind;j<mid+1;j++) {
			moveRight();
		}
		for(int k=robot;k>ind+1;k--) {
			swap();
			if(robot!=ind+2) {
			moveLeft();
		}
		}
		mid++;
		ind+=2;
		//for(int x: colors) {
			//System.out.print(x);
		//}
		//System.out.println();
		}
	}
	
	for(int x: colors) {
		System.out.print(x);
	}
}
}