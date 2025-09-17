package com.gtelant.commerce.service.responses;

import com.gtelant.commerce.service.models.UserSegment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String address;
    private String city;
    private String zipcode;
    private String password;
    private boolean hasNewsletter;
}
