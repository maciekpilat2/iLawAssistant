/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.models.ScanSection;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.io.IOException;

import app.models.Word;
import app.repositories.ScanSectionRepository;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestTemplate;

/**
 * @author Pilat
 */
@Service
public class ScanService {

    @Autowired
    ScanSectionRepository scanSectionRepository;

    public void uploadFileToFtp(byte[] scanByte, String scanName) throws IOException {
        System.out.println("To jest nazwa pliku: " + scanName);
        FTPClient client = new FTPClient();

        // Read the file from resources folder.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = new ByteArrayInputStream(scanByte)) {
            client.connect("s26.zenbox.pl");
            client.login("iLawAssistant@maciekpilat.pl", "sys");
            client.enterLocalPassiveMode();
            // Store file to server / destination folder
            client.changeWorkingDirectory("/public_html/iLawAssistantScans");

            // ustawienie typu transferu dla ftp
            client.setFileType(client.BINARY_FILE_TYPE);// dodane ale nic nie zmienia
            client.setFileTransferMode(client.BINARY_FILE_TYPE); //dodane  ale nic nie zmienia
            client.storeFile(scanName, input);
            input.close();// dopisane nie poprawia
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String sendOCRRequest(String scanUrl) {

        RestTemplate rest = new RestTemplate();

        String http = "http://";
        String ocrApiKey = "1f506d896a88957";
        String language = "pol";
        String fileType = "JPG";
        String link = scanUrl;

// sklejony link do API OCR
        String url = "https://api.ocr.space/parse/imageurl?apikey=" + ocrApiKey + "&url=" + link + "&language=" + language + "&isOverlayRequired=true";

// wysłanie url GETem z doklejonymi parametrami i odebranie danych        
        String res = rest.getForObject(url, String.class);
        System.out.println(res);
        return res;
    }

// zmienia JSON w liste obiektow Word
    public List jsonToList(String string) throws IOException {
//1. zamieniam string na Object
        JSONObject jo1 = new JSONObject(string);
//2. Object zamieniam na JSONArray
        org.json.JSONArray ja1 = jo1.getJSONArray("ParsedResults");
//3. Zeby czesc ktora chce wziac pakuje jako kolejny obiekt
        JSONObject jo2 = ja1.getJSONObject(0);
        JSONObject jo3 = jo2.getJSONObject("TextOverlay");
        org.json.JSONArray ja2 = jo3.getJSONArray("Lines");
        List<Word> wordsList = new ArrayList<Word>();
        for (int i = 0; i < ja2.length(); i++) {
            JSONObject jo4 = ja2.getJSONObject(i);
            org.json.JSONArray ja3 = jo4.getJSONArray("Words");
            for (int e = 0; e < ja3.length(); e++) {
                JSONObject jo5 = ja3.getJSONObject(e);
                long left = jo5.getLong("Left");
                long top = jo5.getLong("Top");
                long height = jo5.getLong("Height");
                String wordText = jo5.getString("WordText");
                long width = jo5.getLong("Width");
                Word word = new Word(wordText, left, top, height, width);
                wordsList.add(word);
            }
        }
        //System.out.println("To jest lista, która powstaje z JSON: " + wordsList);
        return wordsList;
    }

    // zmienia JSON w liste slow
    public List jsonToWordsList(String string) throws IOException {

//1. zamieniam string na Object
        JSONObject jo1 = new JSONObject(string);
//2. Object zamieniam na JSONArray
        org.json.JSONArray ja1 = jo1.getJSONArray("ParsedResults");
//3. Zeby czesc ktora chce wziac pakuje jako kolejny obiekt
        JSONObject jo2 = ja1.getJSONObject(0);
        JSONObject jo3 = jo2.getJSONObject("TextOverlay");
        org.json.JSONArray ja2 = jo3.getJSONArray("Lines");

        List<String> wordsList = new ArrayList<>();

        for (int i = 0; i < ja2.length(); i++) {
            JSONObject jo4 = ja2.getJSONObject(i);
            org.json.JSONArray ja3 = jo4.getJSONArray("Words");

            for (int e = 0; e < ja3.length(); e++) {
                JSONObject jo5 = ja3.getJSONObject(e);

                //long left = jo5.getLong("Left");
                //long top = jo5.getLong("Top");
                //long height = jo5.getLong("Height");
                //long width = jo5.getLong("Width");
                String wordText = jo5.getString("WordText");

                //Word word = new Word(wordText, left, top, height, width);
                wordsList.add(wordText);
            }
        }
        //System.out.println("To jest lista, która powstaje z JSON: " + wordsList);
        return wordsList;
    }

    public String getParsedText(String json) {

        //1. zamieniam string na Object
        JSONObject jo1 = new JSONObject(json);
//2. Object zamieniam na JSONArray
        org.json.JSONArray ja1 = jo1.getJSONArray("ParsedResults");
//3. Zeby czesc ktora chce wziac pakuje jako kolejny obiekt
        JSONObject jo2 = ja1.getJSONObject(0);
        //  JSONObject parsedText = jo2.getJSONObject("ParsedText");
        String parsedText = jo2.getString("ParsedText");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("Parsed document text: " + parsedText);

        return parsedText;
    }

    public void courtNameFinder(List wordList) {

        // tworze strumien slow ze skanu
//        Stream<Word> courtNameStream = wordList.stream();
//        courtNameStream.filter(g -> g.Word = "Sąd"))
    }

    // Metoda zwraca listę obiektów Word znajdujących się w wybranej sekcji skanu. Zwraca listę obiektów WORD. Słowa pisane małą literą
    // W słowach z danej sekcji ma być szukana konkretna informacja.
    public List<Word> getScanWordsFromSection(List<Word> listOfWordsFromScan, String informationType) {

        List<Word> ListOfWordsFromScanSection = new ArrayList<>();
        for (ScanSection s : scanSectionRepository.getScanSectionsOfSelectedType(informationType)) {
            for (Word w : listOfWordsFromScan) {
                if (
                        s.getSectionLeft() <= w.getLeft()
                        & s.getSectionRight() > (w.getLeft() + w.getWidth())
                        & s.getSectionTop()<= w.getTop()
                        & s.getSectionBottom() > (w.getTop()+ w.getHeight())
                        ) {
                    w.getWordText().toLowerCase();
                    ListOfWordsFromScanSection.add(w);
                    System.out.println("W wybranej sekcji znalazłem słowo: " + w.getWordText());
                }
            }
        }
        return ListOfWordsFromScanSection;
    }
    
}
