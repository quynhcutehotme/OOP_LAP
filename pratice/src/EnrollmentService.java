package solid_project;

import java.util.Arrays;
import java.util.List;


interface EnrollmentValidator {
    void validate(String student, String course);
}


class StudentNameValidator implements EnrollmentValidator {
    @Override
    public void validate(String student, String course) {
        if (student == null || student.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid student name!");
        }
    }
}

 interface EnrollmentRepository {
    void save(String student, String course);
}


class ConsoleEnrollmentRepository implements EnrollmentRepository {
    @Override
    public void save(String student, String course) {
        System.out.println("Saving enrollment: " + student + " -> " + course);
    }
}


interface Notifier {
    void notify(String student, String course);
}


class EmailNotifier implements Notifier {
    @Override
    public void notify(String student, String course) {
        System.out.println("Sending EMAIL to " + student + " for course " + course);
    }
}


class SmsNotifier implements Notifier {
    @Override
    public void notify(String student, String course) {
        System.out.println("Sending SMS to " + student + " for course " + course);
    }
}

public class EnrollmentService {
    private final List<EnrollmentValidator> validators;
    private final List<Notifier> notifiers;
    private final EnrollmentRepository repository;
    public EnrollmentService(List<EnrollmentValidator> validators,
                             List<Notifier> notifiers,
                             EnrollmentRepository repository) {
        this.validators = validators;
        this.notifiers = notifiers;
        this.repository = repository;
    }
    public void enroll(String student, String course) {
        for (EnrollmentValidator v : validators) {
            v.validate(student, course);
        }
        repository.save(student, course);
        for (Notifier n : notifiers) {
            n.notify(student, course);
        }
    }
}


class Main {
    public static void main(String[] args) {
        EnrollmentValidator validator = new StudentNameValidator();
        EnrollmentRepository repository = new ConsoleEnrollmentRepository();
        Notifier email = new EmailNotifier();
        Notifier sms = new SmsNotifier();

        EnrollmentService service = new EnrollmentService(
                Arrays.asList(validator),
                Arrays.asList(email, sms),
                repository
        );
        
        service.enroll("Alice", "Math 101");
        service.enroll("Bob", "History 202");
        service.enroll("Charlie", "Physics 303");
    }
}