package project.Film.models;

public class Pengguna extends User{
    private String username,password,genreDisuka;
    private Watchlist watchlist;
    private boolean isLogin;
    
    public Pengguna (String nama, String negara, String username, String password, String genreDisuka){
        super(nama, negara);
        this.username = username;
        this.password = password;
        this.genreDisuka = genreDisuka;
        this.watchlist = new Watchlist(this);
        this.isLogin = false;
    }
    
    public boolean login(String userName, String passWord)
    {
        if(this.username.equals(userName) && this.password.equals(passWord)){
            this.isLogin = true;
        }else {
            this.isLogin = false;
        }
        return isLogin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenreDisuka() {
        return genreDisuka;
    }

    public void setGenreDisuka(String genreDisuka) {
        this.genreDisuka = genreDisuka;
    }

    public Watchlist getWatchlist() {
        return watchlist;
    }

} 
