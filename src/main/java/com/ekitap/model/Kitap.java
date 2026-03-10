package com.ekitap.model;

public class Kitap {
    private int kitapId;
    private String kitapAdi;
    private Kategori kategori;    
    private Yazar yazar;
    private Yayinevi yayinevi;
    private int sayfaSayisi;
    private String aciklama;
    private int stokAdedi;
    private double kitapFiyati;
    private String kitapResim;

    // Getter ve Setterlar

    public int getKitapId() { return kitapId; }
    public void setKitapId(int kitapId) { this.kitapId = kitapId; }

    public String getKitapAdi() { return kitapAdi; }
    public void setKitapAdi(String kitapAdi) { this.kitapAdi = kitapAdi; }

    public Kategori getKategori() { return kategori; }
    public void setKategori(Kategori kategori) { this.kategori = kategori; }

    public Yazar getYazar() { return yazar; }
    public void setYazar(Yazar yazar) { this.yazar = yazar; }

    public Yayinevi getYayinevi() { return yayinevi; }
    public void setYayinevi(Yayinevi yayinevi) { this.yayinevi = yayinevi; }

    public int getSayfaSayisi() { return sayfaSayisi; }
    public void setSayfaSayisi(int sayfaSayisi) { this.sayfaSayisi = sayfaSayisi; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = aciklama; }

    public int getStokAdedi() { return stokAdedi; }
    public void setStokAdedi(int stokAdedi) { this.stokAdedi = stokAdedi; }

    public double getKitapFiyati() { return kitapFiyati; }
    public void setKitapFiyati(double kitapFiyati) { this.kitapFiyati = kitapFiyati; }

    public String getKitapResim() { return kitapResim; }
    public void setKitapResim(String kitapResim) { this.kitapResim = kitapResim; }
}
