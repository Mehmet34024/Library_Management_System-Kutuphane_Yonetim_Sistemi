
class Kitap {
    private String baslik;
    private String yazar;
    private String isbn;
    private boolean oduncDurumu; // Kitap ödünçte mi?

    // Constructor
    public Kitap(String baslik, String yazar, String isbn) {
        this.baslik = baslik;
        this.yazar = yazar;
        this.isbn = isbn;
        this.oduncDurumu = false; // Başlangıçta kitap kütüphanede mevcut
    }

    // Getters
    public String getBaslik() {
        return baslik;
    }

    public String getYazar() {
        return yazar;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isOduncDurumu() {
        return oduncDurumu;
    }

    // Setters
    public void setOduncDurumu(boolean oduncDurumu) {
        this.oduncDurumu = oduncDurumu;
    }

}
