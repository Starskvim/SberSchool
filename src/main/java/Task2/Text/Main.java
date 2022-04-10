package Task2.Text;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Path path = Paths.get("Task2Text.txt");
        List<String> words = Utils.getWords(path);

        System.out.println("------------------------");
        System.out.println("Всего слов:" + words.size());
        System.out.println("Уникальных слов:" + Utils.countUniqueWords(words));
        System.out.println("------------------------");
        System.out.println("Статистика по словам:\n" + Utils.getWordsStat(words));
        System.out.println("Уникальные слова в сортированном порядке:\n" + Utils.sortingTask(words));

        System.out.println("---N строка файла N>=1---");
        System.out.println(Utils.getNLine(path, 1));
        System.out.println(Utils.getNLine(path, 2));
        System.out.println(Utils.getNLine(path, 3));
        System.out.println(Utils.getNLine(path, 5));
        System.out.println("------------------------");

        //Итератор
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        IteratorRevers<String> reversedList = new IteratorRevers<>(data);

        for(String s : reversedList){
            System.out.println(s);
        }

        System.out.println("--------Читает с конца файл-------");
         Utils.readFileFromBack(path);
    }



}
