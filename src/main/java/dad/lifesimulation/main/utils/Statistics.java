package dad.lifesimulation.main.utils;

public class Statistics {
	private int energy;
	private int health;
	private int armor;
	private int damage;

	public Statistics(int energy, int health, int armor, int damage) {
		this.energy = energy;
		this.health = health;
		this.armor = armor;
		this.damage = damage;
	}

	/**
	 * 
	 * @return energía que tiene un objeto
	 */

	public int getEnergy() {
		return energy;
	}

	/**
	 * 
	 * @param energy a establecer en un objeto
	 */

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	/**
	 * 
	 * @return health que tiene un objeto
	 */

	public int getHealth() {
		return health;
	}

	/**
	 * 
	 * @param health a establecer en un objeto
	 */

	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * 
	 * @return armadura que tiene un objeto
	 */

	public int getArmor() {
		return armor;
	}

	/**
	 * 
	 * @param armor a establecer en un objeto
	 */

	public void setArmor(int armor) {
		this.armor = armor;
	}

	/**
	 * 
	 * @return damage que aplica sobre un objeto
	 */

	public int getDamage() {
		return damage;
	}

	/**
	 * 
	 * @param damage a establecer en un objeto
	 */

	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * 
	 * @param _dmg cantidad de daño que recibe un objeto
	 */

	public void damageReceive(int _dmg) {
		this.health = health - (_dmg - armor);
	}

	/**
	 * 
	 * @param _health cantidad de vida que recibe un objeto
	 */

	public void healthReceive(int _health) {
		this.health += _health;
	}

	/**
	 * 
	 * @param _armor cantidad de armadura que recibe un objeto
	 */

	public void armorReceive(int _armor) {
		this.armor += _armor;
	}

	/**
	 * 
	 * @param _energy cantidad de energía que recibe un objeto
	 */

	public void energyReceive(int _energy) {
		this.energy += _energy;

	}

}
