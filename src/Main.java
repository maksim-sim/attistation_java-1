import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, List<String>> phoneBook = new HashMap<>();

        addContact(phoneBook, "Иванов", "1234567890");
        addContact(phoneBook, "Петров", "9876543210");
        addContact(phoneBook, "Сидоров", "5555555555");
        addContact(phoneBook, "Иванов", "1111111111");
        addContact(phoneBook, "Петров", "2222222222");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, List<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printPhoneBook(HashMap<String, List<String>> phoneBook) {
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size() + " номер(а)" + entry.getValue());
        }
    }
}