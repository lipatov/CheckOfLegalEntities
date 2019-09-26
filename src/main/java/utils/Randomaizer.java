package utils;

import start.Solution;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Randomaizer {
    private static int NUMBER_OF_LEGAL_ENTITIES = 1000; // количество контрагентов в списке
    private static final String WORD_SEPARATOR = " ";

    /**
     * Генерация случайных значений ИНН, КПП
     *
     * (вычисляет с какой-то вероятностью одно значение (ИНН для ИП), или два значения (ИНН + КПП для ЮЛ)
     * и записывает данные во внешний файл)
     *
     * Данный метод применяется лишь в учебных целях!
     */
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Solution.getPathFileToTestData())))) {
            for (int i = 0; i < NUMBER_OF_LEGAL_ENTITIES; i++) {
                if (Math.random() > 0.5) {
                    writer.write(Long.valueOf(generateRandom(12)).toString());
                    writer.newLine();
                } else {
                    writer.write(Long.valueOf(generateRandom(10)).toString());
                    writer.write(WORD_SEPARATOR);
                    writer.write(Long.valueOf(generateRandom(9)).toString());
                    writer.newLine();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param number Количество знаков (n)
     * @return Возвращает n-значное случайное число
     */
    private static long generateRandom(int number) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(random.nextInt(10));
        }
        return Long.parseLong(sb.toString());
    }

}
