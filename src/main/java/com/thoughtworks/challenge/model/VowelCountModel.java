package com.thoughtworks.challenge.model;

import java.io.Serializable;

/**
 * 
 * @author Kuldeep Jha
 *
 */
public class VowelCountModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int a = 0;
	private int e = 0;
	private int i = 0;
	private int o = 0;
	private int u = 0;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getO() {
		return o;
	}

	public void setO(int o) {
		this.o = o;
	}

	public int getU() {
		return u;
	}

	public void setU(int u) {
		this.u = u;
	}

}
