public class DogLauncher {

    public static void main(String args[]) {
        Dog[] dogs = new Dog[3] ;
        dogs[0] = new Dog(15);
        dogs[1] = new Dog(60);
        dogs[2] = new Dog(110);

        dogs[0].makeNoise();
        dogs[1].makeNoise();
        dogs[2].makeNoise();

	Dog mayaDog = new Dog(20);
	Dog jushDog = new Dog(70);
        //Dog bigger = Dog.maxDog(mayaDog , jushDog);
        Dog bigger = mayaDog.maxDog(jushDog);
        bigger.makeNoise();
	
	int sum = 0; 
	sum = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
        System.out.println(sum);
    }   
}

