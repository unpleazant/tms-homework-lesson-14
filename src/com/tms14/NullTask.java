package com.tms14;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 0. Создать коллекцию класса ArrayList наполнить ее элементами рандомными элементами типа Integer.
 *    С помощью Stream'ов:
 *     - Удалить дубликаты
 *     - Вывести все четные элементы в диапазоне от 7 до 17 (включительно)
 *     - Каждый элемент умножить на 2
 *     - Отсортировать и вывести на экран первых 4 элемента
 *     - Вывести количество элементов в стриме
 *     - Вывести среднее арифметическое всех чисел в стриме
 */
public class NullTask {

    static Random random = new Random();

    public static void main(String[] args) {
        ArrayList<Integer> list = generateList(10);

        System.out.println("Randomly generated list: " + list);

        System.out.println("List without duplicates: " + list.stream().distinct().collect(Collectors.toList()));

        System.out.println("Filtered list (7 <= x <= 17): " + list.stream().filter(integer -> (7 <= integer && integer <= 17)).collect(Collectors.toList()));

        System.out.println("Every item * 2: " + list.stream().map(integer -> integer * 2).collect(Collectors.toList()));

        System.out.println("First 4 elements of sorted list: " + list.stream().sorted().limit(4).collect(Collectors.toList()));

        System.out.println("Elements count in stream: " + list.stream().count());

        System.out.println("Average value of elements in list: " + list.stream().mapToDouble(Integer::intValue).average().getAsDouble());
    }

    private static ArrayList generateList(int listSize) {
        return IntStream.range(0, listSize).mapToObj(i -> random.nextInt(50)).collect(Collectors.toCollection(() -> new ArrayList<>(listSize)));
    }

}
/**
 * /Users/evgeny/Library/Java/JavaVirtualMachines/corretto-11.0.11/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50277:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/evgeny/IdeaProjects/tms-homework-lesson-14/out/production/tms-homework-lesson-14 com.tms14.NullTask
 * Randomly generated list: [6, 14, 49, 28, 2, 3, 5, 5, 32, 38]
 * List without duplicates: [6, 14, 49, 28, 2, 3, 5, 32, 38]
 * Filtered list (7 <= x <= 17): [14]
 * Every item * 2: [12, 28, 98, 56, 4, 6, 10, 10, 64, 76]
 * First 4 elements of sorted list: [2, 3, 5, 5]
 * Elements count in stream: 10
 * Average value of elements in list: 18.2
 *
 * Process finished with exit code 0
 */