/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author 
 * William Winterflood
 */

import java.time.ZonedDateTime;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.io.IOException;

public class Track {
  
  ArrayList<Point> points;


  // TODO: Create a stub for the constructor
  public Track()  {
    points = new ArrayList<Point>();
    points.clear();
    
  }

  public Track (String filename) throws IOException{
    readFile(filename);

  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename) throws IOException {

      points.clear();
      
      File file = new File(filename);
      Scanner input = new Scanner(file);

      input.nextLine();
      
      if (!file.exists()) {
        input.close();
        throw new GPSException("File does not exist");
      }

      while (input.hasNextLine()) {
        String line = input.nextLine();
        String[] variables = line.split(",");

        if (variables.length < 4) {
          input.close();
          throw new GPSException("Error: Not enough columns");
        }
        
        ZonedDateTime t = ZonedDateTime.parse(variables[0]);
        double lon = Double.parseDouble(variables[1]);
        double lat = Double.parseDouble(variables[2]);
        double elev = Double.parseDouble(variables[3]);


        Point temp = new Point(t, lon, lat, elev);
        add(temp);

        System.out.printf("%s, (%.5f, %.5f), %.5fn",t , lon, lat, elev);

      }
      input.close();
  }
  
  // TODO: Create a stub for add()
  public void add(Point point) {
    points.add(point);
  }
  

  // TODO: Create a stub for get()
  public Point get(int index) {
    if (index < 0 || index >= points.size()) {
      throw new GPSException("Incorrect index");
    }

    return points.get(index);
  }
  

  // TODO: Create a stub for size()
  public int size() {
    int size = points.size();
    return size;

  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint() {

    if (points.isEmpty()) {
      throw new GPSException("Track is empty.");
    }

    Point lowestP = points.get(0);

    for (int i = 1; i < points.size(); i++) {
      Point currentP = points.get(i);

      if (currentP.getElevation() < lowestP.getElevation()) {
        lowestP = currentP;
      }
    } 
    
    return lowestP;
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint() {
    if (points.isEmpty()) {
      
      throw new GPSException("Track is empty");
    }
    Point highestP = points.get(0);

    for (int i = 1; i < points.size(); i++) {
      Point currentHP = points.get(i);

      if (currentHP.getElevation() > highestP.getElevation()) {
        highestP = currentHP;
      }
    }
    return highestP;
  }

  // TODO: Create a stub for totalDistance()
  public double totalDistance() {
   double totalDistance = 0.0;

   if (points.size() < 2) {
    throw new GPSException ("Less than two points");
   }

   for (int i = 0; i < points.size() - 1; i++) {
    Point p1  = points.get(i);
    Point p2 = points.get(i + 1);

    totalDistance += Point.greatCircleDistance(p1, p2);
   }
   return totalDistance;
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed() {
    if (points.size() < 2) {
      throw new GPSException ("Not enough points");
    }

   double totalDistance = this.totalDistance();
   double totalTime = 0.0;

    for (int i = 0; i < points.size() - 1; i++) {
      Point startPoint = points.get(i);
      Point endPoint = points.get(i + 1);

      double timeBetweenPoints = startPoint.getTime().until(endPoint.getTime(), ChronoUnit.SECONDS);

      totalTime = totalTime + timeBetweenPoints;
    }

    double averageSpeed = totalDistance / totalTime;

    return averageSpeed;
  }


  
  
}
