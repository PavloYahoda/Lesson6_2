import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pets {

    private static String name;
    private static String owner;
    private static int age;

    public Pets(String name, String owner, int age){
        Pets.name = name;
        Pets.owner = owner;
        Pets.age = age;
    }

    public static ArrayList<Pets> petCreator() {
        File file = new File("Pets.txt");
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
            ArrayList<Pets> pets = new ArrayList<>();
//          Беру по очереди каждую часть их буферного списка, сплитю и вношу в список полей объекта
            for (String s : buffer) {
//                System.out.println(s);
                ArrayList<String> param = new ArrayList<>(Arrays.asList(s.split(",")));

                name = param.get(0);
                owner = param.get(1);
                age = Integer.parseInt(param.get(2));
//          Создаю объект с известными полями и добавляю в список объектов
                pets.add(new Pets(name, owner, age));
            }
            return pets;

        } catch (Exception ignored) {

        }
        return null;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }
        if (!(object instanceof Pets)) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }

        Pets other = (Pets) object;
        return age == other.age &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.owner, other.owner);
    }
}
