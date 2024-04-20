package com.priyanshu.controller;

import com.priyanshu.DAO.WarehouseDAO;
import com.priyanshu.model.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseDAO warehouseDAO;

    @GetMapping("")
    public List<Warehouse> getAllWarehouses() {
        return warehouseDAO.getAll();
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable int id) {
        return warehouseDAO.getById(id);
    }

    @PostMapping("")
    public String addWarehouse(@RequestBody Warehouse warehouse) {
        int result = warehouseDAO.save(warehouse);
        if (result == 1) {
            return "Warehouse added successfully!";
        } else {
            return "Failed to add warehouse!";
        }
    }

    @PutMapping("/{id}")
    public String updateWarehouse(@RequestBody Warehouse warehouse, @PathVariable int id) {
        int result = warehouseDAO.update(warehouse, id);
        if (result == 1) {
            return "Warehouse updated successfully!";
        } else {
            return "Failed to update warehouse!";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteWarehouse(@PathVariable int id) {
        int result = warehouseDAO.delete(id);
        if (result == 1) {
            return "Warehouse deleted successfully!";
        } else {
            return "Failed to delete warehouse!";
        }
    }

    @GetMapping("/location/{location}")
    public List<Warehouse> getWarehousesByLocation(@PathVariable String location) {
        return warehouseDAO.getByLocation(location);
    }

    @GetMapping("/capacity-greater-than/{capacity}")
    public List<Warehouse> getWarehousesByCapacityGreaterThan(@PathVariable int capacity) {
        return warehouseDAO.getByCapacityGreaterThan(capacity);
    }

    @GetMapping("/capacity-less-than/{capacity}")
    public List<Warehouse> getWarehousesByCapacityLessThan(@PathVariable int capacity) {
        return warehouseDAO.getByCapacityLessThan(capacity);
    }

    @GetMapping("/sorted-by-location")
    public List<Warehouse> getWarehousesSortedByLocation() {
        return warehouseDAO.getAllSortedByLocation();
    }

    @GetMapping("/sorted-by-capacity")
    public List<Warehouse> getWarehousesSortedByCapacity() {
        return warehouseDAO.getAllSortedByCapacity();
    }
}
