package com.macross.entry;

public class clothing {
    private int id;
    private String name;
    private String url;
    private String img;
    private String effect;
    private String effect_C;
    private int singer;
    private int episode;

    public clothing() {
    }

    public clothing(int id, String name, String url, String img, String effect, String effect_C, int singer, int episode) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.img = img;
        this.effect = effect;
        this.effect_C = effect_C;
        this.singer = singer;
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

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getEffect_C() {
        return effect_C;
    }

    public void setEffect_C(String effect_C) {
        this.effect_C = effect_C;
    }

    public int getSinger() {
        return singer;
    }

    public void setSinger(int singer) {
        this.singer = singer;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "clothing{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", effect='" + effect + '\'' +
                ", effect_C='" + effect_C + '\'' +
                ", singer=" + singer +
                ", episode=" + episode +
                '}';
    }
}
