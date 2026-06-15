import java.util.Scanner;

public class 1Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== BICHINHO VIRTUAL ===");
        System.out.println("Projeto: 4 pilares de OOP");
        System.out.println("- Encapsulamento: atributos privados em Bicho");
        System.out.println("- Heranca: Cachorro e Gato herdam de Bicho");
        System.out.println("- Abstracao: metodos abstratos em Bicho");
        System.out.println("- Polimorfismo: mesmo metodo, comportamentos diferentes\n");

        System.out.println("Escolha seu pet:");
        System.out.println("1 - Cachorro");
        System.out.println("2 - Gato");

        int tipoPet;
        while (true) {
            if (entrada.hasNextInt()) {
                tipoPet = entrada.nextInt();
                entrada.nextLine();
                if (tipoPet == 1 || tipoPet == 2) break;
            } else {
                entrada.nextLine();
            }
            System.out.println("Opcao invalida. Digite 1 para Cachorro ou 2 para Gato.");
        }

        System.out.println("Digite o nome do seu pet:");
        String nome = entrada.nextLine();

        Bicho pet;
        if (tipoPet == 1) {
            pet = new Cachorro(nome);
        } else {
            pet = new Gato(nome);
        }
        System.out.println(pet.getNome() + " (" + pet.getClass().getSimpleName() + ") nasceu! Cuide bem dele!\n");

        System.out.println("=== OBJETIVO ===");
        System.out.println("Faca seu pet chegar a idade 50 sem deixar os atributos chegarem aos limites!");
        System.out.println("- Fome: nao deixe chegar a 100");
        System.out.println("- Felicidade: nao deixe chegar a 0");
        System.out.println("- Cansaco: nao deixe chegar a 100");
        System.out.println("- Banheiro: nao deixe chegar a 100");
        System.out.println("- Sujeira: nao deixe chegar a 100\n");

        while (true) {
            System.out.println("=== O que " + pet.getNome() + " vai fazer? ===");
            System.out.println("1. Alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Verificar status");
            System.out.println("4. Habilidade especial");
            System.out.println("5. Descansar");
            System.out.println("6. Ir ao banheiro");
            System.out.println("7. Limpar");
            System.out.println("8. Sair");

            if (!entrada.hasNextInt()) {
                entrada.nextLine();
                System.out.println("Digite um numero valido.\n");
                continue;
            }
            int escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1:
                    pet.alimentar();
                    break;
                case 2:
                    pet.brincar();
                    break;
                case 3:
                    pet.verificarStatus();
                    continue;
                case 4:
                    pet.habilidadeEspecial();
                    break;
                case 5:
                    System.out.println("Por quantas horas " + pet.getNome() + " vai descansar?");
                    if (entrada.hasNextInt()) {
                        int horas = entrada.nextInt();
                        entrada.nextLine();
                        pet.descansar(horas);
                    } else {
                        entrada.nextLine();
                        pet.descansar();
                    }
                    break;
                case 6:
                    pet.irAoBanheiro();
                    break;
                case 7:
                    pet.limpar();
                    break;
                case 8:
                    System.out.println("Encerrando o jogo. Ate mais!");
                    return;
                default:
                    System.out.println("Escolha invalida. Tente novamente.\n");
                    continue;
            }

            pet.passarTempo();

            if (pet.verificarDerrota()) {
                System.out.println("\nGame over! " + pet.getNome() + " nao resistiu.");
                break;
            }

            if (pet.getIdade() >= 50) {
                System.out.println("\nParabens! " + pet.getNome() + " chegou a idade 50!");
                System.out.println("VOCE VENCEU!");
                break;
            }
        }

        entrada.close();
    }
}
