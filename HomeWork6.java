
import java.util.ArrayList;


public class HomeWork6 {


    public void print(){
        Pets pet = new Pets();
        Owners owner = new Owners();
        ArrayList<Pets> myPet = pet.petCreator();
        ArrayList<Owners> myOwner = owner.ownerCreator();

        Object Mars = myPet.get(0);
        Object Bars = myPet.get(1);
        Object Fas = myPet.get(2);
        Object Bogdan = myOwner.get(0);
        Object Andrew = myOwner.get(1);
        Object Pavlo = myOwner.get(2);

        System.out.println("Is Mars equals Bars: "
                + Mars.equals(Bars));
        System.out.println("Is Mars equals Fas: "
                + Mars.equals(Fas));
        System.out.println("Is Bars equals Fas: "
                + Bars.equals(Fas));
        System.out.println("Is Bogdan equals Andrew: "
                + Bogdan.equals(Andrew));
        System.out.println("Is Bogdan equals Pavlo: "
                + Bogdan.equals(Pavlo));
        System.out.println("Is Andrew equals Pavlo: "
                + Andrew.equals(Pavlo));
    }

    public static void main(String[] args) {

        HomeWork6 homeWork6 = new HomeWork6();
        homeWork6.print();
    }
}