package project.Film.models;

public class Film{
    private String namaFilm, durasi, tahunTerbit, sinopsis;

    public Film(){}
    
    public Film(String namaFilm, String durasi, String tahunTerbit, String sinopsis)
    {
        this.namaFilm = namaFilm;
        this.durasi = durasi;
        this.tahunTerbit = tahunTerbit;
        this.sinopsis = sinopsis;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getTahunTerbit() {
        return tahunTerbit;
    }

    public void settahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    
}
