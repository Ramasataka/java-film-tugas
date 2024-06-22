package project.Film.utils;

public class ScreenClearner {
    public static void clearConsole() {  
        try {
            System.out.print("\033[H\033[2J"); 
            System.out.flush(); 
        }  
        catch (final Exception e) {  
            e.printStackTrace();
        }  
      }
}
