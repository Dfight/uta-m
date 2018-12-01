package com.macross.entry;

public class episode {
    private int id;
    private String name;
    private String url;
    private String img;
    private int fighter;
    private int clothing;
    private int opus;
    private String text;

    public episode() {
    }

    public episode(int id, String name, String url, String img, int fighter, int clothing, int opus, String text) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.img = img;
        this.fighter = fighter;
        this.clothing = clothing;
        this.opus = opus;
        this.text = text;
    }

    @Override
    public String toString() {
        return "episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", fighter=" + fighter +
                ", clothing=" + clothing +
                ", opus=" + opus +
                ", text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getFighter() {
        return fighter;
    }

    public void setFighter(int fighter) {
        this.fighter = fighter;
    }

    public int getClothing() {
        return clothing;
    }

    public void setClothing(int clothing) {
        this.clothing = clothing;
    }

    public int getOpus() {
        return opus;
    }

    public void setOpus(int opus) {
        this.opus = opus;
    }
}
