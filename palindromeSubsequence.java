
public class palindromeSubsequence {
	public static String findPalindromeRec(String s) {	
	if(s.length()==1||s.length()==0) {
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
		if(s.length()==1||s.length()==0) {
			return s;
		}
		String[][] sub=new String[s.length()][s.length()];
		int[][] len=new int[s.length()][s.length()];
		for(int i=0;i<s.length();i++) {
			sub[i][i]=""+s.charAt(i);
		}
		for(int i=0;i<s.length();i++) {
			for(int j=1;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j)) {
					sub[i][j]=sub[i][j-1]+s.charAt(j);
				}
				else {
					sub[i][j]=sub[i][j-1];
				}
			}
		}
		return "";
	}
	public static void main(String[] args) {
		System.out.println(findPalindromeRec("supercalifragilisticexpialidocious"));
		System.out.println(findPalindromeRec("programming"));
	}
}
