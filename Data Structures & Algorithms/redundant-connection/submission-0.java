class DisjointSet {
    List<Integer> parent, size;

    public DisjointSet(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // note: 1-based
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

    public int [] unionBySize(int u, int v) {
        int pu = findUParent(u);
        int pv = findUParent(v);
        if (pu == pv) return new int[]{u,v}; 

        if (size.get(pu) >= size.get(pv)) {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        } else {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        }
        return null;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        int ans[] = new int[2];
        for (int[] edge : edges) {
            int [] temp = ds.unionBySize(edge[0], edge[1]);
            if(temp != null){
                ans = temp;
            }
        }
        return ans;
    }
}
