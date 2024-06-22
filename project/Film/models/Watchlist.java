package project.Film.models;
import java.util.ArrayList;
import java.util.List;

public class Watchlist {
    private Pengguna pengguna;
    private List<Film> films;

    public Watchlist(Pengguna pengguna) {
        this.pengguna = pengguna;
        this.films = new ArrayList<>();
    }

    public void addFilm(Film film) {
        films.add(film);
    }


    public void removeFilm(Film film) {
        films.remove(film);
    }


    public List<Film> getFilms() {
        return films;
    }


    public Pengguna getPengguna() {
        return pengguna;
    }
}
