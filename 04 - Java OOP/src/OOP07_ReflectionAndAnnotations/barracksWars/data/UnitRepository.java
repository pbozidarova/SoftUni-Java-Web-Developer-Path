package OOP07_ReflectionAndAnnotations.barracksWars.data;

import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.Repository;
import OOP07_ReflectionAndAnnotations.barracksWars.interfaces.Unit;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

	private Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		if (!this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, 0);
		}

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formatedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			statBuilder.append(formatedEntry);
		}
		statBuilder.setLength(
				statBuilder.length() - System.lineSeparator().length());

		return statBuilder.toString();
	}

	public void removeUnit(String unitType){
		if(!this.amountOfUnits.containsKey(unitType) || this.amountOfUnits.get(unitType) == 0){
			throw new IllegalArgumentException("No such units in repository.");
		}

		int oldCount = this.amountOfUnits.get(unitType) -1;
		if(oldCount == -1){
			this.amountOfUnits.remove(unitType);
		}else{
			this.amountOfUnits.put(unitType, oldCount);
		}
	}
}
