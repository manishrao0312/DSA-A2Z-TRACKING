
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    boolean[] currentPath;
    boolean[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        currentPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (!map.containsKey(prerequisite)) {
                map.put(prerequisite, new ArrayList<>());
            }
            map.get(prerequisite).add(course);
        }
        for (int course = 0; course < numCourses; course++) {
            if (!visited[course]) {

                if (!dfs(course)) {
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int course) {
        if (currentPath[course]) {
            return false;
        }
        if (visited[course]) {
            return true;
        }
        currentPath[course] = true;
        if (map.containsKey(course)) {
            for (int nextCourse : map.get(course)) {

                if (!dfs(nextCourse)) {
                    return false;
                }
            }
        }
        currentPath[course] = false;
        visited[course] = true;
        return true;
    }
}