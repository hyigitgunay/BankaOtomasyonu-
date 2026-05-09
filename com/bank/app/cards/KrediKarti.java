package com.bank.app.cards;

import java.util.Random;

/**
 * KrediKarti sinifi - Musterilerin kredi kartlarini temsil eder.
 * Her kredi kartinin bir kart numarasi, limiti, guncel borcu ve
 * kullanilabilir limiti vardir.
 */
public class KrediKarti {

    // Kredi kartinin benzersiz numarasi (otomatik uretilir)
    private String kartNumarasi;
    // Kredi kartinin toplam limiti
    private double limit;
    // Kredi kartinin guncel borcu
    private double guncelBorc;
    // Kredi kartinin kullanilabilir (kalan) limiti
    private double kullanilabilirLimit;

    /**
     * KrediKarti constructor'i
     * kartNumarasi otomatik olarak random number generator ile uretilir
     * kullanilabilirLimit = limit - guncelBorc olarak hesaplanir
     * @param limit Kartın toplam limiti
     * @param guncelBorc Kartin baslangic borcu
     */
    public KrediKarti(double limit, double guncelBorc) {
        // Kart numarasini random olarak uret (16 haneli sayi, 4'lu gruplar)
        Random random = new Random();
        StringBuilder kartNo = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            kartNo.append(random.nextInt(10));
        }
        this.kartNumarasi = kartNo.toString();
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        // Kullanilabilir limit = toplam limit - guncel borc
        this.kullanilabilirLimit = limit - guncelBorc;
    }

    // --- Getter ve Setter Metotlari ---

    public String getKartNumarasi() {
        return kartNumarasi;
    }

    public void setKartNumarasi(String kartNumarasi) {
        this.kartNumarasi = kartNumarasi;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getGuncelBorc() {
        return guncelBorc;
    }

    public void setGuncelBorc(double guncelBorc) {
        this.guncelBorc = guncelBorc;
        // Borc degistiginde kullanilabilir limiti guncelle
        this.kullanilabilirLimit = this.limit - guncelBorc;
    }

    public double getKullanilabilirLimit() {
        return kullanilabilirLimit;
    }

    public void setKullanilabilirLimit(double kullanilabilirLimit) {
        this.kullanilabilirLimit = kullanilabilirLimit;
    }

    /**
     * Kredi karti bilgilerini formatlı String olarak dondurur
     * Kart numarasi 4'lu gruplar halinde gosterilir
     * @return Kart bilgileri
     */
    @Override
    public String toString() {
        // Kart numarasini 4'lu gruplar halinde formatla (ornek: 1234-5678-9012-3456)
        String formatliKartNo = kartNumarasi.substring(0, 4) + "-" +
                                kartNumarasi.substring(4, 8) + "-" +
                                kartNumarasi.substring(8, 12) + "-" +
                                kartNumarasi.substring(12, 16);
        return "=== Kredi Karti ===" +
               "\nKart No: " + formatliKartNo +
               "\nLimit: " + String.format("%.2f", limit) + " TL" +
               "\nGuncel Borc: " + String.format("%.2f", guncelBorc) + " TL" +
               "\nKullanilabilir Limit: " + String.format("%.2f", kullanilabilirLimit) + " TL";
    }
}
