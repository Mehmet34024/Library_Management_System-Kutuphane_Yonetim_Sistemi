import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Kitaplik kitaplik = new Kitaplik();
    static Uyeler uyeler = new Uyeler();

    public static void main(String[] args) {
        // Başlangıçta birkaç kitap ve üye ekleyelim
        kitaplik.kitapEkle(new Kitap("Savaş ve Barış", "Lev Tolstoy", "24001"));
        kitaplik.kitapEkle(new Kitap("İçimizdeki Şeytan", "Sabahattin Ali", "24002"));
        kitaplik.kitapEkle(new Kitap("Yıldıza Dokunmak", "Sezin Karameşe", "24003"));
        kitaplik.kitapEkle(new Kitap("Rezonans Kanunu", "Pierre Franckh", "24004"));

        uyeler.uyeEkle(new Uye("Mehmet Açıkgöz", 1));
        uyeler.uyeEkle(new Uye("Eda Kayıran", 2));
        uyeler.uyeEkle(new Uye("Ayşe Kırgın", 3));
        uyeler.uyeEkle(new Uye("Sümeyye Mart", 4));

        while (true) {
            System.out.println("Kullanıcı Yönetim Sistemine Hoşgeldiniz");
            System.out.println("1. Üye Yönetimi");
            System.out.println("2. Kitap Yönetimi");
            System.out.println("3. Çıkış");
            System.out.print("Bir seçenek girin: ");
            int secim = scanner.nextInt();
            scanner.nextLine();  // Buffer temizleme

            switch (secim) {
                case 1:
                    uyeYonetimi();
                    break;
                case 2:
                    kitapYonetimi();
                    break;
                case 3:
                    System.out.println("Çıkılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }

    // Üye Yönetimi Menüsü
    public static void uyeYonetimi() {
        while (true) {
            System.out.println("\nÜye Yönetimi");
            System.out.println("1. Üye Ekle");
            System.out.println("2. Üye Silme");
            System.out.println("3. Üye Listele");
            System.out.println("4. Üye Ara");
            System.out.println("5. Üye Bilgilerini Güncelle");
            System.out.println("6. Üye Ödünç Geçmişini Görüntüle");
            System.out.println("7. Geri");
            System.out.print("Bir seçenek girin: ");
            int secim = scanner.nextInt();
            scanner.nextLine();  // Buffer temizleme

            switch (secim) {
                case 1:
                    // Üye Ekleme
                    System.out.print("Üye İsmi: ");
                    String isim = scanner.nextLine();
                    System.out.print("Üye Numarası: ");
                    int uyeNumarasi = scanner.nextInt();
                    uyeler.uyeEkle(new Uye(isim, uyeNumarasi));
                    System.out.println("Üye başarıyla eklendi.");
                    break;
                case 2:
                    // Üye Silme
                    System.out.print("Silmek istediğiniz üye numarasını girin: ");
                    int silinecekNumara = scanner.nextInt();
                    if (uyeler.uyeSil(silinecekNumara)) {
                        System.out.println("Üye başarıyla silindi.");
                    } else {
                        System.out.println("Üye bulunamadı.");
                    }
                    break;
                case 3:
                    uyeler.uyeListele();
                    break;
                case 4:
                    System.out.print("Aramak istediğiniz üye numarasını girin: ");
                    int aramaNumarasi = scanner.nextInt();
                    Uye uye = uyeler.uyeAra(aramaNumarasi);
                    if (uye != null) {
                        System.out.println("Üye bulundu: " + uye.getIsim());
                    } else {
                        System.out.println("Üye bulunamadı.");
                    }
                    break;
                case 5:
                    // Üye bilgilerini güncelleme
                    System.out.print("Güncellemek istediğiniz üye numarasını girin: ");
                    uyeNumarasi = scanner.nextInt();
                    scanner.nextLine();
                    Uye uyeToUpdate = uyeler.uyeAra(uyeNumarasi);
                    if (uyeToUpdate != null) {
                        System.out.print("Yeni isim girin: ");
                        String yeniIsim = scanner.nextLine();
                        uyeToUpdate.setIsim(yeniIsim);
                        System.out.println("Üye ismi başarıyla güncellendi.");
                    } else {
                        System.out.println("Üye bulunamadı.");
                    }
                    break;
                case 6:
                    // Ödünç geçmişi görüntüleme
                    System.out.print("Ödünç geçmişini görmek istediğiniz üye numarasını girin: ");
                    int numara = scanner.nextInt();
                    Uye uye1 = uyeler.uyeAra(numara);
                    if (uye1 != null) {
                        // Ödünç kitaplarının listesini göster
                        uye1.oduncGeçmisiGoster();
                    } else {
                        System.out.println("Üye bulunamadı.");
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Geçersiz seçenek.");
            }
        }
    }

    // Kitap Yönetimi Menüsü
    public static void kitapYonetimi() {
        while (true) {
            System.out.println("\nKitap Yönetimi");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitap Ödünç Al");
            System.out.println("3. Kitap İade Et");
            System.out.println("4. Kitap Arama");
            System.out.println("5. Kitapları Listele");
            System.out.println("6. Kitap Silme");
            System.out.println("7. Mevcut Kitap Kontrolü");
            System.out.println("8. Geri");
            System.out.print("Bir seçenek girin: ");
            int secim = scanner.nextInt();
            scanner.nextLine();  // Buffer temizleme

            switch (secim) {
                case 1:
                    // Kitap Ekle
                    System.out.print("Kitap Başlığı: ");
                    String baslik = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String yazar = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    kitaplik.kitapEkle(new Kitap(baslik, yazar, isbn));
                    System.out.println("Kitap başarıyla eklendi.");
                    break;
                case 2:
                    // Kitap Ödünç Al
                    System.out.print("Üye numaranızı girin: ");
                    int uyeNumarasi = scanner.nextInt();
                    Uye uye = uyeler.uyeAra(uyeNumarasi);
                    if (uye == null) {
                        System.out.println("Üye bulunamadı.");
                        break;
                    }

                    scanner.nextLine();  // Bu boş satırı temizlemek için kullanılmalı
                    System.out.print("Ödünç almak istediğiniz kitabın ISBN'sini girin: ");
                    String oduncIsbn = scanner.nextLine();
                    Kitap kitap = kitaplik.kitapAra(oduncIsbn);
                    if (kitap != null && !kitap.isOduncDurumu()) {
                        if (kitaplik.kitapOduncAl(oduncIsbn)) {
                            uye.kitapOduncAl(kitap);  // Kitap ödünç alındığında üye bilgilerine ekle
                            System.out.println("Kitap ödünç alındı.");
                        } else {
                            System.out.println("Kitap zaten ödünç alınmış.");
                        }
                    } else {
                        System.out.println("Kitap bulunamadı veya zaten ödünç alınmış.");
                    }
                    break;
                case 3:
                    // Kitap İade Et
                    System.out.print("İade etmek istediğiniz kitabın ISBN'sini girin: ");
                    String iadeIsbn = scanner.nextLine();
                    System.out.print("Üye numarasını girin: ");
                    int iadeUyeNumarasi = scanner.nextInt();
                    scanner.nextLine(); // Buffer temizleme

                    Uye iadeUye = uyeler.uyeAra(iadeUyeNumarasi);
                    if (iadeUye != null) {
                        // İade işlemi yaparken bugünkü tarihi gönderiyoruz
                        iadeUye.kitapIadeEt(iadeIsbn, LocalDate.now());  // İade tarihini şu anki tarih olarak ayarlıyoruz
                    } else {
                        System.out.println("Üye bulunamadı.");
                    }
                    break;
                case 4:
                    // Kitap Arama
                    System.out.print("Aramak istediğiniz kitabın ISBN'sini girin: ");
                    String araIsbn = scanner.nextLine();
                    kitap = kitaplik.kitapAra(araIsbn);
                    if (kitap != null) {
                        System.out.println("Kitap bulundu: " + kitap.getBaslik() + " - " + kitap.getYazar() + " - ISBN: " + kitap.getIsbn());
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;
                case 5:
                    // Kitap Listeleme
                    kitaplik.kitapListesiGoster();
                    break;
                case 6:
                    // Kitap Silme
                    System.out.print("Silmek istediğiniz kitabın ISBN'sini girin: ");
                    String silIsbn = scanner.nextLine();
                    if (kitaplik.kitapSil(silIsbn)) {
                        System.out.println("Kitap başarıyla silindi.");
                    } else {
                        System.out.println("Kitap bulunamadı.");
                    }
                    break;
                case 7:
                    // Mevcut Kitap Kontrolü
                    System.out.print("Kitabın ISBN'sini girin: ");
                    String kontrolIsbn = scanner.nextLine();
                    kitaplik.mevcutKitapDurumu(kontrolIsbn);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Geçersiz seçenek.");
            }
        }
    }
}