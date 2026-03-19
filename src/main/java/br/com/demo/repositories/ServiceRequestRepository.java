package br.com.demo.repositories;

import br.com.demo.models.ServiceRequestModel;
import org.json.simple.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ServiceRequestRepository {
    private final List<JSONObject> serviceRequests;

    public ServiceRequestRepository() {
        this.serviceRequests = new ArrayList<>();
    }

    public List<JSONObject> getServiceRequestsRepository() {
        return this.serviceRequests;
    }

    public Boolean alreadyAdded(Integer id) {
        for (JSONObject request : this.serviceRequests) {
            if (request.get("id").equals(id)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public void save(ServiceRequestModel serviceRequest) throws IllegalArgumentException {
        if (serviceRequest.getId() == null) {
            throw new IllegalArgumentException("A solicitação de serviço deve ter obrigatoriamente um ID");
        }

        if (alreadyAdded(serviceRequest.getId())) {
            throw new IllegalArgumentException(
                    "Uma solicitação de serviço com esse ID já foi adicionada: " + serviceRequest.getId()
            );
        }

        JSONObject newServiceRequest = new JSONObject();
        newServiceRequest.put("id", serviceRequest.getId());
        newServiceRequest.put("description", serviceRequest.getDescription());
        newServiceRequest.put("category", serviceRequest.getCategory());
        newServiceRequest.put("priority", serviceRequest.getPriority());
        newServiceRequest.put("location", serviceRequest.getLocation());
        newServiceRequest.put("history", serviceRequest.getHistory());

        this.serviceRequests.add(newServiceRequest);
    }

    public void removeById(Integer id) {
        this.serviceRequests.removeIf(request -> request.get("id").equals(id));
    }

    public List<JSONObject> getServiceRequests() {
        return this.serviceRequests;
    }
}
