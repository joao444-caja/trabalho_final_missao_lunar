
package br.unochapeco.missoes.view;

import br.unochapeco.missoes.model.Astronauta;
import br.unochapeco.missoes.model.Missao;
import br.unochapeco.missoes.model.Nave;
import br.unochapeco.missoes.model.NaveCargueira;
import br.unochapeco.missoes.model.NaveTripulada;
import br.unochapeco.missoes.repository.BinRepository;
import br.unochapeco.missoes.repository.NitriteRepository;
import br.unochapeco.missoes.repository.MissaoRepository;
import br.unochapeco.missoes.service.MissionService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DATA_DIR = "data";
    private static final String BIN_FILE = DATA_DIR + "/missions.bin";
    private static final String NITRITE_FILE = DATA_DIR + "/nitrite.db";

    public static void main(String[] args) throws Exception {
        new java.io.File(DATA_DIR).mkdirs();
        MissaoRepository binRepo = new BinRepository(BIN_FILE);
        MissaoRepository nitRepo = new NitriteRepository(NITRITE_FILE);
        MissionService service = new MissionService(binRepo, nitRepo);

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("\n=== Sistema Lunar - Menu ===");
            System.out.println("1. Cadastrar missão");
            System.out.println("2. Listar missões");
            System.out.println("3. Buscar missão por código");
            System.out.println("4. Registrar resultado científico");
            System.out.println("5. Adicionar astronauta a missão");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");
            String opt = sc.nextLine().trim();
            try {
                switch(opt) {
                    case "1": cadastrarMissao(sc, service); break;
                    case "2": listarMissoes(service); break;
                    case "3": buscarMissao(sc, service); break;
                    case "4": registrarResultado(sc, service); break;
                    case "5": adicionarAstronauta(sc, service); break;
                    case "6": running = false; break;
                    default: System.out.println("Opção inválida");
                }
            } catch(Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        service.fechar();
        sc.close();
        System.out.println("Encerrado.");
    }

    private static void cadastrarMissao(Scanner sc, MissionService service) throws Exception {
        System.out.print("Código: "); String codigo = sc.nextLine().trim();
        System.out.print("Nome: "); String nome = sc.nextLine().trim();
        System.out.print("Data lançamento (YYYY-MM-DD): "); LocalDate lanc = LocalDate.parse(sc.nextLine().trim());
        System.out.print("Data retorno (YYYY-MM-DD): "); LocalDate ret = LocalDate.parse(sc.nextLine().trim());
        System.out.print("Destino: "); String destino = sc.nextLine().trim();
        System.out.print("Objetivo: "); String objetivo = sc.nextLine().trim();

        System.out.print("Tipo de nave (1=tripulada,2=cargueira): "); String t = sc.nextLine().trim();
        System.out.print("Nome da nave: "); String nomeNave = sc.nextLine().trim();
        System.out.print("Capacidade (nº tripulantes): "); int cap = Integer.parseInt(sc.nextLine().trim());
        Nave nave = t.equals("1") ? new NaveTripulada(nomeNave, cap) : new NaveCargueira(nomeNave, cap);

        Missao m = new Missao(codigo, nome, lanc, ret, destino, objetivo, nave);
        // opcional: adicionar astronautas agora?
        System.out.print("Deseja adicionar astronautas agora? (s/n): "); String add = sc.nextLine().trim();
        while(add.equalsIgnoreCase("s")) {
            System.out.print("Nome astronauta: "); String nomeA = sc.nextLine().trim();
            System.out.print("Idade: "); int idade = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Especialidade: "); String esp = sc.nextLine().trim();
            System.out.print("Horas de voo: "); int horas = Integer.parseInt(sc.nextLine().trim());
            m.adicionarAstronauta(new Astronauta(nomeA, idade, esp, horas));
            System.out.print("Adicionar outro? (s/n): "); add = sc.nextLine().trim();
        }

        service.salvarMissao(m);
        System.out.println("Missão salva nas duas formas de persistência.");
    }

    private static void listarMissoes(MissionService service) throws Exception {
        List<Missao> todas = service.listar();
        if (todas.isEmpty()) {
            System.out.println("Nenhuma missão cadastrada.");
            return;
        }
        for (Missao m : todas) {
            System.out.println(m);
            System.out.println("Tripulantes:");
            m.getTripulantes().forEach(a -> System.out.println("  - " + a));
            System.out.println("Duração (dias): " + m.duracaoDias());
            System.out.println("-------------------------");
        }
    }

    private static void buscarMissao(Scanner sc, MissionService service) throws Exception {
        System.out.print("Código: "); String cod = sc.nextLine().trim();
        Missao m = service.buscar(cod);
        if (m == null) System.out.println("Missão não encontrada.");
        else {
            System.out.println(m);
            m.getTripulantes().forEach(a -> System.out.println("  - " + a));
        }
    }

    private static void registrarResultado(Scanner sc, MissionService service) throws Exception {
        System.out.print("Código da missão: "); String cod = sc.nextLine().trim();
        System.out.print("Resultado científico (texto): "); String res = sc.nextLine().trim();
        service.registrarResultado(cod, res);
        System.out.println("Resultado registrado.");
    }

    private static void adicionarAstronauta(Scanner sc, MissionService service) throws Exception {
        System.out.print("Código da missão: "); String cod = sc.nextLine().trim();
        Missao m = service.buscar(cod);
        if (m == null) { System.out.println("Missão não encontrada"); return; }
        System.out.print("Nome astronauta: "); String nomeA = sc.nextLine().trim();
        System.out.print("Idade: "); int idade = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Especialidade: "); String esp = sc.nextLine().trim();
        System.out.print("Horas de voo: "); int horas = Integer.parseInt(sc.nextLine().trim());
        if (idade < 21) { System.out.println("Astronauta deve ter pelo menos 21 anos."); return; }
        if (m.getTripulantes().size() + 1 > m.getNave().getCapacidade()) {
            System.out.println("Não há capacidade na nave para este astronauta."); return;
        }
        m.adicionarAstronauta(new Astronauta(nomeA, idade, esp, horas));
        // salvar alterações
        service.salvarMissao(m);
        System.out.println("Astronauta adicionado e missão atualizada.");
    }
}
