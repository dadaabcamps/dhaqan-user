package com.drcdadaab.dhaqanuser;

/**
 * Created by oriaso on 9/25/17.
 */

public class Article {
    String id, title, author, content, category;

    public Article(){

    }

    public Article(String id, String title, String author, String content, String category){

        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.category = category;
    }

    public String getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }

    public String getCategory(){
        return category;
    }

    public String getAuthor(){
        return author;
    }

    public String getContent(){
        return content;
    }
}
