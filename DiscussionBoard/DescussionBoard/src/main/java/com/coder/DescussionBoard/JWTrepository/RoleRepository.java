package com.coder.DescussionBoard.JWTrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.DescussionBoard.JWTmodel.Role;
import com.coder.DescussionBoard.JWTmodel.RoleName;
  
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}