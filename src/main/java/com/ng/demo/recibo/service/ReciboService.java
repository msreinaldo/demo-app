package com.ng.demo.recibo.service;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ng.demo.recibo.domain.Recibo;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Service
public class ReciboService {
	
	public Recibo getInstanciaRecibo() throws JAXBException {
		JAXBContext instancia = JAXBContext.newInstance(Recibo.class);
		Unmarshaller instanciaRecibo = instancia.createUnmarshaller();	
		File file = new File("");
		return (Recibo) instanciaRecibo.unmarshal( new File(file.getAbsolutePath() + "/recibo.xml" ) );		
		//Descomentar caso esteja em ambiente de desenvolvimento e definir local do arquivo xml
		//return (Recibo) instanciaRecibo.unmarshal( new File("D:\\recibo.xml" ) );
	}
	
	public List<Recibo> getRecibos() throws JAXBException{
		List<Recibo> recibos = new ArrayList<Recibo>();
		
		Recibo recibo1 = getInstanciaRecibo();
		recibo1.setTotalRecebido(100.00);
		
		Recibo recibo2 = getInstanciaRecibo();
		recibo2.setID("2");
		recibo2.setTotalRecebido(110.10);
				
		Recibo recibo3 = getInstanciaRecibo();
		recibo3.setID("3");
		recibo3.setTotalRecebido(120.20);
		
		Recibo recibo4 = getInstanciaRecibo();
		recibo4.setID("4");
		recibo4.setTotalRecebido(130.30);		
		
		recibos.add(recibo1);
		recibos.add(recibo2);
		recibos.add(recibo3);
		recibos.add(recibo4);
		
		return recibos;
	}
	
	public String toStringXml(Recibo recibo) throws JAXBException {
		JAXBContext instancia = JAXBContext.newInstance(Recibo.class);
		Marshaller instanciaProps = instancia.createMarshaller();
		instanciaProps.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); 
        
		StringWriter stringXml = new StringWriter();
        instanciaProps.marshal(recibo, stringXml);
		return stringXml.toString();	    
	}
	
	public String toStringJson(Recibo recibo) {
		return new Gson().toJson(recibo);
	}
	
}

