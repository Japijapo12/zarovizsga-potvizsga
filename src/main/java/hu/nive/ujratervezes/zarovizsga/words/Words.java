package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String s) {
        int countDigit = 0;
        int countOther = 0;

        for (char c: s.toCharArray()) {

            if (Character.isDigit(c)) {
                countDigit++;
            }

            else {
                countOther++;
            }

        }
        return countDigit > countOther;
    }
}
