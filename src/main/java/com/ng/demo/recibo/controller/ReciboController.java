package com.ng.demo.recibo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ng.demo.recibo.domain.Recibo;
import com.ng.demo.recibo.service.ReciboService;

import jakarta.xml.bind.JAXBException;

@Controller
public class ReciboController {

	@Autowired
	ReciboService reciboService;
		
	@RequestMapping(value = "/recibos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recibo>> getAll() {
		try {
			List<Recibo> recibos = new ArrayList<Recibo>();
			recibos = reciboService.getRecibos();			
			
			if (recibos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(recibos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/recibosJSON", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recibo>> getAllJson() {
		try {
			List<Recibo> recibos = new ArrayList<Recibo>();
			recibos = reciboService.getRecibos();			
			
			if (recibos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(recibos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/recibosXML", method = RequestMethod.GET)
	public String getAllXML() throws JAXBException {
		StringBuilder tempRecibos = new StringBuilder();
		List<Recibo> recibos = new ArrayList<Recibo>();
		recibos = reciboService.getRecibos();	
		recibos.forEach(recibo -> {
				try {
					tempRecibos.append(reciboService.toStringXml(recibo));
				} catch (JAXBException e) {					
					e.printStackTrace();
				}
			}		
		);
		return tempRecibos.toString();
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {        
        model.addAttribute("eventName", "ngBilling");        
        return "index";
    }
	
	
}
