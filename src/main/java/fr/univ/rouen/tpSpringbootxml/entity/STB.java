package fr.univ.rouen.tpSpringbootxml.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "STB")
@JacksonXmlRootElement(localName = "STB")
public class STB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JacksonXmlProperty(isAttribute = true)
	private  Integer id;

	@JacksonXmlProperty
	private String title;
	@JacksonXmlProperty
	private String date;

	@JacksonXmlProperty
	private String descr;

	public STB(String title,  String date, String descr) {
		super();
		this.title = title;
		this.date = date;
		this.descr = descr;
	}



	public STB() {
	}


	@Override
	public String toString() {
		return ("STB [Id ="+id +",Title=" + title + ",Date=" + date + ",Description=" + descr + "]");

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
}