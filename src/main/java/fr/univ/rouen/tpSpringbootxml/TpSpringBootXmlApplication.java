package fr.univ.rouen.tpSpringbootxml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.univ.rouen.tpSpringbootxml.entity.STB;
import fr.univ.rouen.tpSpringbootxml.repository.STBRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TpSpringBootXmlApplication implements CommandLineRunner{
	
	@Autowired
	private STBRepository stbService;
	
	public static void main(String[] args) {
		SpringApplication.run(TpSpringBootXmlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		STB stb = new STB("title1", LocalDate.now().toString(), "descr1");
		STB stb2 = new STB("title2", LocalDate.now().toString(), "descr1");
		STB stb3 = new STB("title3", LocalDate.now().toString(), "descr1");
		STB stb4 = new STB("title4", LocalDate.now().toString(), "descr1");
		STB stb5 = new STB("title5", LocalDate.now().toString(), "descr1");


		List<STB> tempList =  Stream.of(stb,stb2,stb3,stb4,stb5).collect(Collectors.toList());
		stbService.saveAll(tempList);


	}

}
