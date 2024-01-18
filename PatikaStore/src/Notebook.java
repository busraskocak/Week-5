import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product implements Operation {
    Scanner scanner = new Scanner(System.in);
    boolean isMenuRunning = true;

    private static int id = 1;

    private static ArrayList<Notebook> notebookList = new ArrayList<>();


    public Notebook(String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
    }

    public Notebook() {
    }

    @Override
    public void runMenu() {
        while (isMenuRunning) {
            System.out.println("Notebook Yönetim Paneli");
            System.out.println("1 - Notebook ekleme \n" +
                    "2 - Notebook Silme \n" +
                    "3 - id ye göre filtreleme \n" +
                    "4 - Markaya göre filtreleme \n" +
                    "5 - Notebook listeleme \n" +
                    "0 - Çıkış yap");
            System.out.print("Yapmak istediğiniz işlemi seçiniz : ");

            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    filterByProductId();
                    break;
                case 4:
                    filterByProductBrand();
                    break;
                case 5:
                    showProductList();
                    break;
                case 0:
                    System.out.println("Çıkış Yapıldı");
                    isMenuRunning = false;
                    break;
                default:
                    System.out.println("Hatalı bir değer girdiniz");
            }
        }


    }

    @Override
    public void showProductList() {
        if (notebookList.isEmpty()) {
            System.out.println("Telefon listesi boş.");
        } else {
            System.out.println("Telefon Listesi:");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                    "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok", "Marka", "Ekran", "RAM", "Depolama");
            System.out.println("----------------------------------------------------------------------------------------------------");

            for (Notebook notebook : notebookList) {
                System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getDiscountRate(), notebook.getStock(),
                        notebook.getBrandName(), notebook.getScreenSize(), notebook.getRam(), notebook.getMemory());
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }


    @Override
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Notebook detaylarını giriniz:");
        System.out.println("Ürün Adı: ");
        String name = scanner.next();
        System.out.println("Fiyat: ");
        double price = scanner.nextDouble();
        System.out.println("İndirim Oranı: ");
        double discountRate = scanner.nextDouble();
        System.out.println("Stok: ");
        int stock = scanner.nextInt();
        System.out.println("Marka Adı: ");
        String brandName = scanner.next();
        System.out.println("Ekran boyutu: ");
        String screenSize = scanner.next();
        System.out.println("RAM: ");
        int ram = scanner.nextInt();
        System.out.println("Memory: ");
        String memory = scanner.next();
        Notebook notebook = new Notebook(name, price, discountRate, stock, brandName, screenSize, ram, memory);
        notebookList.add(notebook);
        System.out.println("Notebook başarılı şekilde eklendi.");

    }

    @Override
    public void deleteProduct() {
        System.out.println("Silmek istediğiniz notebook'un ID numarasını giriniz : ");
        int deleteIdNotebook = scanner.nextInt();

        Notebook notebookToDelete = findNotebookById(deleteIdNotebook);
        if (notebookToDelete != null) {
            notebookList.remove(notebookToDelete);
            System.out.println("Notebook başarıyla silindi.");
        } else {
            System.out.println("Belirtilen ID'ye sahip notebook bulunamadı.");
        }
    }

    private Notebook findNotebookById(int id) {
        for (Notebook notebook : notebookList) {
            if (notebook.getId() == id) {
                return notebook;
            }
        }
        return null;

    }

    @Override
    public void filterByProductId() {
        System.out.println("Filtrelemek istediğiniz notebook'un ID numarasını giriniz : ");
        int filterIdNotebook = scanner.nextInt();

        Notebook filteredNotebook = findNotebookById(filterIdNotebook);
        if (filteredNotebook != null) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s |\n",
                    "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok", "Marka", "Ekran", "RAM", "Depolama");
            System.out.println("----------------------------------------------------------------------------------------------------");

            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s |\n",
                    filteredNotebook.getId(), filteredNotebook.getName(), filteredNotebook.getPrice(), filteredNotebook.getDiscountRate(),
                    filteredNotebook.getStock(), filteredNotebook.getBrandName(), filteredNotebook.getScreenSize(),
                    filteredNotebook.getRam(), filteredNotebook.getMemory());
        } else {
            System.out.println("Belirtilen ID'ye sahip notebook bulunamadı.");
        }

    }

    @Override
    public void filterByProductBrand() {
        System.out.println("Filtrelemek istediğiniz markayı giriniz : ");
        String filterBrand = scanner.next();

        ArrayList<Notebook> filteredNotebooks = new ArrayList<>();
        for (Notebook notebook : notebookList) {
            if (notebook.getBrandName().equalsIgnoreCase(filterBrand)) {
                filteredNotebooks.add(notebook);
            }
        }

        if (!filteredNotebooks.isEmpty()) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s |\n",
                    "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok", "Marka", "Ekran", "RAM", "Depolama");
            System.out.println("----------------------------------------------------------------------------------------------------");

            for (Notebook notebook : filteredNotebooks) {
                System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s |\n",
                        notebook.getId(), notebook.getName(), notebook.getPrice(), notebook.getDiscountRate(),
                        notebook.getStock(), notebook.getBrandName(), notebook.getScreenSize(),
                        notebook.getRam(), notebook.getMemory());
            }
        } else {
            System.out.println("Belirtilen markaya sahip notebook bulunamadı.");
        }

    }
}
