package com.macross.entry;

public class singer {
    private int id;
    private String name;
    private String url;
    private String img1;
    private String img2;
    private int max_level;
    private int opus;

    public singer() {
    }

    public singer(int id, String name, String url, String img1, String img2, int max_level, int opus) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.img1 = img1;
        this.img2 = img2;
        this.max_level = max_level;
        this.opus = opus;
    }

    @Override
    public String toString() {
        return "singer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", max_level=" + max_level +
                ", opus=" + opus +
                '}';
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public int getMax_level() {
        return max_level;
    }

    public void setMax_level(int max_level) {
        this.max_level = max_level;
    }

    public int getOpus() {
        return opus;
    }

    public void setOpus(int opus) {
        this.opus = opus;
    }
}
