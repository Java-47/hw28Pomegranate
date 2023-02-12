package dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Box implements Iterable<Pomegranate> {
	private String name;
	private List<Pomegranate> granates;

	public Box() {
		granates = new ArrayList<>();
		Random rand = new Random();
		int granatesCount = rand.nextInt((11)) + 10; // 10-20
		for (int i = 0; i < granatesCount; i++) {
			granates.add(new Pomegranate());
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pomegranate> getGranates() {
		return granates;
	}

	public void setGranates(List<Pomegranate> granates) {
		this.granates = granates;
	}

	@Override
	public Iterator<Pomegranate> iterator() {
		return granates.iterator();
	}

	public int getSeedCount() {
		return granates.stream()
				.mapToInt(granates -> granates.getSeeds().size())
				.reduce(0, (accum, s) -> accum + s);

	}
}
