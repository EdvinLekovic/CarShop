package com.example.backend.service;

import com.example.backend.model.ServiceRequest;
import com.example.backend.model.dto.AnswerServiceRequestDto;
import com.example.backend.model.dto.ServiceRequestDto;
import com.example.backend.model.dto.UsernameDto;

import java.util.List;
import java.util.Optional;

public interface ServiceRequestService {
    List<ServiceRequest> listAllUnAnsweredServiceRequests();
    List<ServiceRequest> listAllServiceRequestsByUsername(UsernameDto usernameDto);
    Optional<ServiceRequest> addServiceRequest(ServiceRequestDto serviceRequestDto);

    Optional<ServiceRequest> editServiceRequest(ServiceRequestDto serviceRequestDto,Long id);

    void deleteServiceRequest(Long id);

    Optional<ServiceRequest> answerServiceRequest(AnswerServiceRequestDto answerServiceRequestDto, Long id);
}
