package practice.StableMarriage;

public class Woman {
	static final int numOfMen = 5;
	private int id = 0;
	private int current = 0;
	private int[] preferenceList = new int[numOfMen];
	private int[] rankingList = new int[numOfMen];

	Woman(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getCurrent() {
		return current;
	}

	public void setPreferenceList(int[] preferenceList) {
		this.preferenceList = preferenceList;
	}

	public int[] getRankingList() {
		for (int i = 0; i < this.preferenceList.length; i++) {
			rankingList[preferenceList[i] - 1] = i + 1;
		}
		return rankingList;
	}
}