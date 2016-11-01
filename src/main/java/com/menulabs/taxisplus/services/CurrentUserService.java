package com.menulabs.taxisplus.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.menulabs.taxisplus.domain.Role;
import com.menulabs.taxisplus.domain.dto.CurrentUser;

@Service
public class CurrentUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

    public boolean canAccessUser(CurrentUser currentUser, Long userId) {
        LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
        return currentUser != null
                && (currentUser.getRole() == Role.ADMINCAPTURER || currentUser.getId().equals(userId));
    }

}
