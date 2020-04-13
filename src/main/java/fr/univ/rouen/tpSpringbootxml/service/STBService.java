package fr.univ.rouen.tpSpringbootxml.service;

import java.util.List;

import fr.univ.rouen.tpSpringbootxml.entity.STB;


public interface STBService {
    List<STB>  findAll();
    STB findById(Integer id);
    STB addNewStb(STB stb);
    Integer deleteStb( STB stb);
}
