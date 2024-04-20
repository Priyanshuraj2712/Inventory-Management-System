package com.priyanshu.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.priyanshu.model.Inventory;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Inventory inventory) {
        String sql = "INSERT INTO inventory (id, supplier_id, warehouse_id, price, category, name, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, inventory.getId(), inventory.getSupplierId(), inventory.getWarehouseId(), inventory.getPrice(),
                inventory.getCategory(), inventory.getName(), inventory.getQuantity());
    }

    @Override
    public int update(Inventory inventory, int id) {
        String sql = "UPDATE inventory SET supplier_id=?, warehouse_id=?, price=?, category=?, name=?, quantity=? WHERE id=?";
        return jdbcTemplate.update(sql, inventory.getSupplierId(), inventory.getWarehouseId(), inventory.getPrice(),
                inventory.getCategory(), inventory.getName(), inventory.getQuantity(), id);
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM inventory WHERE id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Inventory> getAll() {
        String sql = "SELECT * FROM inventory";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Inventory.class));
    }

    @Override
    public Inventory getById(int id) {
        String sql = "SELECT * FROM inventory WHERE id=?";
        return jdbcTemplate.queryForObject(sql,new Object[] {id},new BeanPropertyRowMapper<>(Inventory.class));
    	}
        @Override
        public List<Inventory> getByCategory(String category) {
            String sql = "SELECT * FROM inventory WHERE category=?";
            return jdbcTemplate.query(sql, new Object[]{category}, new BeanPropertyRowMapper<>(Inventory.class));
        }

        @Override
        public List<Inventory> getByQuantityGreaterThan(int quantity) {
            String sql = "SELECT * FROM inventory WHERE quantity > ?";
            return jdbcTemplate.query(sql, new Object[]{quantity}, new BeanPropertyRowMapper<>(Inventory.class));
        }

        @Override
        public List<Inventory> getByQuantityLessThan(int quantity) {
            String sql = "SELECT * FROM inventory WHERE quantity < ?";
            return jdbcTemplate.query(sql, new Object[]{quantity}, new BeanPropertyRowMapper<>(Inventory.class));
        }

        @Override
        public List<Inventory> getByPriceRange(double minPrice, double maxPrice) {
            String sql = "SELECT * FROM inventory WHERE price BETWEEN ? AND ?";
            return jdbcTemplate.query(sql, new Object[]{minPrice, maxPrice}, new BeanPropertyRowMapper<>(Inventory.class));
        }

        @Override
        public List<Inventory> getAllSortedByCategory() {
            String sql = "SELECT * FROM inventory ORDER BY category";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Inventory.class));
        }

        @Override
        public List<Inventory> getAllSortedByQuantity() {
            String sql = "SELECT * FROM inventory ORDER BY quantity";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Inventory.class));
        }

        @Override
        public List<Inventory> getAllSortedByPrice() {
            String sql = "SELECT * FROM inventory ORDER BY price";
            return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Inventory.class));
        }
    }
