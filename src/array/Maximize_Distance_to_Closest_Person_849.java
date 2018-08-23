package array;

/**
 * Created by Anson Luo(Anson.Luo@pegasus.ae) on 8/23/18.
 */
public class Maximize_Distance_to_Closest_Person_849 {

    public int maxDistToClosest(int[] seats) {
        Integer tempDistance = 0, maxDistance = 0, firstSeated = null, lastSeated = 0;
        for (int i = 0; i < seats.length; i++) {
            int temp = seats[i];
            if (temp == 1) {
                if (firstSeated == null) {
                    firstSeated = i;
                }
                if (i > lastSeated) {
                    lastSeated = i;
                }
                maxDistance = Math.max(tempDistance, maxDistance);
                tempDistance = 0;
            }
            tempDistance++;
        }
        int startDistance = 0,endDistance = 0, midDistance = 0;
        startDistance = firstSeated;
        endDistance = seats.length - 1 -lastSeated;
        midDistance = maxDistance/2;
        return Math.max(Math.max(startDistance, endDistance), midDistance);
    }
}
