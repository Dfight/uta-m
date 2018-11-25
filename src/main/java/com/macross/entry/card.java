package com.macross.entry;

public class card {
    private int id;
    private String name;
    private String url;
    private int star;
    private int episode;
    private int skill_C;
    private int skill_A;
    private int skill_L;
    private int opus;
    private int attr;

    public card() {
    }

    public card(int id, String name, String url, int star, int episode, int skill_C, int skill_A, int skill_L, int opus, int attr) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.star = star;
        this.episode = episode;
        this.skill_C = skill_C;
        this.skill_A = skill_A;
        this.skill_L = skill_L;
        this.opus = opus;
        this.attr = attr;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSkill_C() {
        return skill_C;
    }

    public void setSkill_C(int skill_C) {
        this.skill_C = skill_C;
    }

    public int getSkill_A() {
        return skill_A;
    }

    public void setSkill_A(int skill_A) {
        this.skill_A = skill_A;
    }

    public int getSkill_L() {
        return skill_L;
    }

    public void setSkill_L(int skill_L) {
        this.skill_L = skill_L;
    }

    public int getOpus() {
        return opus;
    }

    public void setOpus(int opus) {
        this.opus = opus;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    @Override
    public String toString() {
        return "card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", star=" + star +
                ", episode=" + episode +
                ", skill_C=" + skill_C +
                ", skill_A=" + skill_A +
                ", skill_L=" + skill_L +
                ", opus=" + opus +
                ", attr=" + attr +
                '}';
    }
}
