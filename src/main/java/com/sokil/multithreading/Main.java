package com.sokil.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final Product[] PRODUCTS = {
            new Product("Tickles Scholer Teddy", 199),
            new Product("Grey Mother Elephant Stuffed Soft Plush Toy Love Girl 30 cm", 150),
            new Product("Plush Toy Kids Birthday Black Panda 26 cm", 110),
            new Product("Funskool Digger the Dog", 317),
            new Product("Dimpy Stuff Cute Pink and Cream Bear Couple Soft Toy, Pink (9.8-inch)", 290),
            new Product("Amardeep And Co Amardeep Soft Baby Rattle Bunny", 270),
            new Product("Funskool Twirlly Whirlly Turtle", 164),
    };

    private static final int ALL_PRODUCTS_PRICE;

    static {
        long sum = 0;
        for (Product product : PRODUCTS) {
            sum += product.getPrice();
        }
        ALL_PRODUCTS_PRICE = (int) sum;
    }

    private static ReentrantLock buyLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Cart price is " + ALL_PRODUCTS_PRICE);
        System.out.println("TEST PROGRESS: ");
        Account seller = new Account(7000_7857_8767_2143L, "5432", 0, buyLock);
        do {
            seller.setBalance(0);
            Shop shop = new Shop(PRODUCTS, buyLock);

            Account johnAccount = new Account(1234_7857_8767_2143L, "1234", 2000, buyLock);
            Shop.Cart johnCart = shop.new Cart();
            johnCart.add(PRODUCTS);

            Account lucyAccount = new Account(8965_7857_8767_2143L, "1234", 2000, buyLock);
            Shop.Cart lucyCart = shop.new Cart();
            lucyCart.add(PRODUCTS);

            Thread thread1 = new Thread(() ->{
                johnCart.buyAll(seller, johnAccount);
            }
            );
            Thread thread2 = new Thread(() ->{
                lucyCart.buyAll(seller, lucyAccount);
            }
            );

            thread1.start();
            thread2.start();
            thread1.join();

            if (seller.getBalance() != ALL_PRODUCTS_PRICE * 2) {
                System.out.print('.');
                System.err.println(seller.getBalance());
            } else {
                System.out.println("Seller balance is " + seller.getBalance());
                break;
            }
        } while (true);
    }
}
