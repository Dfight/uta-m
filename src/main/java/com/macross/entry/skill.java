package com.macross.entry;

public class skill {
    private int id;
    private String pos;
    private String type;
    private String level;
    private String effect;
    private String effect_C;
    private String effect_M;
    private String effect_M_C;

    public skill() {
    }

    public skill(int id, String pos, String type, String level, String effect, String effect_C, String effect_M, String effect_M_C) {
        this.id = id;
        this.pos = pos;
        this.type = type;
        this.level = level;
        this.effect = effect;
        this.effect_C = effect_C;
        this.effect_M = effect_M;
        this.effect_M_C = effect_M_C;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public String getEffect_M() {
        return effect_M;
    }

    public void setEffect_M(String effect_M) {
        this.effect_M = effect_M;
    }

    public String getEffect_M_C() {
        return effect_M_C;
    }

    public void setEffect_M_C(String effect_M_C) {
        this.effect_M_C = effect_M_C;
    }

    @Override
    public String toString() {
        return "skill{" +
                "id=" + id +
                ", pos='" + pos + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", effect='" + effect + '\'' +
                ", effect_C='" + effect_C + '\'' +
                ", effect_M='" + effect_M + '\'' +
                ", effect_M_C='" + effect_M_C + '\'' +
                '}';
    }
}
