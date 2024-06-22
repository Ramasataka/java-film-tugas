package project.Film.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import project.Film.models.Artis;
import project.Film.models.Film;
import project.Film.models.Genre;
import project.Film.models.Pengguna;
import project.Film.models.Watchlist;
import project.Film.utils.InitialData;
import project.Film.utils.ScreenClearner;

public class Menu {
    private InitialData allData = new InitialData();
    private ArrayList<Film> dataFilm = allData.initFilm();
    private Map<String, List<Artis>> movieArtistsMap = allData.initArtis();
    private Map<String, Genre> dataGenre = allData.initGenre();
    
    private int pilih;
    private Pengguna penggunaAktif;

    private Scanner input = new Scanner(System.in);

    public Menu(ArrayList<Pengguna> dataPenggunas, Pengguna pengguna) {
        this.penggunaAktif = pengguna;
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
                    lihatFilm();
                    break;
                case 2:
                    watchListMenu();
                    break;
                case 0:
                    System.out.println("KELUAR ");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
    }

    public void lihatFilm() {
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
        



        System.out.println("=========================");
        System.out.println("Pilih Menu");
        System.out.println("1. Home");
        System.out.println("2. Watch List Menu");
        System.out.println("0. Balik");

        System.out.print("Input : ");

        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                startMenu();
                break;
            case 2:
                watchListMenu();
                break;
            case 0:
                startMenu();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    public void watchListMenu()
    {
        ScreenClearner.clearConsole();
        System.out.println("Pilih Menu Watchlist");
        System.out.println("1. Tambah Watchlist");
        System.out.println("2. History Watchlist");
        System.out.println("0. Balik");
        System.out.print("Input : ");
        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                tambahKeWatchlist();;
                break;
            case 2:
                lihatWatchlist();;
                break;
            case 0:
                startMenu();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }

    public void tambahKeWatchlist() {
        ScreenClearner.clearConsole();
        int i = 1;
        for (Film film : dataFilm) {
            System.out.println(i + ". " + film.getNamaFilm());
            i++;
        }
        System.out.println("Masukkan nomor film yang ingin ditambahkan ke Watchlist: ");
        System.out.print("Input : ");
        int nomorFilm = input.nextInt();
        input.nextLine();
    
        if (nomorFilm > 0 && nomorFilm <= dataFilm.size()) {
            Film selectedFilm = dataFilm.get(nomorFilm - 1);
            Pengguna currentUser = penggunaAktif; 
            Watchlist watchlist = currentUser.getWatchlist();
    
            // Check if the film is already in the watchlist
            boolean alreadyInWatchlist = false;
            for (Film film : watchlist.getFilms()) {
                if (film.equals(selectedFilm)) {
                    alreadyInWatchlist = true;
                    break;
                }
            }
    
            if (!alreadyInWatchlist) {
                watchlist.addFilm(selectedFilm);
                System.out.println(selectedFilm.getNamaFilm() + " berhasil ditambahkan ke Watchlist.");
            } else {
                System.out.println(selectedFilm.getNamaFilm() + " sudah ada di Watchlist.");
            }
            System.out.print("Tekan ENTER untuk melanjutkan");
            input.nextLine();
            startMenu();
        } else {
            System.out.println("Nomor film tidak valid.");
            System.out.print("Tekan ENTER untuk melanjutkan");
            input.nextLine();
            tambahKeWatchlist();
        }
    }
    

    public void lihatWatchlist() {
        ScreenClearner.clearConsole();
    Pengguna currentUser = penggunaAktif; 
    Watchlist watchlist = currentUser.getWatchlist();

    System.out.println("============================================");
    System.out.println("Watchlist untuk " + currentUser.getNama() + ":");
    
    if(watchlist.getFilms().isEmpty()){
        System.out.println("Watchlist Kosong");
    }else{
        int i = 1;
        for (Film film : watchlist.getFilms()) {
            System.out.println(i);
            System.out.println("Judul: " + film.getNamaFilm());
            System.out.println("Tahun: " + film.getTahunTerbit());
            System.out.println("Durasi: " + film.getDurasi());
            System.out.println("Sinopsis: " + film.getSinopsis());
            System.out.println("--------------------------------------------");
            i++;
        }
    }
    System.out.println("============================================");
    
    System.out.println("Pilih Menu ");
        System.out.println("1. Tambah Watchlist");
        System.out.println("2. Hapus Watchlist");
        System.out.println("3. Lihat Film");
        System.out.println("4. Menu");
        System.out.print("Input : ");

        pilih = input.nextInt();
        input.nextLine();

        switch (pilih) {
            case 1:
                tambahKeWatchlist();;
                break;
            case 2:
                hapusDariWatchlist();;
                break;
            case 3:
                lihatFilm();
                break;
            case 4:
            startMenu();
            break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
    }



    public void hapusDariWatchlist() {
        ScreenClearner.clearConsole();
        Pengguna currentUser = penggunaAktif; 
        Watchlist watchlist = currentUser.getWatchlist();

        System.out.println("============================================");
        System.out.println("Watchlist untuk " + currentUser.getNama() + ":");

        if (watchlist.getFilms().isEmpty()) {
            System.out.println("Watchlist kosong.");
        } else {
            int i = 1;
            for (Film film : watchlist.getFilms()) {
                System.out.println(i + ". " + film.getNamaFilm());
                i++;
            }

            System.out.println("Masukkan nomor film yang ingin dihapus dari Watchlist: ");
            int nomorFilm = input.nextInt();
            input.nextLine();

            if (nomorFilm > 0 && nomorFilm <= watchlist.getFilms().size()) {
                Film selectedFilm = watchlist.getFilms().get(nomorFilm - 1);
                watchlist.removeFilm(selectedFilm);
                System.out.println(selectedFilm.getNamaFilm() + " berhasil dihapus dari Watchlist.");
            } else {
                System.out.println("Nomor film tidak valid.");
            }
        }

        System.out.println("============================================");
        input.nextLine();
        startMenu();
    }


}
