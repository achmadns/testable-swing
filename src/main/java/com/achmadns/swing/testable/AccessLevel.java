package com.achmadns.swing.testable;

public enum AccessLevel {
	NONE(0), EXECUTE_ONLY(1), WRITE_ONLY(2), WRITE_AND_EXECUTE(3), READ_ONLY(4), READ_AND_EXECUTE(
			5), READ_AND_WRITE(6), FULL(7);
	private int level;

	private AccessLevel(int level) {
		this.level = level;
	}

	public AccessLevel get(int level) {
		for (AccessLevel l : values()) {
			if (l.level == level)
				return l;
		}
		return NONE;
	}
}
