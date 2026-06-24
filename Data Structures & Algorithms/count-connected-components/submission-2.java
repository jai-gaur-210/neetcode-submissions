List<Integer> parent;
    List<Integer> size;
class DisjointSet {
    
    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUParent(int node) {
        if (node == parent.get(node)) return node;
        int root = findUParent(parent.get(node));
        parent.set(node, root); // path compression
        return root;
    }
    public void unionBySize(int u, int v) {
        int pu = findUParent(u);
        int pv = findUParent(v);
        if (pu == pv) return; // already in same component
        if (size.get(pu) >= size.get(pv)) {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        } else {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        }
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        for (int[] e : edges) {
            ds.unionBySize(e[0], e[1]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findUParent(i) == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
