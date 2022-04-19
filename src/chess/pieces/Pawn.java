package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
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

			//movimento especial En Passant white
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				//|Testando se a posi��o da esquerda existe, se tem uma pe�a que seja oponente, e se essa pe�a � uma pe�a que est� vulneravel ao en passant
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.GetEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				//|Testando se a posi��o da direita existe, se tem uma pe�a que seja oponente, e se essa pe�a � uma pe�a que est� vulneravel ao en passant
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.GetEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
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
			
			//movimento especial En Passant black
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				//|Testando se a posi��o da esquerda existe, se tem uma pe�a que seja oponente, e se essa pe�a � uma pe�a que est� vulneravel ao en passant
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.GetEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				//|Testando se a posi��o da direita existe, se tem uma pe�a que seja oponente, e se essa pe�a � uma pe�a que est� vulneravel ao en passant
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.GetEnPassantVulnerable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}

}