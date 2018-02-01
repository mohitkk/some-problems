package Testing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    boolean isDirected = false;
    Map<Long, Vertex<T>> allVertices;
    List<Edge<T>> allEdges;
    public static void main(final String[] args) {
        // TODO Auto-generated method stub

    }

}

class Edge<T> {
    Vertex<T> first;
    Vertex<T> second;
    boolean isDirected = false;
    long weight;

    Edge(final Vertex<T> first, final Vertex<T> second, final boolean isDirected, final long weight) {
        this.first = first;
        this.second = second;
        this.isDirected = isDirected;
        this.weight = weight;
    }
}

class Vertex<T> {
    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public List<Vertex<T>> getAdjacentVertices() {
        return adjacentVertices;
    }
    private long id;
    private T data;
    private final List<Edge<T>> edges = new ArrayList<Edge<T>>();
    private final List<Vertex<T>> adjacentVertices = new ArrayList<Vertex<T>>();

    public void addAdjacentVertex(final Edge<T> edge, final Vertex<T> vertex) {
        edges.add(edge);
        adjacentVertices.add(vertex);
    }

}
