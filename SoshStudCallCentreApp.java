public class SoshStudCallCentreApp
{
    private String studentName;
    private String queryType;
    private int secondsSpent;

    public SoshStudCallCentreApp()
    {
        this.studentName = "Thando";
        this.queryType = "General";
        this.secondsSpent = 0;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public void setQueryType(String queryType)
    {
        this.queryType = queryType;
    }

    public void setSecondsSpent(int secondsSpent)
    {
        this.secondsSpent = secondsSpent;
    }

    public int determineMinutes()
    {
        return secondsSpent / 60;
    }

    public String determineServiceRating()
    {
        int minutes = determineMinutes();

        if (minutes < 5)
        {
            return "Excellent";
        }
        else if (minutes >= 5 && minutes <= 10)
        {
            return "Good";
        }
        else
        {
            return "Needs Improvement";
        }
    }

    public void displayCallDetails()
    {
        System.out.println("Student Call Centre Enquiry Details");
        System.out.println("===============================");
        System.out.println("Student Name: \t\t" + studentName);
        System.out.println("Query Type: \t\t" + queryType + " Enquiry");
        System.out.println("Minutes Spent: \t\t" + determineMinutes() + " minutes");
        System.out.println("Service Rating: \t\t" + determineServiceRating());
        System.out.println("================================");
    }
}