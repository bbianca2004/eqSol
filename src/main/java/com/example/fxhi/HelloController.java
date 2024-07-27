package com.example.fxhi;

import MathUtil.MathUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class HelloController  implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button btn;
    @FXML
    private TextField aCoefTxt;
    @FXML
    private TextField bCoefTxt;
    @FXML
    private TextField cCoefTxt;

    private MathUtil mathUtil = new MathUtil();

    @FXML
    protected void onHelloBtnClick() {
        double a = Double.parseDouble(aCoefTxt.getText());
        double b = Double.parseDouble(aCoefTxt.getText());
        double c = Double.parseDouble(aCoefTxt.getText());

        welcomeText.setText(mathUtil.solveQuadraticEquation(a, b, c).toString());

    }

    Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");

    UnaryOperator<TextFormatter.Change> filter = c -> {
        String text = c.getControlNewText();
        if (validEditingState.matcher(text).matches()) {
            return c ;
        } else {
            return null ;
        }
    };

    StringConverter<Double> converter = new StringConverter<Double>() {

        @Override
        public Double fromString(String s) {
            if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
                return 0.0 ;
            } else {
                return Double.valueOf(s);
            }
        }


        @Override
        public String toString(Double d) {
            return d.toString();
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        aCoefTxt.setTextFormatter(new TextFormatter<>(converter, 0.0, filter));
        bCoefTxt.setTextFormatter(new TextFormatter<>(converter, 0.0, filter));
        cCoefTxt.setTextFormatter(new TextFormatter<>(converter, 0.0, filter));
    }

}