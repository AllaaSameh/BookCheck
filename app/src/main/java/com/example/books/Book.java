package com.example.books;

public class Book {

    private int id;
    private String Bookname;
    private String Booktype;
    private int read;
    private String comment;

    public Book() {
    }

    public Book(int id, String bookname, String booktype, int read, String comment) {
        this.id = id;
        Bookname = bookname;
        Booktype = booktype;
        this.read = read;
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public String getBooktype() {
        return Booktype;
    }

    public void setBooktype(String booktype) {
        Booktype = booktype;
    }

}
