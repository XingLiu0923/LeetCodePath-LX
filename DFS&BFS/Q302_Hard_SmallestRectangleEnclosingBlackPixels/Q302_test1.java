public class Q302_test1 {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length; if (m == 0) return 0;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] border = new int[] {x, x, y, y};
        dfs(image, x, y, visited, border);
        return (border[1] - border[0] + 1) * (border[3] - border[2] + 1);
    }

    private void dfs(char[][] image, int i, int j, boolean[][] visited, int[] border) {
        int m = image.length, n = image[0].length;
        visited[i][j] = true;
        border[0] = Math.min(border[0], i); border[1] = Math.max(border[1], i);
        border[2] = Math.min(border[2], j); border[3] = Math.max(border[3], j);
        if (i - 1 > -1 && image[i - 1][j] == '1' && !visited[i - 1][j]) dfs(image, i - 1, j, visited, border);
        if (i + 1 < m && image[i + 1][j] == '1' && !visited[i + 1][j]) dfs(image, i + 1, j, visited, border);
        if (j - 1 > -1 && image[i][j - 1] == '1' && !visited[i][j - 1]) dfs(image, i, j - 1, visited, border);
        if (j + 1 < n && image[i][j + 1] == '1' && !visited[i][j + 1]) dfs(image, i, j + 1, visited, border);
    }
}
