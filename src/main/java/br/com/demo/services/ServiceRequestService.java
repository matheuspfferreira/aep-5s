package br.com.demo.services;

import br.com.demo.models.ServiceRequestModel;
import br.com.demo.models.interfaces.ServiceRequestType;
import br.com.demo.repositories.ServiceRequestRepository;
import org.json.simple.JSONObject;

import java.util.List;

public class ServiceRequestService {
    private final ServiceRequestRepository repository;

    public ServiceRequestService(ServiceRequestRepository repository) {
        this.repository = repository;
    }

    public void saveRequest(ServiceRequestModel model) {
        try {
            this.repository.save(model);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro de validação: " + e.getMessage());
        }
    }

    public List<JSONObject> getAllRequests() {
        return this.repository.getServiceRequests();
    }

    public Boolean sendServiceRequest(ServiceRequestType serviceRequestType) {
        return serviceRequestType.sendServiceRequest();
    }
}