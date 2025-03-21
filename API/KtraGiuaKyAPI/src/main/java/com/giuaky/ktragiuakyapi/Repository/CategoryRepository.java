package com.giuaky.ktragiuakyapi.Repository;

import com.giuaky.ktragiuakyapi.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



// Ten:Nguyen Hoai Tan
// MSSV: 22110413
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
