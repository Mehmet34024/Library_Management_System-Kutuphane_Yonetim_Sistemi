import java.time.LocalDate;
import java.util.ArrayList;

class Uye {
    private String isim;                              // Üyenin ismi
    private int uyeNumarasi;                          // Üyenin numarası
    private ArrayList<OduncKitap> oduncAlinanKitaplar; // Üyenin ödünç aldığı kitaplar listesi

    // Constructor
    public Uye(String isim, int uyeNumarasi) {
        this.isim = isim;
        this.uyeNumarasi = uyeNumarasi;
        this.oduncAlinanKitaplar = new ArrayList<>();
    }

    // Getterlar
    public String getIsim() {
        return isim;
    }

    public int getUyeNumarasi() {
        return uyeNumarasi;
    }

    // Kitap ödünç alma
    public void kitapOduncAl(Kitap kitap) {
        LocalDate oduncAlmaTarihi = LocalDate.now();  // Geçerli tarihi al
        OduncKitap oduncKitap = new OduncKitap(kitap, oduncAlmaTarihi);  // Güncel tarihi geçerek OduncKitap nesnesini oluştur
        oduncAlinanKitaplar.add(oduncKitap);  // Kitap listesine ekle
    }

    // Kitap iade etme
    public void kitapIadeEt(String isbn, LocalDate iadeTarihi) {
        for (OduncKitap oduncKitap : oduncAlinanKitaplar) {
            if (oduncKitap.getKitap().getIsbn().equals(isbn)) {
                oduncKitap.setIadeTarihi(iadeTarihi);  // İade tarihi güncelleniyor
                System.out.println("Kitap '" + oduncKitap.getKitap().getBaslik() + "' iade edildi.");
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }

    // Ödünç geçmişini gösterme
    public void oduncGeçmisiGoster() {
        if (oduncAlinanKitaplar.isEmpty()) {
            System.out.println(isim + " adlı üyenin ödünç geçmişi bulunmamaktadır.");
        } else {
            System.out.println(isim + " adlı üyenin ödünç aldığı kitaplar:");
            for (OduncKitap oduncKitap : oduncAlinanKitaplar) {
                System.out.println("Başlık: " + oduncKitap.getKitap().getBaslik() +
                        ", Yazar: " + oduncKitap.getKitap().getYazar() +
                        ", Ödünç Alınma Tarihi: " + oduncKitap.getOduncAlmaTarihi() +
                        ", İade Tarihi: " + (oduncKitap.getIadeTarihi() != null ? oduncKitap.getIadeTarihi() : "Henüz iade edilmedi"));
            }
        }
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public boolean oduncKitapSil(String iadeIsbn) {
        return false;
    }
}
