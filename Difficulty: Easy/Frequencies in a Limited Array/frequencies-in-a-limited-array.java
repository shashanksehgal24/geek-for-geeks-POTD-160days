import java.util.*;

class Solution {
    public List<Integer> frequencyCount(int[] arr) {
        int n = arr.length;
        int[] frequency = new int[n];

        for (int value : arr) {
            frequency[value - 1]++;
        }

        List<Integer> result = new ArrayList<>();

        for (int count : frequency) {
            result.add(count);
        }

        return result;
    }
}