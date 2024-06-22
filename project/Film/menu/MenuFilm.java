package project.Film.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import project.Film.models.Artis;
import project.Film.models.Film;
import project.Film.models.Genre;
import project.Film.models.Pengguna;
import project.Film.utils.ScreenClearner;

public class MenuFilm {
    ArrayList<Film> dataFilm;
    Map<String, List<Artis>> movieArtistsMap;
    Map<String, Genre> dataGenre;
    ArrayList<Pengguna> penggunaList;
    Map<String, List<Film>> dataFilmByGenre;
    private Pengguna penggunaAktif;
    private int pilih;
    private Scanner input = new Scanner(System.in);
    private Menu menu;
    private MenuWatchlist menuWatchlist;

    public MenuFilm(ArrayList<Film> film, Map<String, List<Artis>> movieArtistsMap, Map<String, Genre> dataGenre, Pengguna pengguna, Map<String, List<Film>> dataFilmByGenre, Menu menu)
    {
        this.dataFilm = film;
        this.movieArtistsMap = movieArtistsMap;
        this.dataGenre = dataGenre;
        this.penggunaAktif = pengguna;
        this.dataFilmByGenre = dataFilmByGenre;
        this.menu = menu;
    }


    public void lihatFilm() {
        ScreenClearner.clearConsole();
        System.out.println("=========================");
        System.out.println("Pilih Menu Film");
        System.out.println("1. Semua Film");
        System.out.println("2. Pilih Genre");
        System.out.println("0. Balik");

        System.out.print("Input : ");

        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                semuaFilm();;
                break;
            case 2:
                pilihGenre();;
                break;
            case 0:
                menu.startMenu();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    public void semuaFilm()
    {
        ScreenClearner.clearConsole();
        System.out.println("============================================");
        System.out.println("              List Film ");
        
        int i = 1;
        for (Film film : dataFilm) {
            System.out.println(i);
            System.out.println("Judul: " + film.getNamaFilm());
            System.out.println("Tahun: " + film.getTahunTerbit());
            System.out.println("Durasi: " + film.getDurasi());
            System.out.println("Sinopsis: " + film.getSinopsis());
        
            System.out.print("Artis: ");
            List<Artis> artists = movieArtistsMap.getOrDefault(film.getNamaFilm(), new ArrayList<>());
            for (Artis artis : artists) {
                System.out.print(artis.getNama() + " = " + artis.getRole() + "\n" + "From " + artis.getNegara() + "\n");
            }
            System.out.println();
        
            System.out.print("Genre: ");
            Genre genre = dataGenre.get(film.getNamaFilm());
            if (genre != null) {
                System.out.println(genre.getNamaGenre());
            }
                        
            System.out.println();
            System.out.println("--------------------------------------------");
            i++;
        }
        

        this.menuWatchlist = new MenuWatchlist(dataFilm, movieArtistsMap, dataGenre, penggunaAktif, dataFilmByGenre, menu);;

        System.out.println("=========================");
        System.out.println("Pilih Menu");
        System.out.println("1. Lihat Sesuai Genre");
        System.out.println("2. Watchlist Menu");
        System.out.println("0. Menu");

        System.out.print("Input : ");

        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                pilihGenre();
                break;
            case 2:
                menuWatchlist.watchListMenu();
                break;
            case 0:
                menu.startMenu();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
    public void pilihGenre()
    {
        ScreenClearner.clearConsole();
        System.out.println("Genre yang ada di Program ini:");
        List<String> genreList = new ArrayList<>(dataFilmByGenre.keySet());
        for (int i = 0; i < genreList.size(); i++) {
            System.out.println((i + 1) + ". " + genreList.get(i));
        }

        System.out.print("Pilih genre: ");
        int genreChoice = input.nextInt();
        input.nextLine(); 
        if (genreChoice < 1 || genreChoice > genreList.size()) {
            System.out.println("Choice Salah Pilih Ulang");
            System.exit(0);
        }

        String selectedGenre = genreList.get(genreChoice - 1);
        liatFilmSesuaiGenre(selectedGenre);
    
    }

    public void liatFilmSesuaiGenre(String selectedGenre)
    {
        ScreenClearner.clearConsole();
        List<Film> filmsInGenre = dataFilmByGenre.get(selectedGenre);

        
        ScreenClearner.clearConsole();
        System.out.println("============================================");
        System.out.println("              List Film ");
        System.out.println("Genre: " + selectedGenre);
        System.out.println("--------------------------------------------");

        
        int i = 1;
        for (Film film : filmsInGenre) {
            System.out.println(i);
            System.out.println("Judul: " + film.getNamaFilm());
            System.out.println("Tahun: " + film.getTahunTerbit());
            System.out.println("Durasi: " + film.getDurasi());
            System.out.println("Sinopsis: " + film.getSinopsis());

            System.out.print("Artis: ");
            List<Artis> artists = movieArtistsMap.getOrDefault(film.getNamaFilm(), new ArrayList<>());
            for (Artis artis : artists) {
                System.out.print(artis.getNama() + " = " + artis.getRole() + "\n" + "From " + artis.getNegara() + "\n");
            }
            System.out.println();

            System.out.println();
            System.out.println("--------------------------------------------");
            i++;
        }
        
        System.out.println("=========================");
        System.out.println("Pilih Menu");
        System.out.println("1. Semua Film");
        System.out.println("2. Pilih Genre");
        System.out.println("3. Watchlist Menu");
        System.out.println("0. Menu");

        System.out.print("Input : ");

        this.menuWatchlist = new MenuWatchlist(dataFilm, movieArtistsMap, dataGenre, penggunaAktif, dataFilmByGenre, menu);;
        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                semuaFilm();
                break;
            case 2:
                pilihGenre();
                break;
            case 3:
                menuWatchlist.watchListMenu();
                break;    
            case 0:
                menu.startMenu();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }
}
