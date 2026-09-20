
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

        // We came back to a course
        // that is already in our current path.
        if (currentPath[course]) {
            return false;
        }

        // This course was already completely checked.
        if (visited[course]) {
            return true;
        }

        // Start exploring this course
        currentPath[course] = true;

        // Check where this course goes
        if (map.containsKey(course)) {

            for (int nextCourse : map.get(course)) {

                if (!dfs(nextCourse)) {
                    return false;
                }
            }
        }

        // Finished exploring this course
        currentPath[course] = false;

        // Remember that this course is completely safe
        visited[course] = true;

        return true;
    }
}