class Solution {
    HashMap<String,Integer> islandMap;
    
    public int numIslands(char[][] grid) {
        islandMap = new HashMap<String,Integer>();
        int islandCount = 0;
        //int islandId = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if('1' == grid[i][j] && !islandMap.containsKey(i+","+j)) {
                    islandDFS(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    
    public void islandDFS(char[][] grid, int row, int col) {
        String nodeKey = row + "," + col;
        if(islandMap.containsKey(nodeKey)) return;
        if(row < 0 || col < 0) return;
        if(row >= grid.length || col >= grid[0].length) return;
        if(grid[row][col] == '0') return;
        // == '1'
        islandMap.put(nodeKey,1);
        islandDFS(grid, row-1, col);
        islandDFS(grid, row, col-1);
        islandDFS(grid, row+1, col);
        islandDFS(grid, row, col+1);
    }
}

/* 

assuming diagonal connections are not included in island formation

traverse grid left-right, top-botom / 0..n, 0..m
when a 1 is found, increment island countfind
use dfs to find all nodes in island
add island nodes to hashmap, so as not to count any island twice
after traversing island, continue searching grid

O(m*n)

*/