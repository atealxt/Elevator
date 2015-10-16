package io.github.atealxt.elevator.algorithm;

public class Record {

	int from;
	int to;
	int numPeople;

	public Record(int from, int to, int numPeople) {
		super();
		this.from = from;
		this.to = to;
		this.numPeople = numPeople;
	}

	boolean validate() {
		if (to == from || to < 1 || from < 1 || numPeople < 1) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Record [from=" + from + ", to=" + to + ", numPeople=" + numPeople + "]";
	}
}
