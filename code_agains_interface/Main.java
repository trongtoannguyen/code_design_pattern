import static java.lang.System.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // client code
        // Example 1
        ISpeaker speaker = SpeakerFactory.createSpeaker(Language.GERMAN);
        ISpeaker speaker2 = SpeakerFactory.createSpeaker(Language.ENGLISH);
        speaker.speak();
        out.println();
        speaker2.speak();

        // Example 2
        Map<String, String> map = new HashMap<>();
        HashMap<String, String> hashMap = new HashMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        HashMapPrinter hashMapPrinter = new HashMapPrinter();
        hashMapPrinter.printMap(map);
        hashMapPrinter.printMap(hashMap);
        hashMapPrinter.printMap(treeMap);

        // Example 3
        MapReporter mapReporter = new MapReporter(map);
        MapReporter hashMapReporter = new MapReporter(hashMap);
        MapReporter treeMapReporter = new MapReporter(treeMap);
        hashMapReporter.printMap();
    }
}

enum Language {
    ENGLISH, GERMAN, SPANISH
}

class SpeakerFactory {
    private SpeakerFactory() {
        throw new IllegalArgumentException("Cannot instantiate the factory class.");
    }

    public static ISpeaker createSpeaker(Language language) {
        return switch (language) {
            case Language.ENGLISH -> new EnglishSpeaker();
            case Language.GERMAN -> new GermanSpeaker();
            case Language.SPANISH -> new SpanishSpeaker();
            default -> throw new IllegalArgumentException("No speaker can speak such language.");
        };
    }
}

interface ISpeaker {
    void speak();
}

class EnglishSpeaker implements ISpeaker {
    public void speak() {
        out.print("I speak English.");
    }
}

class GermanSpeaker implements ISpeaker {
    public void speak() {
        out.print("I speak German.");
    }
}

class SpanishSpeaker implements ISpeaker {
    public SpanishSpeaker() {
        throw new  UnsupportedOperationException("Not implemented yet.");
    }

    public void speak() {
        out.print("I speak Spanish.");
    }
}
