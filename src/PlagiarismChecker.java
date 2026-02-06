/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Eisha Yadav
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        int m = doc1.length();
        int n = doc2.length();

        int[][] tabulationTable = new int[m + 1][n + 1];

        // Iterate through ever single char comparison for every element in the docs
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If they are equal add to the table
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    tabulationTable[i][j] = tabulationTable[i - 1][j - 1] + 1;
                } else {
                    // If they aren't equal store the max length for future reference
                    tabulationTable[i][j] = Math.max(tabulationTable[i - 1][j], tabulationTable[i][j - 1]);
                }
            }
        }

        // Return the final max length
        return tabulationTable[m][n];

    }
}
