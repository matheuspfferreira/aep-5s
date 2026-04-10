import br.com.demo.models.IdentifiedServiceRequestModel;
import br.com.demo.models.ServiceRequestModel;
import br.com.demo.models.enums.ServiceCategory;
import br.com.demo.models.enums.ServicePriority;
import br.com.demo.repositories.ServiceRequestRepository;
import br.com.demo.services.ServiceRequestService;
import org.json.simple.JSONObject;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos as camadas (Injeção de Dependência Manual)
        ServiceRequestRepository repository = new ServiceRequestRepository();
        ServiceRequestService service = new ServiceRequestService(repository);
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- CIVITAS: MENU PRINCIPAL ---");
            System.out.println("1. Registrar nova solicitação");
            System.out.println("2. Listar todas as solicitações (JSON)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            // Tratamento básico para evitar que o programa quebre se não for número
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido.");
                continue;
            }

            switch (opcao) {
                case 1:
                    // --- PENDÊNCIA 1: FORMULÁRIO ---
                    System.out.println("\n--- FORMULÁRIO DE SOLICITAÇÃO ---");

                    System.out.print("Digite a descrição do problema: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite a localização/endereço: ");
                    String localizacao = scanner.nextLine();

                    System.out.println("Escolha a Categoria: (1) Saúde (2) Iluminação (3) Pavimentação (4) Segurança");
                    int catInput = Integer.parseInt(scanner.nextLine());
                    ServiceCategory categoria = switch (catInput) {
                        case 2 -> ServiceCategory.LIGHTING;
                        case 3 -> ServiceCategory.FLOORING;
                        case 4 -> ServiceCategory.SCHOOL_SAFETY;
                        default -> ServiceCategory.HEALTH;
                    };

                    // Gerando um ID aleatório para o exemplo acadêmico
                    int idAleatorio = (int) (Math.random() * 10000);

                    // Criando o modelo
                    ServiceRequestModel novaSolicitacao = new IdentifiedServiceRequestModel(
                            idAleatorio, descricao, categoria, ServicePriority.MEDIUM, localizacao
                    );

                    // Salvando via Service
                    service.saveRequest(novaSolicitacao);
                    System.out.println("\n✅ Sucesso! Solicitação registrada com ID: " + idAleatorio);
                    break;

                case 2:
                    // --- PENDÊNCIA 2: LISTAGEM ---
                    System.out.println("\n--- LISTA DE SOLICITAÇÕES CADASTRADAS ---");
                    List<JSONObject> registros = service.getAllRequests();

                    if (registros.isEmpty()) {
                        System.out.println("Nenhuma solicitação encontrada no sistema.");
                    } else {
                        for (JSONObject json : registros) {
                            System.out.println("------------------------------------");
                            System.out.println("ID: " + json.get("id"));
                            System.out.println("DESCRIÇÃO: " + json.get("description"));
                            System.out.println("LOCAL: " + json.get("location"));
                            System.out.println("CATEGORIA: " + json.get("category"));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o Civitas. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}