package practice.StableMarriage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import practice.StableMarriage.*;

public class Main {
	public static void main(String args[]) {
		try {
			// open file
			FileReader menList = new FileReader("classes/practice/StableMarriage/MenList.txt");
			FileReader womenList = new FileReader("classes/practice/StableMarriage/WomenList.txt");
			int numOfMen = Woman.numOfMen;
			int numOfWomen = Man.numOfWomen;
			Man[] manArray = new Man[numOfMen];
			Woman[] womanArray = new Woman[numOfWomen];

			// initialize
			Scanner menScanner = new Scanner(menList);
			Scanner womenScanner = new Scanner(womenList);
			FreeMan freeMan = new FreeMan();
			for(int i = 0; i < numOfMen; i++) {
				Man man = new Man(menScanner.nextInt());
				int[] preferenceList = new int[numOfWomen];
				for (int j = 0; j < numOfWomen; j++) {
					preferenceList[j] = menScanner.nextInt();
				}
				man.setPreferenceList(preferenceList);
				manArray[i] = man;
				freeMan.insertFirst(man.getId());
			}

			for(int i = 0; i < numOfWomen; i++) {
				Woman woman = new Woman(womenScanner.nextInt());
				int[] preferenceList = new int[numOfMen];
				for (int j = 0; j < numOfMen; j++) {
					preferenceList[j] = womenScanner.nextInt();
				}
				woman.setPreferenceList(preferenceList);
				womanArray[i] = woman;
			}
			menList.close();
			womenList.close();

			// match
			while (freeMan.getLength() > 0) {
				Man m = manArray[freeMan.getFirstId()-1]; // pick first free man in the list
				int womanId = m.getPreferenceList()[m.getNextProposed()-1]; // pick the current proposed woman's id
				Woman w = womanArray[womanId-1];
				if (w.getCurrent() == 0) { // if w is free
					freeMan.removeFirst(); // remove m from the free man list
					w.setCurrent(m.getId());
				} else if (w.getRankingList()[w.getCurrent()-1] > w.getRankingList()[m.getId()-1]) { // if w prefers m to her current fiance
					freeMan.removeFirst();
					freeMan.insertFirst(w.getCurrent());
					w.setCurrent(m.getId());
				}
				m.setNextProposed(); // m set the next proposed woman no matter he's been accepted or rejected
			}

			// print result
			System.out.println("man   woman   ");
			Man m;
			for (int i = 0; i < numOfMen; i++) {
				m = manArray[i];
				System.out.printf("%2d%7d%n", m.getId(), m.getPreferenceList()[m.getNextProposed()-2]);
			}

		} catch (IOException ex) {
			System.out.println("Cannot find the file. Please check the directory");
		}
	}
}