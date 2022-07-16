import java.util.Objects;

public class HomeWork6 {

    public static void main(String[] args) {

        System.out.println("Is Mars equals Bars: "
                + Objects.requireNonNull(Pets.petCreator()).get(0).equals(Objects.requireNonNull(Pets.petCreator()).get(1)));
        System.out.println("Is Mars equals Fas: "
                + Objects.requireNonNull(Pets.petCreator()).get(0).equals(Objects.requireNonNull(Pets.petCreator()).get(2)));
        System.out.println("Is Bars equals Fas: "
                + Objects.requireNonNull(Pets.petCreator()).get(1).equals(Objects.requireNonNull(Pets.petCreator()).get(2)));
        System.out.println("Is Bogdan equals Andrew: "
                + Objects.requireNonNull(Owners.ownerCreator()).get(0).equals(Objects.requireNonNull(Owners.ownerCreator()).get(1)));
        System.out.println("Is Bogdan equals Pavlo: "
                + Objects.requireNonNull(Owners.ownerCreator()).get(0).equals(Objects.requireNonNull(Owners.ownerCreator()).get(2)));
        System.out.println("Is Andrew equals Pavlo: "
                + Objects.requireNonNull(Owners.ownerCreator()).get(1).equals(Objects.requireNonNull(Owners.ownerCreator()).get(2)));

    }
}