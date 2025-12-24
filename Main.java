package EmailSpamFilter;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of emails
        System.out.println("Enter the number of emails");
        int n = sc.nextInt();

        int[] scores = new int[n];

        // Input: spam scores
        System.out.println("Enter the spam scores");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            if (scores[i] < 0) {
                System.out.println("Negative scores are not allowed");
                return; // Stop execution without System.exit(0)
            }
        }

        // Modify scores based on rules
        for (int i = 0; i < n; i++) {
            if (scores[i] >= 50) {
                scores[i] += 10;
            } else {
                scores[i] = Math.max(0, scores[i] - 5);
            }
        }

        // Count frequency of each modified score
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int score : scores) {
            freqMap.put(score, freqMap.getOrDefault(score, 0) + 1);
        }

        // Find unique scores (appearing exactly once) and calculate sum
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }

        // Output result
        if (sum == 0) {
            System.out.println("No unique scores found after modification");
        } else {
            System.out.println(sum);
        }
    }
}
