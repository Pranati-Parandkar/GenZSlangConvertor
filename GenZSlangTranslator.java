import java.util.*;

//INTERFACE
interface Translator {
    String translate(String sentence);
}

//ABSTRACT CLASS
abstract class SlangTranslator implements Translator {
    protected Map<String, List<String>> slangMap = new HashMap<>();
    protected Random random = new Random();

    protected abstract void initSlang();

    protected String preserveCase(String original, String slang) {
        if (original.toUpperCase().equals(original)) {
            return slang.toUpperCase();
        } else if (Character.isUpperCase(original.charAt(0))) {
            return slang.substring(0, 1).toUpperCase() + slang.substring(1);
        }
        return slang;
    }

    @Override
    public String translate(String sentence) {
        initSlang();

        boolean changed = false;
        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            String punctuation = word.replaceAll("[a-zA-Z]", "");
            String lower = cleanWord.toLowerCase();

            if (slangMap.containsKey(lower)) {
                List<String> options = slangMap.get(lower);
                String slang = options.get(random.nextInt(options.size()));
                slang = preserveCase(cleanWord, slang);
                result.append(slang).append(punctuation).append(" ");
                changed = true;
            } else {
                result.append(word).append(" ");
            }
        }

        // Fallback Gen-Z vibe if nothing changed
        if (!changed) {
            String[] fallback = {"fr", "lowkey", "not gonna lie", "vibes"};
            result.append(fallback[random.nextInt(fallback.length)]);
        }

        return result.toString().trim();
    }
}

//SOFT MODE
class SoftTranslator extends SlangTranslator {
    protected void initSlang() {
        slangMap.put("hi", List.of("hey", "hello"));
        slangMap.put("hey", List.of("yo"));
        slangMap.put("friend", List.of("bestie"));
        slangMap.put("cool", List.of("nice", "pretty cool"));
        slangMap.put("love", List.of("fr adore", "fr adore"));
        slangMap.put("i", List.of("i"));
        slangMap.put("you", List.of("u"));
        slangMap.put("good", List.of("nice", "sweet"));
        slangMap.put("amazing", List.of("awesome", "wow"));
        slangMap.put("yes", List.of("yeah", "yup"));
        slangMap.put("no", List.of("nah", "nope"));
        slangMap.put("wow", List.of("wow", "ooh"));
        slangMap.put("friend group", List.of("squad", "gang"));
        slangMap.put("party", List.of("chill", "fun"));
        slangMap.put("homework", List.of("assignment", "work"));
        slangMap.put("assignment", List.of("torturing assignment"));
        slangMap.put("school", List.of("class", "campus"));
        slangMap.put("yes please", List.of("yeah sure"));
        slangMap.put("no thanks", List.of("nah"));
        slangMap.put("sad", List.of("down", "upset"));
        slangMap.put("happy", List.of("good vibes", "cheerful"));
        slangMap.put("tired", List.of("sleepy", "beat"));
        slangMap.put("hungry", List.of("starving", "peckish"));
        slangMap.put("eat", List.of("munch", "snack"));
        slangMap.put("eating", List.of("munching", "snacking"));
        slangMap.put("code", List.of("work", "program"));
        slangMap.put("coding", List.of("programming", "working"));
        slangMap.put("get", List.of("receive", "grab"));
        slangMap.put("getting", List.of("receiving", "grabbing"));
        slangMap.put("play", List.of("hang out", "have fun"));
        slangMap.put("playing", List.of("hanging out", "having fun"));
        slangMap.put("study", List.of("review", "learn"));
        slangMap.put("studying", List.of("reviewing", "learning"));
    }
}

//SAVAGE MODE
class SavageTranslator extends SlangTranslator {
    protected void initSlang() {
        slangMap.put("hi", List.of("yo", "sup"));
        slangMap.put("hey", List.of("yo bro"));
        slangMap.put("friend", List.of("bestie", "bro"));
        slangMap.put("cool", List.of("fire", "goated"));
        slangMap.put("love", List.of("lowkey love", "lowkey love"));
        slangMap.put("i", List.of("i"));
        slangMap.put("you", List.of("u", "uuu"));
        slangMap.put("good", List.of("slay", "strong"));
        slangMap.put("amazing", List.of("fire", "beast"));
        slangMap.put("yes", List.of("yass", "fr"));
        slangMap.put("no", List.of("fr", "nah"));
        slangMap.put("wow", List.of("fr", "insane"));
        slangMap.put("friend group", List.of("squad", "bros"));
        slangMap.put("party", List.of("lit", "wild"));
        slangMap.put("homework", List.of("drag", "task"));
        slangMap.put("assignment", List.of("drag", "torturing assignment"));
        slangMap.put("school", List.of("grind", "place"));
        slangMap.put("yes please", List.of("fr yes"));
        slangMap.put("no thanks", List.of("fr nah"));
        slangMap.put("sad", List.of("weak", "rip"));
        slangMap.put("happy", List.of("hype", "stoked"));
        slangMap.put("tired", List.of("wrecked", "drained"));
        slangMap.put("hungry", List.of("famished", "weak"));
        slangMap.put("eat", List.of("chow", "nom"));
        slangMap.put("eating", List.of("chomping", "feasting"));
        slangMap.put("code", List.of("grind", "hack"));
        slangMap.put("coding", List.of("grinding", "hacking"));
        slangMap.put("get", List.of("snag", "cop"));
        slangMap.put("getting", List.of("snagging", "copping"));
        slangMap.put("play", List.of("chill", "hang"));
        slangMap.put("playing", List.of("chilling", "hanging"));
        slangMap.put("study", List.of("grind", "work"));
        slangMap.put("studying", List.of("grinding", "working"));
    }
}

