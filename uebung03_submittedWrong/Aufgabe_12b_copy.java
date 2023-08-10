public class Aufgabe_12b_copy {
    public static void main(String[] args) {
        CharSequence stringSequence = "This.is.a.String";
        CharSequence stringBuilderSequence = new StringBuilder("This.is.a.StringBuilder");
        CharSequence stringBufferSequence = new StringBuffer("This.is.a.StringBuffer");

        System.out.println(substringAfterLastDot(stringSequence)); // Outputs: "String"
        System.out.println(substringAfterLastDot(stringBuilderSequence)); // Outputs: "StringBuilder"
        System.out.println(substringAfterLastDot(stringBufferSequence)); // Outputs: "StringBuffer"
    }

    public static CharSequence substringAfterLastDot(CharSequence sequence) {
        int lastIndex = sequence.toString().lastIndexOf('.');
        if (lastIndex == -1) { // No dot found in the CharSequence
            return ""; // Return an empty string
        } else {
            return sequence.subSequence(lastIndex + 1, sequence.length()); // Returns everything after the last dot
        }
    }
}
