package com.tms14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 1. Создать коллекцию класса ArrayList со значениями имен всех студентов в группе
 С помощью Stream'ов:
 - Вернуть количество количество людей с вашим именем (вне зависимости от верхнего/нижнего регистра букв)
 - Выбрать все имена, начинающиеся на "а" (вне зависимости от верхнего/нижнего регистра букв)
 - Отсортировать и вернуть первый элемент коллекции или "Empty", если коллекция пуста
 */
public class FirstTask {

    public static void main(String[] args) {
        String myName = "Evgenii";
        List<String> listOfNames = Arrays.asList("Evgenii", "Maria", "Vitalii", "Olga", "Julia", "Svetlana", "Aleksandr", "Anton", "Valeria");
        System.out.println("Count of people with the same name: " + listOfNames.stream().filter(name -> name.equalsIgnoreCase(myName)).count());
        System.out.println("The names starts with \"A\": " + listOfNames.stream().filter(name -> name.startsWith("A") || name.startsWith("a")).collect(Collectors.toList()));
        System.out.println((listOfNames.stream().count() != 0) ? "The first name of sorted list: " + listOfNames.stream().sorted().findFirst().get() : "Empty");
    }

}
/**
 * /Users/evgeny/Library/Java/JavaVirtualMachines/corretto-11.0.11/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50310:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/evgeny/IdeaProjects/tms-homework-lesson-14/out/production/tms-homework-lesson-14 com.tms14.FirstTask
 * Count of people with the same name: 1
 * The names starts with "A": [Aleksandr, Anton]
 * The first name of sorted list: Aleksandr
 *
 * Process finished with exit code 0
 */