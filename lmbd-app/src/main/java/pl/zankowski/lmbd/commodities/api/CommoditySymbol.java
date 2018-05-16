package pl.zankowski.lmbd.commodities.api;

public enum CommoditySymbol {

    XAGPLN("XAGPLN=X"),
    XAUPLN("XAUPLN=X");

    private final String ticker;

    CommoditySymbol(final String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return ticker;
    }

}
