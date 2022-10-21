package aircondition;

import java.io.File;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

public class virtualfriends {
	public static void main(String[] args) {
		//Scanner in= new Scanner(System.in);
		File input;
		Scanner in= new Scanner(System.in);
		try {
			input = new File("C:\\Users\\Mango T. Shih-tzu\\Desktop\\School\\CompSci\\Algo\\Homework\\bin\\aircondition\\virtualfriends-1.in");
			in = new Scanner(input);
		} catch (Exception e) {
			System.out.println(e);
		}
		HashMap<String, HashSet<String>> network= new HashMap<String, HashSet<String>>();
		HashMap<String, String> friend= new HashMap<String, String>();
		int groupCount=in.nextInt();
		if( groupCount!=0) {
			for(int i=0;i<groupCount;i++) {
				int group=in.nextInt();
				if(group!=0) {
				for(int j=0;j<group;j++) {
					String one=in.next().toLowerCase(), onetemp=one, two=in.next().toLowerCase(), twotemp=two;
					if(friend.containsKey(one)) {
						String parent=friend.get(one);
						while(parent!=one) {
							parent=one;
							one=friend.get(one);
						}
					}
					if(friend.containsKey(two)) {
						String parent=friend.get(two);
						while(parent!=two) {
							parent=two;
							two=friend.get(two);
						}
					}
					if(one.equals(two)) {
						System.out.println(network.get(one).size());
						continue;
					}
					if(onetemp.equals(one)&&!network.containsKey(one)&&!friend.containsKey(one)) {
						friend.put(one, one);
						network.put(one, new HashSet<String>());
						friend.put(two, one);
					}
					if(network.containsKey(two)) {
						if(network.get(one).size()>=network.get(two).size()) {
						network.get(one).addAll(network.get(two));
						//network.get(one).add(two);
						network.remove(two);
						friend.put(two, one);
						//friend.put(one, one);
						if(!two.equals(twotemp)) {
							network.get(one).add(twotemp);
							friend.put(twotemp, one);
						}
						}else {
							network.get(two).addAll(network.get(one));
							//network.get(two).add(one);
							network.remove(one);
							friend.put(one, two);
							//friend.put(two, two);
							if(!two.equals(twotemp)) {
								network.get(two).add(twotemp);
								friend.put(twotemp, two);
							}
							one=two;
						}
					}else {
						friend.put(two, one);
						network.get(one).add(one);
						network.get(one).add(two);
					}
					System.out.println(network.get(one).size());
				}
			}
			}
		}
}
}
