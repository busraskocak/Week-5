import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        System.out.print("Lütfen bir metin giriniz :");
        String text= scan.nextLine();
        //HashMap
        HashMap<String,Integer> hashMap = new HashMap<>();
        //Metni kelimelere ayırıyoruz.
        String[] words = text.split(" ");

        for (String word :words){
            if (hashMap.containsKey(word)){
                hashMap.put(word,hashMap.get(word)+1);

            }else {
                hashMap.put(word,1);
            }
        }
        String mostUsedWord = "";
        int mostUsedNum =0;

        for (String key : hashMap.keySet()){
            int count = hashMap.get(key);
            if (count > mostUsedNum){
                mostUsedNum = count;
                mostUsedWord = key;

            }
        }
        System.out.println("En çok geçen kelime: " + mostUsedWord);
        System.out.println("Bu kelime metinde " + mostUsedNum + " kez geçiyor.");







    }
}