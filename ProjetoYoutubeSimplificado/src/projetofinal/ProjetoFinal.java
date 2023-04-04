package projetofinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

        
public class ProjetoFinal {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Video> videosCadastrados = new ArrayList<>();
    private static Map<Usuario, Set<Video>> avaliacoes = new HashMap<>(); 
    private static Map<Video, Set<Usuario>> curtidas = new HashMap<>();      
    private static List<Visualizacao> visualizacoes = new ArrayList<>();
    private static Video videoAtual;
    
    public static Usuario buscarUsuario(String login){
        for(Usuario usuario : usuarios){
            if(usuario.getLogin().equals(login)){
                return usuario;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        menu();      
        
    }
    
    
    public static void menu(){
        Scanner t = new Scanner(System.in);
        int op;
        do {
            System.out.print("Bem-vindo ao projeto simplificado do YouTube\n");
            System.out.println("----------------------------------------------");
            System.out.println("1 - Cadastros");
            System.out.println("2 - Funcionalidades");
            System.out.println("3 - Relatório de desempenho dos vídeos");
            System.out.println("4 - Sair");
            System.out.print("Opção que deseja: ");
            op = t.nextInt();
        
            switch(op){
                case 1: 
                    menuCadastros();
                    break;
                case 2:
                    menuAcoes();
                    break;
                case 3:
                    exibirVisualizacoes();
                    break;
                case 4:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nOpção inválida. Escolha outra opção...");
                    System.out.print("Opção que deseja: ");
                    int opcao = t.nextInt();
            }
        } while(op != 4);
            
    }
    
    public static void menuCadastros(){
        Scanner t = new Scanner(System.in);
        System.out.println("\nMenu de Cadastros");
        System.out.println("--------------------");
        System.out.println("1 - Cadastro de Vídeos");
        System.out.println("2 - Cadastro de Usuários");
        System.out.println("3 - Consulta de Cadastros");
        System.out.println("4 - Voltar para o Menu Principal");
        System.out.print("\nOpção que deseja: ");
        int op = t.nextInt();
        
        switch(op){
            case 1: 
                System.out.print("\n");
                cadastrarVideo();
                break;
            case 2: 
                System.out.println("");
                cadastrarUsuario();
                break;
            case 3:
                System.out.print("\n");
                cadastrados();
                break;
            case 4:
                System.out.print("\n");
                menu();
                break;
            default:
                System.out.println("\nOpção inválida. Escolha outra opção...");
                menuCadastros();
                System.out.print("Opção que deseja: ");
                op = t.nextInt();
        }
    }
    
    
    
    public static void cadastrarVideo(){
        Scanner t = new Scanner(System.in);
        System.out.println("Cadastro de Vídeos");
        System.out.println("---------------------");
        System.out.print("Deseja cadastrar quantos vídeos? ");
        int c = t.nextInt();
        t.nextLine();
        
        Video v[] = new Video[c];
        
        for (int i = 0; i < v.length; i++){
            System.out.print("Digite o título do vídeo #"+ (i+1) + ": ");
            String titulo = t.nextLine();
            v[i] = new Video(titulo);
            videosCadastrados.add(v[i]);
            
        }
        
        System.out.print("\nTítulos dos vídeos cadastrados: ");
        System.out.println("\n");
        for (int i = 0; i < v.length; i++){
            System.out.println("Título do vídeo #" + (i+1) + ": " + v[i].getTitulo());
        }
        
        
        menuCadastros();
    }
    
    public static void cadastrarUsuario(){
        Scanner t = new Scanner(System.in);
        
        boolean sair = false;
        
        System.out.println("Cadastro de Usuários");
        System.out.println("-----------------------");
        
        while(!sair){
            System.out.print("Digite o login do usuário: ");
            String login = t.nextLine();
            
            boolean verificarLogin = false;
            
            for (Usuario u : usuarios){
            if(u.getLogin().equals(login)){
                verificarLogin = true;
                break;
                }
            }
            
            if(verificarLogin){
                System.out.println("\nErro! Login já cadastrado.");
                continue;
            }
            
            System.out.print("Digite o nome do usuário: ");
            String nome = t.nextLine();
            System.out.print("Digite o sexo do usuário: ");
            String sexo = t.nextLine();
            System.out.print("Digite a idade do usuário: ");
            int idade = t.nextInt();
            t.nextLine(); 
        
            usuarios.add(new Usuario(login,nome,sexo,idade));
        
            System.out.println("\nUsuário cadastrado com sucesso!");
            
            System.out.print("\nDeseja realizar um novo cadastro? [S/N] ");
            String op = t.nextLine();
            System.out.println("");
            if(op.equalsIgnoreCase("N")){
                sair = true;
                menuCadastros();
            }
            
            
        }
        
    }
    
    
    public static void cadastrados(){
        Scanner t = new Scanner(System.in);
        System.out.println("Cadastrados");
        System.out.println("--------------");
        System.out.println("1 - Títulos Cadastrados");
        System.out.println("2 - Usuários Cadastrados");
        System.out.println("3 - Voltar para o Menu de Cadastros");
        System.out.print("\nOpção que deseja: ");
        int op = t.nextInt();
        
        switch(op){
            case 1:
                titulosCadastrados();
                break;
            case 2:
                usuariosCadastrados();
               break;
            case 3:
                menuCadastros();
                break;
            default:
                System.out.println("\nOpção inválida. Escolha outra opção...");
                cadastrados();
                System.out.print("Opção que deseja: ");
                op = t.nextInt();           
        }
        
    }
    
    public static void titulosCadastrados(){
        if(videosCadastrados.isEmpty()){
            System.out.println("\nNenhum vídeo cadastrado!\n");
            cadastrados();
            return;
        }
        System.out.println("\nTítulos dos vídeos cadastrados: ");
        System.out.println("----------------------------------");
        
        
        for(Video video: videosCadastrados){
            System.out.println("x " + video.getTitulo());
        }
        System.out.println();
        cadastrados();                    
    }
    
    public static void usuariosCadastrados(){
        if(usuarios.isEmpty()){
            System.out.println("\nNenhum usuário cadastrado!\n");
            cadastrados();
            return;
        }
        System.out.println("\nUsuários cadastrados: ");
        System.out.println("-------------------------");
        
        for(Usuario usuario: usuarios){
            System.out.println("x " + usuario.getLogin());
        }
        System.out.println();
        cadastrados();
    }
    
    
    public static void menuAcoes(){
        Scanner t = new Scanner(System.in);
        System.out.println("\nMenu das Ações");
        System.out.println("----------------------");
        System.out.println("1 - Reproduzir Vídeo");
        System.out.println("2 - Pausar Vídeo");
        System.out.println("3 - Curtir Vídeo");
        System.out.println("4 - Avaliar Vídeo");
        System.out.println("5 - Voltar para o Menu Principal");
        System.out.print("Opção que deseja: ");
        int op = t.nextInt();
        
        switch(op){
            case 1:
                reproduzir();
                break;
            case 2:
                pausar();
                break;
            case 3:
                curtir();
                break;
            case 4:
                avaliacao();
                break;
            case 5:
                System.out.println("\n");
                menu();
                break;
            default:
                System.out.println("\nOpção inválida. Escolha outra opção...");
                cadastrados();
                System.out.print("Opção que deseja: ");
                op = t.nextInt();    
        }
        
    }
    
    public static void reproduzir(){
        Scanner t = new Scanner(System.in);
        System.out.print("\nTítulo do vídeo: ");
        String titulo = t.nextLine();
        
        Video videoEncontrado = null;
        for(Video video : videosCadastrados){
            if(video.getTitulo().equals(titulo)){
                videoEncontrado = video;
                break;
            }
        }
        
        if(videoEncontrado != null){
            System.out.print("Deseja reproduzir o vídeo?[S/N]");
            String resp = t.nextLine();
        
            if(resp.equalsIgnoreCase("S")){
                Usuario usuarioAtual = new Usuario("Usuário", "atual", "padrao", 1234);
                Visualizacao visualizacao = new Visualizacao(usuarioAtual, videoEncontrado);
                visualizacoes.add(visualizacao);
                videoAtual = videoEncontrado;
                videoEncontrado.play();
                System.out.println("\nReproduzindo o vídeo " + titulo + "...");
            } else {
                System.out.println("\nReprodução cancelada pelo usuário");
            }
        } else {
            System.out.println("\nVídeo não cadastrado!");
        }
        menuAcoes();
    }
    
    public static void pausar(){
        Scanner t = new Scanner(System.in);  
        System.out.print("\nTítulo do vídeo que deseja pausar: ");
        String titulo = t.nextLine();
        
        Video videoEncontrado = null;
        for(Video video : videosCadastrados){
            if(video.getTitulo().equals(titulo)){
                videoEncontrado = video;
                break;
            }
        }
        
        if(videoEncontrado != null){
            if((videoAtual != null) && (videoAtual.equals(videoEncontrado))){
                System.out.println("\nO vídeo " + titulo + " está sendo pausado");
                videoAtual.pause();
            } else {
                System.out.println("\nO vídeo " + titulo + " não está sendo "
                        + "reproduzido...");
            }
        } else {
            System.out.println("\nVídeo não cadastrado!");
        }
        menuAcoes();
    }
    
    public static void curtir(){
        Scanner t = new Scanner(System.in);
        System.out.print("\nInforme o seu login: ");
        String login = t.nextLine();
        Usuario usuario = buscarUsuario(login);
        
        if (usuario == null) {
            System.out.println("\nUsuário não encontrado!");
            menuAcoes();
            return;        
        } 
        
        System.out.print("Informe o título do vídeo que deseja curtir: ");
        String titulo = t.nextLine();
        Video videoEncontrado = null;
        
        for(Video video : videosCadastrados){
            if (video.getTitulo().equals(titulo)){
                videoEncontrado = video;
                break;
            }
        }
        
        if (videoEncontrado == null){
            System.out.println("\nVídeo não cadastrado!");
            menuAcoes();
            return;
        }
        
        if (videoEncontrado != null){
            curtidas.putIfAbsent(videoEncontrado, new HashSet<>());
             if(curtidas.get(videoEncontrado).contains(usuario)){
                System.out.println("\nVocê já curtiu este vídeo!");
                menuAcoes();
                return; 
            }
            
            videoEncontrado.like();
            System.out.println("\nCurtida realizada com sucesso!");
            curtidas.get(videoEncontrado).add(usuario);
            menuAcoes();
            
        } else {
            System.out.println("\nVídeo não cadastrado!");
            menuAcoes();
        }

        
    }
    
    public static void avaliacao(){
        Scanner t = new Scanner(System.in);
        System.out.print("\nInforme o seu login: ");
        String login = t.nextLine();
        Usuario usuario = buscarUsuario(login);
        
        if (usuario == null) {
            System.out.println("\nUsuário não encontrado!");
            menuAcoes();
            return;        
        } 
        
        System.out.print("Informe o título do vídeo que deseja avaliar: ");
        String titulo = t.nextLine();
        Video videoEncontrado = null;
        
        for(Video video : videosCadastrados){
            if (video.getTitulo().equals(titulo)){
                videoEncontrado = video;
                break;
            }
        }
        
        if (videoEncontrado == null){
            System.out.println("\nVídeo não encontrado!");
            menuAcoes();
            return;
        }
        
        if(avaliacoes.containsKey(usuario) && avaliacoes.get(usuario).contains(videoEncontrado)){
            System.out.println("\nVocê já avaliou este vídeo!");
            menuAcoes();
            return;
        }
        
        System.out.print("Nota da avaliação: ");
        int nota = t.nextInt();
        t.nextLine();
        
        Visualizacao visualizacao = new Visualizacao(usuario, videoEncontrado);
        visualizacao.avaliar(nota);
        System.out.println("\nAvaliação realizada com sucesso!");
        
        if(!avaliacoes.containsKey(usuario)){
            avaliacoes.put(usuario, new HashSet<>());
        }
        
        avaliacoes.get(usuario).add(videoEncontrado);
        menuAcoes();
    }
      
    
    public static void exibirVisualizacoes() {
    System.out.println("\nRelatório de Desempenho");
    System.out.println("-------------------------");
    
    for (Video v : videosCadastrados) {
        System.out.println("O vídeo " + v.getTitulo() + " possui " + v.getNumReproducoes() + " visualização(ões)");
        System.out.println("O vídeo " + v.getTitulo() + " possui " + v.getCurtidas() + " curtida(s)");
    }
        menu();
    }
    
    
}
