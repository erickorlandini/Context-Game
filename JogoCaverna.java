import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoCaverna {

    private static int membrosDoGrupoVivos = 3;
    private static final Random random = new Random();
    private static List<String> inventario = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cenários do Game
        Cenario start = new Cenario("Você se encontra na entrada escura de uma caverna misteriosa..."); // Podemos usar este como ponto de partida ou o tunel
        Cenario tunelDosTesouros = new Cenario("Logo a frente esta um tunel com uma passagem de água de um lago não tão profundo. Na travessa do lago há tesouros que podem ser uteis. À direita, parece haver um caminho onde o lago se torna mais raso.");
        Cenario portaoMagico = new Cenario("Você chega a um imponente portão mágico, adornado com símbolos misteriosos. Uma voz ecoa: 'Para prosseguir, desvende meu enigma.'");
        Cenario enigmaResolvido = new Cenario("O portão mágico se abre com um estrondo, revelando o caminho adiante.");
        Cenario bifurcacao = new Cenario("O caminho se bifurca. À direita, parece haver um caminho que parece perigoso. À esquerda, ouve-se o som de água corrente.");
        Cenario monstro = new Cenario("Um monstro horrendo bloqueia o caminho! Ele rosna e parece pronto para atacar.");
        Cenario quedaDasPedras = new Cenario("Você chega a uma área onde pedras caem do teto! Será preciso ter cuidado para atravessar."); // Novo cenário
        Cenario rio = new Cenario("Você chega a um rio subterrâneo. A correnteza parece forte e você ouve um barulho estranho vindo das profundezas.");
        Cenario portaAnciaoMagico = new Cenario("Você se encontra diante de uma porta adornada com símbolos arcanos. Sente-se uma aura mágica emanando dela."); // Novo cenário
        Cenario cavernaDosMorcegos = new Cenario("Você entra em uma vasta caverna repleta de morcegos. O som de suas asas ecoa por todo o lugar."); // Novo cenário
        Cenario fugaComSucesso = new Cenario("Com cautela, você e seu grupo conseguem passar sorrateiramente pelo monstro.");
        Cenario fugaComFalha = new Cenario("O monstro percebe sua presença e ataca! Na luta, um membro do seu grupo foi perdido.");
        Cenario separacaoDoGrupo = new Cenario("Você não conseguiu derrotar o monstro e se separou do seu grupo, tendo que seguir por outro caminho.");
        Cenario armadilha = new Cenario("Você pisa em uma placa no chão! Uma rede cai do teto, prendendo um dos seus companheiros.");
        Cenario saida = new Cenario("Após superar muitos perigos, vocês avistam uma luz no fim do túnel! A saída da caverna está próxima.");
        Cenario fimSucesso = new Cenario("Vocês conseguiram sair da caverna sãos e salvos (" + membrosDoGrupoVivos + " membros)!");
        Cenario fimFalhaMonstro = new Cenario("O monstro era muito forte... Vocês foram derrotados.");
        Cenario fimFalhaArmadilha = new Cenario("Seu companheiro ficou preso na armadilha e vocês não conseguiram libertá-lo a tempo...");
        Cenario fimFalhaRio = new Cenario("A correnteza do rio era muito forte e vocês perderam alguns membros do grupo ao tentar atravessar.");
        Cenario passouMonstroInvisivel = new Cenario("Você se torna invisível e passa sorrateiramente pelo monstro.");
        Cenario passouMonstroHipnotizado = new Cenario("O monstro parece hipnotizado e você passa sem ser atacado.");
        Cenario passouMonstroCongelado = new Cenario("O monstro é congelado em um bloco de gelo, permitindo sua passagem.");
        Cenario passouMonstroDado = new Cenario("Você encontrou um caminho seguro e evitou o monstro.");
        Cenario derrotouMonstroDado = new Cenario("Você derrotou o monstro com a ajuda do Dado da sorte!");
        Cenario monstroAindaBloqueia = new Cenario("O monstro ainda bloqueia o caminho.");
        Cenario semSucessoEnigma = new Cenario("Você não conseguiu decifrar o enigma do portão mágico.");
        Cenario exilioDosMortos = new Cenario("Você tentou fugir sorrateiramente, mas o monstro o percebeu! Ele o atacou e você foi separado do seu grupo, sendo levado para um lugar sombrio e silencioso conhecido como o Exílio dos Mortos. Parece haver um caminho de volta, mas perigos espreitam nas sombras.");


        start.adicionarEscolha("Seguir para o interior da caverna", tunelDosTesouros, Escolha.TIPO_NUMERICO);

        tunelDosTesouros.adicionarEscolha("Atravessar o lago e vasculhar os tesouros", tunelDosTesouros, Escolha.TIPO_NUMERICO);
        tunelDosTesouros.adicionarEscolha("Seguir à direita pelo túnel", portaoMagico, Escolha.TIPO_NUMERICO);

        portaoMagico.adicionarEscolha("Tentar resolver o enigma", portaoMagico, Escolha.TIPO_NUMERICO);
        portaoMagico.adicionarEscolha("Voltar", tunelDosTesouros, Escolha.TIPO_VOLTAR_SEGUIR);

        enigmaResolvido.adicionarEscolha("Seguir adiante", bifurcacao, Escolha.TIPO_NUMERICO);

        bifurcacao.adicionarEscolha("Seguir pela direita", monstro, Escolha.TIPO_NUMERICO);
        bifurcacao.adicionarEscolha("Seguir pela esquerda (rio)", rio, Escolha.TIPO_NUMERICO);
        bifurcacao.adicionarEscolha("Voltar", enigmaResolvido, Escolha.TIPO_VOLTAR_SEGUIR);

        monstro.adicionarEscolha("Tentar fugir sorrateiramente", fugaComSucesso, Escolha.TIPO_NUMERICO);
        monstro.adicionarEscolha("Tentar fugir", monstro, Escolha.TIPO_NUMERICO);

        passouMonstroInvisivel.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
        passouMonstroHipnotizado.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
        passouMonstroCongelado.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
        passouMonstroDado.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
        derrotouMonstroDado.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
        new Cenario("Após derrotar o monstro.").adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);

        quedaDasPedras.adicionarEscolha("Avançar com cuidado", saida, Escolha.TIPO_NUMERICO);

        exilioDosMortos.adicionarEscolha("Tentar encontrar o caminho de volta", monstro, Escolha.TIPO_NUMERICO);

        rio.adicionarEscolha("Tentar atravessar o rio", armadilha, Escolha.TIPO_NUMERICO); // Consequência ao atravessar
        rio.adicionarEscolha("Voltar para a bifurcação no caminho", bifurcacao, Escolha.TIPO_VOLTAR_SEGUIR);

        new Cenario("Você atravessou o rio.").adicionarEscolha("Seguir pela porta à esquerda", portaAnciaoMagico, Escolha.TIPO_NUMERICO);
        new Cenario("Você atravessou o rio.").adicionarEscolha("Seguir pela porta à direita", cavernaDosMorcegos, Escolha.TIPO_NUMERICO);

        portaAnciaoMagico.adicionarEscolha("Interagir com o ancião", saida, Escolha.TIPO_NUMERICO);
        cavernaDosMorcegos.adicionarEscolha("Atravessar a caverna", saida, Escolha.TIPO_NUMERICO);

        // Ponto de início do jogo
        Cenario cenarioAtual = start;

        while (cenarioAtual != null && membrosDoGrupoVivos > 0) {
            System.out.println("\n" + cenarioAtual.getDescricao());
            System.out.println("Inventário: " + inventario);

            List<Escolha> escolhasDisponiveis = cenarioAtual.getEscolhas();

            if (escolhasDisponiveis.isEmpty()) {
                System.out.println("Não há mais escolhas neste ponto.");
                cenarioAtual = null;
            } else {
                System.out.println("O que você faz?");
                for (int i = 0; i < escolhasDisponiveis.size(); i++) {
                    Escolha escolha = escolhasDisponiveis.get(i);
                    if(escolha.getTipo().equals(Escolha.TIPO_NUMERICO)) {
                        System.out.println((i + 1) + ". " + escolha.getTexto());
                    }else if (escolha.getTipo().equals(Escolha.TIPO_SIM_NAO)) {
                        System.out.println("(" + (i + 1) + ") " + escolha.getTexto() + " (Sim/Não)");
                    }else if (escolha.getTipo().equals(Escolha.TIPO_PEGAR_LARGAR)) {
                        System.out.println("(" + (i + 1) + ") " + escolha.getTexto() + " (Pegar/Largar)");
                    }else if (escolha.getTipo().equals(Escolha.TIPO_VOLTAR_SEGUIR)) {
                        System.out.println("(" + (i + 1) + ") " + escolha.getTexto() + " (Voltar/Seguir)");
                    }
                }
                System.out.println((escolhasDisponiveis.size() + 1) + ". Verificar Inventário");

                System.out.println("Digite da sua exolha: ");
                String entradaJogador = scanner.nextLine().trim().toLowerCase();

                int escolhaNumerica = -1;
                try {
                    escolhaNumerica = Integer.parseInt(entradaJogador);
                } catch (NumberFormatException e) {
                    // Não é um numero
                }

                boolean escolhaValida = false;
                if(escolhaNumerica >= 1 && escolhaNumerica <= escolhasDisponiveis.size()) {
                    Escolha escolhaSelecionada = escolhasDisponiveis.get(escolhaNumerica - 1);
                    cenarioAtual = escolhaSelecionada.getProximoCenario();
                    escolhaValida = true;

                    if (cenarioAtual == fugaComSucesso) {
                        cenarioAtual = new Cenario("Com cautela, você e seu grupo conseguem passar sorrateiramente pelo monstro.");
                        cenarioAtual.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
                        System.out.println("\nVocês passaram sem serem notados!");
                    } else if (cenarioAtual == fugaComFalha){
                        modificarMembrosDoGrupo(-1);
                        System.out.println("\nO monstro atacou! Um membro foi devorado. Agora restam " + membrosDoGrupoVivos + " membros.");
                        fugaComFalha.setDescricao("O monstro percebe sua presença e ataca! Na luta, um membro do seu grupo foi perdido. Agora restam " + membrosDoGrupoVivos + " membros.");
                    } else if (cenarioAtual == monstro) {
                        List<Escolha> escolhasMonstro = new ArrayList<>();
                        int proximaOpcao = 1;

                        escolhasMonstro.add(new Escolha("(" + proximaOpcao++ + ") Tentar fugir sorrateiramente", monstro, Escolha.TIPO_NUMERICO));
                        escolhasMonstro.add(new Escolha("(" + proximaOpcao++ + ") Enfrentar o monstro", monstro, Escolha.TIPO_NUMERICO));

                        if(inventario.contains("Capa de invisibilidade")) {
                            escolhasMonstro.add(new Escolha("(" + proximaOpcao++ + ") Usar Capa de invisibilidade", new Cenario("Você se torna invisível e passa sorrateiramente pelo monstro."), Escolha.TIPO_NUMERICO));
                        }
                        if(inventario.contains("Pendulo mágico")) {
                            escolhasMonstro.add(new Escolha("(" + proximaOpcao++ + ") Usar Pendulo mágico para hipnotizar o monstro", new Cenario("O monstro parece hipnotizado e você passa sem ser atacado."), Escolha.TIPO_NUMERICO));
                        }
                        if(inventario.contains("Poção de congelamento")) {
                            escolhasMonstro.add(new Escolha("(" + proximaOpcao++ + ") Usar Poção de congelamento no monstro", new Cenario("O monstro é congelado em um bloco de gelo, permitindo sua passagem."), Escolha.TIPO_NUMERICO));
                        }
                        if(inventario.contains("Dado da sorte")) {
                            escolhasMonstro.add(new Escolha("(" + proximaOpcao++ + ") Usar Dado da sorte contra o monstro", monstro, Escolha.TIPO_NUMERICO));
                        }

                        System.out.println("o que você faz?");
                        for(Escolha escolha : escolhasMonstro) {
                            System.out.println(escolha.getTexto());
                        }

                        System.out.println("Digite sua escolha: ");
                        String entradaJogadorMonstro = scanner.nextLine().trim();

                        try {
                            int escolhaJogadorMonstro = Integer.parseInt(entradaJogadorMonstro);
                            if(escolhaJogadorMonstro >= 1 && escolhaJogadorMonstro <= escolhasMonstro.size()) {
                                Escolha escolhaSelecionadaMonstro = escolhasMonstro.get(escolhaJogadorMonstro - 1);
                                
                                if(escolhaSelecionadaMonstro.getTexto().contains("Tentar fugir sorrateiramente")) {
                                    if(random.nextDouble() < 0.5) {
                                        cenarioAtual = new Cenario("Com cautela, você e seu grupo conseguem passar pelo monstro");
                                        cenarioAtual.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
                                        System.out.println("\nVocês passaram sem serem notados!");
                                    } else {
                                        System.out.println("\nO monstro percebe sua presença e ataca! Você é separado do seu grupo.");
                                        modificarMembrosDoGrupo(-1);
                                        cenarioAtual = exilioDosMortos;
                                    }
                                }else if(escolhaSelecionadaMonstro.getTexto().contains("Enfrentar o monstro")){
                                    cenarioAtual = iniciarMinigameMonstro(scanner, quedaDasPedras);
                                }else if(escolhaSelecionadaMonstro.getTexto().contains("Capa de invisibilidade")) {
                                    inventario.remove("Capa de invisibilidade");
                                    cenarioAtual = passouMonstroInvisivel;
                                    passouMonstroInvisivel.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
                                }else if (escolhaSelecionadaMonstro.getTexto().contains("Pendulo mágico")) {
                                    inventario.remove("Pendulo mágico");
                                    cenarioAtual = passouMonstroHipnotizado;
                                    passouMonstroHipnotizado.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
                                } else if (escolhaSelecionadaMonstro.getTexto().contains("Poção de congelamento")) {
                                    inventario.remove("Poção de congelamento");
                                    cenarioAtual = passouMonstroCongelado;
                                    passouMonstroCongelado.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
                                } else if(escolhaSelecionadaMonstro.getTexto().contains("Dado da sorte")) {
                                    cenarioAtual = usarDadoSorteMonstro(scanner, quedaDasPedras);
                                } else if (escolhaSelecionadaMonstro.getTexto().contains("Enfrentar o monstro")) {
                                    cenarioAtual = iniciarMinigameMonstro(scanner, quedaDasPedras);
                                }
                                escolhaValida = true;
                            } else {
                                System.out.println("Escolha inválida.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida.");
                        }
                    } else if (cenarioAtual == tunelDosTesouros && escolhaNumerica == 1) {
                        String itemEncontrado = sortearItem();
                        System.out.println("Você encontrou: " + itemEncontrado + ".");

                        if(inventario.size() < 2) {
                            inventario.add(itemEncontrado);
                            System.out.println("O item foi adicionado ao se inventário.");
                        } else {
                            System.out.println("Seu inventário está cheio. Deseja trocar '" + itemEncontrado + "' por um item existente?");
                            System.out.println("Inventário atual:");
                            for(int i = 0; i < inventario.size(); i++) {
                                System.out.println((i + 1) + ". " + inventario.get(i));
                            }
                            System.out.println((inventario.size() + 1) + ". Não trocar e deixar o item para trás.");
                            System.out.println("Digite o número da sua escolha: ");
                            String escolhaTrocaStr = scanner.nextLine().trim();

                            try {
                                int escolhaTroca = Integer.parseInt(escolhaTrocaStr);
                                if(escolhaTroca >= 1 && escolhaTroca <= inventario.size()) {
                                    String itemTrocado = inventario.get(escolhaTroca - 1);
                                    inventario.set(escolhaTroca - 1, itemTrocado);
                                    System.out.println("Você trocou '" + itemTrocado + "' por '" + itemEncontrado + "'.");
                                } else if(escolhaTroca == inventario.size() + 1) {
                                    System.out.println("Você deixou '" + itemEncontrado + "' para trás.");
                                } else {
                                    System.out.println("Escolha inválida. O item '" + itemEncontrado + "' não foi adicionado.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. O item '" + itemEncontrado + "' não foi adicionado.");
                            }
                        }
                        if(itemEncontrado != null) {
                            inventario.add(itemEncontrado);
                            System.out.println("Você encontrou: " + itemEncontrado + " e adicionou ao seu inventário.");
                        } else {
                            System.out.println("Você vasculhou o lago, mas não encontrou nada de útil.");
                        }
                    } else if(cenarioAtual == portaoMagico) {
                        System.out.println("Você deseja (1) Tentar resolver o enigma ou (2) Voltar?");
                        String escolhaPortao = scanner.nextLine().trim().toLowerCase();
                        if(escolhaPortao.equals("1")) {
                            cenarioAtual = iniciarMinigameEnigma(scanner);
                            escolhaValida = true;
                        } else if(escolhaPortao.equals("2") || escolhaPortao.equals("Voltar")) {
                            cenarioAtual = tunelDosTesouros;
                            escolhaValida = true;
                        } else {
                            System.out.println("Escolha inválida.");
                        }
                    } else if (cenarioAtual != null && cenarioAtual.getDescricao().equals("Você não conseguiu decifrar o enigma do portão mágico.")) {
                        System.out.println("Você deseja (1) Tentar resolver o enigma ou (2) Voltar?");
                        String escolhaRepetirEnigma = scanner.nextLine().trim().toLowerCase();
                        if(escolhaRepetirEnigma.equals("1") || escolhaRepetirEnigma.equals("tentar novamente")) {
                            cenarioAtual = iniciarMinigameEnigma(scanner);
                        } else if(escolhaRepetirEnigma.equals("2") || escolhaRepetirEnigma.equals("voltar")) {
                            cenarioAtual = tunelDosTesouros;
                        } else {
                            escolhaValida = true;
                        }
                    }
                } else if(escolhaNumerica == escolhasDisponiveis.size() + 1) {
                    System.out.println("\n--- Inventário ---");
                    if(inventario.isEmpty()) {
                        System.out.println("Seu inventário está vazio.");
                    } else {
                        for(String item : inventario) {
                            System.out.println("- " + item);
                        }
                    }
                    System.out.println("------------------");
                    escolhaValida = true;
                }else {
                    for (int i = 0; i < escolhasDisponiveis.size(); i++) {
                        Escolha escolha = escolhasDisponiveis.get(i);
                        if(escolha.getTipo().equals(Escolha.TIPO_SIM_NAO)) {
                            if(entradaJogador.equals("sim") || entradaJogador.equals("não")) {
                                if((entradaJogador.equals("sim") && escolha.getTexto().toLowerCase().contains("sim")) ||
                                   (entradaJogador.equals("não") && escolha.getTexto().toLowerCase().contains("não"))) {
                                    cenarioAtual = escolha.getProximoCenario();
                                    escolhaValida = true;
                                    break;
                                }
                            }
                        }else if(escolha.getTipo().equals(Escolha.TIPO_PEGAR_LARGAR)) {
                            if(entradaJogador.equals("pegar") || entradaJogador.equals("largar")) {
                                if((entradaJogador.equals("pegar") && escolha.getTexto().toLowerCase().contains("pegar")) ||
                                   (entradaJogador.equals("largar") && escolha.getTexto().toLowerCase().contains("largar"))) {
                                    cenarioAtual = escolha.getProximoCenario();
                                    escolhaValida = true;
                                    break;
                                }
                            }
                        }else if(escolha.getTipo().equals(Escolha.TIPO_VOLTAR_SEGUIR)) {
                            if(entradaJogador.equals("voltar") || entradaJogador.equals("seguir")) {
                                if((entradaJogador.equals("voltar") && escolha.getTexto().toLowerCase().contains("voltar")) ||
                                   (entradaJogador.equals("seguir") && escolha.getTexto().toLowerCase().contains("seguir"))) {
                                    cenarioAtual = escolha.getProximoCenario();
                                    escolhaValida = true;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(!escolhaValida) {
                    System.out.println("Entrada inválida. Por favor, tente novamente.");
                }

                if(membrosDoGrupoVivos <= 0) {
                    cenarioAtual = new Cenario("Você perdeu todos os membros do grupo");
                }
            }
        }

        System.out.println("\nFim da aventura!");
        scanner.close();
    }

    public static void modificarMembrosDoGrupo(int modificacao) {
        membrosDoGrupoVivos += modificacao;
        if(membrosDoGrupoVivos < 0) {
            membrosDoGrupoVivos = 0;
        }
    }


    public static int getMembrosDoGrupoVivos() {
        return membrosDoGrupoVivos;
    }

    public static String sortearItem() {
        String[] itensPossiveis = {"Chave enferrujada de prata", "Mapa Antigo", "Tocha encantada", "Capa de invisibilidade", "Pendulo mágico", "Poção de congelamento", "Dado da sorte", null};
        int indiceSorteado = random.nextInt(itensPossiveis.length);
        return itensPossiveis[indiceSorteado];
    }

    public static Cenario usarDadoSorteMonstro(Scanner scanner, Cenario quedaDasPedras) {
        System.out.println("\nVocê decide usar o Dado da sorte contra o monstro.");
        System.out.println("O que você deseja que o Dado da sorte faça?");
        System.out.println("(1) Revelar um caminho mais seguro para evitar o monstro.");
        System.out.println("(2) Garantir sua vitória caso decida enfrentar o monstro");
        System.out.println("Digite sua escolha: ");
        String escolhaDadoStr = scanner.nextLine().trim();

        try {
            int escolhaDado = Integer.parseInt(escolhaDadoStr);
            if(escolhaDado == 1) {
                System.out.println("O Dado da sorte revela um caminho seguro! Você evita o confronto.");
                inventario.remove("Dado da sorte");
                return new Cenario("Você encontrou um caminho seguro e evitou o monstro.");
                passouMonstroDado.adicionarEscolha("Seguir adiante", quedaDasPedra, Escolha.TIPO_NUMERICO);
                return passouMonstroDado;
            } else if(escolhaDado == 2) {
                System.out.println("Você sente uma sorte incrível! Sua vitória no confronto será garantida.");
                inventario.remove("Dado da sorte");
                return iniciarMinigameMonstroVitoria(scanner, quedaDasPedras);
            } else {
                System.out.println("Escolha inválida. O Dado da sorte não foi usado.");
                return new Cenario("O monstro ainda bloqueia o caminho.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. O Dado da sorte não foi usado.");
            return new Cenario("O monstro ainda bloqueia o caminho");
        }
    }

    public static Cenario iniciarMinigameMonstroVitoria(Scanner scanner, Cenario quedaDasPedras) {
        System.out.println("\nCom a sorte do Dado, o monstro parece confuso e cai derrotado!");
        Cenario cenarioVitoriaDado = new Cenario("Você derrotou o monstro com a ajuda do Dado da sorte!");
        cenarioVitoriaDado.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
        return cenarioVitoriaDado;
    }

    public static Cenario iniciarMinigameMonstro(Scanner scanner, Cenario quedaDasPedras) {
        int jogadorRoundsVencidos = 0;
        int monstroRoundsVencidos = 0;

        System.out.println("\nVocê decide enfrentear o monstro!");

        while (jogadorRoundsVencidos < 2 && monstroRoundsVencidos < 2) {
            System.out.println("\n--- Round " + (jogadorRoundsVencidos + monstroRoundsVencidos + 1) + " ---");
            System.out.println("Escolha : (1) Atacar ou (2) Defender");
            System.out.println("Sua escolha: ");
            String jogadorEscolhaStr = scanner.nextLine().trim().toLowerCase();
            String jogadorEscolha = "";
            if(jogadorEscolhaStr.equals("1") || jogadorEscolhaStr.equals("atacar")) {
                jogadorEscolha = "atacar";
            } else if (jogadorEscolhaStr.equals("2") || jogadorEscolhaStr.equals("defender")) {
                jogadorEscolha = "defender";
            } else {
                System.out.println("Escolha inválida. Você perdeu este round.");
                monstroRoundsVencidos++;
                continue;
            }

            String monstroEscolha = random.nextInt() < 0.5 ? "atacar" : "defender";
            System.out.println("Monstro escolheu: " + monstroEscolha);

            int numeroSorteado = random.nextInt(10);
            System.out.println("Número sorteado: " + numeroSorteado);

            if(numeroSorteado % 2 == 0) {
                if(jogadorEscolha.equals("atacar") && monstroEscolha.equals("defender")) {
                    System.out.println("Seu ataque foi bem-sucedido!");
                    jogadorRoundsVencidos++;
                }else if (jogadorEscolha.equals("defender") && monstroEscolha.equals("atacar")) {
                    System.out.println("O ataque do monstro foi defendido.");
                }else if (jogadorEscolha.equals("atacar") && monstroEscolha.equals("atacar")) {
                    System.out.println("Ambos atacaram! Empate neste round.");
                }else if (jogadorEscolha.equals("defender") && monstroEscolha.equals("defender")) {
                    System.out.println("Ambos defenderam.");
                }
            } else {
                if(jogadorEscolha.equals("defender") && monstroEscolha.equals("atacar")) {
                    System.out.println("Você defendeu com sucesso!");
                    jogadorRoundsVencidos++;
                }else if (jogadorEscolha.equals("atacar") && monstroEscolha.equals("defender")) {
                    System.out.println("O monstro defendeu o seu ataque");
                }else if (jogadorEscolha.equals("defender") && monstroEscolha.equals("defender")) {
                    System.out.println("Ambos defenderam! Empate neste round.");
                }else if (jogadorEscolha.equals("atacar") && monstroEscolha.equals("atacar")) {
                    System.out.println("Ambos atacaram.");
                }
            }

            System.out.println("Placar: Você " + jogadorRoundsVencidos + " - Monstro " + monstroRoundsVencidos);
        }

        if(jogadorRoundsVencidos >= 2) {
            System.out.println("\nVocê derrotou o monstro!");
            Cenario cenarioVitoriaMonstro = new Cenario("Após uma batalha intensa, o monstro foi derrotado.");
            cenarioVitoriaMonstro.adicionarEscolha("Seguir adiante", quedaDasPedras, Escolha.TIPO_NUMERICO);
            return cenarioVitoriaMonstro;
        } else {
            System.out.println("\nVocê foi derrotado pelo monstro!");
            modificarMembrosDoGrupo(-1);
            return new Cenario("Você não conseguiu derrotar o monstro e se separoudo seu grupo, tendo que seguir por outro caminho.");
        }
    }

    public static Cenario iniciarMinigameEnigma(Scanner scanner) {
        String[] enigmas = {
            "O que tem olhos mas não pode ver?",
            "O que é cheio de buracos mas ainda segura água?",
            "O que sempre vem, mas nunca chega?",
            "O que é mais útil quando quebrado?",
            "O que tem cidades, mas não casas, florestas, mas não árvores e água, mas não peixes?",
            "O que quanto mais você tira, maior fica?"
        };
        String[] respostas = {"agulha", "esponja", "amanhã", "ovo", "mapa", "buraco"};
        int indiceEnigmaSorteado = random.nextInt(enigmas.length);
        String enigma = enigmas[indiceEnigmaSorteado];
        String respostaCorreta = respostas[indiceEnigmaSorteado].toLowerCase();
        int tentativas = 0;
        boolean acertou = false;

        System.out.println("\n" + enigma);

        while (tentativas < 3 && !acertou) {
            System.out.println("Sua resposta: ");
            String respostaJogador = scanner.nextLine().trim().toLowerCase();

            if(respostaJogador.equals(respostaCorreta)) {
                System.out.println("Resposta correta! O portão se abre");
                acertou = true;
                return new Cenario("O portão mágico se abre com um estrondo, revelando o caminho adiante.");
            } else {
                tentativas++;
                System.out.println("Resposta incorreta. Você tem mais " + (3 - tentativas) + " tentativas.");
            }
        }

        System.out.println("Você não conseguiu decifrar o enigma.");
        return new Cenario("Você não conseguiu decifrar o enigma do portão mágico.");
    }
}
