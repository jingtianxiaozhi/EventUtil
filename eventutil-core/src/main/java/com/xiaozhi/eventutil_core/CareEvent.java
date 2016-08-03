package com.xiaozhi.eventutil_core;

public class CareEvent<T> {

	public int what;
	public T paramObj;

	public CareEvent(int what, T paraObject) {
		this.what = what;
		this.paramObj = paraObject;
	}
}
