package org.example.algorithm.array_and_strings;

public enum Color {
    Red("color");
    private final String colorStr;

    private Color(String colorStr) {
        this.colorStr = colorStr;
    }

    public static String getColorStr(Color color) {
        return color.colorStr;
    }
}