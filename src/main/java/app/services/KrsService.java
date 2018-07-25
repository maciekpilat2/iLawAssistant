/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.models.Address;
import app.models.KrsDataModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.regex.*;

/**
 *
 * @author Pilat
 */
import org.apache.commons.lang3.text.WordUtils;

@Service
public class KrsService {

    public String krsSearch(String serchData, String numberType) {

        if (numberType.equals("NAZWA")) {
            return krsQueryName(serchData);
        } else if (numberType.equals("NIP")) {
            return krsQueryNip(serchData);
        } else if (numberType.equals("KRS")) {
            return krsQueryKrs(serchData);
        } else {
            return krsQueryRegon(serchData);
        }
    }

    public String krsQueryName(String subjectName) {

        System.out.println("Tu powinny być dane z COUNT");

        RestTemplate rest = new RestTemplate();
        String url = "https://api-v3.mojepanstwo.pl/dane/krs_podmioty.json?conditions[q]=";
        String properSubjectName = null;
        List<String> listOfKrsNames = krsNameVariantCreator(subjectName);

        for (String k : listOfKrsNames) {

            String restResult = rest.getForObject(url + k, String.class);
            JSONObject jSONObject = new JSONObject(restResult);
            System.out.println("DANE: " + restResult.toString());
            Long hitCount = jSONObject.getLong("Count");

            if (!"0".equals(hitCount)) {
                properSubjectName = k;
                System.out.println("subjectName value = " + subjectName.toString());
                break;
            }
        }
        String restResult = rest.getForObject("https://api-v3.mojepanstwo.pl/dane/krs_podmioty.json?conditions[q]=" + properSubjectName, String.class);
        return restResult;

    }

    public String krsQueryNip(String subjectNip) {
        RestTemplate rest = new RestTemplate();
        String url = "https://api-v3.mojepanstwo.pl/dane/krs_podmioty.json?conditions[krs_podmioty.nip]=" + subjectNip;
        String restResult = rest.getForObject(url, String.class
        );
        return restResult;
    }

    public String krsQueryKrs(String subjectKrs) {
        RestTemplate rest = new RestTemplate();
        String url = "https://api-v3.mojepanstwo.pl/dane/krs_podmioty.json?conditions[krs_podmioty.krs]=" + subjectKrs;
        String restResult = rest.getForObject(url, String.class
        );
        return restResult;
    }

    public String krsQueryRegon(String subjectRegon) {
        RestTemplate rest = new RestTemplate();
        String url = "https://api-v3.mojepanstwo.pl/dane/krs_podmioty.json?conditions[krs_podmioty.regon]=" + subjectRegon;
        String restResult = rest.getForObject(url, String.class
        );
        return restResult;
    }

