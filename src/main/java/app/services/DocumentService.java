package app.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class DocumentService {

    // nie jest podlaczone, trzrba zrobic jeszcze event type
    public static void handleDocument(String document, List<String> keywords) {

        List<String> foundKeywords = findKeywordsInDocument(document, keywords);
        boolean isDocumentRightType = isDocumentRightType(keywords, foundKeywords);
        System.out.println("Przeszukiwany dokument " + (isDocumentRightType ? "Jest szukanym typem" : "Nie jest szukanym typem"));
    }

    public static List<String> findKeywordsInDocument(String document, List<String> keyWords) {

        List<String> keywordsLowercase = new ArrayList<>();
        List<String> foundWords = new ArrayList<>();
        keyWords.forEach(keyWord -> keywordsLowercase.add(keyWord.toLowerCase()));

        String patternString = "\\b(" + StringUtils.join(keywordsLowercase, "|") + ")\\b";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(document.toLowerCase());

        while (matcher.find()) {
            foundWords.add(matcher.group(1));
        }

        return removeDuplicates(foundWords);
    }

    public static List<String> removeDuplicates(List<String> keywords) {
        Set<String> tempSet = new HashSet<>();
        tempSet.addAll(keywords);
        keywords.clear();
        keywords.addAll(tempSet);
        return keywords;
    }

    public static boolean isDocumentRightType(List<String> keywords, List<String> foundKeywords) {

        if (keywords.size() != foundKeywords.size()) {
            return false;
        }

        List<String> keywordsLowercase = new ArrayList<>();
        keywords.forEach(keyWord -> keywordsLowercase.add(keyWord.toLowerCase()));

        Collections.sort(keywordsLowercase);
        Collections.sort(foundKeywords);

        return keywordsLowercase.equals(foundKeywords);
    }

    public String findSignature(String document) {
        String regex = "[IVXC]+\\s?[a-zA-Z]?\\s?[a-zA-Z]\\s?\\d+\\/\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(document);

        if (matcher.find()) {
            return matcher.group(0);
        }
        return "brak";
    }


}
