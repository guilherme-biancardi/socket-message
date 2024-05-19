/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package components;

/**
 *
 * @author guilh
 */
public interface FieldInterface {
    public String getValidations();
    public void setValidations(String validations);
    public void setError(boolean valid);
    public String getText();
}
