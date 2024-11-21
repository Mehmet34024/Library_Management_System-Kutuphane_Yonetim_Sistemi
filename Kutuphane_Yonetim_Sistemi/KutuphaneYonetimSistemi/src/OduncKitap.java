import java.time.LocalDate;

class OduncKitap {
    private Kitap kitap;              // Ödünç alınan kitap
    private LocalDate oduncAlmaTarihi;  // Kitap ödünç alındığında tarih
    private LocalDate iadeTarihi;      // Kitap iade edildiğinde tarih

    // Constructor: OduncKitap nesnesi oluşturulurken kitap ve ödünç alma tarihi belirtilir
    public OduncKitap(Kitap kitap, LocalDate oduncAlmaTarihi) {
        this.kitap = kitap;
        this.oduncAlmaTarihi = oduncAlmaTarihi;
        this.iadeTarihi = null;  // Başlangıçta iade tarihi null (kitap henüz iade edilmedi)
    }

    // Getterlar
    public Kitap getKitap() {
        return kitap;  // Ödünç alınan kitabı döndürür
    }

    public LocalDate getOduncAlmaTarihi() {
        return oduncAlmaTarihi;  // Kitap ödünç alınma tarihini döndürür
    }

    public LocalDate getIadeTarihi() {
        return iadeTarihi;  // Kitap iade edilirse iade tarihini döndürür
    }

    // İade tarihi ayarlamak için setter
    public void setIadeTarihi(LocalDate iadeTarihi) {
        this.iadeTarihi = iadeTarihi;  // Kitap iade edildiğinde tarihi ayarlar
    }
}
