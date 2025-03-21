package com.giuaky.ktragiuakyapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//22110429_VoNguyenXuanThinh
public interface ProductRepository extends JpaRepository<Product, Long> {
}
