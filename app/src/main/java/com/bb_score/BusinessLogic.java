package com.bb_score;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bb_score.industry_facility.IndustryFacilitiesProvider;
import com.bb_score.location.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BusinessLogic {
    private final Set<Location> locations;
    private IndustryFacilitiesProvider industryFacilitiesProvider;
    private final HashMap<Player, Integer> scores = new HashMap<Player, Integer>();

    public BusinessLogic(Set<Location> locations) {
        this.locations = locations;
    }

    public Map<Player, Integer> calculateScore(){
        return scores;
    }

    public static void main(String[] args) {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadAll(){
        loadIndustryFacilities();
        loadLinks();
        loadLocations();
        loadMerchantPoints();
    }

    private void loadMerchantPoints() {
        throw new UnsupportedOperationException();
    }

    private void loadLocations() {
        throw new UnsupportedOperationException();
    }

    private void loadLinks() {
        throw new UnsupportedOperationException();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void loadIndustryFacilities(){
        this.industryFacilitiesProvider = new IndustryFacilitiesProvider("industry_facilities.json");
    }
}
