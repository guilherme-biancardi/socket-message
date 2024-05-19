package components;

import javax.swing.JPasswordField;

/**
 *
 * @author guilh
 */
public class PasswordFieldComponent extends JPasswordField implements FieldInterface {

    private final BaseField baseField = new BaseField(this);
    private String validations;

    public PasswordFieldComponent() {
        baseField.initComponent();
    }

    @Override
    public void setError(boolean valid) {
       baseField.setError(valid);
    }

    @Override
    public String getText() {
        return new String(super.getPassword());
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
