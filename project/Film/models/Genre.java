package project.Film.models;

public class Genre {
    private String namaGenre;
    public Genre(){}
    public Genre(String namaGenre){
        this.namaGenre = namaGenre;
    }

    public String getNamaGenre() {
        return namaGenre;
    }

    public void setNamaGenre(String namaGenre) {
        this.namaGenre = namaGenre;
    }
}
