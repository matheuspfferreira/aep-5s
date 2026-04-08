package br.com.demo.services;

import br.com.demo.models.ServiceRequestModel;
import br.com.demo.models.interfaces.ServiceRequestType;
import br.com.demo.repositories.ServiceRequestRepository;
import org.json.simple.JSONObject;

import java.util.List;

public class ServiceRequestService {
    // 1. Criamos um atributo para o repositório
    private final ServiceRequestRepository repository;

    // 2. Criamos o CONSTRUTOR para aceitar o repositório (Resolve o erro do "repository" vermelho no Main)
    public ServiceRequestService(ServiceRequestRepository repository) {
        this.repository = repository;
    }

    // 3. Criamos o método saveRequest (Resolve o erro do "saveRequest" vermelho no Main)
    public void saveRequest(ServiceRequestModel model) {
        try {
            this.repository.save(model);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }
    }

    // 4. Criamos o método getAllRequests (Resolve o erro do "getAllRequests" vermelho no Main)
    public List<JSONObject> getAllRequests() {
        return this.repository.getServiceRequests();
    }

    // Método que você já tinha (removi o static para ele usar o repositório da instância)
    public Boolean sendServiceRequest(ServiceRequestType serviceRequestType) {
        return serviceRequestType.sendServiceRequest();
    }
}