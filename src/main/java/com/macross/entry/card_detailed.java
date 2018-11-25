package com.macross.entry;

public class card_detailed {
    private int id;
    private int state;
    private String img;
    private int total;
    private int soul;
    private int voice;
    private int charm;
    private int life;
    private int support;
    private int fold_wave;
    private int luck;

    public card_detailed() {
    }

    public card_detailed(int id, int state, String img, int total, int soul, int voice, int charm, int life, int support, int fold_wave, int luck) {
        this.id = id;
        this.state = state;
        this.img = img;
        this.total = total;
        this.soul = soul;
        this.voice = voice;
        this.charm = charm;
        this.life = life;
        this.support = support;
        this.fold_wave = fold_wave;
        this.luck = luck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSoul() {
        return soul;
    }

    public void setSoul(int soul) {
        this.soul = soul;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        this.charm = charm;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public int getFold_wave() {
        return fold_wave;
    }

    public void setFold_wave(int fold_wave) {
        this.fold_wave = fold_wave;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    @Override
    public String toString() {
        return "card_detailed{" +
                "id=" + id +
                ", state=" + state +
                ", img='" + img + '\'' +
                ", total=" + total +
                ", soul=" + soul +
                ", voice=" + voice +
                ", charm=" + charm +
                ", life=" + life +
                ", support=" + support +
                ", fold_wave=" + fold_wave +
                ", luck=" + luck +
                '}';
    }
}
