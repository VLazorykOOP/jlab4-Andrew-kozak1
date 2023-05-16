import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // введення шляху до файлу
        System.out.print("Введіть шлях до файлу: ");
        String filePath = scanner.nextLine();

        // читання даних з файлу та обробка
        Set<String> words1 = processFile(filePath);

        // введення імені першого файлу
        System.out.print("Введіть ім'я першого файлу: ");
        String fileName1 = scanner.nextLine();

        // введення імені другого файлу
        System.out.print("Введіть ім'я другого файлу: ");
        String fileName2 = scanner.nextLine();

        // читання даних з першого файлу та обробка
        Set<String> words2 = processFile(fileName1);

        // читання даних з другого файлу та обробка
        Set<String> words3 = processFile(fileName2);

        // знаходження перетину множин слів
        words2.retainAll(words3);

        // виведення результатів на консоль
        System.out.println("Слова з файлу " + filePath + ": " + words1);
        System.out.println("Слова з файлу " + fileName1 + ": " + words2);
        System.out.println("Слова з файлу " + fileName2 + ": " + words3);
        System.out.println("Спільні слова з файлів " + fileName1 + " та " + fileName2 + ": " + words2);

        // запис результатів до файлу
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
            writer.write("Спільні слова з файлів " + fileName1 + " та " + fileName2 + ": " + words2);
            writer.close();
            System.out.println("Результати успішно записані до файлу result.txt");
        } catch (IOException e) {
            System.out.println("Помилка при записі результатів до файлу: " + e.getMessage());
        }
    }

    // метод для обробки файлу та повернення множини слів
    public static Set<String> processFile(String fileName) {
        Set<String> words = new HashSet<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] splitLine = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                words.addAll(Arrays.asList(splitLine));
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено: " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + e.getMessage());
        }
        return words;
   
    }
}    
