package com.gtelant.commerce.service.dtos;


import com.gtelant.commerce.service.models.UserSegment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String address;
    private String city;
    private String zipcode;
    private String role;
    private LocalDateTime lastSeenAt;
    private boolean hasNewsletter;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private List<UserSegmentResponse> userSegments;
}
