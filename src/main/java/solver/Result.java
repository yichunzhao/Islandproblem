package solver;

import lombok.Data;
import lombok.NonNull;

@Data(staticConstructor = "of")
public class Result<T> {
    @NonNull
    T result;
}