    public KrsDataModel krsJsonParser(String krsResultString) {
        KrsDataModel krsDataModel = new KrsDataModel();
        JSONObject jSONObject = new JSONObject(krsResultString);
        JSONArray ja = jSONObject.getJSONArray("Dataobject");
        JSONObject data1 = ja.getJSONObject(0);
        JSONObject data2 = data1.getJSONObject("data");
        Address adres = new Address();

        // Array na wzory regularnych
        List<String> regexPatterns = new ArrayList();
        // dodanie zapytan na liste
        regexPatterns.add("(?<=ul. )[^,]*"); // ulica
        regexPatterns.add("(?<=nr )[^,]*"); //nr
        regexPatterns.add("(?<=lok. )[^,]*"); //lok
        regexPatterns.add("(?<=miejsc. )[^,]*"); // miasto
        regexPatterns.add("(?<=kod )[^,]*"); //kod
        regexPatterns.add("(?<=poczta )[^,]*"); //poczta
        regexPatterns.add("(?<=kraj )[^,]*"); //kraj
        // petla po wszystkich zapytaniach wyciaga poszczegolne czesci adresu i dodaje na ta sama liste
        // jej rozmiar jest ograniczony do 6 bo inaczej wyciagniete dane zapisane jako kolejna pozycja powoduja nie konczaca sie petle
        for (int r = 0; r <= 6; r++) {
            Pattern pattern = Pattern.compile(regexPatterns.get(r));
            Matcher matcher = pattern.matcher(data2.get("krs_podmioty.adres").toString());
            matcher.find();
            regexPatterns.add(matcher.group().toString());
        }
        // wyciaganie danych z listy i pakowanie do obiektu klasy address
        adres.setStreetName(regexPatterns.get(7));
        adres.setStreetNumber(regexPatterns.get(8));
        //adres.set....(regexPatterns.get(9)); //numer mieszkania
        adres.setCity(regexPatterns.get(10));
        adres.setPostalCode(regexPatterns.get(11));
        //adres.set....(regexPatterns.get(12)); // poczta
        adres.setCountry(regexPatterns.get(13));

        krsDataModel.setEmail(data2.getString("krs_podmioty.adres_miejscowosc"));
        krsDataModel.setDataWykreslenieRejestrPrzedsiebiorcow(data2.get("krs_podmioty.data_wyrejestrowania_przedsiebiorcy").toString());
        krsDataModel.setDataWykreslenieRejestrStowarzyszen(data2.get("krs_podmioty.data_wykreslenia_stowarzyszenia").toString());
        krsDataModel.setDataSprawdzeniaDanych(data2.getString("krs_podmioty.data_sprawdzenia"));
        krsDataModel.setAdresLokal(data2.getLong("krs_podmioty.adres_lokal"));
        krsDataModel.setAdresMiejscowosc(data2.getString("krs_podmioty.adres_miejscowosc"));
        krsDataModel.setLiczbaCzlonkowKomitetuZal(data2.getString("krs_podmioty.liczba_czlonkow_komitetu_zal"));
        krsDataModel.setRegon(data2.getString("krs_podmioty.regon"));
        krsDataModel.setFormaPrawnaId(data2.getLong("krs_podmioty.forma_prawna_typ_id"));
        krsDataModel.setLiczbaZmianUmow(data2.getLong("krs_podmioty.liczba_zmian_umow"));
        krsDataModel.setWartoscKapitalZakladowy(data2.getLong("krs_podmioty.wartosc_kapital_zakladowy"));
        krsDataModel.setDataWpisRejestrStowarzyszen(data2.getString("krs_podmioty.rejestr_stowarzyszen"));
        krsDataModel.setNip(data2.getString("krs_podmioty.nip"));
        krsDataModel.setLiczbaProkurentow(data2.getLong("krs_podmioty.liczba_prokurentow"));
        krsDataModel.setWww(data2.getString("krs_podmioty.www"));
        krsDataModel.setFormaPrawna(data2.getString("krs_podmioty.forma_prawna_str"));
        krsDataModel.setNazwaOrganuReprezentacji(data2.getString("krs_podmioty.nazwa_organu_reprezentacji"));
        krsDataModel.setLiczbaAkcjiWszystkichEmisji(data2.getLong("krs_podmioty.liczba_emisji_akcji"));
        krsDataModel.setTwitterAccount_id(data2.getString("krs_podmioty.twitter_account_id"));
        krsDataModel.setDataDokonaniaWpisu(data2.getString("krs_podmioty.data_dokonania_wpisu"));
        krsDataModel.setNazwaOrganuNadzoru(data2.getString("krs_podmioty.nazwa_organu_nadzoru"));
        krsDataModel.setWartoscCzescKapitaluWplaconego(data2.getLong("krs_podmioty.wartosc_czesc_kapitalu_wplaconego"));
        krsDataModel.setWartoscNominalnaPodwyzszeniaKapitalu(data2.getLong("krs_podmioty.wartosc_nominalna_podwyzszenia_kapitalu"));
        krsDataModel.setFirma(data2.getString("krs_podmioty.firma"));
        krsDataModel.setLiczbaJedynychAkcjonariuszy(data2.getLong("krs_podmioty.opp"));
        krsDataModel.setDataRejestracjiStowarzyszenia(data2.getString("krs_podmioty.data_rejestracji_stowarzyszenia"));
        krsDataModel.setLiczbaNadzorcow(data2.getLong("krs_podmioty.liczba_nadzorcow"));
        krsDataModel.setSposobReprezentacji(data2.getString("krs_podmioty.sposob_reprezentacji"));
        krsDataModel.setLiczbaZmian(data2.getLong("krs_podmioty.liczba_zmian"));
        krsDataModel.setSygnaturaAkt(data2.getString("krs_podmioty.sygnatura_akt"));
        krsDataModel.setNazwaSkrocona(data2.getString("krs_podmioty.nazwa_skrocona"));
        krsDataModel.setDataOstatniegoWpisu(data2.get("krs_podmioty.data_ostatni_wpis").toString());
        krsDataModel.setLiczbaReprezentantow(data2.getLong("krs_podmioty.liczba_reprezentantow"));
        krsDataModel.setAdres(adres);

        System.out.println("Dane z KRS: " + krsDataModel.toString());
        return krsDataModel;
    }
// klasa tworzy rozne warianty literowe stringa na potrzeby wyszukiwania słowengo w krs

