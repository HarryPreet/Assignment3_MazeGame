//package GameLogic;

public class GameElement {
    private String name;
    private String symbol;

    public GameElement(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
