package solver;

import model.DefaultGraph;
import model.Matrix;
import model.Vertex;

public interface Transformer {

    DefaultGraph<Vertex> convert(Matrix matrix);
}
