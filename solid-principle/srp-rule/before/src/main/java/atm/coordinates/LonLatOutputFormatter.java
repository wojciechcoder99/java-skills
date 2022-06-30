package atm.coordinates;

import atm.AircraftTarget;
import atm.coordinates.CoordinateOutputFormatter;

import java.util.List;

public class LonLatOutputFormatter extends CoordinateOutputFormatter {

    @Override
    public String parse(List<AircraftTarget> targets) {
        StringBuilder sb = new StringBuilder();
        targets.forEach(a -> sb.append(buildLocation(a.lon(), a.lat())));
        return sb.toString();
    }
}
