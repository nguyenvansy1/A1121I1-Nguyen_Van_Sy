package customer_management.repository;

import customer_management.entity.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepo extends PagingAndSortingRepository<Province,Long> {
}
