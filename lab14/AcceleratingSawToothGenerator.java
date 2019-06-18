import lab14lib.Generator;

/**
 * Created by YFateen on 4/27/17.
 */
public class AcceleratingSawToothGenerator implements Generator {
    private double period;
    private int state;
    private double increment;
    private int count = 0;
    private double start = 0;

    public AcceleratingSawToothGenerator(double period, double increment) {
        this.state = 0;
        this.period = period;
        this.increment = increment;
        this.count = 0;
    }

    public double next() {
        if (count == period) {
            period = Math.round(period * increment);
            this.state = 0;
            this.count = 0;
        }
        this.state++;
        double toReturn = normalize(this.state % period);
        return toReturn;
    }

    public double normalize(double input) {
        double toReturn = (input / this.period * 2) - 1 ;
        count++;
        return toReturn;
    }
}
