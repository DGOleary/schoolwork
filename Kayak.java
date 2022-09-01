import java.util.*;

public class Kayak {
    //method findLetter
    public static LinkedList<String> makeStrings(char[][] data){
        LinkedList<String> strList= new LinkedList<String>();
        for(char[] x: data){
            strList.add(String.valueOf(x));
        }
        //counter for the loop to create diagonal strings
        int count=0,count2=0;
        //temporary strings for each direction
        String str1="",str2="";
        for(int i=0;i<data[0].length;i++){
            for(int j=i;j<data[0].length;j++){
                count++;
                if(count<=data.length){
                    str1+=""+data[j][count];
                }
            }
        }
        return strList;
    }

    public static boolean containsKayak(char[][] data){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                if(j+1<=data[i].length){

                }
            }
        }
    }
}
