package utils;

import unisoft.ws.fnsndscaws2.response.NdsResponse2;

public class Printer {

    private static final String INN_NAME = "ИНН: ";
    private static final String STATUS_NAME = " Статус: ";
    private static final String KPP_NAME = " КПП: ";
    private static final String IP_DATA = "Данные о Индивидуальном предпринимателе: ";
    private static final String UL_DATA = "Данные о Юридическом лице: ";

    /**
     * Метод для вывода результатов в консоль
     *
     * @param respNp Коллекция List<NdsResponse2.NP> ответов от сервера
     */
    public static void printNp(NdsResponse2.NP respNp) {
        if (respNp.getKPP() == null) {
            System.out.println(IP_DATA + INN_NAME + respNp.getINN() + STATUS_NAME + getStateMessageIp(respNp.getState()));
        } else {
            System.out.println(UL_DATA + INN_NAME + respNp.getINN() + KPP_NAME + respNp.getKPP() + STATUS_NAME + getStateMessageUl(respNp.getState()));
        }
    }

    /**
     * @return Возвращает признак состояния (атрибут State) для ИП
     */
    private static String getStateMessageIp(String state) {
        return StateMessages.StateMessagesForIp[Integer.parseInt(state)];
    }

    /**
     * @return Возвращает признак состояния (атрибут State) для Юридического лица
     */
    private static String getStateMessageUl(String state) {
        return StateMessages.StateMessagesForUl[Integer.parseInt(state)];
    }
}
