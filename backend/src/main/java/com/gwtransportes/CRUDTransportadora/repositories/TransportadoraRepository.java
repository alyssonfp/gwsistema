package com.gwtransportes.CRUDTransportadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gwtransportes.CRUDTransportadora.entities.Transportadora;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {

}
