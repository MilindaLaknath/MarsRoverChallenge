package service;

import repo.Plateau;
import repo.RoverCordinates;

public class RoverImpl implements Rover {

    Plateau plateau;
    RoverCordinates cordinates;

    RoverImpl(RoverCordinates cordinates, Plateau plateau) {
        this.cordinates = cordinates;
        this.plateau = plateau;
    }

    public String control() {
        char[] letters = cordinates.getPath().toUpperCase().toCharArray();
        for (char c : letters) {
            switch (c) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    moveForward();
                    break;
                default:
                    System.out.println("Wrong imput");
            }
        }
        return  this.cordinates.getX() + " " + this.cordinates.getY() + " " + this.cordinates.getFace();
    }

    private void turnLeft() {
        switch (this.cordinates.getFace()) {
            case 'N':
                this.cordinates.setFace('W');
                break;
            case 'E':
                this.cordinates.setFace('N');
                break;
            case 'S':
                this.cordinates.setFace('E');
                break;
            case 'W':
                this.cordinates.setFace('S');
                break;
            default:
        }
    }

    private void turnRight() {
        switch (this.cordinates.getFace()) {
            case 'N':
                this.cordinates.setFace('E');
                break;
            case 'E':
                this.cordinates.setFace('S');
                break;
            case 'S':
                this.cordinates.setFace('W');
                break;
            case 'W':
                this.cordinates.setFace('N');
                break;
            default:
        }
    }

    private void moveForward() {
        switch (this.cordinates.getFace()) {
            case 'E':
                if (this.cordinates.getX() <= plateau.getUpperX())
                    this.cordinates.setX(this.cordinates.getX()+1);
                break;
            case 'W':
                if (this.cordinates.getX() >= plateau.getLowerX())
                    this.cordinates.setX(this.cordinates.getX()-1);
                break;
            case 'N':
                if (this.cordinates.getY() <= plateau.getUpperY())
                    this.cordinates.setY(this.cordinates.getY()+1);
                break;
            case 'S':
                if (this.cordinates.getY() >= plateau.getLowerY())
                    this.cordinates.setY(this.cordinates.getY()-1);
                break;
            default:
        }
    }

}
