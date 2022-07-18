import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pets {

    private String name;
    private String owner;
    private int age;
    private ArrayList<String> buffer;

    public Pets(String name, String owner, int age){
        this.name = name;
        this.owner = owner;
        this.age = age;
    }

    public Pets() {

    }


    public ArrayList<String> readFromFile(){
        File file = new File("Pets.txt");
        try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {

            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String allLines = String.valueOf(stringBuilder);
            buffer = new ArrayList<>(Arrays.asList(allLines.split(";")));
        } catch (Exception ignored) {

        }
        return buffer;
    }


    public ArrayList<Pets> petCreator() {

            ArrayList<Pets> pet = new ArrayList<>();

            for (String s : buffer) {
                ArrayList<String> param = new ArrayList<>(Arrays.asList(s.split(",")));
                name = param.get(0);
                owner = param.get(1);
                age = Integer.parseInt(param.get(2));
                pet.add(new Pets(name, owner, age));
            }
            return pet;
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
