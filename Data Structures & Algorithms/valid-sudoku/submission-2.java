class Solution {
    private boolean isValidRow(char[] row){
        int[] count = new int[10];
        for (char c : row){
            if (c == '.') continue;
            int num = c - '0';
            count[num]++;
        }
        for (int i : count){
            if (i > 1){
                return false;
            }
        }
        return true;
    }

    private char[][] columnExtractor(char[][] board){
        char[][] output = new char[9][9];
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                output[i][j] = board[j][i];
            }
        }
        return output;
    }

    private char[][] boxExtractor(char[][] board){
        char[][] output = new char[9][9];
        for (int box = 0; box < 9; box++){
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            int idx = 0;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    output[box][idx++] = board[startRow + i][startCol + j];
                }
            }
        }
        return output;
    }

    public boolean isValidSudoku(char[][] board) {
        char[][] boxes = boxExtractor(board);
        char[][] columns = columnExtractor(board);
        for(int i = 0; i < 9; i++){
            if (!isValidRow(boxes[i])) return false;
        }
        for(int i = 0; i < 9; i++){
            if (!isValidRow(columns[i])) return false;
        }        
        for(int i = 0; i < 9; i++){
            if (!isValidRow(board[i])) return false;
        }
        return true;
    }
}