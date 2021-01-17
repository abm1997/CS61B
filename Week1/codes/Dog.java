public class Dog {
    public int weight;
    
    /** integer constructor 
    *now when you make an instance of Dog like Dog d = new Dog(50) 
    * that's meaning weight of d is 50
    */
    
    public Dog(int w) {
        w = weight;
    }

    public void makeNoise() {
        if (weight < 30) {
            System.out.println("yip yipyip");
        } else if (weight < 60) {
            System.out.println("bark bark");
        } else {
            System.out.println("woooooof");
        }        
    }
  
}
