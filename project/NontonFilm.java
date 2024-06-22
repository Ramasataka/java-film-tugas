package project;
import java.util.ArrayList;
import java.util.Scanner;

import project.Film.menu.Menu;
import project.Film.models.Pengguna;
import project.Film.utils.InitialData;
import project.Film.utils.ScreenClearner;
public class NontonFilm{
    private static Scanner input = new Scanner(System.in);
    private static InitialData initData = new InitialData();
    private static ArrayList<Pengguna> dataPengguna;
    private static Pengguna penggunaAktif;
    private static boolean isRunning = true;

    public static void main(String[] args) {
        dataPengguna = initData.initPengguna();

        while(isRunning){
            start();
        }

    }
    
    
    private static void start()
    {
        while(penggunaAktif == null)
        {
            login();
        }
        Menu menu = new Menu(dataPengguna, penggunaAktif); 
        menu.startMenu();

        penggunaAktif = null;
        System.out.print("Apakah anda ingin menutup program? (y|t) : ");
        String jawaban = input.nextLine();
        if (jawaban.equalsIgnoreCase("y")) {
            isRunning = false;
            System.out.print("Terima kasih telah menggunakan program ini.");
        }
    }


    private static void login()
    {
        ScreenClearner.clearConsole();
        String username, password;
        System.out.println("SINI LOGIN DULU");
        System.out.print("Username : ");
        username = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();

        for (Pengguna temp : dataPengguna) {
            if(temp.login(username, password)) {
                penggunaAktif = temp;
            }
        }
    }
}
