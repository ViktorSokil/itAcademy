package com.sokil.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class Shop {
    private Product[] availableProducts;
    private Lock lock;

    public Shop(Product[] availableProducts, Lock lock) {
        this.availableProducts = availableProducts;
        this.lock = lock;
    }

    public Product[] getAvailableProducts() {
        return availableProducts;
    }

    public void markSold(Product product) {
        // TO BE IMPLEMENTED
    }

    public class Cart {
        private Shop shop;
        private List<Product> products = new ArrayList<>();

        public Cart() {
            this.shop = Shop.this;
        }

        public void add(Product[] newProducts) {
            products.addAll(Arrays.asList(newProducts));
        }

        public long getTotalPrice() {
            long sum = 0;
            for (Product product : products) {
                sum += product.getPrice();
            }
            return sum;
        }

        public void buyAll(Account seller, Account buyer) {
                lock.lock();
                try {
                    if (buyer.getBalance() >= getTotalPrice()) {
                        for (int i = 0; i < products.size(); i++) {
                            Product product = products.get(i);
                            buyer.setBalance(buyer.getBalance() - product.getPrice());
                            seller.setBalance(seller.getBalance() + product.getPrice());
                            shop.markSold(product);
                        }
                        products.clear();
                    }
                } finally {
                    lock.unlock();
                }
        }
    }
}
