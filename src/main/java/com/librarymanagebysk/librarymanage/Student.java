package com.librarymanagebysk.librarymanage;

public class Student {
    private String name;
    private String id;
    private boolean bookTaken;
    private int quantity;
    private int fees;

    public Student(String name, String id, boolean bookTaken, int quantity, int fees) {
        this.name = name;
        this.id = id;
        this.bookTaken = bookTaken;
        this.quantity = quantity;
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isBookTaken() {
        return bookTaken;
    }

    public void setBookTaken(boolean bookTaken) {
        this.bookTaken = bookTaken;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", bookTaken=" + bookTaken +
                ", quantity=" + quantity +
                ", fees=" + fees +
                '}';
    }
}
