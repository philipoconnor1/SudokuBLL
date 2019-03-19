package pkgHelper;

public class PuzzleViolation {

	private pkgEnum.ePuzzleViolation ePuzzleViolation;
	private int iValue;
	
	public PuzzleViolation(pkgEnum.ePuzzleViolation ePuzzleViolation, int iValue) {
		this.ePuzzleViolation = ePuzzleViolation;
		this.iValue = iValue;
	}

	public pkgEnum.ePuzzleViolation getePuzzleViolation() {
		return ePuzzleViolation;
	}

	public int getiValue() {
		return iValue;
	}
	
	
	
}
