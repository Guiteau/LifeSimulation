package dad.lifesimulation.main.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Statistics implements Serializable {
	private int energy;
	private int health;
	private int armor;
	private int damage;
	private PropertyChangeSupport support;
	
	/**
	 * Constructor.
	 */

	public Statistics() {
		support = new PropertyChangeSupport(this);
	}
	
	/**
	 * Constructor.
	 * @param energy
	 * @param health
	 * @param armor
	 * @param damage
	 */
	
	public Statistics(int energy, int health, int armor, int damage) {
		this.energy = energy;
		this.health = health;
		this.armor = armor;
		this.damage = damage;
		
		support = new PropertyChangeSupport(this);
	}

	/**
	 * 
	 * @return energy current energy of an Entity (int value)
	 */

	public int getEnergy() {
		return energy;
	}


	/**
	 * 
	 * @return health current health of an Entity (int value)
	 */

	public int getHealth() {
		return health;
	}

	/**
	 * 
	 * @return armor current armor of an Entity (int value)
	 */

	public int getArmor() {
		return armor;
	}


	/**
	 * 
	 * @return damage current damage an Entity (object type) can cause
	 */

	public int getDamage() {
		return damage;
	}

	/**
	 * 
	 * @param _dmg amount of damage an Entity (object type) receives
	 */

	public void damageReceive(int _dmg) {
		this.setHealth(this.getHealth() - _dmg);
	}

	/**
	 * 
	 * @param _health amount of health an Entity (object type) receives 
	 */

	public void healthReceive(int _health) {
		this.setHealth(this.getHealth() + _health);
	}

	/**
	 * 
	 * @param _armor amount of armor an Entity (object type) receives
	 */

	public void armorReceive(int _armor) {
		this.setArmor(this.getArmor() + _armor);
	}

	/**
	 * 
	 * @param _energy amount of enerfy an Entity (object type) receives
	 */

	public void energyReceive(int energy) {
		this.setEnergy(this.getEnergy() + energy);
	}

	/**
	 * 
	 * @param damage damage to set (int value)
	 */

	public void setDamage(int damage) {
		int oldDamage = this.damage;
		this.damage = damage;
		support.firePropertyChange("damage", oldDamage, damage);
	}
	
	/**
	 * 
	 * @param armor armor to set (int value)
	 */

	public void setArmor(int armor) {
		int oldArmor = this.armor;
		this.armor = armor;
		support.firePropertyChange("damage", oldArmor, armor);
	}

	/**
	 * 
	 * @param health health to set (int value)
	 */

	public void setHealth(int health) {
		int oldHealth = this.health;
		this.health = health;
		support.firePropertyChange("damage", oldHealth, health);
	}

	/**
	 * 
	 * @param energy energy to set (int value)
	 */

	public void setEnergy(int energy) {
		int oldEnergy = this.energy;
		this.energy = energy;
		support.firePropertyChange("damage", oldEnergy, energy);
	}
	
	/**
	 * Adds a new PropertyChangeListener to the initial PropertyChangeListener
	 * 
	 * @param listener PropertyChangeListener to be added
	 */
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

	
	/**
	 * Removes a PropertyChangeListener present in the initial PropertyChangeListener
	 * 
	 * @param listener PropertyChangeListener to be removed
	 */
	
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
