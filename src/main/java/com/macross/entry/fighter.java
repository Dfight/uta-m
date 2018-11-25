package com.macross.entry;

public class fighter {
    private int id;
    private String name;
    private String url;
    private String img;
    private String driver;
    private int attack;
    private int hit;
    private int episode;

    public fighter() {
    }

    public fighter(int id, String name, String url, String img, String driver, int attack, int hit, int episode) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.img = img;
        this.driver = driver;
        this.attack = attack;
        this.hit = hit;
        this.episode = episode;
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

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "fighter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", driver='" + driver + '\'' +
                ", attack=" + attack +
                ", hit=" + hit +
                ", episode=" + episode +
                '}';
    }
}
