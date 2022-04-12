package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece{

	public Rook(Board board, Color color) {
		super(board, color);
	}

	//Onde estiver essa peça, vai aparecer a letra correspondente a ela
	@Override
	public String toString() {
		return "R";
	}
	
}
