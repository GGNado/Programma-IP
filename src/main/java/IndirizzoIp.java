public class IndirizzoIp {
    private int primoOttetto;
    private int secondoOttetto;
    private int  terzoOttetto;
    private int quartoOttetto;
    private CLASSE classe;
    private String subnetMask;
    private String netID;
    private String broadcast;
    private String gatewayA;
    private String gatewayB;

    public IndirizzoIp(int primoOttetto, int secondoOttetto, int terzoOttetto, int quartoOttetto) {
        this.primoOttetto = primoOttetto;
        this.secondoOttetto = secondoOttetto;
        this.terzoOttetto = terzoOttetto;
        this.quartoOttetto = quartoOttetto;

    }

    public int getPrimoOttetto() {
        return primoOttetto;
    }

    public void setPrimoOttetto(int primoOttetto) {
        this.primoOttetto = primoOttetto;
    }

    public int getSecondoOttetto() {
        return secondoOttetto;
    }

    public void setSecondoOttetto(int secondoOttetto) {
        this.secondoOttetto = secondoOttetto;
    }

    public int getTerzoOttetto() {
        return terzoOttetto;
    }

    public void setTerzoOttetto(int terzoOttetto) {
        this.terzoOttetto = terzoOttetto;
    }

    public int getQuartoOttetto() {
        return quartoOttetto;
    }

    public void setQuartoOttetto(int quartoOttetto) {
        this.quartoOttetto = quartoOttetto;
    }

    public void generaSubnetMask() {
        if (primoOttetto <= 127)
            this.subnetMask = "255.0.0.0";
        else if (primoOttetto <= 191)
            this.subnetMask = "255.255.0.0";
        else if (primoOttetto <= 223){
            this.subnetMask = "255.255.255.0";
        } else {
            this.subnetMask = "255.255.255.255";
        }
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public String getGatewayA() {
        return gatewayA;
    }

    public void generaGateway() {
        if (primoOttetto <= 127) {
            this.gatewayA = "" + primoOttetto + "." + "255.255.254";
            this.gatewayB = "" + primoOttetto + "." + "0.0.1";
        } else if (primoOttetto <= 191) {
            this.gatewayA = "" + primoOttetto + "." + secondoOttetto + "." + "255.254";
            this.gatewayB = "" + primoOttetto + "." + secondoOttetto + "." + "0.1";
        }else if (primoOttetto <= 223) {
            this.gatewayA = "" + primoOttetto + "." + secondoOttetto + "." + terzoOttetto + ".254";
            this.gatewayB = "" + primoOttetto + "." + secondoOttetto + "." + terzoOttetto + ".1";
        }else {
            this.netID = "Non definito";
        }
    }

    public String getGatewayB() {
        return gatewayB;
    }


    public CLASSE getClasse() {
        return classe;
    }

    public void generaClasse() {
        if (primoOttetto <= 127)
            this.classe = CLASSE.A;
        else if (primoOttetto <= 191)
            this.classe = CLASSE.B;
        else if (primoOttetto <= 223)
            this.classe = CLASSE.C;
        else
            this.classe = CLASSE.D;
    }

    public void generaNetID() {
        if (primoOttetto <= 127)
            this.netID = "" + primoOttetto + "." +  "0.0.0";
        else if (primoOttetto <= 191)
            this.netID = "" + primoOttetto + "." + secondoOttetto + "." +  "0.0";
        else if (primoOttetto <= 223)
            this.netID = "" + primoOttetto + "." + secondoOttetto + "." + terzoOttetto + ".0";
        else
            this.netID = "Non definito";

    }

    public String getNetID() {
        return netID;
    }

    public String getBroadcast(){
        return broadcast;
    }

    public void generaBroadcast(){
        if (primoOttetto <= 127)
            this.broadcast = "" + primoOttetto + "." +  "255.255.255";
        else if (primoOttetto <= 191)
            this.broadcast = "" + primoOttetto + "." + secondoOttetto + "." +  "255.255";
        else if (primoOttetto <= 223)
            this.broadcast = "" + primoOttetto + "." + secondoOttetto + "." + terzoOttetto + ".255";
        else
            this.broadcast = "Non definito";
    }
}
