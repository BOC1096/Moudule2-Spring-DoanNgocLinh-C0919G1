package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.AppUser;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

@Service
public interface UserService {
    AppUser getUser(String userName);
}
