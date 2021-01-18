public class Dog {
    public int weight;
    
    /** integer constructor 
    *now when you make an instance of Dog like Dog d = new Dog(50) 
    * that's meaning weight of d is 50
    */
    
    public Dog(int w) {
        weight = w;
    }

    public void makeNoise() {
        if (weight < 50) {
            System.out.println("yip yipyip");
        } else if (weight < 100) {
            System.out.println("bark bark");
        } else {
            System.out.println("woooooof");
        }        
    }

    public static Dog maxDog(Dog d1 , Dog d2) {
        System.out.println("This is the static maxDog");
        if (d1.weight > d2.weight) {
            return d1;
        }
        return d2;
    }

    public Dog maxDog(Dog d2) {
        System.out.println("This is the instance maxDog");
        if (this.weight > d2.weight) {
            return this ;
        }
        return d2;  
    }
}
