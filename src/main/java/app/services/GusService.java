/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import cis.bir.publ._2014._07.*;
import cis.bir.publ._2014._07.datacontract.ObjectFactory;
import cis.bir.publ._2014._07.datacontract.ParametryWyszukiwania;
import org.springframework.stereotype.Service;
import javax.xml.bind.JAXBElement;
import javax.xml.ws.soap.AddressingFeature;
import org.tempuri.IUslugaBIRzewnPubl;
import org.tempuri.UslugaBIRzewnPubl;

/**
 *
 * @author Pilat
 */
@Service
public class GusService {

    public void gusFindOne() {

        //ObjectFactory objectFactory = new ObjectFactory();
//    DaneSzukaj daneSzukaj = new DaneSzukaj();
//    Zaloguj zaloguj = new Zaloguj();
        //ParametryWyszukiwania parametryWyszukiwania = new ParametryWyszukiwania();
        
        
//UslugaBIRzewnPubl service = new UslugaBIRzewnPubl();
//service.setHandlerResolver(new SoapHandlerResolver()); //<- doklejanie SID'a do HTTP HEADER
//IUslugaBIRzewnPubl port = service.getE3(new AddressingFeature());
//String statusUslugi = "StatusUslugi";
//String result = port.getValue(statusUslugi);
//// logowanie, jezeli sesja wygasla, badx logowanie pierwszy raz
//if ((SoapMessageHandler.sessionCookie.equals("")) || (! result.equals("1"))){
//    String sid = port.zaloguj("abcde12345abcde12345");
//    SoapMessageHandler.sessionCookie = sid; 
//}
// przykład wyszukiwania po NIPie

        UslugaBIRzewnPubl service = new UslugaBIRzewnPubl();
        IUslugaBIRzewnPubl port = service.getE3(new AddressingFeature());
        String sid = port.zaloguj("abcde12345abcde12345");
        
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<String> nipParam = objectFactory.createParametryWyszukiwaniaNip("9521913245");
        ParametryWyszukiwania parametryWyszukiwania = new ParametryWyszukiwania();
        parametryWyszukiwania.setNip(nipParam);
        String raport = port.daneSzukaj(parametryWyszukiwania);
        System.out.println("Raport GUS: " + raport);
    }
}
