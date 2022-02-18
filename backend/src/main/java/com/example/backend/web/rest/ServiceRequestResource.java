package com.example.backend.web.rest;

import com.example.backend.model.ServiceRequest;
import com.example.backend.model.dto.AnswerServiceRequestDto;
import com.example.backend.model.dto.ServiceRequestDto;
import com.example.backend.model.dto.UsernameDto;
import com.example.backend.service.ServiceRequestService;
import org.springframework.web.bind.annotation.*;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/service-request")
@CrossOrigin("http://localhost:8080")
public class ServiceRequestResource {

    private final ServiceRequestService serviceRequestService;

    public ServiceRequestResource(ServiceRequestService serviceRequestService) {
        this.serviceRequestService = serviceRequestService;
    }

    @GetMapping
    public List<ServiceRequest> listAllUnAnsweredServiceRequests() {
        return serviceRequestService.listAllUnAnsweredServiceRequests();
    }

    @PostMapping("/list-by-user")
    public List<ServiceRequest> listAllServiceRequestsByUsername(@RequestBody UsernameDto usernameDto) {
        return serviceRequestService.listAllServiceRequestsByUsername(usernameDto);
    }

    @PostMapping("/add-service-request")
    public Optional<ServiceRequest> addServiceRequest(@RequestBody ServiceRequestDto serviceRequestDto) {
        return serviceRequestService.addServiceRequest(serviceRequestDto);
    }

    @PostMapping("/edit-service-request/{id}")
    public Optional<ServiceRequest> editServiceRequest(@RequestBody ServiceRequestDto serviceRequestDto,
                                                       @PathVariable Long id) {
        return serviceRequestService.editServiceRequest(serviceRequestDto, id);
    }

    @DeleteMapping("/delete-service-request/{id}")
    public void deleteServiceRequest(@PathVariable Long id) {
        serviceRequestService.deleteServiceRequest(id);
    }

    @PostMapping("/answer-service-request/{id}")
    public Optional<ServiceRequest> addAnswerOnService(@RequestBody AnswerServiceRequestDto answerServiceRequestDto, @PathVariable Long id) {
        return serviceRequestService.answerServiceRequest(answerServiceRequestDto, id);
    }
}
