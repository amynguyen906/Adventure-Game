/*
* Adventure.java
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
import java.util.Scanner;
public class Adventure {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		Player playerOfGame = new Player();
		Map mapOfGame = new Map();
		
		//sets player's location to (0,0)
		playerOfGame.setLocationX(0);
		playerOfGame.setLocationY(0);
		Room currentRoom = mapOfGame.getRoom(playerOfGame.getLocationX(), playerOfGame.getLocationY());
		
		String playerInput = "";
		boolean playerAlive = true;
	
		System.out.println("Welcome to UGA Adventures: Episode I\n"
				+ "The Adventure of the Cave of Redundancy Adventure\n"
				+ "By: Amy Nguyen\n");
		
		System.out.println(currentRoom.getDescription());
		playerInput = keyboard.nextLine();
	
		//game will end when player opens chest or is eaten by grue
		while (playerAlive) {
			currentRoom = mapOfGame.getRoom(playerOfGame.getLocationX(), playerOfGame.getLocationY());
		
			//if user enters an invalid command
			while (!playerInput.equalsIgnoreCase("get lamp")&&!playerInput.equalsIgnoreCase("light lamp")&&!playerInput.equalsIgnoreCase("end")&&!playerInput.equalsIgnoreCase("north")&&
					!playerInput.equalsIgnoreCase("south")&&!playerInput.equalsIgnoreCase("east")&&!playerInput.equalsIgnoreCase("west")&&!playerInput.equalsIgnoreCase("look")&&
					!playerInput.equalsIgnoreCase("get key")&&!playerInput.equalsIgnoreCase("open chest")&&!playerInput.equalsIgnoreCase("unlock chest")) {
				
				System.out.println("I'm sorry I don't know how to do that.");
				System.out.println("Please re-enter a command.");
				playerInput = keyboard.nextLine(); //makes user keep entering a command until program receives a valid command 
			}
			
			//if user enters "get lamp" command
			if (playerInput.equalsIgnoreCase("get lamp")) {
				
				if (currentRoom.getLamp() == null) {
					System.out.println("No lamp present");
				}
				else {
					playerOfGame.setLamp(currentRoom.getLamp());
					currentRoom.clearLamp();
					System.out.println("OK");
				}
				
				playerInput = keyboard.nextLine();
			}
			
			//if user enters "light lamp" command
			if(playerInput.equalsIgnoreCase("light lamp")) {
				
				if (playerOfGame.getLamp() == null) {
					System.out.println("You don't have the lamp to light");
				}
				else {
					playerOfGame.getLamp().lightLamp();
					System.out.println("OK");
				}
				
				playerInput = keyboard.nextLine();
			}
			
			//if user wants to move north, south, east, west
			if (playerInput.equalsIgnoreCase("north")||playerInput.equalsIgnoreCase("south")||playerInput.equalsIgnoreCase("east")||playerInput.equalsIgnoreCase("west")) {
				
				//if the room is dark, and player does not have a lamp/have a lamp but lamp is not lit
				if ((currentRoom.isDark() == true) && (playerOfGame.getLamp() == null || (playerOfGame.getLamp() != null && playerOfGame.getLamp().lampLit() == false))) {
					System.out.println("You have stumbled into a passing grue, and have been eaten");
					System.exit(0);
				}
				
				if (playerInput.equalsIgnoreCase("north") && currentRoom.canGoNorth() == false) {
					System.out.println("Can't go that way");
				}
				else if (playerInput.equalsIgnoreCase("north")) {
					playerOfGame.setLocationX(playerOfGame.getLocationX() - 1);
				}
				else if (playerInput.equalsIgnoreCase("south") && currentRoom.canGoSouth() == false ) {
					System.out.println("Can't go that way");
				}
				else if (playerInput.equalsIgnoreCase("south")) {
					playerOfGame.setLocationX(playerOfGame.getLocationX() + 1);
				}
				else if (playerInput.equalsIgnoreCase("east") && currentRoom.canGoEast() == false) {
					System.out.println("Can't go that way");
				}
				else if (playerInput.equalsIgnoreCase("east")) {
					playerOfGame.setLocationY(playerOfGame.getLocationY() + 1);
				}
				else if (playerInput.equalsIgnoreCase("west") && currentRoom.canGoWest() == false) {
					System.out.println("Can't go that way");
				}
				else if (playerInput.equalsIgnoreCase("west")) {
					playerOfGame.setLocationY(playerOfGame.getLocationY() - 1);
				}
				
				currentRoom = mapOfGame.getRoom(playerOfGame.getLocationX(), playerOfGame.getLocationY()); //update room location
				
				//if the room is dark, and player does not have a lamp/have a lamp but lamp is not lit
				if ((currentRoom.isDark() == true) && (playerOfGame.getLamp() == null || (playerOfGame.getLamp() != null && playerOfGame.getLamp().lampLit() == false))) {
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
				else {
					System.out.println(currentRoom.getDescription());
				}
				
				playerInput = keyboard.nextLine();
			}
			
			//user wants to look around
			if (playerInput.equalsIgnoreCase("look")) {
				
				//if the room is dark, and player does not have a lamp/have a lamp but lamp is not lit
				if ((currentRoom.isDark() == true) && (playerOfGame.getLamp() == null || (playerOfGame.getLamp() != null && playerOfGame.getLamp().lampLit() == false))) {
					System.out.println("It is pitch black, you can't see anything. You may be eaten by a grue!");
				}
				else {
					System.out.println(currentRoom.getDescription());
					
					//if there is a lamp in the room
					if (currentRoom.getLamp() != null) {
						System.out.println("There is an old oil lamp that was made long ago here.");
					}
					
					//if there is a key in the room
					if (currentRoom.getKey() != null) {
						System.out.println("You see the outline of a key on a dusty shelf that's covered in dust.");
					}
					
					//if there is a chest in the room
					if (currentRoom.getChest() != null) {
						System.out.println("There is a large, wooden, massive, oaken chest here with the word “CHEST” carved into it.");
					}
					
					//shows possible exits from the current room the player is in
					System.out.print("Exits are: ");
					
					if(currentRoom.canGoNorth() == true) {
						System.out.println("north");
					}
					if(currentRoom.canGoSouth() == true) {
						System.out.println("south");
					}
					if(currentRoom.canGoEast() == true) {
						System.out.println("east");
					}
					if(currentRoom.canGoWest() == true) {
						System.out.println("west");
					}
				}
				
				playerInput = keyboard.nextLine();
			}
			
			//if player wants to take key from room
			if (playerInput.equalsIgnoreCase("get key")) {
				
				if (currentRoom.getKey() == null) {
					System.out.println("No key present");
				}
				else {
					playerOfGame.setKey(currentRoom.getKey());
					currentRoom.clearKey();
					System.out.println("OK");
				}
				
				playerInput = keyboard.nextLine();
			}
				
			//if player wants to open chest
			if (playerInput.equalsIgnoreCase("open chest")) {
				
				if (currentRoom.getChest() != null && currentRoom.getChest().isLocked() == false) {
					System.out.println(currentRoom.getChest().getContents());
					System.exit(0); //ends the game when the chest is open
				}
				else {
					if (currentRoom.getChest() == null) {
						System.out.println("No chest present");
					}
					if (currentRoom.getChest().isLocked() == true) {
						System.out.println("The chest is locked");
					}	
					
					playerInput = keyboard.nextLine();
				}
			}
			
			//if player wants to unlock the chest 
			if (playerInput.equalsIgnoreCase("unlock chest")) {
				
				if (playerOfGame.getKey() != null && currentRoom.getChest() != null) {
					playerOfGame.getKey().use(currentRoom.getChest());
					System.out.println("OK");
				}
				else {
					if (playerOfGame.getKey() == null) {
						System.out.println("Need a key to do any unlocking!");
					}
					if (currentRoom.getChest() == null) {
						System.out.println("No chest to unlock");
					}
				}
				
				playerInput = keyboard.nextLine();
			}
		}
		
		keyboard.close();
	}
}