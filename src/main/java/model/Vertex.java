package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Data
@AllArgsConstructor
@Builder
public class Vertex {
  private int value;
  private Vertex upperVertex;
  private Vertex lowerVertex;
  private Vertex leftVertex;
  private Vertex rightVertex;

  private Coordinate coordinate;

  public List<Vertex> allAdjacentVertices() {
    return Stream.of(upperVertex, lowerVertex, leftVertex, rightVertex)
        .filter(v -> Optional.ofNullable(v).isPresent())
        .collect(toList());
  }
}
