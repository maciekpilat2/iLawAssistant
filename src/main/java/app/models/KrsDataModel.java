/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */

public class KrsDataModel extends Model{

private String dataWykreslenieRejestrPrzedsiebiorcow;
private String dataWykreslenieRejestrStowarzyszen;
private String dataSprawdzeniaDanych;
private Long adresLokal;
private String adresMiejscowosc;
private String liczbaCzlonkowKomitetuZal;
private String regon;
private Long formaPrawnaId;
private Long liczbaZmianUmow;
private String siedziba; // trzeba strworzyć obiekt "kraj POLSKA, woj. MAZOWIECKIE, powiat WARSZAWA, gmina WARSZAWA, miejsc. WARSZAWA",
private Long wartoscKapitalZakladowy;
private String dataWpisRejestrStowarzyszen;
private String nazwa;
private String adresKodPocztowy;
private String nip;
private Long liczbaProkurentow;
private Boolean nieprzedsiebiorca;
private String www;
private String formaPrawna;
private String nazwaOrganuReprezentacji;
private Address adres;
private String podmiotyId;
private Long liczbaAkcjiWszystkichEmisji;
private String dotacjeUeBeneficjentId;
private Long liczbaEmisjiAkcji;
private String twitterAccount_id;
private String dataDokonaniaWpisu;
private String nazwaOrganuNadzoru;
private Long wartoscCzescKapitaluWplaconego;
private Long wartoscNominalnaPodwyzszeniaKapitalu;
private String dataRejestracjiPrzedsiebiorcy;
private String firma;
private Long liczbaJedynychAkcjonariuszy;                
private String dataRejestracjiStowarzyszenia;
private Long liczbaNadzorcow;
private String sposobReprezentacji;
private Long liczbaZmian;
private String sygnaturaAkt;
private Long liczbaWspolnikow;
private String nazwaSkrocona;
private String dataOstatniegoWpisu;
private Long liczbaReprezentantow;
private String email;
private Long kapitalDocelowy;
private Long wartoscNominalnaAkcji;
private String gpwSpolkaId;
private Boolean knfOstrzezenie;
private String krs;
private String dataZawieszeniaDzialanosci;
private String dataRejestracji;
private String dataUprawomocnieniaWykreslenia;
private Long liczbaOddzialow;
private String dataWznowieniaDzialanosci;
private Boolean umowaSpolkiCywilnej;
//private Court oznaczenieSadu;    

