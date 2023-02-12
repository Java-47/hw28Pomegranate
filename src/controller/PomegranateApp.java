package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import dao.Box;

public class PomegranateApp {

	public static void main(String[] args) {
		Random rand = new Random();
		int boxCount = rand.nextInt(101) + 100; // 100-200
		List<Box> boxes = new ArrayList<>();
		for (int i = 0; i < boxCount; i++) {
			Box box = new Box();
			box.setName("Box #" + i);
			boxes.add(box);
		}

		totalSeadsInBoxes(boxes);
		int maxSeed = maximumSeedsInBox(boxes);

		System.out.println("Max seeds count in the box = " + maxSeed);
		System.out.println("Name of maximum seeds boxes = " + nameOfMaxSeeds(boxes, maxSeed));
	}

	private static int totalSeadsInBoxes(List<Box> boxes) {
		int totalSeeds = boxes.stream().flatMap(box -> box.getGranates().stream())
				.map(pomegranate -> pomegranate.getSeeds().size())
				.reduce(0, (accum, s) -> accum + s);
		System.out.println("Total seeds = " + totalSeeds);
		return totalSeeds;
	}

	private static int maximumSeedsInBox(List<Box> boxes) {

		return boxes.stream()
				.map(b -> b.getSeedCount())
				.max(Integer::compareTo)
				.orElse(null);
	}

	private static List<String> nameOfMaxSeeds(List<Box> boxes, int maxSeeds) {

		return boxes.stream()
				.filter(b -> b.getSeedCount() == maxSeeds)
				.map(b -> b.getName())
				.collect(Collectors.toList());
	}
}
