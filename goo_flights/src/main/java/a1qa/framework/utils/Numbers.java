package a1qa.framework.utils;

public enum Numbers {

	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), THIRTY(30);

	private int num;

	private Numbers(int num) {
		this.num = num;
	}

	public int getNumber() {
		return num;
	}
}