    @Override
    public String toString() {
        return "KrsDataModel{" + "dataWykreslenieRejestrPrzedsiebiorcow=" + dataWykreslenieRejestrPrzedsiebiorcow + ", dataWykreslenieRejestrStowarzyszen=" + dataWykreslenieRejestrStowarzyszen + ", dataSprawdzeniaDanych=" + dataSprawdzeniaDanych + ", adresLokal=" + adresLokal + ", adresMiejscowosc=" + adresMiejscowosc + ", liczbaCzlonkowKomitetuZal=" + liczbaCzlonkowKomitetuZal + ", regon=" + regon + ", formaPrawnaId=" + formaPrawnaId + ", liczbaZmianUmow=" + liczbaZmianUmow + ", siedziba=" + siedziba + ", wartoscKapitalZakladowy=" + wartoscKapitalZakladowy + ", dataWpisRejestrStowarzyszen=" + dataWpisRejestrStowarzyszen + ", nazwa=" + nazwa + ", adresKodPocztowy=" + adresKodPocztowy + ", nip=" + nip + ", liczbaProkurentow=" + liczbaProkurentow + ", nieprzedsiebiorca=" + nieprzedsiebiorca + ", www=" + www + ", formaPrawna=" + formaPrawna + ", nazwaOrganuReprezentacji=" + nazwaOrganuReprezentacji + ", adres=" + adres + ", podmiotyId=" + podmiotyId + ", liczbaAkcjiWszystkichEmisji=" + liczbaAkcjiWszystkichEmisji + ", dotacjeUeBeneficjentId=" + dotacjeUeBeneficjentId + ", liczbaEmisjiAkcji=" + liczbaEmisjiAkcji + ", twitterAccount_id=" + twitterAccount_id + ", dataDokonaniaWpisu=" + dataDokonaniaWpisu + ", nazwaOrganuNadzoru=" + nazwaOrganuNadzoru + ", wartoscCzescKapitaluWplaconego=" + wartoscCzescKapitaluWplaconego + ", wartoscNominalnaPodwyzszeniaKapitalu=" + wartoscNominalnaPodwyzszeniaKapitalu + ", dataRejestracjiPrzedsiebiorcy=" + dataRejestracjiPrzedsiebiorcy + ", firma=" + firma + ", liczbaJedynychAkcjonariuszy=" + liczbaJedynychAkcjonariuszy + ", dataRejestracjiStowarzyszenia=" + dataRejestracjiStowarzyszenia + ", liczbaNadzorcow=" + liczbaNadzorcow + ", sposobReprezentacji=" + sposobReprezentacji + ", liczbaZmian=" + liczbaZmian + ", sygnaturaAkt=" + sygnaturaAkt + ", liczbaWspolnikow=" + liczbaWspolnikow + ", nazwaSkrocona=" + nazwaSkrocona + ", dataOstatniegoWpisu=" + dataOstatniegoWpisu + ", liczbaReprezentantow=" + liczbaReprezentantow + ", email=" + email + ", kapitalDocelowy=" + kapitalDocelowy + ", wartoscNominalnaAkcji=" + wartoscNominalnaAkcji + ", gpwSpolkaId=" + gpwSpolkaId + ", knfOstrzezenie=" + knfOstrzezenie + ", krs=" + krs + ", dataZawieszeniaDzialanosci=" + dataZawieszeniaDzialanosci + ", dataRejestracji=" + dataRejestracji + ", dataUprawomocnieniaWykreslenia=" + dataUprawomocnieniaWykreslenia + ", liczbaOddzialow=" + liczbaOddzialow + ", dataWznowieniaDzialanosci=" + dataWznowieniaDzialanosci + ", umowaSpolkiCywilnej=" + umowaSpolkiCywilnej + '}';
    }



    

    /**
     * @return the dataSprawdzeniaDanych
     */
    public String getDataSprawdzeniaDanych() {
        return dataSprawdzeniaDanych;
    }

    /**
     * @param dataSprawdzeniaDanych the dataSprawdzeniaDanych to set
     */
    public void setDataSprawdzeniaDanych(String dataSprawdzeniaDanych) {
        this.dataSprawdzeniaDanych = dataSprawdzeniaDanych;
    }

    /**
     * @return the adresLokal
     */
    public Long getAdresLokal() {
        return adresLokal;
    }

    /**
     * @param adresLokal the adresLokal to set
     */
    public void setAdresLokal(Long adresLokal) {
        this.adresLokal = adresLokal;
    }

    /**
     * @return the adresMiejscowosc
     */
    public String getAdresMiejscowosc() {
        return adresMiejscowosc;
    }

    /**
     * @param adresMiejscowosc the adresMiejscowosc to set
     */
    public void setAdresMiejscowosc(String adresMiejscowosc) {
        this.adresMiejscowosc = adresMiejscowosc;
    }

    /**
     * @return the liczbaCzlonkowKomitetuZal
     */
    public String getLiczbaCzlonkowKomitetuZal() {
        return liczbaCzlonkowKomitetuZal;
    }

    /**
     * @param liczbaCzlonkowKomitetuZal the liczbaCzlonkowKomitetuZal to set
     */
    public void setLiczbaCzlonkowKomitetuZal(String liczbaCzlonkowKomitetuZal) {
        this.liczbaCzlonkowKomitetuZal = liczbaCzlonkowKomitetuZal;
    }

    /**
     * @return the regon
     */
    public String getRegon() {
        return regon;
    }

