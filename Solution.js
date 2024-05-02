
/**
 * @param {number[]} input
 * @return {number}
 */
var findMaxK = function (input) {
    const RANGE_OF_VALUES = [-1000, 1000];
    const OFFSET = Math.abs(RANGE_OF_VALUES[0]);
    const NOT_FOUND = -1;

    const foundValues = new Array(RANGE_OF_VALUES[1] + OFFSET + 1).fill(false);
    for (let value of input) {
        foundValues[value + OFFSET] = true;
    }

    for (let value = RANGE_OF_VALUES[1] + OFFSET; value >= OFFSET; --value) {
        if (foundValues[value] && foundValues[OFFSET - (value - OFFSET)]) {
            return value - OFFSET;
        }
    }

    return NOT_FOUND;
};
