package pl.zankowski.lmbd.commodities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.zankowski.lmbd.commodities.api.CommoditySymbol;

import java.util.List;

@RestController
@RequestMapping("/api/commodities")
public class CommoditiesRestController {

    private final CommoditiesService commoditiesService;

    @Autowired
    public CommoditiesRestController(final CommoditiesService commoditiesService) {
        this.commoditiesService = commoditiesService;
    }

    @GetMapping
    public ResponseEntity<?> getCommoditiesData(@RequestParam final List<CommoditySymbol> symbols) {
        return ResponseEntity.ok(commoditiesService.getCommoditiesData(symbols));
    }

    @GetMapping("/symbols")
    public ResponseEntity<?> getAvailableSymbols() {
        return ResponseEntity.ok(commoditiesService.getAvailableSymbols());
    }

}
