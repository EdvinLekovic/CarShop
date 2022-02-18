package com.example.backend.service.impl;

import com.example.backend.model.ServiceRequest;
import com.example.backend.model.User;
import com.example.backend.model.dto.AnswerServiceRequestDto;
import com.example.backend.model.dto.ServiceRequestDto;
import com.example.backend.model.dto.UsernameDto;
import com.example.backend.model.enums.ServiceStatus;
import com.example.backend.repository.ServiceRequestRepository;
import com.example.backend.service.ServiceRequestService;
import com.example.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceRequestImpl implements ServiceRequestService {

    private final ServiceRequestRepository serviceRequestRepository;
    private final UserService userService;

    public ServiceRequestImpl(ServiceRequestRepository serviceRequestRepository, UserService userService) {
        this.serviceRequestRepository = serviceRequestRepository;
        this.userService = userService;
    }

    @Override
    public List<ServiceRequest> listAllUnAnsweredServiceRequests() {
        return serviceRequestRepository.findAll()
                .stream()
                .filter(service -> service.getAnswer() == null)
                .collect(Collectors.toList());
    }

    @Override
    public List<ServiceRequest> listAllServiceRequestsByUsername(UsernameDto usernameDto) {
        Optional<User> user = userService.findUserByUsername(usernameDto.getUsername());
        if (user.isEmpty()) {
            return new ArrayList<>();
        }
        return serviceRequestRepository.findAllByUser(user.get());
    }

    @Override
    public Optional<ServiceRequest> addServiceRequest(ServiceRequestDto serviceRequestDto) {
        User user = userService.findUserByUsername(serviceRequestDto.getUsernameDto().getUsername()).orElseThrow();
        ServiceRequest serviceRequest = new ServiceRequest(user,
                serviceRequestDto.getServiceType(),
                serviceRequestDto.getDescription());
        return Optional.of(serviceRequestRepository.save(serviceRequest));
    }

    @Override
    public Optional<ServiceRequest> editServiceRequest(ServiceRequestDto serviceRequestDto, Long id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow();
        serviceRequest.setDescription(serviceRequestDto.getDescription());
        return Optional.of(serviceRequestRepository.save(serviceRequest));
    }

    @Override
    public void deleteServiceRequest(Long id) {
        serviceRequestRepository.deleteById(id);
    }

    @Override
    public Optional<ServiceRequest> answerServiceRequest(AnswerServiceRequestDto answerServiceRequestDto, Long id) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow();
        serviceRequest.setAnswer(answerServiceRequestDto.getAnswer());
        serviceRequest.setServiceStatus(ServiceStatus.DONE);
        return Optional.of(serviceRequestRepository.save(serviceRequest));
    }
}
