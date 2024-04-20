package com.priyanshu.DAO;
import java.util.List;
import com.priyanshu.model.Inventory;

public interface InventoryDAO {

    int save(Inventory inventory);

    int update(Inventory inventory, int id);

    int delete(int id);

    List<Inventory> getAll();

    Inventory getById(int id);

    List<Inventory> getByCategory(String category);

    List<Inventory> getByQuantityGreaterThan(int quantity);

    List<Inventory> getByQuantityLessThan(int quantity);

    List<Inventory> getByPriceRange(double minPrice, double maxPrice);

    List<Inventory> getAllSortedByCategory();

    List<Inventory> getAllSortedByQuantity();

    List<Inventory> getAllSortedByPrice();
}
