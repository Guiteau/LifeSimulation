package dad.lifesimulation.main.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Statistics {
	private int energy;
	private int health;
	private int armor;
	private int damage;
	private PropertyChangeSupport support;

	public Statistics() {
		support = new PropertyChangeSupport(this);
	}
	
	public Statistics(int energy, int health, int armor, int damage) {
		this.energy = energy;
		this.health = health;
		this.armor = armor;
		this.damage = damage;
		
		support = new PropertyChangeSupport(this);
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
	 * @return health que tiene un objeto
	 */

	public int getHealth() {
		return health;
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
	 * @return damage que aplica sobre un objeto
	 */

	public int getDamage() {
		return damage;
	}

	/**
	 * 
	 * @param _dmg cantidad de daño que recibe un objeto
	 */

	public void damageReceive(int _dmg) {
		this.setHealth(this.getHealth() - _dmg);
	}

	/**
	 * 
	 * @param _health cantidad de vida que recibe un objeto
	 */

	public void healthReceive(int _health) {
		this.setHealth(this.getHealth() + _health);
	}

	/**
	 * 
	 * @param _armor cantidad de armadura que recibe un objeto
	 */

	public void armorReceive(int _armor) {
		this.setArmor(this.getArmor() + _armor);
	}

	/**
	 * 
	 * @param _energy cantidad de energía que recibe un objeto
	 */

	public void energyReceive(int energy) {
		this.setEnergy(this.getEnergy() + energy);
	}

	
	/**
	 * 
	 * @param damage a establecer en un objeto
	 */

	public void setDamage(int damage) {
		int oldDamage = this.damage;
		this.damage = damage;
		support.firePropertyChange("damage", oldDamage, damage);
	}
	
	/**
	 * 
	 * @param armor a establecer en un objeto
	 */

	public void setArmor(int armor) {
		int oldArmor = this.armor;
		this.armor = armor;
		support.firePropertyChange("damage", oldArmor, armor);
	}

	/**
	 * 
	 * @param health a establecer en un objeto
	 */

	public void setHealth(int health) {
		int oldHealth = this.health;
		this.health = health;
		support.firePropertyChange("damage", oldHealth, health);
	}

	/**
	 * 
	 * @param energy a establecer en un objeto
	 */

	public void setEnergy(int energy) {
		int oldEnergy = this.energy;
		this.energy = energy;
		support.firePropertyChange("damage", oldEnergy, energy);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
