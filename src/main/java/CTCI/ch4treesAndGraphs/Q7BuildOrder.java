package CTCI.ch4treesAndGraphs;

import java.util.*;

public class Q7BuildOrder {

    public class Graph {
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

    public class Project {

        private ArrayList<Project> children = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();
        private String name;
        private int dependencies = 0;

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
                node.incrementDependencies();
            }
        }

        private void incrementDependencies() {
            dependencies++;
        }

        public ArrayList<Project> getChildren() {
            return children;
        }

        public void decrementDependencies() {
            dependencies--;
        }

        public int getNumberDependencies() {
            return dependencies;
        }
    }

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

    public int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project : projects) {
            if (project.getNumberDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }

        return offset;
    }



    public Project[] orderProjects(ArrayList<Project> projects) {

        Project[] order = new Project[projects.size()];

        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;

        while (toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            if (current == null) return null;

            ArrayList<Project> children = current.getChildren();

            for (Project child : children) {
                child.decrementDependencies();
            }

            endOfList = addNonDependent(order, children, endOfList);

            toBeProcessed++;
        }

        return order;
    }

    public String[] convertToStringList(Project[] projects) {
        String[] buildOrder = new String[projects.length];

        for (int i = 0; i < projects.length; i++) {
            buildOrder[i] = projects[i].getName();
        }

        return buildOrder;
    }

    public Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);
        return orderProjects(graph.getNodes());
    }

    public String[] buildOrderWrapper(String[] projects, String[][] dependencies) {
        Project[] buildOrder = findBuildOrder(projects, dependencies);

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
        new Q7BuildOrder().runTopSort();
    }

    public void runTopSort(){
        int[] order = findOrder(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 2}, {1, 4}, {4, 3}});
        System.out.println(Arrays.toString(order));
        vis.clear();map.clear();topSort.clear();
        order = findOrder(5, new int[][]{{0,1},{1,2},{2,3},{1,4},{4,3}});
        System.out.println(Arrays.toString(order));
        vis.clear();map.clear();topSort.clear();
        order = findOrder(6, new int[][]{{0,1},{1,2},{2,3},{1,4},{4,3}});
        System.out.println(Arrays.toString(order));
    }


    Map<Integer, List<Integer>> map = new HashMap<>();//{{1->0},{2->0},{3->[1,2]}}
    int numCourses;
    int[][] prerequisites;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;

        createMap(prerequisites);
        if(hasCycle()) return new int[]{};

        vis.clear();
        int[] arr = new int[numCourses];
        int i = 0;

        for( int key: map.keySet() ){
            if( !vis.contains(key) ) {
                List<Integer> tops = topSort(key, new LinkedList<>());

                for(int t: tops){
                    arr[i++] = t;
                }
            }
        }

        return arr;
    }


    public boolean hasCycle(int numCourses){

        for( int i = 0; i < numCourses; i++ ){
            if( isCycle(i, i, new HashSet<>()) ) return true;
        }

        return false;
    }

    public boolean isCycle(int node, int n, Set<Integer> vis){
        if( node == n && vis.contains(node) ) return true;
        if( vis.contains(n) ) return false;


        vis.add(n);

        List<Integer> deps = map.get(n);
        for(int i = 0; i < deps.size(); i++ ){
            if( isCycle(node, deps.get(i), vis) ) return true;
        }

        return false;
    }

    public void createMap(int[][] prerequisites){
        for( int i = 0; i < numCourses; i++ ){
            if( !map.containsKey(i) ) map.put(i, new ArrayList<>());
        }

        for( int i = 0; i < prerequisites.length; i++ ){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
    }

    Set<Integer> vis = new HashSet<>();

    public boolean hasCycle(){
        for( int key: map.keySet() ) {
            if( isCycle(key, key) ){
                return true;
            }
            vis.clear();
        }

        return false;
    }

    public boolean isCycle(int node, int startNode){
        if( node == startNode && vis.contains(node) ) return true;
        if( vis.contains(node) ) return false;

        vis.add(node);

        List<Integer> deps = map.get(node);

        for( int dep: deps ){
            if( isCycle(dep, startNode) ) return true;
        }

        return false;
    }

    List<Integer> topSort = new LinkedList<>();

    public List<Integer> topSort(int node, List<Integer> sort){
        if( vis.contains(node) ) return sort;

        vis.add(node);

        List<Integer> deps = map.get(node);

        for( int dep: deps ){
            topSort(dep, sort);
        }

        sort.add(node);

        return sort;
    }

}