//UNHINGED MODE
class UnhingedTranslator extends SlangTranslator {
    protected void initSlang() {
        slangMap.put("hi", List.of("YO", "AYOO"));
        slangMap.put("hey", List.of("YO BRO"));
        slangMap.put("friend", List.of("BESTIEEE", "BROOO"));
        slangMap.put("cool", List.of("STRAIGHT FIRE", "INSANE"));
        slangMap.put("love", List.of("LOWKEY LOVEE", "FR ADORE"));
        slangMap.put("i", List.of("I"));
        slangMap.put("you", List.of("UUU", "Uuuu"));
        slangMap.put("good", List.of("ABSOLUTELY LIT", "UNREAL"));
        slangMap.put("amazing", List.of("LEGENDARY", "GOD TIER"));
        slangMap.put("yes", List.of("YAAAAS", "OMG YES"));
        slangMap.put("no", List.of("NAHHH", "NOOOO"));
        slangMap.put("wow", List.of("HOLY MOLY", "WHOA"));
        slangMap.put("friend group", List.of("LEGENDARY SQUAD", "THE UNSTOPPABLES"));
        slangMap.put("party", List.of("CRAZY PARTY", "UNHINGED NIGHT"));
        slangMap.put("homework", List.of("TORTURE PAPER", "LIFE SUCKUCKING ASSIGNMENT"));
        slangMap.put("assignment", List.of("TORTURE PAPER", "LIFE SUCKUCKING ASSIGNMENT"));
        slangMap.put("school", List.of("HELLHOUSE", "NIGHTMARE SCHOOL"));
        slangMap.put("yes please", List.of("YAAAAS"));
        slangMap.put("no thanks", List.of("NOOOO"));
        slangMap.put("sad", List.of("DEVASTATED", "CRYING"));
        slangMap.put("happy", List.of("ECSTATIC", "LIT"));
        slangMap.put("tired", List.of("DEAD", "ZOMBIE MODE"));
        slangMap.put("hungry", List.of("STARVING", "CANNOT EVEN"));
        slangMap.put("eat", List.of("MUNCH", "MUNCH"));
        slangMap.put("eating", List.of("MUNCHING", "MUNCHING"));
        slangMap.put("code", List.of("HACK THE PLANET", "MASTER CODE"));
        slangMap.put("coding", List.of("HACKING", "MASTERING CODE"));
        slangMap.put("get", List.of("OBTAIN", "GRAB"));
        slangMap.put("getting", List.of("OBTAINING", "GRABBING"));
        slangMap.put("play", List.of("LOWKEY PLAY", "HAVE FUN"));
        slangMap.put("playing", List.of("HAVING FUN"));
        slangMap.put("study", List.of("GRIND","GRIND"));
        slangMap.put("studying", List.of("GRINDING","GRINDING"));
    }
}

//THREAD CLASS
class TranslationThread extends Thread {
    private Translator translator;
    private String sentence;

    TranslationThread(Translator translator, String sentence) {
        this.translator = translator;
        this.sentence = sentence;
    }

    @Override
    public void run() {
        try {
            System.out.println("\nTranslating...");
            Thread.sleep(800);
            System.out.println("\nTranslated Sentence:");
            System.out.println(translator.translate(sentence));
        } catch (InterruptedException e) {
            System.out.println("Translation interrupted");
        }
    }
}

//MAIN
public class GenZSlangTranslator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Gen-Z Slang Translator");

        while (true) {
            System.out.println("\nChoose Gen-Z tone:");
            System.out.println("1. Soft");
            System.out.println("2. Savage");
            System.out.println("3. Unhinged");
            System.out.println("0. Exit");

            String choice = sc.nextLine();
            if (choice.equals("0")) {
                System.out.println("Bye!");
                break;
            }

            Translator translator;
            switch (choice) {
                case "1":
                    translator = new SoftTranslator();
                    break;
                case "2":
                    translator = new SavageTranslator();
                    break;
                case "3":
                    translator = new UnhingedTranslator();
                    break;
                default:
                    System.out.println("Invalid choice, try again");
                    continue;
            }

            System.out.println("\nEnter a sentence:");
            String sentence = sc.nextLine();

            Thread t = new TranslationThread(translator, sentence);
            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Thread error");
            }
        }
        sc.close();
    }
}