    /**
     * @param regon the regon to set
     */
    public void setRegon(String regon) {
        this.regon = regon;
    }

    /**
     * @return the formaPrawnaId
     */
    public Long getFormaPrawnaId() {
        return formaPrawnaId;
    }

    /**
     * @param formaPrawnaId the formaPrawnaId to set
     */
    public void setFormaPrawnaId(Long formaPrawnaId) {
        this.formaPrawnaId = formaPrawnaId;
    }

    /**
     * @return the liczbaZmianUmow
     */
    public Long getLiczbaZmianUmow() {
        return liczbaZmianUmow;
    }

    /**
     * @param liczbaZmianUmow the liczbaZmianUmow to set
     */
    public void setLiczbaZmianUmow(Long liczbaZmianUmow) {
        this.liczbaZmianUmow = liczbaZmianUmow;
    }

    /**
     * @return the siedziba
     */
    public String getSiedziba() {
        return siedziba;
    }

    /**
     * @param siedziba the siedziba to set
     */
    public void setSiedziba(String siedziba) {
        this.siedziba = siedziba;
    }

    /**
     * @return the wartoscKapitalZakladowy
     */
    public Long getWartoscKapitalZakladowy() {
        return wartoscKapitalZakladowy;
    }

    /**
     * @param wartoscKapitalZakladowy the wartoscKapitalZakladowy to set
     */
    public void setWartoscKapitalZakladowy(Long wartoscKapitalZakladowy) {
        this.wartoscKapitalZakladowy = wartoscKapitalZakladowy;
    }



    /**
     * @return the nazwa
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * @param nazwa the nazwa to set
     */
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    /**
     * @return the adresKodPocztowy
     */
    public String getAdresKodPocztowy() {
        return adresKodPocztowy;
    }

    /**
     * @param adresKodPocztowy the adresKodPocztowy to set
     */
    public void setAdresKodPocztowy(String adresKodPocztowy) {
        this.adresKodPocztowy = adresKodPocztowy;
    }

    /**
     * @return the nip
     */
    public String getNip() {
        return nip;
    }

    /**
     * @param nip the nip to set
     */
    public void setNip(String nip) {
        this.nip = nip;
    }

    /**
     * @return the liczbaProkurentow
     */
    public Long getLiczbaProkurentow() {
        return liczbaProkurentow;
    }

    /**
     * @param liczbaProkurentow the liczbaProkurentow to set
     */
    public void setLiczbaProkurentow(Long liczbaProkurentow) {
        this.liczbaProkurentow = liczbaProkurentow;
    }

    /**
     * @return the nieprzedsiebiorca
     */
    public Boolean getNieprzedsiebiorca() {
        return nieprzedsiebiorca;
    }

    /**
     * @param nieprzedsiebiorca the nieprzedsiebiorca to set
     */
    public void setNieprzedsiebiorca(Boolean nieprzedsiebiorca) {
        this.nieprzedsiebiorca = nieprzedsiebiorca;
    }

    /**
     * @return the www
     */
    public String getWww() {
        return www;
    }

    /**
     * @param www the www to set
     */
    public void setWww(String www) {
        this.www = www;
    }

    /**
     * @return the formaPrawna
     */
    public String getFormaPrawna() {
        return formaPrawna;
    }

    /**
     * @param formaPrawna the formaPrawna to set
     */
    public void setFormaPrawna(String formaPrawna) {
        this.formaPrawna = formaPrawna;
    }

    /**
     * @return the nazwaOrganuReprezentacji
     */
    public String getNazwaOrganuReprezentacji() {
        return nazwaOrganuReprezentacji;
    }

    /**
     * @param nazwaOrganuReprezentacji the nazwaOrganuReprezentacji to set
     */
    public void setNazwaOrganuReprezentacji(String nazwaOrganuReprezentacji) {
        this.nazwaOrganuReprezentacji = nazwaOrganuReprezentacji;
    }

    /**
     * @return the adres
     */
//    public Address getAdres() {
//        return adres;
//    }

