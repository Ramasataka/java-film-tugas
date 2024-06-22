package project.Film.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import project.Film.models.Artis;
import project.Film.models.Film;
import project.Film.models.Genre;
import project.Film.models.Pengguna;
import project.Film.utils.InitialData;
import project.Film.utils.ScreenClearner;

public class Menu {
    private InitialData allData = new InitialData();
    private ArrayList<Film> dataFilm = allData.initFilm();
    private Map<String, List<Artis>> movieArtistsMap = allData.initArtis();
    private Map<String, Genre> dataGenre = allData.initGenre();
    private Map<String, List<Film>> dataFilmByGenre = allData.initDataByGenre();
    private MenuWatchlist menuWatchlist;
    private MenuFilm menuFilm;

    ArrayList<Pengguna> penggunaList;

    
    private int pilih;
    private Pengguna penggunaAktif;

    private Scanner input = new Scanner(System.in);
    
    public Menu(ArrayList<Pengguna> dataPenggunas, Pengguna pengguna) {
        this.penggunaAktif = pengguna;
        this.penggunaList = dataPenggunas;
        this.menuWatchlist = new MenuWatchlist(dataFilm, movieArtistsMap, dataGenre,penggunaAktif, dataFilmByGenre, this);
        this.menuFilm = new MenuFilm(dataFilm, movieArtistsMap, dataGenre, pengguna, dataFilmByGenre, this);
    }


    public void startMenu()
    {

        String nama = penggunaAktif.getNama();
            
        ScreenClearner.clearConsole();
        System.out.println("Selamat Datang Ke FILM");
        System.out.println(nama);
        
            System.out.println("PILIH MENU");
            System.out.println("1. LIHAT FILM");
            System.out.println("2. Watch List Menu");
            System.out.println("0. Keluar");
            System.out.print("Input : ");
            pilih = input.nextInt();
            input.nextLine();

            switch (pilih) {
                case 1:
                    menuFilm.lihatFilm();;
                    break;
                case 2:
                    menuWatchlist.watchListMenu();
                    break;
                case 0:
                    System.out.println("KELUAR ");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
    }

}
