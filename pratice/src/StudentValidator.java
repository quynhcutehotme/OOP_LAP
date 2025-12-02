package OOP;

public class StudentValidator {
    public boolean isValid(String name, String email) {
        if (name == null || name.isBlank()
                || email == null || !email.contains("@")) {
            return false;
        }
        return true;
    }
}

class StudentRepository {
    public void save(String name, String email) {
        System.out.println("Saving " + name + " with email " + email + " to database...");
    }
}

class EmailService {
    public void sendWelcomeEmail(String email) {
        System.out.println("Sending welcome email to " + email);
    }
}

class StudentManager {
private final StudentValidator validator;
private final StudentRepository repository;
private final EmailService emailService;

public StudentManager(StudentValidator validator, StudentRepository repository, EmailService emailService) {
    this.validator = validator;
    this.repository = repository;
    this.emailService = emailService;
}


public void addStudent(String name, String email) {
    if (!validator.isValid(name, email)) {
        System.out.println("Invalid data! Student not added.");
        return;
    }
    repository.save(name, email);
    emailService.sendWelcomeEmail(email);

    System.out.println("Student " + name + " successfully added.");
}

    public static void main(String[] args) {
        StudentValidator validator = new StudentValidator();
        StudentRepository repo = new StudentRepository();
        EmailService emailService = new EmailService();
        StudentManager manager = new StudentManager(validator, repo, emailService);
        manager.addStudent("Tin", "tin@example.com");
    }

}

