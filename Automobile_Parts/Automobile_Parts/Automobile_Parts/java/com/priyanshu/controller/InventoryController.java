package com.priyanshu.controller;

import com.priyanshu.DAO.InventoryDAO;
import com.priyanshu.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryDAO inventoryDAO;

    @GetMapping("")
    public List<Inventory> getAllInventory() {
        return inventoryDAO.getAll();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable int id) {
        return inventoryDAO.getById(id);
    }

    @PostMapping("")
    public String addInventory(@RequestBody Inventory inventory) {
        int result = inventoryDAO.save(inventory);
        if (result == 1) {
            return "Inventory added successfully!";
        } else {
            return "Failed to add inventory!";
        }
    }

    @PutMapping("/{id}")
    public String updateInventory(@RequestBody Inventory inventory, @PathVariable int id) {
        int result = inventoryDAO.update(inventory, id);
        if (result == 1) {
            return "Inventory updated successfully!";
        } else {
            return "Failed to update inventory!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteInventory(@PathVariable int id) {
        int result = inventoryDAO.delete(id);
        if (result == 1) {
            return "Inventory deleted successfully!";
        } else {
            return "Failed to delete inventory!";
        }
    }

    @GetMapping("/category/{category}")
    public List<Inventory> getInventoryByCategory(@PathVariable String category) {
        return inventoryDAO.getByCategory(category);
    }

    @GetMapping("/quantity-greater-than/{quantity}")
    public List<Inventory> getInventoryByQuantityGreaterThan(@PathVariable int quantity) {
        return inventoryDAO.getByQuantityGreaterThan(quantity);
    }

    @GetMapping("/quantity-less-than/{quantity}")
    public List<Inventory> getInventoryByQuantityLessThan(@PathVariable int quantity) {
        return inventoryDAO.getByQuantityLessThan(quantity);
    }

    @GetMapping("/price-range/{minPrice}/{maxPrice}")
    public List<Inventory> getInventoryByPriceRange(@PathVariable double minPrice, @PathVariable double maxPrice) {
        return inventoryDAO.getByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/sorted-by-category")
    public List<Inventory> getInventorySortedByCategory() {
        return inventoryDAO.getAllSortedByCategory();
    }

    @GetMapping("/sorted-by-quantity")
    public List<Inventory> getInventorySortedByQuantity() {
        return inventoryDAO.getAllSortedByQuantity();
    }

    @GetMapping("/sorted-by-price")
    public List<Inventory> getInventorySortedByPrice() {
        return inventoryDAO.getAllSortedByPrice();
    }
}
