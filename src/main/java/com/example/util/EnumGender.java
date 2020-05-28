package com.example.util;

public enum EnumGender {
	M("M"), F("F");

	private String g;

	private EnumGender(String g) {
		this.g = g;
	}

	public String getGender() {
		return g;
	}
}
