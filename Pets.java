
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Pets {

    private String name;
    private String owner;
    private int age;
    private ArrayList<String> param;

    public Pets(String name, String owner, int age) {
        this.name = name;
        this.owner = owner;
        this.age = age;
    }

    public Pets() {

    }
    public Pets(ArrayList<String> param) {
        this.param = param;
        this.name = param.get(0);
        this.owner = param.get(1);
        this.age = Integer.parseInt(param.get(2));
    }

    public ArrayList<Pets> petCreator() {

        ReadFromFile readFromFile = new ReadFromFile();
        ArrayList<Pets> pet = new ArrayList<>();

        for (String s : readFromFile.readFromFile("Pets.txt")) {
            param = new ArrayList<>(Arrays.asList(s.split(",")));

            pet.add(new Pets(param));
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
