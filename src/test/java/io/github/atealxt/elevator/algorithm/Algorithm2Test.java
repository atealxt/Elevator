package io.github.atealxt.elevator.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Algorithm2Test {

	@Test
	public void testSolution() {

		Algorithm2 algo = new Algorithm2();

		List<Record> yesterday = new ArrayList<Record>();
		yesterday.addAll(Arrays.asList(new Record(1, 3, 1), new Record(1, 6, 4), new Record(1, 7, 3), new Record(1, 9, 2)));
		yesterday.addAll(Arrays.asList(new Record(1, 2, 4), new Record(1, 4, 6), new Record(1, 8, 10)));

		List<Record> today = new ArrayList<Record>();
		today.addAll(Arrays.asList(new Record(1, 3, 1), new Record(1, 6, 4), new Record(1, 7, 3), new Record(1, 9, 2)));

		// 30 people yesterday; 10 people into the building already today.
		Assert.assertEquals(1, algo.solution(yesterday, today));

		// 10 more people comes.
		today.addAll(Arrays.asList(new Record(1, 2, 4), new Record(1, 4, 6)));
		Assert.assertEquals(1, algo.solution(yesterday, today));

		// 5 more people comes (5 not yet).
		today.addAll(Arrays.asList(new Record(1, 8, 5)));
		Assert.assertEquals(1, algo.solution(yesterday, today));

		// 1 more people comes, then stop changes to 8th.
		today.addAll(Arrays.asList(new Record(1, 8, 1)));
		Assert.assertEquals(8, algo.solution(yesterday, today));

		// all rest 4 people comes.
		today.addAll(Arrays.asList(new Record(1, 8, 4)));
		Assert.assertEquals(8, algo.solution(yesterday, today));
	}
}
