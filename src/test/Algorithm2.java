package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class Algorithm2 extends Solution {

	@Override
	public void test() {

		List<Record> yesterday = new ArrayList<Record>();
		yesterday.addAll(Arrays.asList(new Record(1, 3, 1), new Record(1, 6, 4), new Record(1, 7, 3), new Record(1, 9, 2)));
		yesterday.addAll(Arrays.asList(new Record(1, 2, 4), new Record(1, 4, 6), new Record(1, 8, 10)));

		List<Record> today = new ArrayList<Record>();
		today.addAll(Arrays.asList(new Record(1, 3, 1), new Record(1, 6, 4), new Record(1, 7, 3), new Record(1, 9, 2)));

		// 30 people yesterday; 10 people into the building already today.
		Assert.assertEquals(1, solution(yesterday, today));

		// 10 more people comes.
		today.addAll(Arrays.asList(new Record(1, 2, 4), new Record(1, 4, 6)));
		Assert.assertEquals(1, solution(yesterday, today));

		// 5 more people comes (5 not yet).
		today.addAll(Arrays.asList(new Record(1, 8, 5)));
		Assert.assertEquals(1, solution(yesterday, today));

		// 1 more people comes, then stop changes to 8th.
		today.addAll(Arrays.asList(new Record(1, 8, 1)));
		Assert.assertEquals(8, solution(yesterday, today));

		// all rest 4 people comes.
		today.addAll(Arrays.asList(new Record(1, 8, 4)));
		Assert.assertEquals(8, solution(yesterday, today));
	}

	public static int solution(List<Record> history, List<Record> input) {
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

	private static double init(List<Record> history) {
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
