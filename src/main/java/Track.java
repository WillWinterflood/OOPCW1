/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author 
 * William Winterflood
 */

import java.time.ZonedDateTime;
import java.io.File;
import java.util.Scanner;

public class Track {
  private String PointData;

  // TODO: Create a stub for the constructor
  public Track()  {
    PointData = "";
  

  }

  public Track (String filename) {
    readFile(filename);


  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename) {
    Scanner input = new Scanner(filename);
    
    while (input.hasNextLine()) {
      String line = input.nextLine();
      String[] variables = line.split(",");

      ZonedDateTime t = ZonedDateTime.parse(variables[0]);
      double lon = Double.valueOf(variables[1]);
      double lat = Double.valueOf(variables[2]);
      double elev = Double.valueOf(variables[3]);

      Point temp = new Point(t, lon, lat, elev);
      add(temp);

      System.out.printf("%d (%.5f, %.5f), %.5fn",t , lon, lat, elev);
    }

    input.close();

  }

  // TODO: Create a stub for add()
  public void add(Point point) {

  }
  

  // TODO: Create a stub for get()
  public Point get(int index) {
    return null;

  }
  

  // TODO: Create a stub for size()
  public int size() {
    return 0;

  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint() {
    return null;
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint() {
    return null;
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
