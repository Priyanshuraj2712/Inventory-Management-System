package com.priyanshu.DAO;

import com.priyanshu.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SupplierDAOImpl implements SupplierDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Supplier supplier) {
        String sql = "INSERT INTO supplier (name, contact_name, contact_phone, contact_email) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, supplier.getName(), supplier.getContactName(), supplier.getContactPhone(), supplier.getContactEmail());
    }

    @Override
    public int update(Supplier supplier, int id) {
        String sql = "UPDATE supplier SET name=?, contact_name=?, contact_phone=?, contact_email=? WHERE id=?";
        return jdbcTemplate.update(sql, supplier.getName(), supplier.getContactName(), supplier.getContactPhone(), supplier.getContactEmail(), id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM supplier WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Supplier> getAll() {
        String sql = "SELECT * FROM supplier";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Supplier.class));
    }

    @Override
    public Supplier getById(int id) {
        String sql = "SELECT * FROM supplier WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Supplier.class));
    }

    @Override
    public List<Supplier> getByName(String name) {
        String sql = "SELECT * FROM supplier WHERE name=?";
        return jdbcTemplate.query(sql, new Object[]{name}, new BeanPropertyRowMapper<>(Supplier.class));
    }

    @Override
    public List<Supplier> getByContactEmail(String email) {
        String sql = "SELECT * FROM supplier WHERE contact_email=?";
        return jdbcTemplate.query(sql, new Object[]{email}, new BeanPropertyRowMapper<>(Supplier.class));
    }
}