    public List<String> krsNameVariantCreator(String serchedName) {

        List<String> krsNameVariants = new ArrayList();
        krsNameVariants.add(serchedName);
        krsNameVariants.add(serchedName.toLowerCase());
        krsNameVariants.add(serchedName.toUpperCase());
        krsNameVariants.add(WordUtils.capitalize(krsNameVariants.get(1).toString()));
        System.out.println("GENERATOR NAZW DO KRS API");
        System.out.println("Liczba pozycji w liście: " + krsNameVariants.size());
        for (Object k : krsNameVariants) {
            System.out.println("Nazwy w generatorze różnych zapisów nazw: " + k.toString());
        }
        return krsNameVariants;

    }

}

//private String siedziba; // trzeba strworzyć obiekt "kraj POLSKA, woj. MAZOWIECKIE, powiat WARSZAWA, gmina WARSZAWA, miejsc. WARSZAWA",
//private String adresKodPocztowy;
//private Boolean nieprzedsiebiorca;
//private Address adres;
//private String podmiotyId;
//private String dotacjeUeBeneficjentId;
//private Long liczbaEmisjiAkcji;
//private Long liczbaWspolnikow;
//private String email;
//private Long kapitalDocelowy;
//private Long wartoscNominalnaAkcji;
//private String gpwSpolkaId;
//private Boolean knfOstrzezenie;
//private String krs;
//private String dataZawieszeniaDzialanosci;
//private String dataRejestracji;
//private String dataUprawomocnieniaWykreslenia;
//private Long liczbaOddzialow;
//private String dataWznowieniaDzialanosci;
//private Boolean umowaSpolkiCywilnej;
//private Court oznaczenieSadu;    
//                "krs_podmioty.siedziba": "kraj POLSKA, woj. MAZOWIECKIE, powiat WARSZAWA, gmina WARSZAWA, miejsc. WARSZAWA",
//                "krs_podmioty.wartosc_kapital_zakladowy": 0,
//                "krs_podmioty.nazwa": "\"FUNDACJA GLOCI\"",
//                "krs_podmioty.adres_kod_pocztowy": "02-308",
//                "krs_podmioty.empty": "0",
//                "krs_podmioty.nieprzedsiebiorca": "0",
//                "krs_podmioty.wczesniejsza_rejestracja_str": "",
//                "krs_podmioty.adres": "ul. GRÓJECKA, nr 34, lok. 4, miejsc. WARSZAWA, kod 02-308, poczta WARSZAWA, kraj POLSKA",
//                "krs_podmioty.id": "597449",
//                "krs_podmioty.liczba_akcji_wszystkich_emisji": "0",
//                "krs_podmioty.dotacje_ue_beneficjent_id": "0",
//                "krs_podmioty.person_id": [
//                ],
//                "krs_podmioty.liczba_dzialalnosci": "0",
//                "krs_podmioty.numer_wpisu": "4",
//                "krs_podmioty.deleted_on_request": "0",
//                "krs_podmioty.adres_ulica": "Grójecka",
//                "krs_podmioty.liczba_jedynych_akcjonariuszy": "0",
//                "krs_podmioty.wykreslony": "0",
//                "krs_podmioty.gmina_id": "2226",
//                "krs_podmioty.wojewodztwo_id": "7",
//                "krs_podmioty.liczba_wspolnikow": "0",
//                "krs_podmioty.cel_dzialania": "",
//                "krs_podmioty.email": "BIURO@GLOCI.PL",
//                "krs_podmioty.adres_poczta": "Warszawa",
//                "krs_podmioty.kod_pocztowy_id": "15827",
//                "krs_podmioty.data_wpisu_opp": null,
//                "krs_podmioty.wartosc_kapital_docelowy": 0,
//                "krs_podmioty.adres_numer": "34",
//                "krs_podmioty.powiat_id": "335",
//                "krs_podmioty.adres_kraj": "Polska",
//                "krs_podmioty.wartosc_nominalna_akcji": 0,
//                "krs_podmioty.gpw_spolka_id": "0",
//                "krs_podmioty.miejscowosc_id": "16239",
//                "krs_podmioty.knf_ostrzezenie_id": "0",
//                "krs_podmioty.krs": "0000597449",
//                "krs_podmioty.data_zawieszenia_dzialanosci": null,
//                "krs_podmioty.data_rejestracji": "2016-01-20",
//                "krs_podmioty.ostatni_wpis_id": "0",
//                "krs_podmioty.data_uprawomocnienia_wykreslenia": null,
//                "krs_podmioty.forma_prawna_id": "1",
//                "krs_podmioty.liczba_oddzialow": "0",
//                "krs_podmioty.data_wznowienia_dzialanosci": null,
//                "krs_podmioty.umowa_spolki_cywilnej": "0",
//                "krs_podmioty.oznaczenie_sadu": "SĄD REJONOWY DLA M. ST. WARSZAWY W WARSZAWIE, XIII WYDZIAŁ GOSPODARCZY KRAJOWEGO REJESTRU SĄDOWEGO"
//            }
//        }
