package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.apache.commons.math3.random.RandomData;
import org.apache.commons.math3.random.RandomDataImpl;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Text txtQuestion;
    @FXML
    private Text txtAnswer1;
    @FXML
    private Text txtAnswer2;
    @FXML
    private Text txtAnswer3;
    @FXML
    private Text correctAnswer;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtQuestion.setFill(Color.BLUE);
        txtQuestion.setText("Press Next to Start");
        txtAnswer1.setText("");
        txtAnswer2.setText("");
        txtAnswer3.setText("");
    }

    public void add(ActionEvent event) {
        System.out.println("Agrh !!!");
    }

    public void answer1(Event event) {
        analyzedMethod(txtAnswer1, correctAnswer.getText());
    }

    public void answer2(Event event) {
        analyzedMethod(txtAnswer2, correctAnswer.getText());
    }

    public void answer3(Event event) {
        analyzedMethod(txtAnswer3, correctAnswer.getText());
    }


    private void analyzedMethod(Text answerTxtField, String strToCompare) {
        if (answerTxtField.getText().equals(strToCompare)) {
            answerTxtField.setFill(Color.GREEN);
        } else {
            answerTxtField.setFill(Color.RED);
            answerTxtField.setStrikethrough(true);
        }
    }

    public void next(ActionEvent event) throws IOException {

        txtQuestion.setFill(Color.BLACK);
        txtAnswer1.setFill(Color.BLACK);
        txtAnswer1.setStrikethrough(false);

        txtAnswer2.setFill(Color.BLACK);
        txtAnswer2.setStrikethrough(false);

        txtAnswer3.setFill(Color.BLACK);
        txtAnswer3.setStrikethrough(false);

        CollectionWords collectionWords = new CollectionWords();
        collectionWords.fillTestDataRandom();

        List<Text> textList = Arrays.asList(new Text[]{txtAnswer1, txtAnswer3, txtAnswer2});
        List<Word> words = fillUITextFieldsRandom(collectionWords, textList);
        setRandomQuestion(words, textList);
    }

    private void setRandomQuestion(List<Word> words, List<Text> textList) {
        Word word = words.get(getRandomQuestion(textList));
        txtQuestion.setText(word.getRus());
        correctAnswer.setText(word.getEng());
    }

    private List<Word> fillUITextFieldsRandom(CollectionWords collectionWords, List<Text> textList) {
        List<Word> words = collectionWords.getMixedWords();
        assert words.size() >= textList.size();
        //mix text-fields
        Collections.shuffle(textList);
        for (int i = 0; i < textList.size(); i++) {
            textList.get(i).setText(words.get(i).getEng());
        }
        return words;
    }

    private int getRandomQuestion(List<Text> textList) {
        assert textList.size() > 0;
        RandomData randomData = new RandomDataImpl();
        return randomData.nextInt(0, textList.size() - 1);
    }
}
