package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece{

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	//Sem set pq a cor n pode ser alterada, somente acessada (pelo get)
	public Color getColor() {
		return color;
	}
	
}
