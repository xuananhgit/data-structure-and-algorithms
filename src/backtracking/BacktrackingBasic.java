package backtracking;

public class BacktrackingBasic {
    private static final String[] colors = {"red", "green", "blue", "yellow", "purple"};
    private static final int[] selections = new int[colors.length];
    private static int count = 0;
    private static final int[] validValues = {0,1};

    private static void backtrack(int currentIndex) {
        for (var validValue : validValues) {
            selections[currentIndex] = validValue;
            if (currentIndex == colors.length - 1) {
                process();
            } else {
                backtrack(currentIndex + 1);
            }
        }
    }

    public static void process() {
        StringBuilder newMixColor = new StringBuilder();
        for (var i = 0; i < colors.length; i++) {
            if (selections[i] == 1) {
                newMixColor.append(colors[i]);
            }
        }
        count++;
        System.out.println(count + " newColor: " + newMixColor);
    }

    public static void main(String[] args) {
        backtrack(0);
    }
}
