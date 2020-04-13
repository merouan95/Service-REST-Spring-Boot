package fr.univ.rouen.tpSpringbootxml.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement
public class ListSTB implements Serializable {

    @JacksonXmlProperty(localName = "STB")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<STB> listSTB=new ArrayList<>();

    public ListSTB(List<STB> listSTB) {
        this.listSTB = listSTB;
    }

    public ListSTB() {
    }

    public List<STB> getListSTB() {
        return listSTB;
    }

    public void setListSTB(List<STB> listSTB) {
        this.listSTB = listSTB;
    }
}
