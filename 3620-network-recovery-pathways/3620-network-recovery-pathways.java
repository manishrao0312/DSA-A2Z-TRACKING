class Solution {
public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
int low = 0, high = 0;
int n = online.length;

    ArrayList<ArrayList<int[]>> lst = new ArrayList<>();
    for(int i = 0; i < n; i++) {
        lst.add(new ArrayList<>());
    }

    for(int edge[] : edges) {
        lst.get(edge[0]).add(new int[] {edge[1], edge[2]});
        high = Math.max(edge[2], high);
    }

    int ans = -1;
    while(low <= high) {
        int mid = low + (high - low) / 2;
        if(isThisSolution(mid, lst, online, k, n)) {
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return ans;
}

boolean isThisSolution(int cost, ArrayList<ArrayList<int[]>> lst, boolean[] online, long k, int n) {
    long costArr[] = new long[n];  // 
    Arrays.fill(costArr, Long.MAX_VALUE);

    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (Long.compare(a[1], b[1])));
    pq.add(new long[] {0, 0});

    while(!pq.isEmpty()) {
        long[] curr = pq.poll();
        int node = (int) curr[0];
        long currCost = curr[1];

        if(currCost > costArr[node]) continue;
        
        for(int[] edge : lst.get(node)) {
            int adj = edge[0];
            int wt = edge[1];

            if(wt < cost || !online[adj]) continue;

            long newCost = currCost + wt;
            if(newCost < costArr[adj] && newCost <= k) {
                if(adj == n - 1) return true; 
                costArr[adj] = newCost;
                pq.offer(new long[]{adj, newCost});
            }
        }
    }

    return false;
}

}