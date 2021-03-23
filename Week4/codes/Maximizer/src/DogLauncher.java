import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog[] dogs = {new Dog("ELyse", 3), new Dog("Sture", 9),
                new Dog("Atemesos", 15)};
        Dog maxDog = (Dog) Maximizer.max(dogs);
        maxDog.bark();

        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(dogs[0], dogs[2]) >0) {
            dogs[0].bark();
        } else {
            dogs[2].bark();
        }
    }
}
