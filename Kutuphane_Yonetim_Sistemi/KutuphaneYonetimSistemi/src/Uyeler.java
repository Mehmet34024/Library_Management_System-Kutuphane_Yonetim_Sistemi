import java.util.ArrayList;

class Uyeler {
    private ArrayList<Uye> uyeListesi = new ArrayList<>();

    // Üye ekleme
    public void uyeEkle(Uye uye) {
        uyeListesi.add(uye);
    }

    // Üye silme
    public boolean uyeSil(int uyeNumarasi) {
        for (Uye uye : uyeListesi) {
            if (uye.getUyeNumarasi() == uyeNumarasi) {
                uyeListesi.remove(uye);
                return true;
            }
        }
        return false;
    }

    // Üye listeleme
    public void uyeListele() {
        if (uyeListesi.isEmpty()) {
            System.out.println("Listede üye bulunmamaktadır.");
        } else {
            System.out.println("Üye Listesi:");
            for (Uye uye : uyeListesi) {
                System.out.println("İsim: " + uye.getIsim() + " - Üye Numarası: " + uye.getUyeNumarasi());
            }
        }
    }

    // Üye arama
    public Uye uyeAra(int uyeNumarasi) {
        for (Uye uye : uyeListesi) {
            if (uye.getUyeNumarasi() == uyeNumarasi) {
                return uye;
            }
        }
        return null;
    }
}