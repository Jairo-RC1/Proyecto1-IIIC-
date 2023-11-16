package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    public Validations() {

    }

    public boolean validateABCWithSpaces(String valor) {
        // Validates letters (A-Z), the letter "Ñ," and spaces
        Pattern pat = Pattern.compile("[A-Za-z Ññ]*");
        Matcher mat = pat.matcher(valor);
        return mat.matches();
        //true or false if the values is not found in the validation
    }

    public boolean validateNumbers(String valor) {
        //Validates regular numbers
        Pattern pat = Pattern.compile("[0-9]*");
        Matcher mat = pat.matcher(valor);
        return mat.matches();
    }

    public boolean validateDecimals(String valor) {
        //Validates decimal numbers
        Pattern pat = Pattern.compile("[0-9.]+");
        Matcher mat = pat.matcher(valor);
        return mat.matches();
    }

    public boolean validateAlfanumeric(String valor) {
        //Validates letters and numbers
        Pattern pat = Pattern.compile("^[a-zA-Z0-9 ]*$");
        Matcher mat = pat.matcher(valor);
        return mat.matches();

    }

    public boolean validateLegalID(String valor) {
        //Validates the format to be according legal compliances
        Pattern pat = Pattern.compile("\\d{10}");
        Matcher mat = pat.matcher(valor);
        return mat.matches();

    }

    public boolean validateMail(String valor) {
        //Validates all characters for an email
        Pattern pat = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Matcher mat = pat.matcher(valor);
        return mat.matches();

    }

    public boolean validatePhone(String valor) {
        //Validates numbers to be used
        Pattern pat = Pattern.compile("[0-9]+");
        Matcher mat = pat.matcher(valor);
        return mat.matches();
    }

    public boolean validateID(String valor) {
        //Validates id numbers legally used in Costa Rica
        Pattern pat = Pattern.compile("^[0-9]{1}-[0-9]{4}-[0-9]{4}$");
        Matcher mat = pat.matcher(valor);
        return mat.matches();
    }

    public boolean validateAllSpecialCharacters(String valor) {
        // Validates any character, aside from linejump
        return valor.matches(".*");
    }

    public boolean validateDate(String valor) {
        // Valida el formato de fecha "yyyy-MM-dd"
        Pattern pat = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher mat = pat.matcher(valor);
        return mat.matches();
    }
}
