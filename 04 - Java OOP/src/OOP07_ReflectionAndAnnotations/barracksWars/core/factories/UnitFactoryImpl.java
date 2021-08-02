package OOP07_ReflectionAndAnnotations.barracksWars.core.factories;

import L7_Reflection.barracksWars.interfaces.Unit;
import L7_Reflection.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SuppressWarnings("unchecked")
public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"L7_Reflection.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {

		Unit unit = null;

		try {
			Class clazz =  Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor ctor = clazz.getDeclaredConstructor();
			unit = (Unit)ctor.newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}

		return unit;

	}
}
