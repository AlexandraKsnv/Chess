package java.chess;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(line) && chessBoard.checkPos(column)
                && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)
                && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {
            if (toColumn == column || toLine == line) {
                if (toColumn == column && toLine == line) return false;
                else
                    return true;
            }
            if (Math.abs(line - toLine) == Math.abs(column - toColumn)) return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}