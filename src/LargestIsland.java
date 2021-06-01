class LargestIsland {
    public int maxAreaOfIsland(int[][] grid) {
        // null -> undiscovered, false -> visiting, true-> visited
        Boolean[][] status = new Boolean[grid.length][grid[0].length];
        int result =0;
        for (int i =0; i < grid.length; i++) {
            for (int j =0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && status[i][j] == null) {
                    int count = dfs(grid, status, i, j, 0);
                    if (count > result) {
                        result = count;
                    }
                }
            }
        }

        return result;
    }

    private int dfs(int[][] grid, Boolean[][] status, int x, int y, int count) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return count;
        if (grid[x][y] == 0 || status[x][y] != null) {
            return count;
        }
        if (status[x][y] == null && grid[x][y] == 1 ) {
            status[x][y] = false;
            // dfs(grid, status, x, y, count++);
        }
        if (status[x][y] == false) {
            count++;
            count = dfs(grid, status, x+1, y, count);
            count = dfs(grid, status, x, y+1, count);
            count = dfs(grid, status, x-1, y, count);
            count = dfs(grid, status, x, y-1, count);
            status[x][y] =true;
        }
        return count;
    }
}