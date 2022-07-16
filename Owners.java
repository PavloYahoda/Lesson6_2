import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class Owners {

    private static String firstName;
    private static String lastName;
    private static int age;
    private static String address;
    private static String phone;

    public Owners(String firstName, String lastName, int age, String address, String phone) {
        Owners.firstName = firstName;
        Owners.lastName = lastName;
        Owners.age = age;
        Owners.address = address;
        Owners.phone = phone;
    }

    public static ArrayList<Owners> ownerCreator(){
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
//          В этот список буду добавлять созданные объекты класса Owners
            ArrayList<Owners> owners = new ArrayList<>();
//          Беру по очереди каждую часть их буферного списка, сплитю и вношу в список полей объекта
            for (String s : buffer) {
//                System.out.println(s);
                ArrayList<String> param = new ArrayList<>(Arrays.asList(s.split(",")));

                firstName = param.get(0);
                lastName = param.get(1);
                age = Integer.parseInt(param.get(2));
                address = param.get(3);
                phone = param.get(4);
//          Создаю объект с известными полями и добавляю в список объектов
                owners.add(new Owners(firstName, lastName, age, address, phone));
            }
            return owners;

        } catch (Exception ignored) {

        }
        return null;
    }
    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }
        if (!(object instanceof Owners)) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }

        Owners other = (Owners) object;
        return this.age == other.age &&
                Objects.equals(this.phone, other.phone) &&
                Objects.equals(this.firstName, other.firstName) &&
                Objects.equals(this.lastName, other.lastName) &&
                Objects.equals(this.address, other.address);
    }
}

