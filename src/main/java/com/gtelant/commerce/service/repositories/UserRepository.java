package com.gtelant.commerce.service.repositories;

import com.gtelant.commerce.service.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer>, JpaSpecificationExecutor<User> {
    Page<User> findByFirstNameOrLastNameOrHasNewsletterAllIgnoreCase(String firstName, String lastName, boolean hasNewsletter, Pageable pageable);
}
