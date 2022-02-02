package com.librarymanagebysk.librarymanage.Database;

public class IssueBook {
    private String id;
    private String BookId1;
    private String BookId2;
    private String BookId3;

    public IssueBook(String id, String bookId1, String bookId2, String bookId3) {
        this.id = id;
        BookId1 = bookId1;
        BookId2 = bookId2;
        BookId3 = bookId3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookId1() {
        return BookId1;
    }

    public void setBookId1(String bookId1) {
        BookId1 = bookId1;
    }

    public String getBookId2() {
        return BookId2;
    }

    public void setBookId2(String bookId2) {
        BookId2 = bookId2;
    }

    public String getBookId3() {
        return BookId3;
    }

    public void setBookId3(String bookId3) {
        BookId3 = bookId3;
    }

    @Override
    public String toString() {
        return "IssueBook{" +
                "id='" + id + '\'' +
                ", BookId1='" + BookId1 + '\'' +
                ", BookId2='" + BookId2 + '\'' +
                ", BookId3='" + BookId3 + '\'' +
                '}';
    }
}
