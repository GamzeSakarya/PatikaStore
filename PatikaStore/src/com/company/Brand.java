package com.company;
import java.util.TreeSet;

public class Brand  implements Comparable<Brand>  {
    static TreeSet<Brand> brands = new TreeSet<>();
    private String name;
    private int id;


    public Brand( String name) {

        this.name = name;
    }

    public static Brand getBrand(String name) {
        for (Brand brand : brands) {
            if (brand.getName().equals(name)) {
                return brand;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    @Override
    public int compareTo(Brand o) {
        return this.getName().compareTo(o.getName());
    }

    static {
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Monster"));
        brands.add(new Brand("Samsung"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("Dell"));
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Huawei"));
    }

    public  static void print (){
        for (Brand marka : brands){
            System.out.println(marka.name);
        }
    }




}