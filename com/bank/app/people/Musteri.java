package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

import java.util.ArrayList;
import java.util.Random;

/**
 * Musteri sinifi - Kisi sinifindan miras alir.
 * Bankanin musterilerini temsil eder.
 * Her musterinin bir musteri numarasi, hesaplari ve kredi kartlari vardir.
 */
public class Musteri extends Kisi {

    // Musterinin benzersiz numarasi (otomatik uretilir)
    private String musteriNumarasi;
    // Musterinin sahip oldugu banka hesaplari
    private ArrayList<BankaHesabi> hesaplar;
    // Musterinin sahip oldugu kredi kartlari
    private ArrayList<KrediKarti> krediKartlari;

    /**
     * Musteri constructor'i
     * musteriNumarasi otomatik olarak random number generator ile uretilir
     * @param ad Musterinin adi
     * @param soyad Musterinin soyadi
     * @param email Musterinin email adresi
     * @param telefonNumarasi Musterinin telefon numarasi
     */
    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        // Ust sinif (Kisi) constructor'ini cagir
        super(ad, soyad, email, telefonNumarasi);
        // Musteri numarasini random olarak uret (M + 8 haneli sayi)
        Random random = new Random();
        this.musteriNumarasi = "M" + (10000000 + random.nextInt(90000000));
        // Hesaplar ve kredi kartlari listelerini baslat
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    // --- Getter ve Setter Metotlari ---

    public String getMusteriNumarasi() {
        return musteriNumarasi;
    }

    public void setMusteriNumarasi(String musteriNumarasi) {
        this.musteriNumarasi = musteriNumarasi;
    }

    public ArrayList<BankaHesabi> getHesaplar() {
        return hesaplar;
    }

    public void setHesaplar(ArrayList<BankaHesabi> hesaplar) {
        this.hesaplar = hesaplar;
    }

    public ArrayList<KrediKarti> getKrediKartlari() {
        return krediKartlari;
    }

    public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) {
        this.krediKartlari = krediKartlari;
    }

    /**
     * Musteriye yeni bir banka hesabi ekler
     * Hesap turu parametresine gore VadesizHesap veya YatirimHesabi olusturur
     * @param hesapTuru Acilacak hesap turu ("Vadesiz" veya "Yatirim")
     */
    public void hesapEkle(String hesapTuru) {
        if (hesapTuru.equalsIgnoreCase("Vadesiz")) {
            // Vadesiz hesap olustur ve listeye ekle
            VadesizHesap yeniHesap = new VadesizHesap(0);
            hesaplar.add(yeniHesap);
            System.out.println("Vadesiz hesap basariyla olusturuldu. IBAN: " + yeniHesap.getIban());
        } else if (hesapTuru.equalsIgnoreCase("Yatirim")) {
            // Yatirim hesabi olustur ve listeye ekle
            YatirimHesabi yeniHesap = new YatirimHesabi(0);
            hesaplar.add(yeniHesap);
            System.out.println("Yatirim hesabi basariyla olusturuldu. IBAN: " + yeniHesap.getIban());
        } else {
            System.out.println("Gecersiz hesap turu! Lutfen 'Vadesiz' veya 'Yatirim' giriniz.");
        }
    }

    /**
     * Musteriye yeni bir kredi karti tanimlar
     * @param limit Kredi kartinin limiti
     */
    public void krediKartiEkle(double limit) {
        // Yeni kredi karti olustur (baslangic borcu 0)
        KrediKarti yeniKart = new KrediKarti(limit, 0);
        krediKartlari.add(yeniKart);
        System.out.println("Kredi karti basariyla tanimlandi. Kart No: " + yeniKart.getKartNumarasi() + ", Limit: " + String.format("%.2f", limit) + " TL");
    }

    /**
     * Musterinin bir banka hesabini siler
     * Oncelikle hesabin bakiyesini kontrol eder
     * Bakiye 0'dan buyukse uyari verir, 0'a esitse hesabi siler
     * @param hesap Silinecek banka hesabi
     */
    public void hesapSil(BankaHesabi hesap) {
        if (hesap.getBakiye() > 0) {
            // Bakiye varsa uyari ver
            System.out.println("Lutfen oncelikle bakiyenizi baska bir hesaba aktariniz. (Mevcut bakiye: " + String.format("%.2f", hesap.getBakiye()) + " TL)");
        } else {
            // Bakiye 0 ise hesabi sil
            hesaplar.remove(hesap);
            System.out.println("Hesap basariyla silindi. IBAN: " + hesap.getIban());
        }
    }

    /**
     * Musterinin bir kredi kartini siler
     * Oncelikle kartin guncel borcunu kontrol eder
     * Borc 0'dan buyukse uyari verir, 0'a esitse karti siler
     * @param kart Silinecek kredi karti
     */
    public void krediKartiSil(KrediKarti kart) {
        if (kart.getGuncelBorc() > 0) {
            // Borc varsa uyari ver
            System.out.println("Lutfen oncelikle borc odemesi yapiniz. (Mevcut borc: " + String.format("%.2f", kart.getGuncelBorc()) + " TL)");
        } else {
            // Borc yoksa karti sil
            krediKartlari.remove(kart);
            System.out.println("Kredi karti basariyla silindi. Kart No: " + kart.getKartNumarasi());
        }
    }

    /**
     * Musteri bilgilerini String olarak dondurur
     * @return Musteri bilgileri
     */
    @Override
    public String toString() {
        return "=== Musteri Bilgileri ===" +
               "\nMusteri No: " + musteriNumarasi +
               "\n" + super.toString() +
               "\nHesap Sayisi: " + hesaplar.size() +
               "\nKredi Karti Sayisi: " + krediKartlari.size();
    }
}
