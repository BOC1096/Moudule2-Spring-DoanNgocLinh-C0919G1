package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.AppUser;
import com.codegym.casestudyfurama.repo.AppUserRepository;
import com.codegym.casestudyfurama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIml implements UserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public AppUser getUser(String userName) {
        return appUserRepository.findByUserName(userName);
    }
}
