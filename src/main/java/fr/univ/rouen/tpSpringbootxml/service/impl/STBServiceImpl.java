package fr.univ.rouen.tpSpringbootxml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ.rouen.tpSpringbootxml.entity.STB;
import fr.univ.rouen.tpSpringbootxml.repository.STBRepository;
import fr.univ.rouen.tpSpringbootxml.service.STBService;

import java.util.List;
@Service
public class STBServiceImpl implements STBService {

    @Autowired
    private STBRepository stbRepository;


    @Override
    public List<STB> findAll() {
        return this.stbRepository.findAll();
    }

    @Override
    public STB findById(Integer id) {
        return this.stbRepository.findById(id).orElse(null);
    }

    @Override
    public STB addNewStb(STB stb) {
        return this.stbRepository.save(stb);
    }

    @Override
    public Integer deleteStb(STB stb) {
         this.stbRepository.delete(stb);
        return stb.getId();
    }
}
