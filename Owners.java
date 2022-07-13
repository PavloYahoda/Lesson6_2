import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Owners {

    private static String firstName;
    private static String lastName;
    private static int age;
    private static String address;
    private static double phone;

    public Owners(String firstName, String lastName, int age, String address, double phone) {
        Owners.firstName = firstName;
        Owners.lastName = lastName;
        Owners.age = age;
        Owners.address = address;
        Owners.phone = phone;
    }

    public static ArrayList<Owners> ownerCreater(){
        File file = new File("Owners.txt");
        try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {

            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }
//          Вычитал все из файла. Разделяю по ";" и создаю список
            String allLines = String.valueOf(stringBuilder);
            ArrayList<String> buffer = new ArrayList<>(Arrays.asList(allLines.split(";")));
//          В этот список буду добавлять созданные объекты класса Pets
            ArrayList<Owners> owners = new ArrayList<>();
//          Беру по очереди каждую часть их буферного списка, сплитю и вношу в список полей объекта
            for (String s : buffer) {
                System.out.println(s);
                ArrayList<String> param = new ArrayList<>(Arrays.asList(s.split(",")));

                firstName = param.get(0);
                lastName = param.get(1);
                age = Integer.parseInt(param.get(2));
                address = param.get(3);
                phone = Double.parseDouble(param.get(4));
//          Создаю объект с известными полями и добавляю в список объектов
                owners.add(new Owners(firstName, lastName, age, address, phone));
            }
            return owners;

        } catch (Exception ignored) {

        }
        return null;
    }
}

