public class Interview {

    private int interviewId;
    private int applicationId;
    private String interviewDate;
    private String interviewTime;
    private String interviewRound;
    private String interviewStatus;

    public Interview(int interviewId, int applicationId,
                     String interviewDate, String interviewTime,
                     String interviewRound) {
        this.interviewId = interviewId;
        this.applicationId = applicationId;
        this.interviewDate = interviewDate;
        this.interviewTime = interviewTime;
        this.interviewRound = interviewRound;
        this.interviewStatus = "Scheduled";
    }

    public int getInterviewId() {
        return interviewId;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public String getInterviewTime() {
        return interviewTime;
    }

    public String getInterviewRound() {
        return interviewRound;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public void displayInterview() {
        System.out.println("----------------------------------------");
        System.out.println("Interview ID: " + interviewId);
        System.out.println("Application ID: " + applicationId);
        System.out.println("Interview Date: " + interviewDate);
        System.out.println("Interview Time: " + interviewTime);
        System.out.println("Interview Round: " + interviewRound);
        System.out.println("Interview Status: " + interviewStatus);
    }
}