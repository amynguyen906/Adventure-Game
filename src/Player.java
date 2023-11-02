/*
* Player.java
* Author: Amy Nguyen
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from anywhere other than the authorized
* sources. I recognize that any unauthorized sharing, assistance,
* or plagiarism will be handled in accordance with both the
* University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based on
* an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing or posting
* of source code at any time for this project is prohibited.
*/
public class Player {

	//items that could be in player's possession
	private Lamp lampOfPlayer;
	private Key keyOfPlayer;
	
	//keeps track of player's location
	private int playerLocationX;
	private int playerLocationY;
	
	//returns the lamp in player's possession
	public Lamp getLamp() {
		if (lampOfPlayer == null) {
			return null;
		}
		else {
			return lampOfPlayer;
		}
	}
	
	//returns the key in player's possession
	public Key getKey() {
		if (keyOfPlayer == null) {
			return null;
		}
		else {
			return keyOfPlayer;
		}
	}
	
	//player takes lamp from room
	public void setLamp(Lamp newLamp) {
		lampOfPlayer = newLamp;
	}
	
	//player takes key from room
	public void setKey (Key newKey) {
		keyOfPlayer = newKey;
	}
	
	//returns player's x location
	public int getLocationX() {
		return playerLocationX;
	}
	
	//set player's x location
	public void setLocationX(int newLocation) {
		playerLocationX = newLocation;
	}
	
	//get player's y location
	public int getLocationY() {
		return playerLocationY;
	}
	
	//set player's y location
	public void setLocationY(int newLocation) {
		playerLocationY = newLocation;
	}
}