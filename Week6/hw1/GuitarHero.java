import edu.princeton.cs.algs4.StdAudio;
import  es.datastructur.synthesizer.GuitarString;
public class GuitarHero {

    public static void main(String[] args) {
        GuitarString[] guitar = new GuitarString[37];
        String keyboard = "q2we4r5ty7u8i9op-=[zxdcfvgbnjmk,.;/' ";

        for (int i=0; i<37; i++) {
            double freq = 440.0 * Math.pow(2,(i-24)/12.0);
            guitar[i] = new GuitarString(freq);
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int p = keyboard.indexOf(key);
                if (p < 0) {
                    throw new IllegalArgumentException("please don't press any key outside" +
                            "the guitar keyboard");
                }
                guitar[keyboard.indexOf(key)].pluck();
            }

            double sample = 0;
            for (int i=0; i<37; i++) {
                sample += guitar[i].sample();
            }
            StdAudio.play(sample);

            for (int i=0; i<37; i++) {
                guitar[i].tic();
            }
        }
    }
}
