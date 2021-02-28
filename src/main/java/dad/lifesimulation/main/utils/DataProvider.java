package dad.lifesimulation.main.utils;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

	public static List<EntityReport> entitiesArrayData = new ArrayList<>();

	public DataProvider(List<EntityReport> entitiesArrayData ) {
	
		DataProvider.entitiesArrayData = entitiesArrayData;

	}

	public static List<EntityReport> getEntitiesListDataProvider() {

		return entitiesArrayData;

	}

	public static void setEntitiesArrayData(List<EntityReport> entitiesArrayData) {
		DataProvider.entitiesArrayData = entitiesArrayData;
	}

}
