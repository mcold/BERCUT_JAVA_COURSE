/**
 * «война и мир – том первый»
 * Программа подсчета популярных слов Толстого – Размер слова >= 3 символа
 * Результаты подсчёта вывести в файл results.txt
 * Выводить только те слова, которые встречаются >= 100 раз
 * Доп 1: реализуйте на Java 8 Stream API
 * Доп 2: Найти топ 3 прилагательных
 */

/** Комментарии:
 * Доп 2: не знаю как точно отфильтровать (убрать существительные)
 *
 */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TASK_51 {

    public static void main(String[] args) throws IOException {

        simple_split();
        // stream_api();
        // get_adj();
    }


    public static void simple_split() throws IOException {
        String file_name = "vim1.txt";
        Integer limit_length = 3;
        Integer limit_count = 100;

        Path p = Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\" + file_name);
        List<String> lines = Files.readAllLines(p, Charset.forName("UTF-8"));
        HashMap<String, Integer> mItems = new HashMap<>();

        String var = null;
        for(int i = 0; i < lines.size(); i++){
            List<String> arrLine = Arrays.asList(lines.get(i).split("\\s+|\\p{Punct}+"));
            for(int j = 0; j < arrLine.size(); j++){
                var = arrLine.get(j).replace(" ", "");
                if(var != "" && var.toCharArray().length > limit_length && mItems.putIfAbsent(var, 1) != null){
                    mItems.replace(var, mItems.get(var)+1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(mItems.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            if(entry.getValue() > limit_count){
                System.out.println(entry.getKey() + "   " + entry.getValue());
            }
        }
    }

    public static void stream_api() throws IOException{
        String file_name = "vim1.txt";
        Integer limit_length = 3;

        Integer limit_count = 100;

        Path p = Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\" + file_name);
        List<String> lines = Files.readAllLines(p, Charset.forName("UTF-8"));
        HashMap<String, Integer> mItems = new HashMap<>();

        String var = null;
        for(int i = 0; i < lines.size(); i++){
            List<String> arrLine = Arrays.asList(lines.get(i).split("\\s+|\\p{Punct}+"));
            for(int j = 0; j < arrLine.size(); j++){
                var = arrLine.get(j).replace(" ", "");
                if(var != "" && var.toCharArray().length > limit_length && mItems.putIfAbsent(var, 1) != null){
                    mItems.replace(var, mItems.get(var)+1);
                }
            }
        }

        List<String> resMap = mItems.entrySet()
                                          .stream()
                                          .filter((e -> e.getKey().length() >= limit_length))
                                          .filter(e -> e.getValue() >= limit_count)
                                          .sorted(Comparator.comparing(Map.Entry::getKey))
                                          .sorted(Comparator.comparing(Map.Entry::getValue))
                                          .map(Object::toString)
                                          .collect(Collectors.toList());
        for(String key: resMap){
            System.out.println(key);
        }

    }

    public static void get_adj() throws IOException {
        String file_name = "vim1.txt";
        Integer limit_length = 3;
        String key = null;
        String val = null;

        Path p = Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\" + file_name);
        Stream<String> linesStream = Files.lines(p, Charset.forName("UTF-8"));
        HashMap<String, Integer> mItems = new HashMap<>();

        String[] arr = linesStream.toArray(String[]::new);
        String var = null;
        for(int i = 0; i < arr.length; i++){
            List<String> arrLine = Arrays.asList(arr[i].split("\\s+|\\p{Punct}+"));
            for(int j = 0; j < arrLine.size(); j++){
                var = arrLine.get(j).replace(" ", "");
                if(var != "" && isAdj(var) && var.toCharArray().length > limit_length && mItems.putIfAbsent(var, 1) != null) {
                    mItems.replace(var, mItems.get(var) + 1);
                }
            }
        }

        for(int i = 0; i < 3; i++){
            key = Collections.max(mItems.entrySet(), Map.Entry.comparingByValue()).getKey();
            val = mItems.get(key).toString();
            System.out.println(key + " : " + val);
            mItems.remove(key);
        }
    }

    public static boolean isAdj(String name){
        List<String> arr = Arrays.asList("ый", "ой", "ий", "ая", "ое", "ые", "ого", "его", "ому", "ему", "ым", "им", "ую", "юю", "ей", "ые", "ие", "ых", "их", "ыми", "ими", "ее");
        for(String str: arr){
            if(name.toLowerCase().endsWith(str.toString())) return true;
        }
        return false;
    }

}
