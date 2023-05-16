package com.example.logowanie;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationApi {
    private List<Quotation> quotationList;

    public QuotationApi() {
        this.quotationList = new ArrayList<>();
        quotationList.add(new Quotation("Nauka jest jak niezmierne morze. Im więcej jej pijesz, tym bardziej jesteś spragniony.", "Elon Musk"));
        quotationList.add(new Quotation("Nie wystarczy dużo wiedzieć, ażeby być mądrym.", "Heraklit z Efezu"));
        quotationList.add(new Quotation("Powiedz mi, to zapomnę. Naucz mnie, to może zapamiętam. Zaangażuj mnie, to się nauczę.", "Benjamin Franklin"));
        quotationList.add(new Quotation("Kto się przestaje uczyć, umiera", "Antoine de Saint-Exupery"));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotationList(){
        return quotationList;
    }
    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation){
        return quotationList.add(quotation);
    }
    @DeleteMapping("/api")
    public void deleteQuotation(@RequestParam int index){
        quotationList.remove(index);
    }


}