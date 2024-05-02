
#include <array>
#include <vector>
using namespace std;

class Solution {

    static constexpr array<int, 2> RANGE_OF_VALUES = { -1000, 1000 };
    static const int OFFSET = -RANGE_OF_VALUES[0];
    static const int NOT_FOUND = -1;

public:
    int findMaxK(const vector<int>& input) const {
        array<bool, RANGE_OF_VALUES[1] + OFFSET + 1> foundValues{};
        for (const auto& value : input) {
            foundValues[value + OFFSET] = true;
        }

        for (int value = RANGE_OF_VALUES[1] + OFFSET; value >= OFFSET; --value) {
            if (foundValues[value] && foundValues[OFFSET - (value - OFFSET)]) {
                return value - OFFSET;
            }
        }

        return NOT_FOUND;
    }
};
