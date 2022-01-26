package com.librarymanagebysk.librarymanage;

public class Book {
    private String bookId;
    private String bookName;
    private String writerName;
    private int price;
    private int quantity;

    public Book(String bookId, String bookName, String writerName, int price, int quantity) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.writerName = writerName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", writerName='" + writerName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
