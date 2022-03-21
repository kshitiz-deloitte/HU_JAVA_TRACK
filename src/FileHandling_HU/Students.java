package FileHandling_HU;

public class Students {
    private String name, reg10,reg12, regBtech;
    private int rank;

    public Students(String name, String reg10, String reg12, String regBtech, int rank) {
        this.name = name;
        this.reg10 = reg10;
        this.reg12 = reg12;
        this.regBtech = regBtech;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public String getReg10() {
        return reg10;
    }

    public String getReg12() {
        return reg12;
    }

    public String getRegBtech() {
        return regBtech;
    }

    public int getRank() {
        return rank;
    }
}
