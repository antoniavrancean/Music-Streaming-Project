package clase;

public abstract class Utilizator {
    private String id;
    private String nume;
    private String email;

    public Utilizator(String id, String nume, String email){
        this.id = id;
        this.nume = nume;
        this.email = email;
    }

    //metode abstracte care trebuie implementate de clasele care o mostenesc pe asta
    public abstract String getTipUtilizator();
    public abstract void afiseazaProfil();

    //getters si setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public String toString(){
        return "Utilizator: \nid: " + id + "\nnume: " + nume + "\nemail: " + email + "\ntip: " + getTipUtilizator() + "\n";
    }

}
