package java.chess;

public class Horse extends ChessPiece{

    public Horse(String color){
        super(color);
    }

    @Override
    public  String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if (!chessBoard.checkPos(line) || !chessBoard.checkPos(column)) return false;
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        return Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1 || (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2) &&
                (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.color));
    }

    @Override
    public String getSymbol(){
        return "H";
    }
}