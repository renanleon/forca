package com.renanleon.forca.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtil {

    public static String removeAcento(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
