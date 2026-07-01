package model;

public class Customer {

    private int idCust;
    private String nama;
    private String hp;
    private String alamat;

    public int getIdCust() {
        return idCust;
    }

    public void setIdCust(int idCust) {
        this.idCust = idCust;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}