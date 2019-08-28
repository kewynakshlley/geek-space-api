package com.ufpb.geekspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
