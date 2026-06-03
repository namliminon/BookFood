// Tầng kết nối đến DB

package com.bookfood.backend.repository;

import com.bookfood.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findbySoDienThoai(String sdt);

}
