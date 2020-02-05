package practice.StableMarriage;

public class Man {
	static final int numOfWomen = 5;
	private int id = 0;
	private int nextProposed = 1;
	private int[] preferenceList = new int[numOfWomen];

	Man(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setNextProposed() {
		this.nextProposed++;
	}

	public int getNextProposed() {
		return nextProposed;
	}

	public void setPreferenceList(int[] preferenceList) {
		this.preferenceList = preferenceList;
	}

	public int[] getPreferenceList() {
		return preferenceList;
	}
}