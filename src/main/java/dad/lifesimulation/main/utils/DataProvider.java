package dad.lifesimulation.main.utils;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

	public static List<EntityReport> entitiesArrayData = new ArrayList<>();
	
	/**
	 * Constructor.
	 * @param entitiesArrayData
	 */

	public DataProvider(List<EntityReport> entitiesArrayData ) {
	
		DataProvider.entitiesArrayData = entitiesArrayData;

	}

	/**
	 * 
	 * @return the list of entities that will be used for the report
	 */
	
	public static List<EntityReport> getEntitiesListDataProvider() {

		return entitiesArrayData;

	}
	
	/**
	 * 
	 * @param entitiesArrayData the list of entities to set (EntityReport types)
	 */

	public static void setEntitiesArrayData(List<EntityReport> entitiesArrayData) {
		DataProvider.entitiesArrayData = entitiesArrayData;
	}

}
