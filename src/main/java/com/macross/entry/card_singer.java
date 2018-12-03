package com.macross.entry;

public class card_singer {
    private int id;
    private int card;
    private int singer;

    @Override
    public String toString() {
        return "card_singer{" +
                "id=" + id +
                ", card=" + card +
                ", singer=" + singer +
                '}';
    }

    public card_singer() {
    }

    public card_singer(int id, int card, int singer) {
        this.id = id;
        this.card = card;
        this.singer = singer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getSinger() {
        return singer;
    }

    public void setSinger(int singer) {
        this.singer = singer;
    }
}
