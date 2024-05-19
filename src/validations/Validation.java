package validations;

import components.Alert;
import components.FieldInterface;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author guilh
 */
public class Validation {

    public static boolean validate(FieldInterface[] fields) {
        boolean isValid = true;
        String message = "";

        for (FieldInterface field : fields) {
            String[] validations = field.getValidations().split("\\|");
            

            for (String validation : validations) {
                System.out.println(validation);
                
                if (validation.matches("required") && required(field.getText())) {
                    message += "| Campo obrigatório |";
                    isValid = false;
                }

                if (validation.contains("min")) {
                    Pattern pattern = Pattern.compile("min:(\\d+)");
                    Matcher matcher = pattern.matcher(validation);

                    if (matcher.find()) {
                        int length = Integer.parseInt(matcher.group(1));
                        
                        if (min(field.getText(), length)) {
                            message += "| O campo deve ter ao menos " + length + " caracteres |";
                            isValid = false;
                        }
                    }    
                }
                
                if(validation.matches("email") && email(field.getText())){
                    message += "| O campo não é um e-mail válido |";
                    isValid = false;
                }
            }

            field.setError(isValid);

            if (!isValid) {
                Alert.error("Erro de Validação", message);
                break;
            }
        }

        return isValid;
    }

    private static boolean required(String value) {
        return value.matches("");
    }

    private static boolean min(String value, int length) {
        return value.length() < length;
    }
    
    private static boolean email(String value){
         String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(value);

        // Verifica se o email corresponde ao padrão
        return !matcher.matches();
    }
}
