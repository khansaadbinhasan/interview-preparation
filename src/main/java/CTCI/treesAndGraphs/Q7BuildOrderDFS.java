package CTCI.treesAndGraphs;

import java.lang.reflect.Array;
import java.util.*;

public class Q7BuildOrderDFS {

    public Graph buildGraph(String[] projects, String[][] dependencies) {

        Graph graph = new Graph();

        for (String project : projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency : dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);
        }

        return graph;
    }

    public Stack<Project> orderProjects(ArrayList<Project> projects){

        Stack<Project> stack = new Stack<>();

        for( Project p: projects ){
            if( p.getState() == Project.State.BLANK ){
                if( !doDFS(p, stack) ) return null;
            }
        }

        return stack;
    }

    boolean doDFS(Project project, Stack<Project> stack){
        if( project.getState() == Project.State.PARTIAL ){
            return false;
        }

        if( project.getState() == Project.State.BLANK ){
            project.setState(Project.State.PARTIAL);

            ArrayList<Project> children = project.getChildren();

            for(Project child: children){
                if( !doDFS(child, stack) ) return false;
            }

            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }

        return true;
    }

    Stack<Project> findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public String[] convertToStringList(Project[] projects) {
        String[] buildOrder = new String[projects.length];

        for (int i = 0; i < projects.length; i++) {
            buildOrder[i] = projects[i].getName();
        }

        return buildOrder;
    }


    public String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        Project[] buildOrder = findBuildOrder(projects, dependencies).toArray(new Project[0]);

        if (buildOrder == null) return null;

        String[] buildOrderString = convertToStringList(buildOrder);

        return buildOrderString;
    }

    public void run() {

        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        String[] buildOrder = buildOrderWrapper(projects, dependencies);
        if (buildOrder == null) {
            System.out.println("Circular Dependency.");
        } else {
            for (String s : buildOrder) {
                System.out.println(s);
            }
        }
    }

    public static void main (String[] args){
        new Q7BuildOrder().run();
    }

}


class Project {

    enum State {COMPLETE, PARTIAL, BLANK};
    private State state = State.BLANK;

    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Project(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void addNeighbor(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public ArrayList<Project> getChildren() {
        return children;
    }
}


class Graph {
    private ArrayList<Project> nodes = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if (!map.containsKey(name)) {
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }

        return map.get(name);
    }

    public void addEdge(String startName, String endName) {
        Project start = getOrCreateNode(startName);
        Project end = getOrCreateNode(endName);

        start.addNeighbor(end);
    }

    public ArrayList<Project> getNodes() {
        return nodes;
    }

}
