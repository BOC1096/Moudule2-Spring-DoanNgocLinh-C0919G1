package com.codegym.casestudyfurama.repo;

import com.codegym.casestudyfurama.entity.AppRole;
import com.codegym.casestudyfurama.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppRoleRepository extends JpaRepository<UserRole, Long> {
    @Query("select ur.appRole.nameRole from UserRole ur where ur.appUser.id = ?1")
    List<String> getRoleName(Long userId);
}
