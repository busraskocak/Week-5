import java.util.Comparator;
import java.util.Formattable;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
      Book book1 =new Book("Gece Yarısı Kütüphanesi",250,"Matt Haig","2020");
      Book book2 = new Book("Olasılıksız",350,"Adam Fawer","2005");
      Book book3 = new Book("1984",300,"George Orwell","1949");
      Book book4 = new Book("Suç ve Ceza",687,"Dostoyevski","1866");
      Book book5 = new Book("Kürk Mantolu Madonna",160,"Sabahattin Ali","1943");


      TreeSet<Book> nameSorting = new TreeSet<>();
      nameSorting.add(book1);
      nameSorting.add(book2);
      nameSorting.add(book3);
      nameSorting.add(book4);
      nameSorting.add(book5);

        System.out.println("====SORT BY BOOK NAME====");
        for (Book book : nameSorting){
          System.out.println(book);
        }

        Comparator<Book> pageCountComparator =  Comparator.comparingInt(Book::getPageCount);

      Set<Book> pageCountSorting = new TreeSet<>(pageCountComparator);
      pageCountSorting.addAll(nameSorting);

      System.out.println("====SORT BY PAGE COUNT==== ");
      for (Book book : pageCountSorting){
        System.out.println(book);
      }







    }
}