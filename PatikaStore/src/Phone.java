import java.util.ArrayList;
import java.util.Scanner;

public class Phone extends Product implements Operation {
    Scanner scanner = new Scanner(System.in);
    private static int id = 1;
    private int camera;
    private int batteryCapacity;
    private String color;
    boolean isMenuRunning = true;


    private static ArrayList<Phone> phoneList = new ArrayList<>();

    public Phone(int id, String name, double price, double discountRate, int stock, String brandName, String screenSize, int ram, String memory, int camera, int batteryCapacity, String color) {
        super(id, name, price, discountRate, stock, brandName, screenSize, ram, memory);
        this.camera = camera;
        this.batteryCapacity = batteryCapacity;
        this.color = color;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Phone() {
    }


    @Override
    public void runMenu() {
        while (isMenuRunning) {
            System.out.println("Patika Store Yönetim Paneli");
            System.out.println("1 - Telefon Ekleme\n" +
                    "2 - Telefon Silme \n" +
                    "3 - İd'ye göre filtreleme \n" +
                    "4 - Markaya göre filtreleme \n" +
                    "5 - Telefon listeleme \n" +
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
                    System.out.println("Çıkış yapıldı.");
                    isMenuRunning = false;
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız.");
            }

        }


    }


    @Override
    public void showProductList() {
        if (phoneList.isEmpty()) {
            System.out.println("Telefon listesi boş.");
        } else {
            System.out.println("Telefon Listesi:");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                    "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok", "Marka", "Ekran", "RAM", "Depolama", "Kamera", "Pil Kapasitesi", "Renk");
            System.out.println("----------------------------------------------------------------------------------------------------");

            for (Phone phone : phoneList) {
                System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                        phone.getId(), phone.getName(), phone.getPrice(), phone.getDiscountRate(),
                        phone.getStock(), phone.getBrandName(), phone.getScreenSize(),
                        phone.getRam(), phone.getMemory(), phone.getCamera(), phone.getBatteryCapacity(), phone.getColor());
            }
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void addProduct() {
        System.out.println("Ürün adını giriniz : ");
        String name = scanner.nextLine();
        System.out.println("Ürünün fiyatını giriniz : ");
        int price = scanner.nextInt();
        System.out.println("Ürünün indirim oranını giriniz : ");
        double discount = scanner.nextDouble();
        System.out.println("Ürünün stok miktarını giriniz : ");
        int stock = scanner.nextInt();
        System.out.println("Ürünün markasını giriniz : ");
        String brand = scanner.nextLine();
        System.out.println("Ürünün hafıza bilgisini giriniz : ");
        String memory = scanner.nextLine();
        System.out.println("Ürünün ekran boyutunu giriniz :");
        String screenSize = scanner.nextLine();
        System.out.println("Ürünün pil gücünü giriniz :");
        int battery = scanner.nextInt();
        System.out.println("Ürünün ram bilgisini giriniz");
        int ram = scanner.nextInt();
        System.out.println("Ürünün kamera bilgisini giriniz :");
        int camera = scanner.nextInt();
        System.out.println("Ürünün rengini giriniz");
        String color = scanner.nextLine();
        Phone phone = new Phone(id, name, price, discount, stock, brand, screenSize, ram, memory, camera, battery, color);
        phoneList.add(phone);
        System.out.println("Telefon başarılı bir şekilde eklendi");

    }

    @Override
    public void deleteProduct() {
        System.out.println("Silmek istediğiniz ürünün ID numarasını giriniz : ");
        int deleteIdPhone = scanner.nextInt();

        Phone phoneToDelete = findPhoneById(deleteIdPhone);
        if (phoneToDelete != null) {
            phoneList.remove(phoneToDelete);
            System.out.println("Telefon başarıyla silindi.");
        } else {
            System.out.println("Belirtilen ID'ye sahip telefon bulunamadı.");
        }
    }

    private Phone findPhoneById(int id) {
        for (Phone phone : phoneList) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }


    @Override
    public void filterByProductId() {
        System.out.println("Filtrelemek istediğiniz ürünün ID numarasını giriniz : ");
        int filterIdPhone = scanner.nextInt();

        Phone filteredPhone = findPhoneById(filterIdPhone);
        if (filteredPhone != null) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                    "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok", "Marka", "Ekran", "RAM", "Depolama", "Kamera", "Pil Kapasitesi", "Renk");
            System.out.println("----------------------------------------------------------------------------------------------------");

            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                    filteredPhone.getId(), filteredPhone.getName(), filteredPhone.getPrice(), filteredPhone.getDiscountRate(),
                    filteredPhone.getStock(), filteredPhone.getBrandName(), filteredPhone.getScreenSize(),
                    filteredPhone.getRam(), filteredPhone.getMemory(), filteredPhone.getCamera(), filteredPhone.getBatteryCapacity(), filteredPhone.getColor());
        } else {
            System.out.println("Belirtilen ID'ye sahip telefon bulunamadı.");
        }

    }

    @Override
    public void filterByProductBrand() {
        if (!phoneList.isEmpty()) {
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                    "ID", "Ürün Adı", "Fiyat", "İndirim", "Stok", "Marka", "Ekran", "RAM", "Depolama", "Kamera", "Pil Kapasitesi", "Renk");
            System.out.println("----------------------------------------------------------------------------------------------------");

            for (Phone phone : phoneList) {
                System.out.printf("| %-3s | %-30s | %-9s | %-9s | %-7s | %-9s | %-9s | %-6s | %-9s | %-9s | %-9s |\n",
                        phone.getId(), phone.getName(), phone.getPrice(), phone.getDiscountRate(),
                        phone.getStock(), phone.getBrandName(), phone.getScreenSize(),
                        phone.getRam(), phone.getMemory(), phone.getCamera(), phone.getBatteryCapacity(), phone.getColor());
            }
        } else {
            System.out.println("Belirtilen markaya sahip telefon bulunamadı.");
        }
    }

}
