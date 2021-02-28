package java.com.bb_score.industry_facility;

import java.com.bb_score.Deserializer;
import java.com.bb_score.Provider;


public class IndustryFacilityProvider extends Provider<IndustryFacility> {

    public IndustryFacilityProvider(Deserializer<IndustryFacility> deserializer) {
        super(deserializer);
    }

    @Override
    protected String createUniqueID(IndustryFacility element) {
        return "";
    }
}
