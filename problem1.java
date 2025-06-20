// Problem1 (https://leetcode.com/problems/number-of-islands/)
// Time Complexity : O(2mn)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//traverse through matrix, use bfs/dfs whenever we hit 1, traverse through all posible neighbours
//until no 1 found, and each traversal make q to 0 so they wont be visited again.
//every time while running outer for loops, 1 is found increase count by 1 and return count at the end.

//bfs
// class Solution {
//     int dirs[][];
//     public int numIslands(char[][] grid) {
//         int m =grid.length;
//         int n = grid[0].length;
//         this.dirs = new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
//         int result =0;
//         for(int i=0; i<m; i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]=='1'){
//                     result++;
//                     grid[i][j]='0';
//                     bfs(grid, i,j);
//                 }
//             }
//         }
//         return result;
//     }
//     private void bfs(char[][] grid, int i, int j){
//         int m =grid.length;
//         int n = grid[0].length;
//         Queue<Integer> q=new LinkedList<>();
//         q.add(i); q.add(j);
//         while(!q.isEmpty()){
//             int cr=q.poll();
//             int cc=q.poll();
//             for(int[] dir: dirs){
//                 int nr=cr+dir[0];
//                 int nc=cc+dir[1];
//                 if(nr>=0&&nc>=0&&nr<m&&nc<n&&grid[nr][nc]=='1'){
//                     grid[nr][nc]='0';
//                     q.add(nr);
//                     q.add(nc);
//                 }
//             }
//         } return;
//     }
// }

//dfs
class Solution {
    int dirs[][];
    public int numIslands(char[][] grid) {
        int m =grid.length;
        int n = grid[0].length;
        this.dirs = new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
        int result =0;
        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid, i,j,m,n);
                }
            }
        }
        return result;
    }
    private void dfs(char[][] grid, int i, int j, int m, int n){
        if(i<0||j<0||i>=m||j>=n||grid[i][j]=='0') return;
        grid[i][j]='0';
        for(int[] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            dfs(grid, nr,nc,m,n);
        }
        return;
    }
}