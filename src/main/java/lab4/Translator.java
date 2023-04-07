package lab4;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Translator {
    private Map<String, String> dictionary;

    public String getTranslateString(String inputText) {
        String translatedString = inputText.trim().toLowerCase();

        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            translatedString = translatedString.replaceAll(entry.getKey(), entry.getValue());
        }

        return translatedString;
    }
}
