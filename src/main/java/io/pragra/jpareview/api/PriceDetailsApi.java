package io.pragra.jpareview.api;

import io.pragra.jpareview.entity.PriceDetails;
import io.pragra.jpareview.service.PriceDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PriceDetailsApi {
    private final PriceDetailsService priceDetailsService;

    @PostMapping("/product/{id}/price")
    public PriceDetails createPriceDetails(@RequestBody PriceDetails priceDetails, @PathVariable Long id){
        return this.priceDetailsService.createPriceDetails(priceDetails,id);
    }

    @PutMapping("/product/{id}/price")
    public PriceDetails updatePriceDetails(@RequestBody PriceDetails priceDetails, @PathVariable Long id){
        return this.priceDetailsService.updatePriceDetails(priceDetails,id);
    }

    @GetMapping("/price")
    public List<PriceDetails> getAllPriceDetails() {
        return this.priceDetailsService.getAll();
    }

    @GetMapping("/price/{id}")
    public Optional<PriceDetails> getPriceDetailById(@PathVariable long id) {
       return this.priceDetailsService.getById(id);
    }

    @DeleteMapping("/price/{id}")
    public void deletePriceDetail(@PathVariable long id) {
        this.priceDetailsService.deleteById(id);
    }
}
