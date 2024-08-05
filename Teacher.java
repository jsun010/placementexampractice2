import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Teacher {
    /**
     * For every student who submits at least one assignment, count
     * the number of assignments they missed.  The assignments are
     * numbered from 0 to the numAssignments-1.
     *
     * Inputs:
     *   numAssignmentsGiven: the number of assignments given in the
     *     class
     *   submissions: a list of Submissions, one per student
     *     submission.  Students may submit the same assignment
     *     multiple times.
     *
     * Returns: a map that maps student IDS to the number of assignments missed.
     **/
    public static Map<String, Integer> countMissing(int numAssignmentsGiven,
                                                    List<Submission> submissions) {
        // TODO: complete this function
        Map<String, Map<Integer, Integer>> assignmentMap = new HashMap<>();
        for (Submission submission : submissions) {
            String studentId= submission.studentID;
            assignmentMap.putIfAbsent(studentId, new HashMap<>());
            int assignmentId=submission.assignmentNum;
            int score= submission.score;
            Map<Integer, Integer> studentAssignments = assignmentMap.get(studentId);
            if (studentAssignments != null) {
                studentAssignments.put(assignmentId, score);
            }

        }
        Map<String, Integer> missingAssignments = new HashMap<>();
        for (String studentId : assignmentMap.keySet()) {
            Map<Integer, Integer> studentAssignments = assignmentMap.get(studentId);
            for (int i=0; i<numAssignmentsGiven; i++) {
                if (!studentAssignments.containsKey(i)) {
                    missingAssignments.put(studentId, missingAssignments.getOrDefault(studentId, 0) + 1);
                }
            }
        }
        return missingAssignments;
    }
}
