package model;


import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
public class DefaultGraph<V extends Vertex> implements Graph {

    private List<V> vertices = new ArrayList<>();

    @Override
    public void addVertex(Vertex vertex) {
        vertices.add((V) vertex);
    }

    @Override
    public List getVertices() {
        return vertices;
    }
}
