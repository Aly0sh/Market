package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DbWorker dbWorker=new DbWorker();
        Scanner in=new Scanner(System.in);
        System.out.println("Команды:\n" +
                "1. Показать все товары\n" +
                "2. Товары магазина по отделам\n" +
                "3. 5 самых дорогих товаров\n" +
                "4. Вещи с 50% скидкой");
        System.out.print("Введите команду: ");
        switch (in.nextInt()){
            case 1:
                dbWorker.selectAllProducts();
                break;
            case 2:
                System.out.println("Отделы: \n" +
                        "1. Овощной отдел\n" +
                        "2. Отдел электроники");
                System.out.print("Выберите отдел: ");
                switch (in.nextInt()){
                    case 1:
                        dbWorker.selectProducts();
                        break;
                    case 2:
                        dbWorker.selectGadgets();
                        break;
                    default:
                        System.out.println("Такого отдела не существует!");
                        break;
                }
                break;
            case 3:
                dbWorker.selectTop5();
                break;
            case 4:
                dbWorker.selectDisc50();
                break;
            default:
                System.out.println("Такой команды не существует!");
        }
    }
}
