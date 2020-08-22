package com.example.musictherapy;

public class CardModel {

    private String url, name, length;

    public CardModel() {
    }

    public CardModel(String url, String name, String length) { //클래스 양식 지정
        this.url = url;
        this.name = name;
        this.length = length;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
