package fr.univ.rouen.tpSpringbootxml.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.univ.rouen.tpSpringbootxml.entity.STB;

@Repository
public interface STBRepository extends JpaRepository<STB,Integer> {
}
