/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.DocumentKeyWord;
import app.repositories.DocumentKeyWordRepository;
import app.services.DocumentService;
import static app.services.DocumentService.removeDuplicates;
import app.services.ScanService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Pilat
 */
@Controller
public class ScanController {

    @Autowired
    ScanService scanService;
    @Autowired
    DocumentKeyWordRepository documentKeyWordRepository;

    @RequestMapping("/addscan")
    public String addScan(Model model) {

        return "addscan";
    }

    @PostMapping("/addscan")
    public String postScan(
            @RequestParam("scanMultipart") MultipartFile multipart,
            @RequestParam("scanName") String scanName
    ) throws FileNotFoundException, IOException {

        byte[] scanBytes = multipart.getBytes();

// zapisuje na FTP
        scanService.uploadFileToFtp(multipart.getBytes(), scanName + ".jpg");

// zapisuje dane i url dla MySQL zenbox
        String scanUrl = "http://maciekpilat.pl/iLawAssistantScans/" + scanName + ".jpg";

// wysylam zapytanie do api o OCR,  i umieszczam w obiekcie SCAN do zpisania w MySQL
        String scanJSONString = scanService.sendOCRRequest(scanUrl).toString();

// to jest tekst na którym powinno się szukać słów.
        List<String> scanWordsList = scanService.jsonToWordsList(scanJSONString);
        System.out.println("scanListWords to string: " + scanWordsList.toString().replace(",", " "));
        DocumentService.findDBKeywordsInDocument(scanWordsList.toString().replace(",", " "), documentKeyWordRepository.findAll());

        return "addscan";
    }
}
