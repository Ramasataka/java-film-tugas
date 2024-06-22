package project.Film.utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.Film.models.Artis;
import project.Film.models.Film;
import project.Film.models.Genre;
import project.Film.models.Pengguna;  


public class InitialData {
    private ArrayList<Film> dataFilm = new ArrayList<>();    
    private Map<String, List<Artis>> movieArtistsMap = new HashMap<>();
    private Map<String, Genre> dataGenre= new HashMap<>();
    private ArrayList<Pengguna> dataPengguna = new ArrayList<>();
    
    private static String csvPath = "../FilmJava/project/Film/utils/Movie.csv";
       
        public static String[] readCsv(int n) {
        String line = "";
        String splitBy = ";";
        List<String> result = new ArrayList<>();
        

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            while ((line = br.readLine()) != null) {
                String[] movie = line.split(splitBy);
                if (movie.length > n) {
                    result.add(movie[n]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result.toArray(new String[0]);
    }
    


    public ArrayList<Film> initFilm()
    {
        
        String[] namaFilm       = readCsv(0);
        String[] durasi         = readCsv(1);
        String[] tahunTerbit    = readCsv(2);
        String[] sinposis       = readCsv(3);

        int numFilms = Math.min(Math.min(Math.min(namaFilm.length, durasi.length), tahunTerbit.length), sinposis.length);

        for (int i = 0; i < numFilms; i++){
            Film film = new Film();
            film.setNamaFilm(namaFilm[i]);
            film.setDurasi(durasi[i]);
            film.settahunTerbit(tahunTerbit[i]);
            film.setSinopsis(sinposis[i]);

            dataFilm.add(film);

        }
        return dataFilm;
    }

    public Map<String, List<Artis>> initArtis() {
        String line = "";
        String cellSeparator = ";";
    
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            while ((line = br.readLine()) != null) {
                String[] cells = line.split(cellSeparator);
                if (cells.length > 1) { 
                    String movieName = cells[0].trim(); 
    

                    for (int i = 1; i < cells.length; i++) {
                        String actorDetails = cells[i].trim();
    

                        String[] actors = actorDetails.split(";");
    
                        for (String actor : actors) {
                            String[] fields = actor.split(":");
                            if (fields.length == 3) {
                                String negara = fields[0].trim();
                                String nama = fields[1].trim();
                                String role = fields[2].trim();
    
                                Artis artis = new Artis();
                                artis.setNegara(negara);
                                artis.setNama(nama);
                                artis.setRole(role);
    

                                List<Artis> artists = movieArtistsMap.getOrDefault(movieName, new ArrayList<>());
                                artists.add(artis);
                                movieArtistsMap.put(movieName, artists);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movieArtistsMap;
    }

    public Map<String, Genre> initGenre()
    {
        String[] movieName     = readCsv(0);
        String [] hasilGenre = readCsv(4);
        for (int i = 0; i < dataFilm.size() && i < hasilGenre.length; i++) {
            Genre genre = new Genre();
            genre.setNamaGenre(hasilGenre[i]); 
            dataGenre.put(movieName[i], genre);

        }
    
        return dataGenre;
    
    }
    

    public  ArrayList<Pengguna> initPengguna()
    {
        Pengguna pengguna = new Pengguna("MAX",
         "BELANDA",
          "ver",
           "111",
            "Action");

            dataPengguna.add(pengguna);

        pengguna = new Pengguna("Lando",
         "UK",
          "nor111",
           "2121",
            "Action");

            dataPengguna.add(pengguna);

            return dataPengguna;
    }

}




