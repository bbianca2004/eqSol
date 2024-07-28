package com.example.fxhi;

import MathUtil.MathUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.fxhi.TextFormatterBuilder.getDoubleTextFormatter;

public class QESolverController implements Initializable {
    @FXML
    private Label display;
    @FXML
    private TextField txtA;
    @FXML
    private TextField txtB;
    @FXML
    private TextField txtC;

    private final MathUtil mathUtil = new MathUtil();

    @FXML
    protected void onSolveBtnClick() {
        double a = Double.parseDouble(txtA.getText());
        double b = Double.parseDouble(txtB.getText());
        double c = Double.parseDouble(txtC.getText());

        display.setText(mathUtil.solveQuadraticEquation(a, b, c).toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtA.setTextFormatter(getDoubleTextFormatter());
        txtB.setTextFormatter(getDoubleTextFormatter());
        txtC.setTextFormatter(getDoubleTextFormatter());
    }
}