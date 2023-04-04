package projetofinal;
public class Video implements AcoesVideo {
    private String titulo;
    private int avaliacao, views, curtidas, numReproducoes;;
    private boolean reproduzindo;

    public Video(String titulo) {
        this.titulo = titulo;
        this.avaliacao = 1;
        this.views = 0;
        this.curtidas = 0;
        this.numReproducoes = 0;
        this.reproduzindo = false;
    }

    public int getNumReproducoes() {
        return numReproducoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        int novaAvaliacao;
        novaAvaliacao = (this.avaliacao + avaliacao)/this.views;
        this.avaliacao = novaAvaliacao;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(int curtidas) {
        this.curtidas = curtidas;
    }

    public boolean getReproduzindo() {
        return reproduzindo;
    }

    public void setReproduzindo(boolean reproduzindo) {
        this.reproduzindo = reproduzindo;
    }
    
    @Override
    public void play() {
        this.numReproducoes++;
        this.reproduzindo = true;
    }

    @Override
    public void pause() {
        this.reproduzindo = false;
    }

    @Override
    public void like() {
        this.curtidas++;
    }

    @Override
    public String toString() {
        return "Video{" + "titulo = " + titulo + "\navaliacao = " + 
                avaliacao + "\nviews = " + views + "\ncurtidas = " + 
                curtidas + "\nreproduzindo = " + reproduzindo + '}';
    }
    
    
}
