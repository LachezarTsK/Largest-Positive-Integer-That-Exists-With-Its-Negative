
import kotlin.math.abs

class Solution {

    private companion object {
        val RANGE_OF_VALUES = intArrayOf(-1000, 1000)
        val OFFSET = abs(RANGE_OF_VALUES[0])
        const val NOT_FOUND = -1;
    }

    fun findMaxK(input: IntArray): Int {
        val foundValues = BooleanArray(RANGE_OF_VALUES[1] + OFFSET + 1);
        for (value in input) {
            foundValues[value + OFFSET] = true;
        }

        for (value in (RANGE_OF_VALUES[1] + OFFSET).downTo(OFFSET)) {
            if (foundValues[value] && foundValues[OFFSET - (value - OFFSET)]) {
                return value - OFFSET;
            }
        }

        return NOT_FOUND;
    }
}
