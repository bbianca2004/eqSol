package com.example.fxhi;

import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class TextFormatterBuilder {
    private static final Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");

    private static final UnaryOperator<TextFormatter.Change> filter =
            c ->  validEditingState.matcher(c.getControlNewText()).matches() ? c : null;;

    private static final StringConverter<Double> converter = new StringConverter<>() {

        @Override
        public Double fromString(String s) {
            return s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)
                    ? Double.valueOf(0.0)
                    : Double.valueOf(s);
        }

        @Override
        public String toString(Double d) {
            return d.toString();
        }
    };

    public static TextFormatter<Double> getDoubleTextFormatter() {
        return new TextFormatter<>(converter, 0.0, filter);
    }
}
