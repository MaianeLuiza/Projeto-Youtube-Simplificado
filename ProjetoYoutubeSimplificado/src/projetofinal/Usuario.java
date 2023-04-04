package projetofinal;
public class Usuario extends Pessoa{
    private String login;
    private int totAssitido;
    
    public Usuario(String login, String nome, String sexo, int idade) {
        super(nome, sexo, idade);
        this.login = login;
        this.totAssitido = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTotAssitido() {
        return totAssitido;
    }

    public void setTotAssitido(int totAssitido) {
        this.totAssitido = totAssitido;
    }

    @Override
    public String toString() {
        return "Gafanhoto{" + super.toString() + "\nlogin = " + login + "\ntotAssitido = " + totAssitido + '}';
    }
    
    
}
