package customer_management.service;

import customer_management.entity.Province;
import customer_management.repository.ProvinceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService{
    @Autowired
    ProvinceRepo provinceRepo;
    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepo.findAll(pageable);
    }

    @Override
    public Optional<Province> findById(Long id) {
        return provinceRepo.findById(id);
    }

    @Override
    public void save(Province province) {
        provinceRepo.save(province);
    }

    @Override
    public void remove(Long id) {
        provinceRepo.deleteById(id);
    }
}
