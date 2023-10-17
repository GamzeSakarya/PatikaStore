package com.company;
import java.util.*;

public class MobilePhone extends Product implements Comparable<MobilePhone> {

    static ArrayList<MobilePhone> mobilePhones = new ArrayList<>();
    private String color;
    private static int count = 100;


    public MobilePhone(double price, double discountRate, int amountOfStock, int storage, double screenSize, int RAM, String color, String name, Brand brand) {
        super(count, price, discountRate, amountOfStock, storage, screenSize, RAM, name, brand);
        this.color = color;
        plusOneCount();
    }

    private void plusOneCount() {
        count = count + 1;
    }

    @Override
    public int compareTo(MobilePhone o) {
        return this.getBrand().getName().compareTo(o.getBrand().getName());
    }

    static {
        mobilePhones.add(new MobilePhone(3998.75, 20, 200, 128, 6.5, 6, "Siyah", "Samsung GALAXY A51", new Brand("Samsung")));
        mobilePhones.add(new MobilePhone(8198.8, 10, 200, 64, 6.1, 6, "Beyaz", "Apple Iphone 11", new Brand("Apple")));
        mobilePhones.add(new MobilePhone(4720.0, 15, 200, 128, 6.5, 12, "Mavi", "Redmi Note 10 Pro ", new Brand("Xiamoi")));
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static void printPhone() {
        Collections.sort(mobilePhones);
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM |  Renk   |%n");
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        for (MobilePhone tlf : mobilePhones) {
            System.out.format("| %-3d | %-28s | %-10.2f | %-9s | %-8d | %-5.1f | %-3d |  %-6s |%n",
                    tlf.getId(), tlf.getName(), Math.ceil(tlf.getPrice() * (100 - tlf.getDiscountRate()) / 100), tlf.getBrand().getName(),
                    tlf.getStorage(), tlf.getScreenSize(), tlf.getRAM(), tlf.getColor());

        }

        System.out.format("--------------------------------------------------------------------------------------------------%n");
    }

    public static void printPhoneByID() {
        TreeSet<MobilePhone> mobilePhonesByID = new TreeSet<>(new SortedMobilePhoneByID());
        mobilePhonesByID.addAll(mobilePhones);
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM |  Renk   |%n");
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        for (MobilePhone tlf : mobilePhonesByID) {
            System.out.format("| %-3d | %-28s | %-10.2f | %-9s | %-8d | %-5.1f | %-3d |  %-6s |%n",
                    tlf.getId(), tlf.getName(), Math.ceil(tlf.getPrice() * (100 - tlf.getDiscountRate()) / 100), tlf.getBrand().getName(),
                    tlf.getStorage(), tlf.getScreenSize(), tlf.getRAM(), tlf.getColor());
        }

        System.out.format("--------------------------------------------------------------------------------------------------%n");

    }

    public static void addPhone() {
        Scanner input = new Scanner(System.in);
        System.out.println("İstediğiniz ürünün özelliklerini giriniz :");
        System.out.print("Fiyatı: ");
        double priceChoice = input.nextDouble();
        System.out.print("İndirim oranı: ");
        double discountRateChoice = input.nextDouble();
        System.out.print("Stoğu: ");
        int amountChoice = input.nextInt();
        System.out.print("Hafızası: ");
        int storageChoice = input.nextInt();
        System.out.print("Ekran boyutu: ");
        double screenSizeChoice = input.nextDouble();
        System.out.print("RAM'i: ");
        int RAMChoice = input.nextInt();
        input.nextLine();
        System.out.print("İsmi: ");
        String nameChoice = input.nextLine();
        System.out.print("Rengi: ");
        String colorChoice = input.nextLine();


        int counter = 1;
        for (Brand brand : Brand.brands) {
            System.out.println(counter++ + " - " + brand.getName());
        }
        System.out.println("Marka ID' sini girin: ");
        int selectID = input.nextInt();
        String selected = null;
        switch (selectID) {
            case 1:
                selected = "Casper";
                break;
            case 2:
                selected = "Xiaomi";
                break;
            case 3:
                selected = "Apple";
                break;
            case 4:
                selected = "Monster";
                break;
            case 5:
                selected = "Samsung";
                break;
            case 6:
                selected = "Asus";
                break;
            case 7:
                selected = "Dell";
                break;
            case 8:
                selected = "Lenovo";
                break;
            default:
                selected = "Huawei";
                break;

        }
        mobilePhones.add(new MobilePhone(priceChoice, discountRateChoice, amountChoice, storageChoice, screenSizeChoice, RAMChoice, colorChoice, nameChoice, Brand.getBrand(selected)));
        System.out.println("Ürün eklendi");
        listPhones();

    }

    public static void deletePhone() {
        Scanner input = new Scanner(System.in);
        printPhoneByID();
        System.out.println("Silmek istediğiniz ID: ");

        int delete = input.nextInt();

        Iterator<MobilePhone> iterator = mobilePhones.iterator();
        while (iterator.hasNext()) {
            MobilePhone mobilePhone = iterator.next();
            if (mobilePhone.getId() == delete) {
                iterator.remove();
                System.out.println("Ürün Silindi");
            }
        }
        listPhones();


    }

    public static void listPhones() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ürünün adına göre sıralamak için 1'e , ID'ye göre sıralamak için 2 ye basın: ");
        int list = input.nextInt();
        switch (list) {
            case 1:
                MobilePhone.printPhone();
                break;
            case 2:
                MobilePhone.printPhoneByID();
                break;
        }
    }

