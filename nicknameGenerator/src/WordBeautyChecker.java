import java.util.concurrent.atomic.AtomicInteger;

public class WordBeautyChecker {
    public AtomicInteger counter = new AtomicInteger(0);


    public void firstRule(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(new StringBuilder(words[i]).reverse().toString())) {
                counter.incrementAndGet();
            }
        }
    }

    public void secondRule(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (secondRuleChecker(words[i])) {
                counter.incrementAndGet();
            }
        }
    }

    private Boolean secondRuleChecker(String word) {
        for(int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(0)) {
            } else {
                return false;
            }
        }
        return true;
    }

    public void thirdRule(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (thirdRuleChecker(words[i])) {
                counter.incrementAndGet();
            }
        }
    }

    private Boolean thirdRuleChecker(String word) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
            for(int i = 1; i < word.length(); i++) {
                if (alphabet.indexOf(word.charAt(i)) >= alphabet.indexOf(word.charAt(i - 1))) {
                } else {
                    return false;
                }
            }
            return true;
    }

    public AtomicInteger getCounter() {
        return counter;
    }
}
