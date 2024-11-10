package com.toni.apiUsers.repositories;

import com.toni.apiUsers.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepository extends JpaRepository<UserModel, Integer> { }
