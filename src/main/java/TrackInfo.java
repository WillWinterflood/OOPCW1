

/**
 * Program to provide information on a GPS track stored in a file.
 *
 * @author William Winterflood
 */
import java.io.IOException;

public class TrackInfo {
  public static void main(String[] args) throws IOException {
    // TODO: Implementation TrackInfo application here

    if (args.length == 0) {
      System.out.printf("No File name provided");
      System.exit(0);
    }

    Track track = new Track(args[0]);

    if (track == null) {
      System.out.printf("Cannot make track");
      return;
    }
 
    System.out.printf("%d points in track", track.size());
    System.out.printf("Lowest point is %s", track.lowestPoint().toString());
    System.out.printf("Highest point is %s", track.highestPoint().toString());
    System.out.printf("Total disstance = %.3f km", track.totalDistance());
    System.out.printf("Average speed = %.3f km/s", track.averageSpeed());

  }
}
