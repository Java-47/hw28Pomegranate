package dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Pomegranate implements Iterable<Seed>{
	private List<Seed> seeds;
	private int SeedsCount;
	public Pomegranate(){
		seeds = new ArrayList<>();
		Random rand = new Random();
		SeedsCount = rand.nextInt((301)) + 400; //400-700
		for (int i = 0; i < SeedsCount; i++) {
			
			seeds.add(new Seed());	
		}
	}
	public List<Seed> getSeeds() {
		return seeds;
	}

	public void setSeeds(List<Seed> seeds) {
		this.seeds = seeds;
	}

	@Override
	public Iterator<Seed> iterator() {
		return seeds.iterator();
	}
}
