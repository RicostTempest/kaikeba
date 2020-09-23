package com.windsoft.demo8.orm;

import java.util.Objects;

@TableAnnotation("test_Book")
public class Book {
    @ColumnAnnotation(column = "id",type = "int",length = "11")
    private int id;
    @ColumnAnnotation(column = "name",type = "varchar",length = "50")
    private String name;
    @ColumnAnnotation(column = "info",type = "varchar",length = "1000")
    private String info;

    public Book() {
    }

    public Book(int id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(name, book.name) &&
                Objects.equals(info, book.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, info);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
