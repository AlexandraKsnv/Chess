package java.chess;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int abs1 = Math.abs(column - toColumn);
        int abs2 = Math.abs(line - toLine);
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)
                && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)
                && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {

            if (abs1 == 0 && abs1 == abs2) return false;
            if (abs1 == 0 || abs1 == 1){
                return abs2 == 0 || abs2 == 1;
            }
        }
        return false;
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(board.board[i][j] != null) {
                    if (board.board[i][j].canMoveToPosition(board, i, j, line, column)) return true;
                }
            }
        }
        return true;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}