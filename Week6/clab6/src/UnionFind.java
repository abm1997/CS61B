public class UnionFind {

    // TODO - Add instance variables?

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    private int[] parents ;

    public UnionFind(int n) {
        parents = new int[n];
        for (int i=0; i<n; i++) {
            parents[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex >= parents.length || vertex < 0) {
            throw new IllegalArgumentException("not a valid vertex");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        validate(v1);
        int root = find(v1);
        int size = -1 * parents[root];
        return size;
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        validate(v1);
        return parents[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        if (find(v1) == find(v2)) {
            return true;
        }
        return false;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2) {
            if (v1 != root1) {
                parents[v1] = root1;
            }
            if (v2 != root2) {
                parents[v2] = root2;
            }
            return;
        }

        int totalSize = (sizeOf(v1) + sizeOf(v2));
        if (sizeOf(v1) <= sizeOf(v2)) {
           parents[root1] = root2;
            parents[root2] = -1*totalSize;
        } else {
            parents[root2] = root1;
            parents[root1] = -1*totalSize;
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        validate(vertex);
        while (parents[vertex] >= 0) {
            vertex = parents[vertex];
        }
        return vertex;
    }

    public static void main(String[] args) {
        UnionFind DS = new UnionFind(10);
        DS.union(0,1);
        DS.union(0,2);
        DS.union(4,5);
        DS.union(4,1);
        boolean b = DS.connected(3,4);
        boolean b2 = DS.connected(2,4);
        DS.union(6,7);
        DS.union(6,8);
        DS.union(6,3);
        DS.union(3,4);
    }
}
