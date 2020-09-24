package service;

import repo.Plateau;
import repo.RoverCordinates;

public class RoverFactory {

    public static Rover getRover(RoverCordinates cordinates, Plateau plateau) {
        return new RoverImpl(cordinates, plateau);
    }

}
