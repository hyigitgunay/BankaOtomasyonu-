package com.bank.app.service;

import com.bank.app.people.Musteri;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import java.util.ArrayList;

/**
 * BankaService sinifi - Is mantigi katmani.
 * Tum banka operasyonlarini merkezi olarak yonetir.
 */
public class BankaService {
    private ArrayList<Musteri> musteriler;
    private ArrayList<BankaPersoneli> personeller;

    public BankaService() {
        this.musteriler = new ArrayList<>();
        this.personeller = new ArrayList<>();
    }

    public ArrayList<Musteri> getMusteriler() { return musteriler; }
    public ArrayList<BankaPersoneli> getPersoneller() { return personeller; }

    /** Yeni musteri olusturur */
    public Musteri musteriOlustur(String ad, String soyad, String email, int tel) {
        Musteri m = new Musteri(ad, soyad, email, tel);
        musteriler.add(m);
        System.out.println("\n--- Yeni Musteri Olusturuldu ---");
        System.out.println(m);
        return m;
    }

    /** Yeni personel olusturur */
    public BankaPersoneli personelOlustur(String ad, String soyad, String email, int tel) {
        BankaPersoneli p = new BankaPersoneli(ad, soyad, email, tel);
        personeller.add(p);
        System.out.println("\n--- Yeni Personel Olusturuldu ---");
        System.out.println(p);
        return p;
    }

    /** Musteri adina hesap acar */
    public void hesapAc(Musteri musteri, String hesapTuru) {
        System.out.println("\n--- Hesap Acma Islemi ---");
        musteri.hesapEkle(hesapTuru);
    }

    /** Musteriye kredi karti tanimlar */
    public void krediKartiTanimla(Musteri musteri, double limit) {
        System.out.println("\n--- Kredi Karti Tanimlama ---");
        musteri.krediKartiEkle(limit);
    }

    /** Hesaba para yatirir */
    public void paraYatir(BankaHesabi hesap, double miktar) {
        System.out.println("\n--- Para Yatirma Islemi ---");
        if (hesap instanceof YatirimHesabi) {
            ((YatirimHesabi) hesap).paraEkle(miktar);
        } else {
            hesap.setBakiye(hesap.getBakiye() + miktar);
            System.out.println("Hesaba " + String.format("%.2f", miktar) + " TL yatirildi.");
            System.out.println("Yeni bakiye: " + String.format("%.2f", hesap.getBakiye()) + " TL");
        }
    }

    /** Para transferi yapar */
    public void paraTransferiYap(VadesizHesap vh, BankaHesabi alici, BankaHesabi gonderen, double miktar) {
        System.out.println("\n--- Para Transferi ---");
        vh.paraTransferi(alici, gonderen, miktar);
    }

    /** Kredi karti borcu oder */
    public void krediKartiBorcOde(VadesizHesap vh, KrediKarti kart, double miktar) {
        System.out.println("\n--- Kredi Karti Borc Odeme ---");
        vh.krediKartiBorcOdeme(kart, miktar);
    }

    /** Hesap siler */
    public void hesapSil(Musteri musteri, BankaHesabi hesap) {
        System.out.println("\n--- Hesap Silme Islemi ---");
        musteri.hesapSil(hesap);
    }

    /** Kredi karti siler */
    public void krediKartiSil(Musteri musteri, KrediKarti kart) {
        System.out.println("\n--- Kredi Karti Silme ---");
        musteri.krediKartiSil(kart);
    }
}