    /**
     * @param adres the adres to set
     */
//    public void setAdres(Address adres) {
//        this.adres = adres;
//    }

    /**
     * @return the podmiotyId
     */
    public String getPodmiotyId() {
        return podmiotyId;
    }

    /**
     * @param podmiotyId the podmiotyId to set
     */
    public void setPodmiotyId(String podmiotyId) {
        this.podmiotyId = podmiotyId;
    }

    /**
     * @return the liczbaAkcjiWszystkichEmisji
     */
    public Long getLiczbaAkcjiWszystkichEmisji() {
        return liczbaAkcjiWszystkichEmisji;
    }

    /**
     * @param liczbaAkcjiWszystkichEmisji the liczbaAkcjiWszystkichEmisji to set
     */
    public void setLiczbaAkcjiWszystkichEmisji(Long liczbaAkcjiWszystkichEmisji) {
        this.liczbaAkcjiWszystkichEmisji = liczbaAkcjiWszystkichEmisji;
    }

    /**
     * @return the dotacjeUeBeneficjentId
     */
    public String getDotacjeUeBeneficjentId() {
        return dotacjeUeBeneficjentId;
    }

    /**
     * @param dotacjeUeBeneficjentId the dotacjeUeBeneficjentId to set
     */
    public void setDotacjeUeBeneficjentId(String dotacjeUeBeneficjentId) {
        this.dotacjeUeBeneficjentId = dotacjeUeBeneficjentId;
    }

    /**
     * @return the liczbaEmisjiAkcji
     */
    public Long getLiczbaEmisjiAkcji() {
        return liczbaEmisjiAkcji;
    }

    /**
     * @param liczbaEmisjiAkcji the liczbaEmisjiAkcji to set
     */
    public void setLiczbaEmisjiAkcji(Long liczbaEmisjiAkcji) {
        this.liczbaEmisjiAkcji = liczbaEmisjiAkcji;
    }

    /**
     * @return the twitterAccount_id
     */
    public String getTwitterAccount_id() {
        return twitterAccount_id;
    }

    /**
     * @param twitterAccount_id the twitterAccount_id to set
     */
    public void setTwitterAccount_id(String twitterAccount_id) {
        this.twitterAccount_id = twitterAccount_id;
    }

    /**
     * @return the dataDokonaniaWpisu
     */
    public String getDataDokonaniaWpisu() {
        return dataDokonaniaWpisu;
    }

    /**
     * @param dataDokonaniaWpisu the dataDokonaniaWpisu to set
     */
    public void setDataDokonaniaWpisu(String dataDokonaniaWpisu) {
        this.dataDokonaniaWpisu = dataDokonaniaWpisu;
    }

    /**
     * @return the nazwaOrganuNadzoru
     */
    public String getNazwaOrganuNadzoru() {
        return nazwaOrganuNadzoru;
    }

    /**
     * @param nazwaOrganuNadzoru the nazwaOrganuNadzoru to set
     */
    public void setNazwaOrganuNadzoru(String nazwaOrganuNadzoru) {
        this.nazwaOrganuNadzoru = nazwaOrganuNadzoru;
    }

    /**
     * @return the wartoscCzescKapitaluWplaconego
     */
    public Long getWartoscCzescKapitaluWplaconego() {
        return wartoscCzescKapitaluWplaconego;
    }

    /**
     * @param wartoscCzescKapitaluWplaconego the wartoscCzescKapitaluWplaconego to set
     */
    public void setWartoscCzescKapitaluWplaconego(Long wartoscCzescKapitaluWplaconego) {
        this.wartoscCzescKapitaluWplaconego = wartoscCzescKapitaluWplaconego;
    }

    /**
     * @return the wartoscNominalnaPodwyzszeniaKapitalu
     */
    public Long getWartoscNominalnaPodwyzszeniaKapitalu() {
        return wartoscNominalnaPodwyzszeniaKapitalu;
    }

