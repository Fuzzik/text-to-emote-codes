package texttoemotecodes;

public class Logic {
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                       'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] cyrillic = {'Ѐ', 'Ё', 'Ђ', 'Ѓ', 'Є', 'Ї', 'Љ', 'Њ', 'Ћ', 'Ќ', 'Ѝ', 'Ў', 'Џ',
                       'Б', 'Г', 'Д', 'Ж', 'И', 'Й', 'Л', 'П', 'Ф', 'Ц', 'Ш', 'Ъ', 'Ы'};
    String[] emoteCodes = {":A:", ":bbbb:", ":Tiny:", ":TheD:", ":EnvE:", ":FreebieF:", ":gmod:",
                           ":hhazard:", ":gemini:", ":_J_:", ":civilwarsoldier:", ":journeyl:",
                           ":TR_M:", ":Letter_N:", ":Letter_O:", ":P:", ":_Q_:", ":Letter_R:",
                           ":CDCash:", ":tyger:", ":SmithLuckyHorseshoe:", ":SFvictory:", ":wh:",
                           ":csgox:", ":Y:", ":NZA2_Zed:"};
    
    public String toEmotes(String original) {
        String emoteMessage;
        
        emoteMessage = original.toLowerCase(); // Convert to lower case to remove case sensitivity
        
        // Convert each letter to a unique character not used in emote codes
        // Using characters from the Cyrillic Unicode block
        for (int i = 0; i < alphabet.length; ++i) {
            emoteMessage = emoteMessage.replace(alphabet[i], cyrillic[i]);
        }
        
        // Replace each Cyrillic character (English letter) with its respective emote code
        for (int i = 0; i < cyrillic.length; ++i) {
            emoteMessage = emoteMessage.replace(Character.toString(cyrillic[i]), emoteCodes[i]);
        }
        
        return emoteMessage;
    }
}
