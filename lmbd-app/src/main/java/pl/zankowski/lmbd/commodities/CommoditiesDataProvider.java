package pl.zankowski.lmbd.commodities;

import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Component;
import pl.zankowski.lmbd.commodities.api.CommoditySymbol;
import pl.zankowski.lmbd.commodities.api.TickDataTO;
import pl.zankowski.lmbd.commodities.api.TickDataTOBuilder;
import pl.zankowski.lmbd.core.Percentage;
import pl.zankowski.lmbd.core.exception.LmbdSystemException;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

@Component
class CommoditiesDataProvider {

    private static final String THREAD_NAME = "Commodities-Data-Provider-Thread-";
    private static final long INITIAL_DELAY = 0L;
    private static final long INTERVAL = 15L;
    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;

    private final Set<CommoditiesDataProviderListener> listenerSet;
    private final ScheduledExecutorService executorService;

    public CommoditiesDataProvider() {
        final CustomizableThreadFactory namedThreadFactory = new CustomizableThreadFactory(THREAD_NAME);
        this.executorService = Executors.newSingleThreadScheduledExecutor(namedThreadFactory);
        this.listenerSet = ConcurrentHashMap.newKeySet();
    }

    @PostConstruct
    private void initializeFeedTask() {
        executorService.scheduleWithFixedDelay(FEED_TASK, INITIAL_DELAY, INTERVAL, TIME_UNIT);
    }

    private Runnable FEED_TASK = () -> getTickData(asList(CommoditySymbol.values())).forEach(this::notifyListeners);

    private void notifyListeners(final TickDataTO tickData) {
        listenerSet.forEach(listener -> listener.handle(tickData));
    }

    void addListener(final CommoditiesDataProviderListener listener) {
        listenerSet.add(listener);
    }

    void removeListener(final CommoditiesDataProviderListener listener) {
        listenerSet.remove(listener);
    }

    List<TickDataTO> getTickData(final List<CommoditySymbol> commoditySymbolList) {
        return commoditySymbolList.stream()
                .map(this::getTickData)
                .collect(toList());
    }

    TickDataTO getTickData(final CommoditySymbol commoditySymbol) {
        try {
            return toTickData(YahooFinance.get(commoditySymbol.getTicker()));
        } catch (IOException e) {
            throw new LmbdSystemException(e.getMessage());
        }
    }

    private TickDataTO toTickData(final Stock stock) {
        final StockQuote stockQuote = stock.getQuote();
        return new TickDataTOBuilder()
                .withTicker(stock.getName())
                .withPrice(BigMoney.of(CurrencyUnit.getInstance(stock.getCurrency()), stockQuote.getPrice()))
                .withChange(stockQuote.getChange())
                .withChangeInPercentage(Percentage.createFromPercentage(stockQuote.getChangeInPercent()))
                .build();
    }

}