    /**
     * @param wartoscNominalnaPodwyzszeniaKapitalu the wartoscNominalnaPodwyzszeniaKapitalu to set
     */
    public void setWartoscNominalnaPodwyzszeniaKapitalu(Long wartoscNominalnaPodwyzszeniaKapitalu) {
        this.wartoscNominalnaPodwyzszeniaKapitalu = wartoscNominalnaPodwyzszeniaKapitalu;
    }

    /**
     * @return the dataRejestracjiPrzedsiebiorcy
     */
    public String getDataRejestracjiPrzedsiebiorcy() {
        return dataRejestracjiPrzedsiebiorcy;
    }

    /**
     * @param dataRejestracjiPrzedsiebiorcy the dataRejestracjiPrzedsiebiorcy to set
     */
    public void setDataRejestracjiPrzedsiebiorcy(String dataRejestracjiPrzedsiebiorcy) {
        this.dataRejestracjiPrzedsiebiorcy = dataRejestracjiPrzedsiebiorcy;
    }

    /**
     * @return the firma
     */
    public String getFirma() {
        return firma;
    }

    /**
     * @param firma the firma to set
     */
    public void setFirma(String firma) {
        this.firma = firma;
    }

    /**
     * @return the liczbaJedynychAkcjonariuszy
     */
    public Long getLiczbaJedynychAkcjonariuszy() {
        return liczbaJedynychAkcjonariuszy;
    }

    /**
     * @param liczbaJedynychAkcjonariuszy the liczbaJedynychAkcjonariuszy to set
     */
    public void setLiczbaJedynychAkcjonariuszy(Long liczbaJedynychAkcjonariuszy) {
        this.liczbaJedynychAkcjonariuszy = liczbaJedynychAkcjonariuszy;
    }

    /**
     * @return the dataRejestracjiStowarzyszenia
     */
    public String getDataRejestracjiStowarzyszenia() {
        return dataRejestracjiStowarzyszenia;
    }

    /**
     * @param dataRejestracjiStowarzyszenia the dataRejestracjiStowarzyszenia to set
     */
    public void setDataRejestracjiStowarzyszenia(String dataRejestracjiStowarzyszenia) {
        this.dataRejestracjiStowarzyszenia = dataRejestracjiStowarzyszenia;
    }

    /**
     * @return the liczbaNadzorcow
     */
    public Long getLiczbaNadzorcow() {
        return liczbaNadzorcow;
    }

    /**
     * @param liczbaNadzorcow the liczbaNadzorcow to set
     */
    public void setLiczbaNadzorcow(Long liczbaNadzorcow) {
        this.liczbaNadzorcow = liczbaNadzorcow;
    }

    /**
     * @return the sposobReprezentacji
     */
    public String getSposobReprezentacji() {
        return sposobReprezentacji;
    }

    /**
     * @param sposobReprezentacji the sposobReprezentacji to set
     */
    public void setSposobReprezentacji(String sposobReprezentacji) {
        this.sposobReprezentacji = sposobReprezentacji;
    }

    /**
     * @return the liczbaZmian
     */
    public Long getLiczbaZmian() {
        return liczbaZmian;
    }

    /**
     * @param liczbaZmian the liczbaZmian to set
     */
    public void setLiczbaZmian(Long liczbaZmian) {
        this.liczbaZmian = liczbaZmian;
    }

    /**
     * @return the sygnaturaAkt
     */
    public String getSygnaturaAkt() {
        return sygnaturaAkt;
    }

    /**
     * @param sygnaturaAkt the sygnaturaAkt to set
     */
    public void setSygnaturaAkt(String sygnaturaAkt) {
        this.sygnaturaAkt = sygnaturaAkt;
    }

    /**
     * @return the liczbaWspolnikow
     */
    public Long getLiczbaWspolnikow() {
        return liczbaWspolnikow;
    }

    /**
     * @param liczbaWspolnikow the liczbaWspolnikow to set
     */
    public void setLiczbaWspolnikow(Long liczbaWspolnikow) {
        this.liczbaWspolnikow = liczbaWspolnikow;
    }

