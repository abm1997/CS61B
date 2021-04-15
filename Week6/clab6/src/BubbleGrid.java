public class BubbleGrid {
    private int[][] grid;

    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        int rowNum = grid.length;
        int columnNum = grid[0].length;
        int[][] gridCopy = new int[rowNum][columnNum];

        //copying the grid to not destruct the original grid
        for (int i=0; i<rowNum; i++) {
            for (int j=0; j<columnNum; j++) {
                gridCopy[i][j] = grid[i][j];
            }
        }

        //applying the darts to gridCopy elements
        for (int[] dart : darts) {
            gridCopy[dart[0]][dart[1]] = 0;
        }

        /**
         * we have extra element in the grid to be the root
         * of any bubble connected to the top of grid.
         * unionFind DS is build using a 1D array of integers so we will
         * using the index of every element at the grid (indexes from 0 to rowNum * columnNum)
         * then
         * we union every bubble(1) with its adjacent bubbles only at two direction
         * (the top and the left) other directions are redundant.
         * */
        UnionFind u = new UnionFind(rowNum * columnNum + 1);
        for (int i=0; i<rowNum; i++) {
            for (int j=0; j<columnNum; j++) {

                int index = i * columnNum + j;
                if (gridCopy[i][j] == 1) {
                    if (i==0) {
                        u.union(index, rowNum * columnNum);
                    }
                    if (i>0 && gridCopy[i-1][j]==1) {
                        u.union(index, index - columnNum);
                    }
                    if (j>0 && gridCopy[i][j-1]==1) {
                        u.union(index, index - 1);
                    }
                }
            }
        }

        int[] result = new int[darts.length];
        /**
         * Here we start calculating the falling bubbles starting from the last dart
         * to the first one. lastSize represent the remaining bubbles connected to the top row
         * after applying all darts plus one. Next we union the dart with its adjacent bubbles. The idea
         * here is that if any adjacent bubbles would fall due to the current dart iafter unionng
         * it would be connected to the top row which means increaing the size of top row set stored at
         * the square : rowNum * columnNum. so we subtract lastSize +1 from sizeof rowNum * columnNum
         * to get the falled bubbles.
         * **/
        for (int i = darts.length - 1; i>=0; i--) {
            int lastSize = u.sizeOf(rowNum * columnNum);
            int xDart = darts[i][0];
            int yDart = darts[i][1];

            if (grid[xDart][yDart] == 0) {
                continue;
            } else {
                int indexOfDart = xDart * columnNum + yDart;
                if (xDart == 0) {
                    u.union(indexOfDart, rowNum*columnNum);
                }

                int[][] moves = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};//the moves added to the dart positions to get its 4 adjacents
                for(int j=0; j<4; j++) {
                    int xAdj = xDart + moves[j][0];
                    int yAdj = yDart + moves[j][1];
                    if (xAdj >= rowNum || xAdj < 0 || yAdj >= columnNum || yAdj < 0) {
                        continue;
                    }
                    if (gridCopy[xAdj][yAdj] == 1) {
                        int indexOfAdj = xAdj * columnNum + yAdj;
                        u.union(indexOfDart, indexOfAdj);
                    }
                }

                gridCopy[xDart][yDart] = 1;
                result[i] = Math.max(0, u.sizeOf(rowNum*columnNum) - lastSize - 1);
            }
        }

        return result;
    }

}
