import java.util.*;
import java.io.*;

public class airconditioned {

	public static void main(String[] args) {
		File input;
		Scanner in= new Scanner(System.in);
		try {
			input = new File("1.in");
			in = new Scanner(input);
		} catch (Exception e) {
			System.out.println(e);
		}
			int len = in.nextInt();
			LinkedList<LinkedList<Integer>> rooms = new LinkedList<LinkedList<Integer>>();
			for (int i = 0; i < len; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				int ind = 0;
				Iterator<Integer> it;
				if (rooms.size() == 0) {
					rooms.add(new LinkedList<Integer>(Arrays.asList(a, b)));
				} else {
					for (int j = 0; j < rooms.size(); j++) {
						int temp=ind;
						it = rooms.get(j).iterator();
						while (it.hasNext()) {
							int start=it.next();
							int fin=it.next();
							if(!((a>=start&&a<=fin)||(b>=start&&b<=fin))) {
								ind++;
								break;
							}
							
						}
						if(temp==ind) {
							break;
						}
						
					}
					if(ind>rooms.size()-1) {
						rooms.add(new LinkedList<Integer>());
						rooms.get(rooms.size()-1).add(a);
						rooms.get(rooms.size()-1).add(b);
						}else {
							rooms.get(ind).add(a);
							rooms.get(ind).add(b);
						}
				}
			}
			/*
			for(int i=0;i<rooms.size();i++) {
				System.out.println(i);
				for(int j=0;j<rooms.get(i).size();j++) {
					System.out.print(rooms.get(i).get(j)+" ");
				}
				System.out.println();
			}
			*/
			System.out.println(rooms.size());
			in.close();
		
		
	}
	
}