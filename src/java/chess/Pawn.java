package java.chess;


public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)) return false;
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        if (Math.abs(column - toColumn) > 1 || Math.abs(line - toLine) > 2) return false;

        if (((Math.abs(line - toLine) == 2) && (line == 1 || line == 6) && Math.abs(column - toColumn) == 0) && chessBoard.board[toLine][toColumn] == null) return true;

        if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 0 && chessBoard.board[toLine][toColumn] == null) return true;
        System.out.println(chessBoard.board[toLine][toColumn]);
        return (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 1
                && (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color)));

    }

    @Override
    public String getSymbol() {
        return "P";
    }


}
