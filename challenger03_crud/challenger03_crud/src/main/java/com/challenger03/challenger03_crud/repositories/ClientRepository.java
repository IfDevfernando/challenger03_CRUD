package com.challenger03.challenger03_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenger03.challenger03_crud.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
