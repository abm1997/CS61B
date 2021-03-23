import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    public String name;
    private int size;

    public Dog(String n, int s) {
        name = n;
        size = s;
    }

    public int compareTo(Dog o) {
        return this.size - o.size;
    }


    public void bark() {
        System.out.println(name + " says: bark");
    }

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return a.name.compareTo(b.name);
        }
    }
    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }
}