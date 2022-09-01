import java.util.HashMap;
import java.util.HashSet;

public class Kayak {
    // Method to find the word "kayak" in a word search

    // This method is for processing the data into hashmaps to make finding matches
    // more simple
    public HashMap<String, int[]> mapChars(char[][] data) {
        HashMap<String, int[]> charMap = new HashMap<String, int[]>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int[] tempArr={i,j};
                charMap.put(data[i][j]+"",tempArr);
            }
        }
        System.out.println("Complete charmap");
        return charMap;
    }

    //public static boolean containsKayak(char[][] data){
        /* 
        int dir=-1;
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data[i].length;j++){
                if(data[i][j]=='K'){
                    if(i>0){
                        if()
                    }
                }
            }
        }
        */
    //}
 
    public static void main(String[] args) {
        char[][] testhorz = {{'A', 'K', 'A', 'Y', 'Y', 'Y', 'A', 'K', 'K', 'K'},
        {'K', 'K', 'K', 'Y', 'K', 'A', 'A', 'A', 'K', 'Y'},
        {'K', 'A', 'K', 'K', 'A', 'A', 'K', 'Y', 'Y', 'Y'},
        {'Y', 'K', 'Y', 'Y', 'A', 'A', 'K', 'K', 'Y', 'A'},
        {'Y', 'K', 'K', 'K', 'K', 'Y', 'A', 'A', 'K', 'A'},
        {'A', 'Y', 'Y', 'Y', 'K', 'A', 'A', 'Y', 'Y', 'K'},
        {'Y', 'Y', 'A', 'A', 'A', 'A', 'Y', 'Y', 'A', 'K'},
        {'A', 'A', 'K', 'Y', 'A', 'A', 'Y', 'Y', 'Y', 'Y'},
        {'Y', 'Y', 'K', 'A', 'K', 'K', 'K', 'Y', 'Y', 'A'},
        {'A', 'A', 'K', 'K', 'K', 'A', 'Y', 'A', 'K', 'K'}};
        Kayak kayak=new Kayak();
        HashMap<String, int[]> charMap=kayak.mapChars(testhorz);
        for(String x:charMap.keySet()){
            System.out.println(x.toString()+ " "+ charMap.get(x));
        }
    }
}
