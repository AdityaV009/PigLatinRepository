public class App {
    public static void main(String[] args)
    {
        TestSuite.run();
        // Starter book
        Book input = new Book();
        Book original = new Book();

        input.readFromUrl("People Of the Veil", "https://www.gutenberg.org/cache/epub/74774/pg74774.txt");
        original.readFromUrl("Romeo and Juliet", "https://www.gutenberg.org/cache/epub/1513/pg1513.txt");
        Book output = PigLatinTranslator.translate(input);
        Book result = PigLatinTranslator.translate(original);
        result.writeToFile("Romeo-Juliet-translated.txt");
        output.writeToFile("People-Of-The-Veil-translated.txt");
        System.out.println("Succesfully translated books");
    }
}