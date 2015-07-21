package worksap.co.jp.discount.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zuo on 15-7-21.
 */
public enum CrimeLab {
    INSTANCE;

    private List<Crime> crimes;
    private Map<UUID, Crime> map= new HashMap<>();

    CrimeLab(){
        crimes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved( i%3 == 0);
            crimes.add(c);
            map.put(c.getUuid(), c);
        }
    }

    public Crime getCrime(UUID uuid) {
        return this.map.get(uuid);
    }

    public List<Crime> getCrimes() {
        return crimes;
    }
}
