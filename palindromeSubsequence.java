package aircondition;


public class palindromeSubsequence {
	public static String findPalindromeRec(String s) {	
	if(s.length()<1) {
		return s;
	}
	if(s.charAt(0)==s.charAt(s.length()-1)) {
		return s.charAt(0)+findPalindromeRec(s.substring(1,s.length()-1))+s.charAt(s.length()-1);
	}
	String temp1=findPalindromeRec(s.substring(0,s.length()-1));
	String temp2=findPalindromeRec(s.substring(1));
	if(temp1.length()>temp2.length()) {
		return temp1;
	}else {
		return temp2;
	}
	}
	
	public static String findPalindromeDyn(String s) {
		if(s.length()<1) {
			//checks for base case
			return s;
		}
		String[][] sub=new String[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			sub[i][i]=""+s.charAt(i);
		}
		//fills in base cases in the array
		for(int i=1;i<s.length()+1;i++) {
			for(int j=0;j<s.length()-i;j++) {
				//goes by diagonal line next to the previous case
				if((""+s.charAt(i+j)).equals(sub[j][j])) {
					int max=0;
					String val="";
					for(int k=j+1;k<s.length();k++) {
						for(int h=j+i-1;h>=0;h--) {
							if(sub[k][h]!=null) {
								if(sub[k][h].length()>max) {
									max=sub[k][h].length();
									val=sub[k][h];
								}
							}
						}
					}
					
					/*
					for(int k=1;k<s.length()-j;k++) {
						//checks diagonal row to the bottom left direction for any palindromes to add
						//System.out.println(s.length()-j);
						//System.out.println(k);
						//System.out.println(j);
						//System.out.println((i+j));
						//System.out.println();
						//int val1=j-k,val2=j-k;
						if(sub[j+k][(j+i)-k]!=null) {
							//System.out.println("val "+val);
							//System.out.println("sub "+sub[j+k][(i+j)-k]);
							if(sub[j+k][(i+j)-k].length()>max) {
								max=sub[j+k][(i+j)-k].length();
								val=sub[j+k][(i+j)-k];
							}
						}else {
							break;
						}
					}
					*/
					
					
					sub[j][i+j]=s.charAt(i+j)+val+s.charAt(i+j);
				}else {
					if(sub[j][i+j-1].length()>1) {
						sub[j][i+j]=sub[j][i+j-1];
					}else {
					sub[j][i+j]=""+s.charAt(i+j);
					}
				}
				
		}
			for(String[] x:sub) {
				for(String y: x) {
					if(y==null) {
					//	System.out.print(" * ");
					}else {
					//System.out.print(" "+y+" ");
				}
				}
				//System.out.println();
			}
			//System.out.println();
		}
		for(String[] x:sub) {
			for(String y: x) {
				if(y==null) {
			//		System.out.print(" * ");
				}else {
			//	System.out.print(" "+y+" ");
			}
			}
		//	System.out.println();
		}
		String max=sub[0][s.length()-1];
		System.out.println(max);
		for(int i=1;i<s.length();i++) {
			System.out.println(sub[i][s.length()-1]);
			if(sub[i][s.length()-1].length()>max.length()) {
				max=sub[i][s.length()-1];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		//System.out.println(findPalindromeRec("supercalifragilisticexpialidocious"));
		//System.out.println(findPalindromeRec("programming"));
		//System.out.println(findPalindromeDyn("programming"));
		//System.out.println(findPalindromeDyn("java"));
		//System.out.println(findPalindromeDyn("jsasvas"));
		//String hi=findPalindromeDyn("supercalifragilisticexpialidocious");
		String hi=findPalindromeDyn("supercalifragilistsupercalifragilisticexpialidociousicexpialidocious");
		System.out.println(hi);
		System.out.println(hi.length());
		//System.out.println("suciaiitiiaicus");
		//System.out.println("suciaiitiiaicus".length());
	}
}