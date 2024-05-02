
public class Solution {

    private static final int[] RANGE_OF_VALUES = {-1000, 1000};
    private static final int OFFSET = Math.abs(RANGE_OF_VALUES[0]);
    private static final int NOT_FOUND = -1;

    public int findMaxK(int[] input) {
        boolean[] foundValues = new boolean[RANGE_OF_VALUES[1] + OFFSET + 1];
        for (int value : input) {
            foundValues[value + OFFSET] = true;
        }

        for (int value = RANGE_OF_VALUES[1] + OFFSET; value >= OFFSET; --value) {
            if (foundValues[value] && foundValues[OFFSET - (value - OFFSET)]) {
                return value - OFFSET;
            }
        }

        return NOT_FOUND;
    }
}
