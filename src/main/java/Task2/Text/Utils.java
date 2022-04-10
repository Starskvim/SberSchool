package Task2.Text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static List<String> getWords(Path path) {

        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(
                    line -> {
                        Matcher matcher = pattern.matcher(line);
                        while (matcher.find()) {
                            words.add(matcher.group().toLowerCase());
                        }
                    });
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return words;
    }

    public static int countUniqueWords(List<String> words) {
        return new HashSet<>(words).size();
    }

    public static Map<String, Integer> getWordsStat(List<String> words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map;
    }

    // Выведите на экран список различных слов файла, отсортированный
    // по возрастанию их длины (компаратор сначала по длине слова, потом по тексту)

    public static Set<String> sortingTask(List<String> words) {

        Comparator<String> comparator = Comparator.comparing(String::length);
        comparator = comparator.thenComparing(s -> s);
        Set<String> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(words);

        return treeSet;
    }

    public static void readFileFromBack(Path path) {
        try (Stream<String> lines = Files.lines(path)) {
            lines
                    .collect(Collectors.toCollection(ArrayDeque::new))
                    .descendingIterator()
                    .forEachRemaining(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getNLine(Path path, int n) {

        if (n <= 0) throw new IllegalArgumentException("n>0");

        try (Stream<String> lines = Files.lines(path)) {
            Optional<String> optionalLine = lines.skip(n - 1).findFirst();
            if (optionalLine.isPresent()) return optionalLine.get();
            else throw new IllegalArgumentException("n>lines count");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
