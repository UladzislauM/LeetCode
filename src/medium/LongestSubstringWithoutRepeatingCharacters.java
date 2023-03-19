package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s != null) {
            String[] cutString = s.split("");
            int correctNumSequence = 0;
            List<String> correctSequence = new ArrayList<>();
            NumStrObject numStrObject = new NumStrObject(correctNumSequence, correctSequence);
            correctSequence.add(cutString[0]);
            int testNumSequence = 0;
            for (int i = 1; i < cutString.length - 1; i++) {
                if (!Objects.equals(cutString[i - 1], cutString[i])) {
                    correctNumSequence++;
                    correctSequence.add(cutString[i]);
                } else {
                    testNumSequence = (correctNumSequence >= testNumSequence ? correctNumSequence : testNumSequence);
                    correctNumSequence = 0;
                }

            }
        }
    }

    private class NumStrObject {
        int num;
        List<String> chars;

        public NumStrObject(int num, List<String> chars) {
            this.num = num;
            this.chars = chars;
        }
    }
}
