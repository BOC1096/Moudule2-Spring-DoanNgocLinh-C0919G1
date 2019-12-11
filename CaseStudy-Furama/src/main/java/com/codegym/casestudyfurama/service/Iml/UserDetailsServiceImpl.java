package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.AppUser;
import com.codegym.casestudyfurama.repo.AppRoleRepository;
import com.codegym.casestudyfurama.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUserName(user);
        if (appUser == null) {
            System.out.println("User not found! " + user);
            throw new UsernameNotFoundException("User " + user + " was not found in the database");
        }
        System.out.println("Found User: " + appUser);
        List<String> roleNames = appRoleRepository.getRoleName(appUser.getId());
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(appUser.getUserName(), appUser.getEncrytedPassword(), grantList);
        return userDetails;
    }

}
