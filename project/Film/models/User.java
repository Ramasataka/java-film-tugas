package project.Film.models;

public class User {
    private String nama,negara;

    public User(){}
    public User(String nama, String negara)
    {
        this.nama = nama;
        this.negara = negara;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    
}
