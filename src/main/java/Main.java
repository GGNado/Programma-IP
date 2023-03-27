public class Main {
    // 0xxxxxxx a 01111111 = 0 a 127 = A
    // 10xxxxxx a 10111111 = 128 a 191 = B
    // 110xxxxx a 11011111 = 192 a 223 = C

    public static void main(String[] args) {
        IndirizzoIp indirizzoIp = new IndirizzoIp(192, 168, 1, 1);
        indirizzoIp.generaClasse();
        indirizzoIp.generaSubnetMask();
        indirizzoIp.generaNetID();
        indirizzoIp.generaBroadcast();
        indirizzoIp.generaGateway();

        System.out.println(indirizzoIp.getSubnetMask());
        System.out.println(indirizzoIp.getClasse());
        System.out.println(indirizzoIp.getNetID());
        System.out.println(indirizzoIp.getBroadcast());
        System.out.println(indirizzoIp.getGatewayA() + "\n" + indirizzoIp.getGatewayB());

        new Frame();
    }
}
