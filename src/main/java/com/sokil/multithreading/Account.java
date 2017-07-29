package com.sokil.multithreading;

import java.util.concurrent.locks.Lock;

public class Account {
    private long number;
    private String pin;
    private long balance;
    private Lock lock;

    public Account(long number, String pin, long balance, Lock lock) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
        this.lock = lock;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public long getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
