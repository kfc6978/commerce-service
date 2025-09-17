package com.gtelant.commerce.service.responses;


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
    private LocalDate birthday;
    private LocalDateTime lastSeenAt;
    private boolean hasNewsletter;
    private List<UserSegment> userSegments;

}
