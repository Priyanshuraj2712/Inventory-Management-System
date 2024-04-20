package com.priyanshu.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.priyanshu.model.Warehouse;

@Repository
public class WarehouseDAOImpl implements WarehouseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Warehouse warehouse) {
        String sql = "INSERT INTO warehouse (id, name, location, capacity) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, warehouse.getId(), warehouse.getName(), warehouse.getLocation(), warehouse.getCapacity());
    }

    @Override
    public int update(Warehouse warehouse, int id) {
        String sql = "UPDATE warehouse SET name=?, location=?, capacity=? WHERE id=?";
        return jdbcTemplate.update(sql, warehouse.getName(), warehouse.getLocation(), warehouse.getCapacity(), id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM warehouse WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Warehouse> getAll() {
        String sql = "SELECT * FROM warehouse";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Warehouse.class));
    }

    @Override
    public Warehouse getById(int id) {
        String sql = "SELECT * FROM warehouse WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Warehouse.class));
    	}
    @Override
        public List<Warehouse> getByLocation(String location) {
            String sql = "SELECT * FROM warehouse WHERE location=?";
            return jdbcTemplate.query(sql, new Object[]{location}, new BeanPropertyRowMapper<>(Warehouse.class));
        }

        @Override
        public List<Warehouse> getByCapacityGreaterThan(int capacity) {
            String sql = "SELECT * FROM warehouse WHERE capacity > ?";
            return jdbcTemplate.query(sql, new Object[]{capacity}, new BeanPropertyRowMapper<>(Warehouse.class));
        }

        @Override
        public List<Warehouse> getByCapacityLessThan(int capacity) {
            String sql = "SELECT * FROM warehouse WHERE capacity < ?";
            return jdbcTemplate.query(sql, new Object[]{capacity}, new BeanPropertyRowMapper<>(Warehouse.class));
        }

        @Override
        public List<Warehouse> getAllSortedByLocation() {
            String sql = "SELECT * FROM warehouse ORDER BY location";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Warehouse.class));
        }

        @Override
        public List<Warehouse> getAllSortedByCapacity() {
            String sql = "SELECT * FROM warehouse ORDER BY capacity";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Warehouse.class));
        }
    }