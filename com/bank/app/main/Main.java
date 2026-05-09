package com.bank.app.main;

import com.bank.app.service.BankaService;
import com.bank.app.people.Musteri;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

/**
 * Main sinifi - Uygulamanin baslangic noktasi.
 * Tum siniflarin ve metotlarin calistigini gosteren
 * ornek senaryo icerir.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("    BANKA OTOMASYON SISTEMI");
        System.out.println("========================================");

        // BankaService nesnesi olustur
        BankaService bankaService = new BankaService();

        // =============================================
        // 1. MUSTERI OLUSTURMA
        // =============================================
        System.out.println("\n*** 1. MUSTERI OLUSTURMA ***");
        Musteri musteri1 = bankaService.musteriOlustur("Ahmet", "Yilmaz", "ahmet@email.com", 551234567);
        Musteri musteri2 = bankaService.musteriOlustur("Ayse", "Demir", "ayse@email.com", 559876543);

        // =============================================
        // 2. PERSONEL OLUSTURMA VE MUSTERI ATAMA
        // =============================================
        System.out.println("\n*** 2. PERSONEL OLUSTURMA ***");
        BankaPersoneli personel1 = bankaService.personelOlustur("Mehmet", "Kaya", "mehmet@banka.com", 554443322);

        // Personele musteri atama
        System.out.println("\n--- Personele Musteri Atama ---");
        personel1.musteriEkle(musteri1);
        personel1.musteriEkle(musteri2);

        // =============================================
        // 3. MUSTERI ADINA HESAP ACMA
        // =============================================
        System.out.println("\n*** 3. HESAP ACMA ***");
        // Musteri 1 icin vadesiz hesap ac
        bankaService.hesapAc(musteri1, "Vadesiz");
        // Musteri 1 icin yatirim hesabi ac
        bankaService.hesapAc(musteri1, "Yatirim");
        // Musteri 2 icin vadesiz hesap ac
        bankaService.hesapAc(musteri2, "Vadesiz");

        // Hesaplari degiskenlere ata (sonraki islemler icin)
        VadesizHesap musteri1Vadesiz = (VadesizHesap) musteri1.getHesaplar().get(0);
        YatirimHesabi musteri1Yatirim = (YatirimHesabi) musteri1.getHesaplar().get(1);
        VadesizHesap musteri2Vadesiz = (VadesizHesap) musteri2.getHesaplar().get(0);

        // =============================================
        // 4. HESABA PARA YATIRMA
        // =============================================
        System.out.println("\n*** 4. HESABA PARA YATIRMA ***");
        bankaService.paraYatir(musteri1Vadesiz, 5000.00);
        bankaService.paraYatir(musteri1Yatirim, 10000.00);
        bankaService.paraYatir(musteri2Vadesiz, 3000.00);

        // =============================================
        // 5. HESAPLAR ARASI PARA TRANSFERI
        // =============================================
        System.out.println("\n*** 5. PARA TRANSFERI ***");
        // Musteri1'in vadesiz hesabindan Musteri2'nin vadesiz hesabina 1500 TL transfer
        bankaService.paraTransferiYap(musteri1Vadesiz, musteri2Vadesiz, musteri1Vadesiz, 1500.00);

        // =============================================
        // 6. KREDI KARTI TANIMLAMA
        // =============================================
        System.out.println("\n*** 6. KREDI KARTI TANIMLAMA ***");
        bankaService.krediKartiTanimla(musteri1, 15000.00);
        bankaService.krediKartiTanimla(musteri2, 10000.00);

        // Kredi kartlarini degiskenlere ata
        KrediKarti musteri1Kart = musteri1.getKrediKartlari().get(0);
        KrediKarti musteri2Kart = musteri2.getKrediKartlari().get(0);

        // Kredi kartina borc yukleme (simulasyon)
        System.out.println("\n--- Kredi Kartina Harcama Simulasyonu ---");
        musteri1Kart.setGuncelBorc(2500.00);
        System.out.println("Musteri 1 kredi karti borcu: " + String.format("%.2f", musteri1Kart.getGuncelBorc()) + " TL");
        System.out.println("Kullanilabilir limit: " + String.format("%.2f", musteri1Kart.getKullanilabilirLimit()) + " TL");

        // =============================================
        // 7. KREDI KARTI BORCU ODEME
        // =============================================
        System.out.println("\n*** 7. KREDI KARTI BORC ODEME ***");
        bankaService.krediKartiBorcOde(musteri1Vadesiz, musteri1Kart, 1000.00);

        // =============================================
        // 8. HESAP SILME (BAKIYE KONTROLU ILE)
        // =============================================
        System.out.println("\n*** 8. HESAP SILME ***");
        // Once bakiyesi olan hesabi silmeye calis (uyari vermeli)
        System.out.println(">> Bakiyesi olan hesabi silmeye calisiyoruz:");
        bankaService.hesapSil(musteri1, musteri1Yatirim);

        // Yatirim hesabindan tum parayi cek
        System.out.println("\n>> Once bakiyeyi sifirliyoruz:");
        musteri1Yatirim.paraCek(musteri1Yatirim.getBakiye());

        // Simdi hesabi sil (bakiye 0, basarili olmali)
        System.out.println("\n>> Bakiye sifirlandi, tekrar silmeye calisiyoruz:");
        bankaService.hesapSil(musteri1, musteri1Yatirim);

        // =============================================
        // 9. KREDI KARTI SILME (BORC KONTROLU ILE)
        // =============================================
        System.out.println("\n*** 9. KREDI KARTI SILME ***");
        // Borcu olan karti silmeye calis (uyari vermeli)
        System.out.println(">> Borcu olan kredi kartini silmeye calisiyoruz:");
        bankaService.krediKartiSil(musteri1, musteri1Kart);

        // =============================================
        // 10. OZET BILGILER
        // =============================================
        System.out.println("\n*** 10. OZET BILGILER ***");
        System.out.println("\n" + musteri1);
        System.out.println("\nMusteri 1 Hesaplari:");
        for (BankaHesabi h : musteri1.getHesaplar()) {
            System.out.println("  " + h);
        }
        System.out.println("Musteri 1 Kredi Kartlari:");
        for (KrediKarti k : musteri1.getKrediKartlari()) {
            System.out.println("  " + k);
        }

        System.out.println("\n" + musteri2);
        System.out.println("\nMusteri 2 Hesaplari:");
        for (BankaHesabi h : musteri2.getHesaplar()) {
            System.out.println("  " + h);
        }

        System.out.println("\n" + personel1);

        System.out.println("\n========================================");
        System.out.println("    PROGRAM SONA ERDI");
        System.out.println("========================================");
    }
}
