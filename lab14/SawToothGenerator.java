import lab14lib.Generator;

/**
 * Created by YFateen on 4/27/17.
 */
public class SawToothGenerator implements Generator {
    private int period;
    private int state;

    public SawToothGenerator(int period) {
        this.state = 0;
        this.period = period;
    }

    public double next() {
        this.state++;
        return normalize(this.state % period);
    }

    public double normalize(double input) {
        return (input / this.period * 2) - 1 ;
    }
}
