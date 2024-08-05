public class Submission {
    String studentID;
    int assignmentNum;
    int score;

    public Submission(String sid, int anum, int score) {
        this.studentID = sid;
        this.assignmentNum = anum;
        this.score = score;
    }

    public String toString() {
        return this.studentID + " " + this.assignmentNum + " "+ this.score;
    }
}
