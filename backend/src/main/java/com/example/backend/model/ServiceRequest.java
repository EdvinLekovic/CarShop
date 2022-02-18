package com.example.backend.model;

import com.example.backend.model.enums.ServiceStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String serviceType;

    private ServiceStatus serviceStatus;

    private String description;

    private String answer;

    public ServiceRequest(User user, String serviceType, String description) {
        this.user = user;
        this.serviceType = serviceType;
        this.description = description;
        this.answer = null;
        this.serviceStatus = ServiceStatus.IN_REVIEW;
    }

    public ServiceRequest() {
    }
}
