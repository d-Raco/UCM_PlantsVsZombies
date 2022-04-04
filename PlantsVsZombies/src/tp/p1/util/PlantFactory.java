package tp.p1.util;

import tp.p1.logic.Plant;
import tp.p1.logic.objects.Cherrybomb;
import tp.p1.logic.objects.Peashooter;
import tp.p1.logic.objects.Sunflower;
import tp.p1.logic.objects.Wallnut;

public class PlantFactory {
	private static Plant [] availablePlants = {	
		new Sunflower(),
		new Peashooter(),
		new Cherrybomb(),
		new Wallnut(),
	};
	
	public static Plant getPlant(String plantName){
		Plant newPlant = null;
		switch(plantName) {
		case "sunflower":
		case "s":
			newPlant = new Sunflower();
			break;
		case "peashooter":
		case "p":
			newPlant = new Peashooter();
			break;
		case "cherrybomb":
		case "c":
			newPlant = new Cherrybomb();
			break;
		case "walllnut":
		case "w":
			newPlant = new Wallnut();
		}
		return newPlant;
	}
	
	public static String infoAvilablePlants() {
		String helpstr = "";
		for(int i = 0; i < availablePlants.length; i++) {
			helpstr += availablePlants[i].getInfo() + "\n";
		}
		return helpstr;
	}
}
