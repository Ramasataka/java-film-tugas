package project.Film.models;

public class Artis extends User{
    private String role;

    public Artis(){}
    public Artis(String nama, String negara, String role)
    {
        super(nama, negara);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
