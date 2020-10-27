package solver;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data(staticConstructor = "create")
public class Result {
    public enum Key {Visited, Solution}

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Map<Key, Object> results = new HashMap<>();

    void addResult(Key key, Object obj) {
        results.put(key, obj);
    }

    public Object get(Key key) {
        return results.get(key);
    }
}
