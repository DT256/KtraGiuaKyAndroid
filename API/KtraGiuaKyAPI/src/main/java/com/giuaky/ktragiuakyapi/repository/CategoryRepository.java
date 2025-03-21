package com.giuaky.ktragiuakyapi.repository;

import com.giuaky.ktragiuakyapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



// Ten:Nguyen Hoai Tan
// MSSV: 22110413
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
