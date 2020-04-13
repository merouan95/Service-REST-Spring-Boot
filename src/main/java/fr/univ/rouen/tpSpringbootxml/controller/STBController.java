package fr.univ.rouen.tpSpringbootxml.controller;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.univ.rouen.tpSpringbootxml.entity.ErrorModel;
import fr.univ.rouen.tpSpringbootxml.entity.ListSTB;
import fr.univ.rouen.tpSpringbootxml.entity.STB;
import fr.univ.rouen.tpSpringbootxml.service.STBService;
import fr.univ.rouen.tpSpringbootxml.util.MyValue;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class STBController {

    @Autowired
    private STBService stbService;


    @RequestMapping(value = "/",method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getIndexPage() throws IOException {
        Document doc = Jsoup.parse(new File("src/main/resources/static/index.html"), "utf-8");
        return  new ResponseEntity<String>(doc.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/help",method = RequestMethod.GET,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getHelpPage() throws IOException {
        Document doc = Jsoup.parse(new File("src/main/resources/static/helpPage.html"), "utf-8");
        return  new ResponseEntity<String>(doc.toString(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/resume",method = RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
    public ListSTB findAll() {
       List<STB> tempList = this.stbService.findAll();
       return  new ListSTB(tempList);
    }


    @RequestMapping(value = "/stb",method = RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
    public Object findById(@RequestParam("id") Integer id) {

        STB stb = this.stbService.findById(id);
        if(stb==null){
            return new ErrorModel(id, MyValue.ERROR,MyValue.NOT_FOUND_MESSAGE);
        }
        return stb;
    }


    @RequestMapping(value = "/htmlstb",method = RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
    public Object findHtmlById(@RequestParam("id") Integer id) throws IOException {
        STB stb = this.stbService.findById(id);
        if(stb==null){
            return new ErrorModel(id, MyValue.ERROR,MyValue.NOT_FOUND_MESSAGE);
        }
        Document doc = Jsoup.parse(new File("src/main/resources/static/stb.html"), "utf-8");
        return  doc.toString().replace(":idStb",""+stb.getId())
                              .replace(":titleStb",stb.getTitle())
                               .replace(":dateStb",stb.getDate())
                                .replace(":descripStb",stb.getDescr());
    }

    @RequestMapping(value = "/insert",method = RequestMethod.PUT,produces=MediaType.APPLICATION_XML_VALUE)
    public Object insertSTB(@RequestBody STB stb) {
        STB tempSTB = this.stbService.addNewStb(stb);
        return new ErrorModel(tempSTB.getId(),MyValue.INSERTED,MyValue.OK_MESSAGE);
    }


    @RequestMapping(value = "/delete",method = RequestMethod.DELETE,produces=MediaType.APPLICATION_XML_VALUE)
    public Object deleteSTB(@RequestParam("id") Integer id) {
        STB stb = this.stbService.findById(id);
        if(stb==null){
            return new ErrorModel(id, MyValue.ERROR,MyValue.NOT_FOUND_MESSAGE);
        }
        Integer deletedId = this.stbService.deleteStb(stb);
        return new ErrorModel(deletedId,MyValue.DELETED,MyValue.OK_MESSAGE);
    }


}

