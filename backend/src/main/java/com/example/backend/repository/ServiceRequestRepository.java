package com.example.backend.repository;

import com.example.backend.model.ServiceRequest;
import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    @Query(value = "SELECT * " +
            "FROM service_request s " +
            "WHERE s.answer = NULL",
            nativeQuery = true)
    List<ServiceRequest> findAllServiceRequestsWithoutAnswer();
    @Query(value = "SELECT * " +
            "FROM ServiceRequest s " +
            "WHERE s.user.username = :username",
            nativeQuery = true)
    List<ServiceRequest> findAllServiceRequestsByUser_Username(String username);
    List<ServiceRequest> findAllByUser(User user);
}
