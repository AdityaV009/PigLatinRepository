public class PigLatinTranslator
{
    public static Book translate(Book input)
    {
        Book translatedBook = new Book();
        for (int i = 0; i < input.getLineCount(); i++) {
            String translatedLine = translate(input.getLine(i));
            translatedBook.appendLine(translatedLine);
        }
        return translatedBook;
    }

    public static String translate(String input)
    {
        StringBuilder translatedSentence = new StringBuilder();
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                if (i > start) {
                    translatedSentence.append(translateWord(input.substring(start, i)));
                }
                translatedSentence.append(input.charAt(i));
                start = i + 1;
            }
        }
        if (start < input.length()) {
            translatedSentence.append(translateWord(input.substring(start)));
        }
        return translatedSentence.toString();
    }

    private static String translateWord(String input)
    {
        if (input.isEmpty()) {
            return input;
        }

        boolean isCapitalized = isFirstLetterUppercase(input);
        String lowerInput = lowerBeforeVowel(input);
        String vowels = "aeiouAEIOU";
        String result;

        if (vowels.indexOf(lowerInput.charAt(0)) >= 0) {
            result = lowerInput + "yay";
        } else {
            int firstVowelIndex = findFirstVowel(lowerInput);
            result = lowerInput.substring(firstVowelIndex) + lowerInput.substring(0, firstVowelIndex) + "ay";
        }

        return isCapitalized ? capitalizeFirstLetter(result) : result;
    }

    private static int findFirstVowel(String input)
    {
        for (int i = 0; i < input.length(); i++) {
            if ("aeiouAEIOU".indexOf(input.charAt(i)) >= 0) {
                return i;
            }
        }
        return 0;
    }

    private static boolean isFirstLetterUppercase(String input)
    {
        return Character.isUpperCase(input.charAt(0));
    }

    private static String capitalizeFirstLetter(String word)
    {
        if (word.isEmpty()) {
            return word;
        }
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }

    private static String lowerBeforeVowel(String input)
    {
        int firstVowelIndex = findFirstVowel(input);
        String consonantCluster = input.substring(0, firstVowelIndex);
        String restOfWord = input.substring(firstVowelIndex);
        consonantCluster = consonantCluster.toLowerCase();
        return consonantCluster + restOfWord;
    }
}