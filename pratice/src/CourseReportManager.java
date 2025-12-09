package srp2;
import java.util.List;
public class CourseReportManager {
    private CourseDataLoader loader = new CourseDataLoader();
    private GradeCalculator calculator = new GradeCalculator();
    private ReportFormatter formatter = new ReportFormatter();
    private ReportStorage storage = new ReportStorage();
    private TeacherNotifier notifier = new TeacherNotifier();

    public void generateReport(String courseId) {
        List<String> students = loader.loadStudents(courseId);
        List<Integer> grades = loader.loadGrades(courseId);

        double avg = calculator.calculateAverage(grades);

        String report = formatter.formatReport(courseId, students, grades, avg);

        storage.saveToFile(report);
        notifier.sendEmail(report);
    }
}

class testReport {
    public static void main(String[] args) {
        CourseReportManager manager = new CourseReportManager();
        manager.generateReport("CS101");
    }
}

class CourseDataLoader {
    public List<String> loadStudents(String courseId) {
        System.out.println("Connecting to database...");
        System.out.println("Loading students for " + courseId + "...");
        return List.of("An", "Binh", "Chi");
    }

    public List<Integer> loadGrades(String courseId) {
        return List.of(9, 7, 8);
    }
}


class GradeCalculator {
    public double calculateAverage(List<Integer> grades) {
        double total = 0;
        for (int g : grades) total += g;
        return total / grades.size();
    }
}


class ReportFormatter {
    public String formatReport(String courseId, List<String> students, List<Integer> grades, double avg) {
        StringBuilder sb = new StringBuilder();
        sb.append("Course ID: ").append(courseId).append("\n");
        sb.append("Students and grades:\n");
        for (int i = 0; i < students.size(); i++) {
            sb.append("- ").append(students.get(i))
                    .append(": ").append(grades.get(i)).append("\n");
        }
        sb.append("Average grade: ").append(avg).append("\n");
        return sb.toString();
    }
}

class ReportStorage {
    public void saveToFile(String report) {
        System.out.println("Saving report.txt ...");
    }
}

class TeacherNotifier {
    public void sendEmail(String report) {
        System.out.println("Sending email to teacher...");
        System.out.println(report);
    }
}

