package com.aditya.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	
//	private MarioGame marioGame;                  //tight coupling
//	
//	private SuperContraGame superContrGame;       //tight coupling
	
//	@Autowired
	private GamingConsole gamingConsole;          //loose coupling using Interfaces
	

	/*
	 * public GameRunner(MarioGame marioGame) { this.marioGame = marioGame; }
	 */

	//Constructor Injection   ==>  ==> if we use Const Injection , then @Autowired Annotation on GamingConsole is not required
	
	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole gamingConsole) {
		this.gamingConsole = gamingConsole;
	}


	/*
	 * public void run() {
	 * 
	 * System.out.println("Running Game: " + marioGame );
	 * 
	 * marioGame.up(); marioGame.down(); marioGame.left(); marioGame.right();
	 * 
	 * }
	 */
	
	public void run() {
		
		System.out.println("Running Game: " + gamingConsole );

		gamingConsole.up();
		gamingConsole.down();
		gamingConsole.left();
		gamingConsole.right();
		
	}

}
