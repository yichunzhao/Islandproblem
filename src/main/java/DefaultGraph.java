
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
public class DefaultGraph<V extends  Vertex> implements Graph {

    private List<V> vertices = new ArrayList<>();

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add((V) vertex);

    }
}