    public static void filterPhones() {
        Scanner input = new Scanner(System.in);
        System.out.println("Markaya göre filtrelemek için 1'e , ID'ye göre filtrelemek için 2 ye basın: ");
        int filter = input.nextInt();
        switch (filter) {
            case 1:
                MobilePhone.filterByBrand();
                break;
            case 2:
                MobilePhone.filterByID();

        }
    }

    public static void filterByBrand() {
        Scanner input = new Scanner(System.in);
        int counter = 1;
        for (Brand brand : Brand.brands) {
            System.out.println(counter++ + " - " + brand.getName());
        }
        System.out.println("Filtrelemek istediğiniz ürünün ID'sini girin. ");
        int selectID = input.nextInt();
        String filterBrand = null;
        switch (selectID) {
            case 1:
                filterBrand = "Casper";
                break;
            case 2:
                filterBrand = "Xiaomi";
                break;
            case 3:
                filterBrand = "Apple";
                break;
            case 4:
                filterBrand = "Monster";
                break;
            case 5:
                filterBrand = "Samsung";
                break;
            case 6:
                filterBrand = "Asus";
                break;
            case 7:
                filterBrand = "Dell";
                break;
            case 8:
                filterBrand = "Lenovo";
                break;
            default:
                filterBrand = "Huawei";
                break;

        }
        boolean isFound = false;
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM |  Renk   |%n");
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        for (MobilePhone tlf : mobilePhones) {
            if (filterBrand.equals(tlf.getBrand().getName())) {

                System.out.println(tlf.toString());
                isFound = true;
            }
        }
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        if (!isFound) {
            System.out.println("Seçtiğiniz ürün bulunmamaktadır.");
        }


    }

    public static void filterByID(){
        Scanner input = new Scanner(System.in);
        System.out.println("Ürünün ID' sini girin.");
        int IDNo = input.nextInt();
        boolean isFound = false;
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        System.out.format("| ID  | Ürün Adı                     | Fiyat      | Marka     | Depolama | Ekran | RAM |  Renk   |%n");
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        for (MobilePhone tlf : mobilePhones){

            if (IDNo == tlf.getId()){


                System.out.println(tlf.toString());

                isFound = true;

            }
        }
        System.out.format("--------------------------------------------------------------------------------------------------%n");
        if (!isFound){
            System.out.println("Seçtiğiniz ID ' de ürün bulunmamaktadır.");
        }

    }
    @Override
    public String toString() {
        return String.format("| %-3d | %-28s | %-10.2f | %-9s | %-8d | %-5.1f | %-3d |  %-6s |",
                getId(), getName(), Math.ceil(getPrice() * (100 - getDiscountRate()) / 100),
                getBrand().getName(), getStorage(), getScreenSize(), getRAM(), getColor());
    }
}