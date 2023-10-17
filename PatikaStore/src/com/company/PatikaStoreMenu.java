package com.company;

import java.util.Scanner;

public class PatikaStoreMenu {
    public static void menu() {
        Scanner input = new Scanner(System.in);

        int select = PatikaStoreMenu.printMenu();


        while (select != 0) {
            switch (select) {
                case 1:
                    System.out.println("1- Ürünleri Göster.");
                    System.out.println("2- Ürün Ekle.");
                    System.out.println("3- Ürün Sil.");
                    System.out.println("4- Ürün filtrele.");
                    int choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            Notebook.listNoteBooks();
                            break;
                        case 2:
                            Notebook.addNoteBook();
                            break;
                        case 3:
                            Notebook.deleteNotebook();
                            break;
                        case 4:
                            Notebook.filterNoteBooks();
                    }
                    break;
                case 2:
                    System.out.println("1- Ürünleri Göster.");
                    System.out.println("2- Ürün Ekle.");
                    System.out.println("3- Ürün Sil.");
                    System.out.println("4- Ürün filtrele.");
                    int phoneChoice = input.nextInt();
                    switch (phoneChoice) {
                        case 1:
                            MobilePhone.listPhones();
                            break;
                        case 2:
                            MobilePhone.addPhone();
                            break;
                        case 3:
                            MobilePhone.deletePhone();
                            break;
                        case 4:
                            MobilePhone.filterPhones();
                            break;
                    }
                    break;

                case 3:
                    Brand.print();
                    break;

                default:
                    System.out.println("Geçerli bir sayı giriniz!");
                    break;


            }
            select = PatikaStoreMenu.printMenu();


        }
        System.out.println("Güle güle..");


    }

    public static int printMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Patika Store Ürün Yönetimi! ");
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefonu İşlemleri");
        System.out.println("3 - Markaları Listele");
        System.out.println("0 - Çıkış Yap");
        System.out.print("Seçiminiz: ");
        int select = input.nextInt();
        return select;

    }

}