/*
* Lamp.java
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
public class Lamp {

	/*
	 * Instance variables and methods go here, you're responsible for 
	 * choosing and naming them.
	 */
	
	private boolean lampOn = false;
	
	//returns true if lamp is on, false otherwise
	public boolean lampLit() {
		if (lampOn == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//light player's lamp
	public void lightLamp() {
		lampOn = true;
	}
}