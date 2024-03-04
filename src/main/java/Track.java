/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author 
 * William Winterflood
 */

import java.time.ZonedDateTime;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class Track {
  
  private List<Point> points;

  // TODO: Create a stub for the constructor
  public Track()  {

    points = new ArrayList<>();
    
  }

  public Track (String filename) {
    this();
    readFile(filename);


  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename) {
    try {
      File file = new File(filename);
  
      Scanner input = new Scanner(file);
    
      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[] variables = line.split(",");

        ZonedDateTime t = ZonedDateTime.parse(variables[0]);
        double lon = Double.valueOf(variables[1]);
        double lat = Double.valueOf(variables[2]);
        double elev = Double.valueOf(variables[3]);

        Point temp = new Point(t, lon, lat, elev);
        add(temp);

        System.out.printf("%s, (%.5f, %.5f), %.5fn",t , lon, lat, elev);
      }

      input.close();
    }
    catch (FileNotFoundException e) {
      throw new GPSException("Error loading file.");
    }
  }

  // TODO: Create a stub for add()
  public void add(Point point) {
    points.add(point);
  }
  

  // TODO: Create a stub for get()
  public Point get(int index) {
    return null;

  }
  

  // TODO: Create a stub for size()
  public int size() {
    return points.size();

  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint() {
    Point lowestP = points.get(0);


    if (points.size() == 0) {
      throw new GPSException("Track is empty.");
    }

    else {
      for (int i = 1; i < points.size(); i++) {
        Point currentP = points.get(i);

        if (currentP.getElevation() < lowestP.getElevation()) {
          lowestP = currentP;
        }
      } 
    }
    return lowestP;
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint() {
    Point highestP = points.get(0);

    for (int x = 1; x < points.size(); x++) {
      Point currentHP = points.get(x);

      if (currentHP.getElevation() > highestP.getElevation()) {
        highestP = currentHP;
      }
    }
    if (points.size() == 0) {
      throw new GPSException("Track is empty.");
    }
    return highestP;
  }

  // TODO: Create a stub for totalDistance()
  public double totalDistance() {
   return 0; 
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed() {
    return 0;
  }
}
