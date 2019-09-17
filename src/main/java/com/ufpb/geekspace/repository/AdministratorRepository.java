package com.ufpb.geekspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
	Administrator findByEmailAndPassword(String email, String password);

}
