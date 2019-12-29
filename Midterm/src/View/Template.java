package View;

import javax.swing.*;

public class Template {
    private JTextField tfFullName;
    private JCheckBox maleCheckBox;
    private JPanel rootpanel;

    public JPanel getRootpanel() {
        return rootpanel;
    }

   public JTextField  getTF(){
        return this.tfFullName;
   }
    public JCheckBox getChekBox(){
        return this.maleCheckBox;
    }

    public String getTfFullName() {
        return tfFullName.getText();
    }

    public boolean getMaleCheckBox() {
        if (maleCheckBox.isSelected()){
            return true;
        }
        return false;
    }
}
