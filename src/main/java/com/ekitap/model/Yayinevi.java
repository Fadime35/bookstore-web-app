package com.ekitap.model;

public class Yayinevi {
    private int yayineviId;
    private String yayineviAdi;
    private String yayineviAdresi;  // BU SATIRI EKLE

    public int getYayineviId() {
        return yayineviId;
    }
    public void setYayineviId(int yayineviId) {
        this.yayineviId = yayineviId;
    }

    public String getYayineviAdi() {
        return yayineviAdi;
    }
    public void setYayineviAdi(String yayineviAdi) {
        this.yayineviAdi = yayineviAdi;
    }

    public String getYayineviAdresi() {  // BU SATIRI EKLE
        return yayineviAdresi;
    }
    public void setYayineviAdresi(String yayineviAdresi) {  // BU SATIRI EKLE
        this.yayineviAdresi = yayineviAdresi;
    }
}


