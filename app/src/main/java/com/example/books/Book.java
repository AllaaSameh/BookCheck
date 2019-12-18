package com.example.books;

public class Book {

    private int id;
    private String Bookname;
    private String Booktype;
    private int NumComment;
    private int read;

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

    public int getNumComment() {
        return NumComment;
    }

    public void setNumComment(int numComment) {
        NumComment = numComment;
    }
}
