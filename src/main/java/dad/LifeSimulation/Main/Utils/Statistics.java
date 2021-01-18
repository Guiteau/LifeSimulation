package dad.LifeSimulation.Main.Utils;

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

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public void damageReceive(int _dmg) {
		this.health = health - (_dmg - armor);
	}

	public void healthReceive(int _health) {
		this.health += _health;
	}

	public void armorReceive(int _armor) {
		this.armor += _armor;
	}

	public void energyReceive(int _energy) {
		this.energy += _energy;

	}

}
