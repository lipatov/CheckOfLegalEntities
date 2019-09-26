package utils;

import unisoft.ws.fnsndscaws2.response.NdsResponse2;

public class Printer {

    private static final String INN_NAME = "���: ";
    private static final String STATUS_NAME = " ������: ";
    private static final String KPP_NAME = " ���: ";
    private static final String IP_DATA = "������ � �������������� ���������������: ";
    private static final String UL_DATA = "������ � ����������� ����: ";

    /**
     * ����� ��� ������ ����������� � �������
     *
     * @param respNp ��������� List<NdsResponse2.NP> ������� �� �������
     */
    public static void printNp(NdsResponse2.NP respNp) {
        if (respNp.getKPP() == null) {
            System.out.println(IP_DATA + INN_NAME + respNp.getINN() + STATUS_NAME + getStateMessageIp(respNp.getState()));
        } else {
            System.out.println(UL_DATA + INN_NAME + respNp.getINN() + KPP_NAME + respNp.getKPP() + STATUS_NAME + getStateMessageUl(respNp.getState()));
        }
    }

    /**
     * @return ���������� ������� ��������� (������� State) ��� ��
     */
    private static String getStateMessageIp(String state) {
        return StateMessages.StateMessagesForIp[Integer.parseInt(state)];
    }

    /**
     * @return ���������� ������� ��������� (������� State) ��� ������������ ����
     */
    private static String getStateMessageUl(String state) {
        return StateMessages.StateMessagesForUl[Integer.parseInt(state)];
    }
}
