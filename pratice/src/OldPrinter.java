package OOP;

class OldPrinter implements Printer {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }
}

interface Printer {
    void print(String content);
}
interface Scanner {
    void scan(String content);
}
interface Fax {
    void fax(String content);
}

class MultiFunctionMachine implements Printer, Scanner, Fax {
    @Override
    public void print(String content) {
        System.out.println("Printing: " + content);
    }

    @Override
    public void scan(String content) {
        System.out.println("Scanning: " + content);
    }

    @Override
    public void fax(String content) {
        System.out.println("Faxing: " + content);
    }
}
