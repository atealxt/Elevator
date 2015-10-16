package io.github.atealxt.elevator.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class Algorithm1Test {

	@Test
	public void testSolution() {

		Algorithm1 algo = new Algorithm1();

		List<Record> records = new ArrayList<Record>();

		records.addAll(Arrays.asList(new Record(1, 3, 1), new Record(1, 6, 4), new Record(1, 7, 3), new Record(1, 9, 2)));
		Assert.assertEquals(6, algo.solution(records));

		records.addAll(Arrays.asList(new Record(7, 6, 2), new Record(6, 1, 4)));
		Assert.assertEquals(9, algo.solution(records));

		records.addAll(Arrays.asList(new Record(3, 1, 1), new Record(6, 1, 2), new Record(7, 1, 1), new Record(9, 1, 2)));
		Assert.assertEquals(1, algo.solution(records));
	}
}
