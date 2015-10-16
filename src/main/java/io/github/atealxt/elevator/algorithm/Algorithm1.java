package io.github.atealxt.elevator.algorithm;

import java.util.Arrays;
import java.util.List;

public class Algorithm1 extends Solution {

	public int solution(List<Record> input) {
		int[] score = new int[MAX_FLOOR];
		for (Record r : input) {
			if (!r.validate()) {
				System.out.println("Wrong input: " + r);
				continue;
			}
			score[r.to - 1] += (Math.max(1, r.to - 1) * r.numPeople);
			score[r.from - 1] -= (Math.max(1, r.from - 1) * r.numPeople);
		}
		int maxScore = 0, idx = 0;
		for (int i = 0; i < score.length; i++) {
			if (score[i] > maxScore) {
				maxScore = score[i];
				idx = i;
			}
		}
		System.out.println(Arrays.toString(score));
		return idx + 1;
	}
}