    /**
     * @return the nazwaSkrocona
     */
    public String getNazwaSkrocona() {
        return nazwaSkrocona;
    }

    /**
     * @param nazwaSkrocona the nazwaSkrocona to set
     */
    public void setNazwaSkrocona(String nazwaSkrocona) {
        this.nazwaSkrocona = nazwaSkrocona;
    }

    /**
     * @return the dataOstatniegoWpisu
     */
    public String getDataOstatniegoWpisu() {
        return dataOstatniegoWpisu;
    }

    /**
     * @param dataOstatniegoWpisu the dataOstatniegoWpisu to set
     */
    public void setDataOstatniegoWpisu(String dataOstatniegoWpisu) {
        this.dataOstatniegoWpisu = dataOstatniegoWpisu;
    }

    /**
     * @return the liczbaReprezentantow
     */
    public Long getLiczbaReprezentantow() {
        return liczbaReprezentantow;
    }

    /**
     * @param liczbaReprezentantow the liczbaReprezentantow to set
     */
    public void setLiczbaReprezentantow(Long liczbaReprezentantow) {
        this.liczbaReprezentantow = liczbaReprezentantow;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the kapitalDocelowy
     */
    public Long getKapitalDocelowy() {
        return kapitalDocelowy;
    }

    /**
     * @param kapitalDocelowy the kapitalDocelowy to set
     */
    public void setKapitalDocelowy(Long kapitalDocelowy) {
        this.kapitalDocelowy = kapitalDocelowy;
    }

    /**
     * @return the wartoscNominalnaAkcji
     */
    public Long getWartoscNominalnaAkcji() {
        return wartoscNominalnaAkcji;
    }

    /**
     * @param wartoscNominalnaAkcji the wartoscNominalnaAkcji to set
     */
    public void setWartoscNominalnaAkcji(Long wartoscNominalnaAkcji) {
        this.wartoscNominalnaAkcji = wartoscNominalnaAkcji;
    }

    /**
     * @return the gpwSpolkaId
     */
    public String getGpwSpolkaId() {
        return gpwSpolkaId;
    }

    /**
     * @param gpwSpolkaId the gpwSpolkaId to set
     */
    public void setGpwSpolkaId(String gpwSpolkaId) {
        this.gpwSpolkaId = gpwSpolkaId;
    }

    /**
     * @return the knfOstrzezenie
     */
    public Boolean getKnfOstrzezenie() {
        return knfOstrzezenie;
    }

    /**
     * @param knfOstrzezenie the knfOstrzezenie to set
     */
    public void setKnfOstrzezenie(Boolean knfOstrzezenie) {
        this.knfOstrzezenie = knfOstrzezenie;
    }

    /**
     * @return the krs
     */
    public String getKrs() {
        return krs;
    }

    /**
     * @param krs the krs to set
     */
    public void setKrs(String krs) {
        this.krs = krs;
    }

    /**
     * @return the dataZawieszeniaDzialanosci
     */
    public String getDataZawieszeniaDzialanosci() {
        return dataZawieszeniaDzialanosci;
    }

    /**
     * @param dataZawieszeniaDzialanosci the dataZawieszeniaDzialanosci to set
     */
    public void setDataZawieszeniaDzialanosci(String dataZawieszeniaDzialanosci) {
        this.dataZawieszeniaDzialanosci = dataZawieszeniaDzialanosci;
    }

    /**
     * @return the dataRejestracji
     */
    public String getDataRejestracji() {
        return dataRejestracji;
    }

    /**
     * @param dataRejestracji the dataRejestracji to set
     */
    public void setDataRejestracji(String dataRejestracji) {
        this.dataRejestracji = dataRejestracji;
    }

    /**
     * @return the dataUprawomocnieniaWykreslenia
     */
    public String getDataUprawomocnieniaWykreslenia() {
        return dataUprawomocnieniaWykreslenia;
    }

    /**
     * @param dataUprawomocnieniaWykreslenia the dataUprawomocnieniaWykreslenia to set
     */
    public void setDataUprawomocnieniaWykreslenia(String dataUprawomocnieniaWykreslenia) {
        this.dataUprawomocnieniaWykreslenia = dataUprawomocnieniaWykreslenia;
    }

    /**
     * @return the liczbaOddzialow
     */
    public Long getLiczbaOddzialow() {
        return liczbaOddzialow;
    }

    /**
     * @param liczbaOddzialow the liczbaOddzialow to set
     */
    public void setLiczbaOddzialow(Long liczbaOddzialow) {
        this.liczbaOddzialow = liczbaOddzialow;
    }

    /**
     * @return the dataWznowieniaDzialanosci
     */
    public String getDataWznowieniaDzialanosci() {
        return dataWznowieniaDzialanosci;
    }

    /**
     * @param dataWznowieniaDzialanosci the dataWznowieniaDzialanosci to set
     */
    public void setDataWznowieniaDzialanosci(String dataWznowieniaDzialanosci) {
        this.dataWznowieniaDzialanosci = dataWznowieniaDzialanosci;
    }

    /**
     * @return the umowaSpolkiCywilnej
     */
    public Boolean getUmowaSpolkiCywilnej() {
        return umowaSpolkiCywilnej;
    }

    /**
     * @param umowaSpolkiCywilnej the umowaSpolkiCywilnej to set
     */
    public void setUmowaSpolkiCywilnej(Boolean umowaSpolkiCywilnej) {
        this.umowaSpolkiCywilnej = umowaSpolkiCywilnej;
    }

    /**
     * @return the dataWykreslenieRejestrPrzedsiebiorcow
     */
    public String getDataWykreslenieRejestrPrzedsiebiorcow() {
        return dataWykreslenieRejestrPrzedsiebiorcow;
    }

    /**
     * @param dataWykreslenieRejestrPrzedsiebiorcow the dataWykreslenieRejestrPrzedsiebiorcow to set
     */
    public void setDataWykreslenieRejestrPrzedsiebiorcow(String dataWykreslenieRejestrPrzedsiebiorcow) {
        this.dataWykreslenieRejestrPrzedsiebiorcow = dataWykreslenieRejestrPrzedsiebiorcow;
    }

    /**
     * @return the dataWykreslenieRejestrStowarzyszen
     */
    public String getDataWykreslenieRejestrStowarzyszen() {
        return dataWykreslenieRejestrStowarzyszen;
    }

    /**
     * @param dataWykreslenieRejestrStowarzyszen the dataWykreslenieRejestrStowarzyszen to set
     */
    public void setDataWykreslenieRejestrStowarzyszen(String dataWykreslenieRejestrStowarzyszen) {
        this.dataWykreslenieRejestrStowarzyszen = dataWykreslenieRejestrStowarzyszen;
    }

    /**
     * @return the dataWpisRejestrStowarzyszen
     */
    public String getDataWpisRejestrStowarzyszen() {
        return dataWpisRejestrStowarzyszen;
    }

    /**
     * @param dataWpisRejestrStowarzyszen the dataWpisRejestrStowarzyszen to set
     */
    public void setDataWpisRejestrStowarzyszen(String dataWpisRejestrStowarzyszen) {
        this.dataWpisRejestrStowarzyszen = dataWpisRejestrStowarzyszen;
    }

    /**
     * @return the adres
     */
    public Address getAdres() {
        return adres;
    }

    /**
     * @param adres the adres to set
     */
    public void setAdres(Address adres) {
        this.adres = adres;
    }

    /**
     * @return the oznaczenieSadu
     */
//    public Court getOznaczenieSadu() {
//        return oznaczenieSadu;
//    }

    /**
     * @param oznaczenieSadu the oznaczenieSadu to set
     */
//    public void setOznaczenieSadu(Court oznaczenieSadu) {
//        this.oznaczenieSadu = oznaczenieSadu;
//    }



}
