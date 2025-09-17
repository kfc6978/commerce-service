package com.gtelant.commerce.service.mappers;

import com.gtelant.commerce.service.dtos.UserRequest;
import com.gtelant.commerce.service.dtos.UserSegmentResponse;
import com.gtelant.commerce.service.models.User;
import com.gtelant.commerce.service.dtos.UserResponse;
import com.gtelant.commerce.service.models.UserSegment;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

//拿來收集和user相關的class
@Component
public class UserMapper {

    public UserResponse toUserResponse(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setBirthday(user.getBirthday());
        dto.setAddress(user.getAddress());
        dto.setCity(user.getCity());
        dto.setZipcode(user.getZipcode());
        dto.setRole(user.getRole());
        dto.setHasNewsletter(user.isHasNewsletter());
        dto.setLastSeenAt(user.getLastSeenAt());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setDeletedAt(user.getDeletedAt());
        if (user.getUserSegments() != null) {
            dto.setUserSegments(user.getUserSegments().stream()
                    .map(this::toUserSegmentResponse)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public User toUser(UserRequest dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setBirthday(dto.getBirthday());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setZipcode(dto.getZipcode());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setHasNewsletter(dto.isHasNewsletter());
        return user;
    }

    public UserSegmentResponse toUserSegmentResponse(UserSegment userSegment) {
        UserSegmentResponse dto = new UserSegmentResponse();
        dto.setId(userSegment.getId());
        dto.setUserId(userSegment.getUser().getId());
        dto.setSegmentId(userSegment.getSegment().getId());
        dto.setName(userSegment.getSegment().getTag());
        return dto;
    }
}