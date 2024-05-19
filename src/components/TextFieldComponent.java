package components;


import javax.swing.JTextField;

/**
 *
 * @author guilh
 */
public class TextFieldComponent extends JTextField implements FieldInterface{

    private final BaseField baseField;
    private String validations;
    
    public TextFieldComponent() {
        baseField = new BaseField(this);
        baseField.initComponent();
    }

    public TextFieldComponent(int maxLength) {
        baseField = new BaseField(this);
        baseField.setMaxLength(maxLength);
        baseField.initComponent();
    }

    @Override
    public void setError(boolean valid) {
        baseField.setError(valid);
    }

    @Override
    public void setValidations(String validations) {
        this.validations = validations;
    }

    @Override
    public String getValidations() {
        return validations;
    }
}
