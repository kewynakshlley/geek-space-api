package com.ufpb.geekspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufpb.geekspace.model.Client;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
