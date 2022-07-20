
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class Owners {

    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String phone;
    private ArrayList<String> param;

    public Owners(String firstName, String lastName, int age, String address, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public Owners() {

    }

    public Owners(ArrayList<String> param){
        this.param = param;
        this.firstName = param.get(0);
        this.lastName = param.get(1);
        this.age = Integer.parseInt(param.get(2));
        this.address = param.get(3);
        this.phone = param.get(4);

    }

    public ArrayList<Owners> ownerCreator(){

        ReadFromFile readFromFile = new ReadFromFile();
        ArrayList<Owners> owner = new ArrayList<>();

            for (String s :  readFromFile.readFromFile("Owners.txt")) {

                param = new ArrayList<>(Arrays.asList(s.split(",")));
                owner.add(new Owners(param));
            }
            return owner;
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

