import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        WordBeautyChecker checker = new WordBeautyChecker();

        String[] nicknames = generateNick("gjzdflk", 4);

        Thread firstRuleChecker = new Thread(null, () -> checker.firstRule(nicknames), "Поток 1");
        Thread secondRuleChecker = new Thread(null, () -> checker.secondRule(nicknames), "Поток 2");
        Thread thirdRuleChecker = new Thread(null, () -> checker.thirdRule(nicknames), "Поток 3");

        firstRuleChecker.start();
        secondRuleChecker.start();
        thirdRuleChecker.start();

        firstRuleChecker.join();
        secondRuleChecker.join();
        thirdRuleChecker.join();

        System.out.println(checker.getCounter().get());

    }

    public static String[] generateNick(String source, int length) {
        String[] nicknames = new String[100_000];
        Random random = new Random();
        for (int i = 0; i < nicknames.length; i++){
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < length; j++) {
                builder.append(source.charAt(random.nextInt(source.length())));
            }
            nicknames[i] = builder.toString();
        }
        return nicknames;
    }
}

