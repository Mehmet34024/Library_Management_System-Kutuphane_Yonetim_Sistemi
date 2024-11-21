import java.util.ArrayList;

class Kitaplik {
    private ArrayList<Kitap> kitapListesi = new ArrayList<>();

    // Kitap ekleme
    public void kitapEkle(Kitap kitap) {
        kitapListesi.add(kitap);
    }

    // Kitap silme
    public boolean kitapSil(String isbn) {
        for (Kitap kitap : kitapListesi) {
            if (kitap.getIsbn().equals(isbn)) {
                kitapListesi.remove(kitap);
                return true;
            }
        }
        return false;
    }

    // Kitap ödünç alma
    public boolean kitapOduncAl(String isbn) {
        for (Kitap kitap : kitapListesi) {
            if (kitap.getIsbn().equals(isbn) && !kitap.isOduncDurumu()) {
                kitap.setOduncDurumu(true);
                return true;
            }
        }
        return false;
    }

    // Kitap iade etme
    public boolean kitapIadeEt(String isbn) {
        for (Kitap kitap : kitapListesi) {
            if (kitap.getIsbn().equals(isbn) && kitap.isOduncDurumu()) {
                kitap.setOduncDurumu(false);
                return true;
            }
        }
        return false;
    }

    // Kitap arama
    public Kitap kitapAra(String isbn) {
        for (Kitap kitap : kitapListesi) {
            if (kitap.getIsbn().equals(isbn)) {
                return kitap;
            }
        }
        return null;
    }

    // Kitapları listeleme
    public void kitapListesiGoster() {
        if (kitapListesi.isEmpty()) {
            System.out.println("Kütüphanede kitap bulunmamaktadır.");
        } else {
            System.out.println("\nKitap Listesi:");
            for (Kitap kitap : kitapListesi) {
                System.out.println("Başlık: " + kitap.getBaslik() + ", Yazar: " + kitap.getYazar() + ", ISBN: " + kitap.getIsbn());
            }
        }
    }

    // Mevcut kitap durumu
    public void mevcutKitapDurumu(String isbn) {
        Kitap kitap = kitapAra(isbn);
        if (kitap != null) {
            if (kitap.isOduncDurumu()) {
                System.out.println("Kitap ödünç alınmış.");
            } else {
                System.out.println("Kitap kütüphanede mevcut.");
            }
        } else {
            System.out.println("Kitap bulunamadı.");
        }
    }
}
