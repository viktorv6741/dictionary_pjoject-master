package sample;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class CollectionWords {

    private List<Word> words = new ArrayList();

    public void add(Word word) {
        this.words.add(word);
    }

    public List<Word> getMixedWords() {
        return words;
    }

    public void fillTestDataRandom() throws IOException {

        URL resource = CollectionWords.class.getClassLoader().getResource("words/dictionary.properties");
        Properties properties = new Properties();
        properties.load(new InputStreamReader(resource.openStream(), "UTF-8"));

        HashMap<String, String> map = new HashMap(properties);

        for (String key : map.keySet()) {
            words.add(new Word(key, map.get(key)));
        }
        Collections.shuffle(words);
    }

    public void print() {
        for (Word word : this.words) {
            System.out.println(this.words);
        }
    }

    public Word getRandomObject() {
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }
}
