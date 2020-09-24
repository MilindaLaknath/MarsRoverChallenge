import repo.Plateau;
import repo.RoverCordinates;
import service.Rover;
import service.RoverFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarsDemo {

    private static Scanner scanner;
    private static Logger logger = Logger.getLogger(MarsDemo.class.getName());
    static String filePath = "input.txt";

    public static void main(String[] args) {

        int upperX = 0;
        int upperY = 0;
        ArrayList<RoverCordinates> roverCordinates = new ArrayList<RoverCordinates>();

        if (args.length!=1){
            logger.log(Level.ALL, "Please provide the input file");
        }else {
            filePath = args[0];
        }
        try {
            scanner = new Scanner(new FileInputStream(new File(filePath)));
        } catch (FileNotFoundException e) {
            logger.log(Level.ALL, e.toString());
        }

        String[] upperCoordinates = scanner.nextLine().split(" ");
        upperX = Integer.parseInt(upperCoordinates[0]);
        upperY = Integer.parseInt(upperCoordinates[1]);

        Plateau plateau = new Plateau(upperX, upperY);

        while (scanner.hasNext()) {
            String[] roverCoordinate = scanner.nextLine().split(" ");
            String path = scanner.nextLine();
            RoverCordinates cordinates = new RoverCordinates(Integer.parseInt(roverCoordinate[0]),
                    Integer.parseInt(roverCoordinate[1]),
                    roverCoordinate[2].charAt(0),
                    path);
            roverCordinates.add(cordinates);
        }

        try {
            FileWriter fw = new FileWriter("output.txt");
            for(RoverCordinates cordinates : roverCordinates){
                Rover rover = RoverFactory.getRover(cordinates, plateau);
                fw.write(rover.control());
                fw.write("\n");
            }

            fw.close();
        } catch (IOException e) {
            logger.log(Level.ALL, e.toString());
        }

    }

}


