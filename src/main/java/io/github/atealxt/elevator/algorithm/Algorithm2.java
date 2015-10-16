package io.github.atealxt.elevator.algorithm;

import java.util.Arrays;
import java.util.List;

public class Algorithm2 extends Solution {

	public int solution(List<Record> history, List<Record> input) {
		double[] score = new double[9];
		score[0] = init(history);
		for (Record r : input) {
			if (!r.validate()) {
				System.out.println("Wrong input: " + r);
				continue;
			}
			score[r.to - 1] += (Math.max(1, r.to - 1) * r.numPeople);
			score[r.from - 1] -= (Math.max(1, r.to - 1) * r.numPeople);
		}
		double maxScore = 0;
		int idx = 0;
		for (int i = 0; i < score.length; i++) {
			if (score[i] > maxScore) {
				maxScore = score[i];
				idx = i;
			}
		}
		System.out.println(Arrays.toString(score));
		return idx + 1;
	}

	private double init(List<Record> history) {
		double score = 0d;
		for (Record r : history) {
			if (!r.validate()) {
				System.out.println("Wrong input: " + r);
				continue;
			}
			if (r.from != 1) {
				continue;
			}
			score += (Math.max(1, r.to - 1) * r.numPeople);
		}
		System.out.println(score);
		return score;
	}
}
