package com.example.demo.Comment;

public class Comment {
    private String id;
    private String content;
    private String author;
    // 省略构造方法和getter/setter方法




    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAuthor() {
        return author;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getContent(){
        return content;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
