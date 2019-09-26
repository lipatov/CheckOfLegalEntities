package start;

import handler.HandlerNP;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    private static final String PATH_FILE_TO_TEST_DATA = "src/main/resources/testdata.txt";
    private static final String TIME_RUNNING_TEXT = "Время выполнения: ";
    private static final String TIME_FORMAT_TEXT = " (секунд)";

    public static String getPathFileToTestData() {
        return PATH_FILE_TO_TEST_DATA;
    }

    /**
     * Точка входа в программу
     *
     * Одновременно вычисляется время выполнения (быстродействие программы)
     */
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        HandlerNP.checkNpFromFile(new File(PATH_FILE_TO_TEST_DATA));
        long endTime = System.currentTimeMillis();

        double runtime = new BigDecimal((double) (endTime - startTime) / 1000).setScale(3, RoundingMode.UP).doubleValue();
        System.out.println(TIME_RUNNING_TEXT + runtime + TIME_FORMAT_TEXT);

    }

}