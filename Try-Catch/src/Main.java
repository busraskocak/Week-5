import java.util.Scanner;

public class Main {
    public static int getArray(int []array, int index){
        return array[index];
    }

    public static void main(String[] args) {
        // Kullanıcıdan index girişi alma
        Scanner input = new Scanner(System.in);
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("İndex girin : ");
        int index = input.nextInt();

        try {
            // Metodu çağırarak index elemanı alma
            int result = getArray(array,index);
            System.out.println("İndex eleman " + result);
        }catch (ArrayIndexOutOfBoundsException e){ // Hata durumunda alınacak çıktı
            System.out.println("Hata : Dizi boyutunu aşan bir index girdiniz");

        }
    }
}