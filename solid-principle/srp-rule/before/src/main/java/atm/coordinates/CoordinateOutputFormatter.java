package atm.coordinates;

import atm.AircraftTarget;

import java.util.List;

public abstract class CoordinateOutputFormatter {

    public abstract String parse(List<AircraftTarget> targets);

    protected String buildLocation(int first, int second) {
        return String.format("[%o %o]", first, second);
    }
}
