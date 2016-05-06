package sample;

public class Word {

    private String eng;
    private String rus;

    public Word(String eng, String rus) {
        this.eng = eng;
        this.rus = rus;
    }

    public Word() {
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getRus() {
        return rus;
    }

    public void setRus(String rus) {
        this.rus = rus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (getEng() != null ? !getEng().equals(word.getEng()) : word.getEng() != null) return false;
        return !(getRus() != null ? !getRus().equals(word.getRus()) : word.getRus() != null);

    }

    @Override
    public int hashCode() {
        int result = getEng() != null ? getEng().hashCode() : 0;
        result = 31 * result + (getRus() != null ? getRus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ENG -> " + eng + '\n' +
                "RUS -> " + rus + '\n';
    }
}
