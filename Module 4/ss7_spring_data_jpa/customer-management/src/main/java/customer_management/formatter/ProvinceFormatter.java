package customer_management.formatter;

import customer_management.entity.Province;
import customer_management.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {
    private ProvinceService provinceService;

    public ProvinceFormatter(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String id, Locale locale) throws ParseException {
        Optional<Province> provinceOptional = provinceService.findById(Long.parseLong(id));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Province object, Locale locale) {
        String st = "[" + object.getId() + ", " + object.getName() + "]";
        return st;
    }
}
