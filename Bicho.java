abstract class Bicho {

    private String nome;
    public int pontosDeVida;
    private int nivelDeFome;
    private int nivelFelicidade;
    private int nivelDeCansaco;
    private int nivelVontadeBanheiro;
    private int nivelSujeira;
    private int idade;

    public Bicho(String nome) {
        setNome(nome);
        this.nivelDeFome = 50;
        this.nivelFelicidade = 50;
        this.nivelDeCansaco = 0;
        this.nivelVontadeBanheiro = 0;
        this.nivelSujeira = 0;
        this.idade = 0;
    }

    public final String getNome() {
        return nome;
    }

    public final int getNivelDeFome() {
        return nivelDeFome;
    }

    public final int getNivelFelicidade() {
        return nivelFelicidade;
    }

    public final int getNivelDeCansaco() {
        return nivelDeCansaco;
    }

    public final int getNivelVontadeBanheiro() {
        return nivelVontadeBanheiro;
    }

    public final int getNivelSujeira() {
        return nivelSujeira;
    }

    public final int getIdade() {
        return idade;
    }

    public final void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do bicho nao pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public void alimentar() {
        alterarFome(-10);
        alterarVontadeBanheiro(20);
        System.out.println(nome + " foi alimentado. O nivel de fome diminuiu.");
    }

    public void brincar() {
        alterarFelicidade(10);
        alterarCansaco(10);
        alterarSujeira(15);
        System.out.println(nome + " brincou e ficou mais feliz.");
    }

    public void descansar() {
        alterarCansaco(-15);
        System.out.println(nome + " descansou e se sente menos cansado.");
    }

    public void descansar(int horas) {
        if (horas >= 8) {
            nivelDeCansaco = 0;
            System.out.println(nome + " descansou por " + horas + " horas e esta totalmente descansado.");
        } else {
            alterarCansaco(-(int)(horas * 12.5));
            System.out.println(nome + " descansou por " + horas + " horas.");
        }
    }

    public void irAoBanheiro() {
        alterarVontadeBanheiro(-30);
        System.out.println(nome + " foi ao banheiro e se aliviou.");
    }

    public void limpar() {
        alterarSujeira(-40);
        System.out.println(nome + " foi limpo e esta cheiroso.");
    }

    public void verificarStatus() {
        System.out.println("=== Status de " + nome + " ===");
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Fome: " + nivelDeFome + "/100");
        System.out.println("Felicidade: " + nivelFelicidade + "/100");
        System.out.println("Cansaco: " + nivelDeCansaco + "/100");
        System.out.println("Banheiro: " + nivelVontadeBanheiro + "/100");
        System.out.println("Sujeira: " + nivelSujeira + "/100");
    }

    public boolean verificarDerrota() {
        if (nivelDeFome >= 100) {
            System.out.println("\n" + nome + " morreu de fome! VOCE PERDEU!");
            return true;
        }
        if (nivelDeCansaco >= 100) {
            System.out.println("\n" + nome + " morreu de cansaco! VOCE PERDEU!");
            return true;
        }
        if (nivelFelicidade <= 0) {
            System.out.println("\n" + nome + " morreu de tristeza! VOCE PERDEU!");
            return true;
        }
        if (nivelVontadeBanheiro >= 100) {
            System.out.println("\n" + nome + " nao aguentou e fez coco no chao! VOCE PERDEU!");
            return true;
        }
        if (nivelSujeira >= 100) {
            System.out.println("\n" + nome + " ficou doente de tao sujo! VOCE PERDEU!");
            return true;
        }
        return false;
    }

    public void passarTempo() {
        alterarFome(3);
        alterarFelicidade(-3);
        alterarCansaco(10);
        alterarVontadeBanheiro(2);
        alterarSujeira(1);
        idade++;
    }

    protected final void alterarFome(int delta) {
        nivelDeFome = limitarEntre0e100(nivelDeFome + delta);
    }

    protected final void alterarFelicidade(int delta) {
        nivelFelicidade = limitarEntre0e100(nivelFelicidade + delta);
    }

    protected final void alterarCansaco(int delta) {
        nivelDeCansaco = limitarEntre0e100(nivelDeCansaco + delta);
    }

    protected final void alterarVontadeBanheiro(int delta) {
        nivelVontadeBanheiro = limitarEntre0e100(nivelVontadeBanheiro + delta);
    }

    protected final void alterarSujeira(int delta) {
        nivelSujeira = limitarEntre0e100(nivelSujeira + delta);
    }

    private int limitarEntre0e100(int valor) {
        return Math.max(0, Math.min(100, valor));
    }

    public abstract String emitirSom();

    public abstract void habilidadeEspecial();

    public void interagir() {
        System.out.println(nome + " diz: " + emitirSom());
    }
}
