package com.shanren.domain;

import com.shanren.IEnum;

public enum MyEnum implements IEnum {

	A(1), B(3), C(5);

	private int value;

	private MyEnum(int value) {
		this.value = value;
	}

	@Override
	public int getValue() {
		return this.value;
	}

}
