package com.codegym.taogiohang.repo;

import com.codegym.taogiohang.entity.SanPham;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface GioHangRepository extends PagingAndSortingRepository<SanPham, Long> {

}
