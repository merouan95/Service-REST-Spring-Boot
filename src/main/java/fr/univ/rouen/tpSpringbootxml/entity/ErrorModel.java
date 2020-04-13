package fr.univ.rouen.tpSpringbootxml.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class ErrorModel {

    @JacksonXmlProperty
    private int id;
    @JacksonXmlProperty
    private String status;
    @JacksonXmlProperty
    private String message;


    public ErrorModel() {
    }

    public ErrorModel(int id, String message) {
        this.id = id;
        this.status = message;
    }

    public ErrorModel(int id, String status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
