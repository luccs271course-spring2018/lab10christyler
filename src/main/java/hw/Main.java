package hw;

import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.ClosestFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.RandomWalkIterator;
import sun.java2d.pipe.DrawImage;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {

  public static void main(final String[] args) {
    final String IL = "Illinois";
    final String MO = "Montana";
    final String CA = "California";
    final String TX = "Texas";
    final String GA = "Georgia";
    final String VA = "Virginia";

    final Graph<String, DefaultEdge> map = new SimpleGraph<>(DefaultEdge.class);
    map.addVertex(IL);
    map.addVertex(MO);
    map.addVertex(CA);
    map.addVertex(TX);
    map.addVertex(GA);
    map.addVertex(VA);

    map.addEdge(IL,MO);
    map.addEdge(MO,CA);
    map.addEdge(CA,TX);
    map.addEdge(TX,GA);
    map.addEdge(GA,VA);
    map.addEdge(VA,IL);

    System.out.println(map);

    System.out.println("BreadthFirstIterator:");

    final Iterator<String> bf = new BreadthFirstIterator<>(map, IL);
    while (bf.hasNext()) {
      final String state = bf.next();
      System.out.println(state);
    }

    System.out.println("ClosestFirstIterator:");

    final Iterator<String> cf = new ClosestFirstIterator<>(map, IL);
    while (cf.hasNext()) {
      final String state = cf.next();
      System.out.println(state);
    }

    System.out.println("DepthFirstIterator:");

    final Iterator<String> df = new DepthFirstIterator<>(map, IL);
    while (df.hasNext()) {
      final String state = df.next();
      System.out.println(state);
    }

    System.out.println("");

    GreedyColoring m = new GreedyColoring(map);
    System.out.println(m.getColoring());


  }
}
