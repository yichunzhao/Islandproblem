package model;

import java.util.List;

public interface Graph<V extends Vertex> {
  void addVertex(V v);

  List<V> getVertices();
}
