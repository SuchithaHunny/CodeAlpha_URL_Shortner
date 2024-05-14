import java.util.HashMap;
import java.util.Random;

public class URLShortener {
    private HashMap<String, String> shortToOriginalMap;
    private HashMap<String, String> originalToShortMap;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    public URLShortener() {
        this.shortToOriginalMap = new HashMap<>();
        this.originalToShortMap = new HashMap<>();
    }

    public String shortenURL(String originalURL) {
        if (originalToShortMap.containsKey(originalURL)) {
            return originalToShortMap.get(originalURL);
        }

        String shortURL = generateShortURL();
        shortToOriginalMap.put(shortURL, originalURL);
        originalToShortMap.put(originalURL, shortURL);
        return shortURL;
    }

    public String getOriginalURL(String shortURL) {
        return shortToOriginalMap.get(shortURL);
    }

    private String generateShortURL() {
        StringBuilder shortURL = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            shortURL.append(CHARACTERS.charAt(index));
        }
        return shortURL.toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String originalURL = "https://www.example.com/very/long/url/that/we/want/to/shorten";
        String shortURL = shortener.shortenURL(originalURL);
        System.out.println("Shortened URL: " + shortURL);
        String retrievedOriginalURL = shortener.getOriginalURL(shortURL);
        System.out.println("Retrieved Original URL: " + retrievedOriginalURL);
    }
}
