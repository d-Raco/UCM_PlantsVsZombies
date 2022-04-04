package tp.p1.util;

import java.util.Random;

import tp.p1.logic.Zombie;
import tp.p1.logic.objects.Buckethead;
import tp.p1.logic.objects.CommonZombie;
import tp.p1.logic.objects.Sporty;

public class ZombieFactory {
	private static double frequence = 0.33;
	
	private static Zombie [] availableZombies = {	
		new CommonZombie(),
		new Buckethead(),
		new Sporty(),
	};
	
	public static Zombie getZombie(String name) {
		Zombie newZombie = null;
		switch(name) {
		case "commonzombie":
		case "z":
			newZombie = new CommonZombie();
			break;
		case "buckethead":
		case "b":
			newZombie = new Buckethead();
			break;
		case "sporty":
		case "r":
			newZombie = new Sporty();
		}
		return newZombie;
	}
	
	public static Zombie getZombie(Random r) {
		int num = r.nextInt(10);
		Zombie newZombie;
		if (num < frequence * 10) 
			newZombie = getZombie("z");
		else if (num >= frequence * 10 && num < frequence * 20) 
			newZombie = getZombie("b");
		else
			newZombie = getZombie("r");
		return newZombie;
	}
	
	public static String infoAvailableZombies() {
		String helpstr = "";
		for(int i = 0; i < availableZombies.length; i++)
			helpstr += availableZombies[i].getInfo() + "\n";
		return helpstr;
	}
}
