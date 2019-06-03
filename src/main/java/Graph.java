import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
public class Graph<V extends Vertex> {

    private List<V> vertices = new ArrayList<>();

    public void addVertex(V vertex) {
        vertices.add(vertex);
    }

}
