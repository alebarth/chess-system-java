package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			//Se a posi��o de uma linha acima do pe�o existir e estiver vazia, vai poder mover pra l�
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			//Se a posi��o de uma linha acima e de duas linhas acima do pe�o existir e estiver vazia e se a quantidade de movimentos do pe�o ainda � zero (come�o do jogo), vai poder mover pra l�
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			//Se a posi��o de uma linha acima do pe�o existir e tiver uma pe�a advers�ria, vai poder mover pra l�
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}			
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			//Se a posi��o de uma linha acima do pe�o existir e tiver uma pe�a advers�ria, vai poder mover pra l�
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}			
		}
		else {
			p.setValues(position.getRow() + 1, position.getColumn());
			//Se a posi��o de uma linha acima do pe�o existir e estiver vazia, vai poder mover pra l�
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			//Se a posi��o de uma linha acima e de duas linhas acima do pe�o existir e estiver vazia e se a quantidade de movimentos do pe�o ainda � zero (come�o do jogo), vai poder mover pra l�
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			//Se a posi��o de uma linha acima do pe�o existir e tiver uma pe�a advers�ria, vai poder mover pra l�
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}			
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			//Se a posi��o de uma linha acima do pe�o existir e tiver uma pe�a advers�ria, vai poder mover pra l�
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}	
		}
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}

}