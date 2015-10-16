package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class Algorithm1 extends Solution {

	@Override
	public void test() {

		List<Record> records = new ArrayList<Record>();

		records.addAll(Arrays.asList(new Record(1, 3, 1), new Record(1, 6, 4), new Record(1, 7, 3), new Record(1, 9, 2)));
		Assert.assertEquals(6, solution(records));

		records.addAll(Arrays.asList(new Record(7, 6, 2), new Record(6, 1, 4)));
		Assert.assertEquals(9, solution(records));

		records.addAll(Arrays.asList(new Record(3, 1, 1), new Record(6, 1, 2), new Record(7, 1, 1), new Record(9, 1, 2)));
		Assert.assertEquals(1, solution(records));
	}

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
