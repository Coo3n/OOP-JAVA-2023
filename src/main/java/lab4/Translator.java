package lab4;


import java.util.Map;

public class Translator {
    private Map<String, String> dictionary;

    public Translator(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public String getTranslateString(String inputText) {
        String translatedString = inputText.trim().toLowerCase();

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            translatedString = translatedString.replaceAll(entry.getKey(), entry.getValue());
        }

        return translatedString;
    }
}
