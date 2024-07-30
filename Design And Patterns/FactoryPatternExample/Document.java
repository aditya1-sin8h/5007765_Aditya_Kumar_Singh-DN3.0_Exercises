package FactoryPatternExample;

public interface Document {
    void open();
    void close();
}

class WordDocument implements Document {

    public void open() {
        System.out.println("Opening Word document...");
    }

    public void close() {
        System.out.println("Closing Word document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }

    public void close() {
        System.out.println("Closing PDF document...");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document...");
    }

    public void close() {
        System.out.println("Closing Excel document...");
    }
}