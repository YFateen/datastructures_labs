import lab14lib.Generator;

/**
 * Created by YFateen on 4/27/17.
 */
public class StrangeBitwiseGenerator implements Generator{
    private int period;
    private int state;
    private double weirdState;

    public StrangeBitwiseGenerator(int period) {
        this.state = 0;
        this.period = period;
        state = state + 1;
        this.weirdState = state & (state >>> 3) % period & (state >> 8) % period;
    }

    public double next() {
        this.state++;
        double toReturn = normalize(this.weirdState % period);
        this.weirdState = state & (state >>> 3) % period & (state >> 8) % period;
        return toReturn;
    }

    public double normalize(double input) {
        return (input / this.period * 2) - 1 ;
    }
}

