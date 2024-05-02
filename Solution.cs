
using System;

public class Solution
{
    private static readonly int[] RANGE_OF_VALUES = { -1000, 1000 };
    private static readonly int OFFSET = Math.Abs(RANGE_OF_VALUES[0]);
    private static readonly int NOT_FOUND = -1;

    public int FindMaxK(int[] input)
    {
        bool[] foundValues = new bool[RANGE_OF_VALUES[1] + OFFSET + 1];
        foreach (int value in input)
        {
            foundValues[value + OFFSET] = true;
        }

        for (int value = RANGE_OF_VALUES[1] + OFFSET; value >= OFFSET; --value)
        {
            if (foundValues[value] && foundValues[OFFSET - (value - OFFSET)])
            {
                return value - OFFSET;
            }
        }

        return NOT_FOUND;
    }
}
