# Banka Otomasyon Sistemi

Bu proje, Bursa Teknik Üniversitesi Bilgisayar Mühendisliği bölümü **BLM0121 Nesneye Yönelik Programlama** dersi proje ödevi kapsamında geliştirilmiş, terminal (konsol) üzerinden çalışan bir bankacılık otomasyon sistemidir.

## 🚀 Özellikler

Proje, Nesne Yönelimli Programlamanın (OOP) temel prensipleri olan **Kalıtım (Inheritance)**, **Kapsülleme (Encapsulation)** ve **Çok Biçimlilik (Polymorphism)** kullanılarak tasarlanmıştır.

*   **Kullanıcı Yönetimi:** Personel ve Müşteri hesaplarının oluşturulması.
*   **Hesap İşlemleri:** Vadesiz Hesap ve Yatırım Hesabı açma, hesaba para yatırma ve çekme.
*   **Para Transferi:** Vadesiz hesaplar arası bakiye kontrollü para transferi işlemleri.
*   **Kredi Kartı İşlemleri:** Kredi kartı tanımlama, limit belirleme ve vadesiz hesaptan kredi kartı borcu ödeme.
*   **Güvenli Silme:** Bakiyesi olan banka hesaplarının veya güncel borcu bulunan kredi kartlarının silinmesini engelleyen kontrol mekanizmaları.
*   **Otomatik ID Üretimi:** `java.util.Random` kullanılarak eşsiz IBAN (24 hane), Personel ID, Müşteri No ve Kart Numarası (16 hane) atamaları.

## 📁 Proje & Paket Yapısı

Proje, modülerliği artırmak ve Clean Code prensiplerine uymak amacıyla **5 farklı paket** altında organize edilmiştir:

*   `com.bank.app.people` : `Kisi` (Ana Sınıf), `BankaPersoneli`, `Musteri`
*   `com.bank.app.accounts` : `BankaHesabi` (Ana Sınıf), `VadesizHesap`, `YatirimHesabi`
*   `com.bank.app.cards` : `KrediKarti`
*   `com.bank.app.service` : `BankaService` (Tüm iş mantığının ve bankacılık operasyonlarının yönetildiği servis katmanı)
*   `com.bank.app.main` : `Main` (Uygulamanın başlangıç noktası ve test senaryolarının bulunduğu sınıf)
