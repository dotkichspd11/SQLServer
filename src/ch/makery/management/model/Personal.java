package ch.makery.management.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personal {
	private final IntegerProperty i1;// stt
	private final StringProperty s1;// first name
	private final StringProperty s2;// last name
	private final StringProperty s3;// username
	private final StringProperty s4;// Password
	private final StringProperty s5;// mathematic
	private final StringProperty i2;// aver
	private final StringProperty s6;// Nickname
	private final StringProperty s7;// rage
	private final StringProperty s8;// physic


	public Personal() {
		this(1, null, null);
	}

	public Personal(int stt, String firstName, String lastName) {
		this.i1 = new SimpleIntegerProperty();
		this.s1 = new SimpleStringProperty();
		this.s2 = new SimpleStringProperty();
		this.i2 = new SimpleStringProperty();
		this.s3 = new SimpleStringProperty();
		this.s4 = new SimpleStringProperty();
		this.s5 = new SimpleStringProperty();
		this.s6 = new SimpleStringProperty();
		this.s7 = new SimpleStringProperty();
		this.s8 = new SimpleStringProperty();
	}

	public int getI1() {
		return i1.get();
	}

	public void setI1(int i1) {
		this.i1.set(i1);
	}

	public IntegerProperty i1Property() {
		return i1;
	}

	public String getI2() {
		return i2.get();
	}

	public void setI2(String i2) {
		this.i2.set(i2);
	}

	public StringProperty i2Property() {
		return i2;
	}

	public String getS1() {
		return s1.get();
	}

	public void setS1(String s1) {
		this.s1.set(s1);
	}

	public StringProperty s1Property() {
		return s1;
	}

	public String getS2() {
		return s2.get();
	}

	public void setS2(String s2) {
		this.s2.set(s2);
	}

	public StringProperty s2Property() {
		return s2;
	}

	public String getS3() {
		return s3.get();
	}

	public void setS3(String s3) {
		this.s3.set(s3);
	}

	public StringProperty s3Property() {
		return s3;
	}

	public String getS4() {
		return s4.get();
	}

	public void setS4(String s4) {
		this.s4.set(s4);
	}

	public StringProperty s4Property() {
		return s4;
	}

	public String getS5() {
		return s5.get();
	}

	public void setS5(String s5) {
		this.s5.set(s5);
	}

	public StringProperty s5Property() {
		return s5;
	}

	public String getS6() {
		return s6.get();
	}

	public void setS6(String s6) {
		this.s6.set(s6);
	}

	public StringProperty s6Property() {
		return s6;
	}

	public String getS7() {
		return s7.get();
	}

	public void setS7(String s7) {
		this.s7.set(s7);
	}

	public StringProperty s7Property() {
		return s7;
	}
	public String getS8() {
		return s8.get();
	}

	public void setS8(String s8) {
		this.s8.set(s8);
	}

	public StringProperty s8Property() {
		return s8;
	}

}
