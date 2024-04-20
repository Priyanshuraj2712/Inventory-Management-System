package com.priyanshu.controller;

import com.priyanshu.DAO.SupplierDAO;
import com.priyanshu.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierController {

    @Autowired
    private SupplierDAO supplierDAO;

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliers() {
        return supplierDAO.getAll();
    }

    @GetMapping("/suppliers/{id}")
    public Supplier getSupplierById(@PathVariable int id) {
        return supplierDAO.getById(id);
    }

    @PostMapping("/suppliers")
    public String addSupplier(@RequestBody Supplier supplier) {
        int result = supplierDAO.save(supplier);
        if (result == 1) {
            return "Supplier added successfully!";
        } else {
            return "Failed to add supplier!";
        }
    }

    @PutMapping("/suppliers/{id}")
    public String updateSupplier(@RequestBody Supplier supplier, @PathVariable int id) {
        int result = supplierDAO.update(supplier, id);
        if (result == 1) {
            return "Supplier updated successfully!";
        } else {
            return "Failed to update supplier!";
        }
    }

    @DeleteMapping("/suppliers/{id}")
    public String deleteSupplier(@PathVariable int id) {
        int result = supplierDAO.delete(id);
        if (result == 1) {
            return "Supplier deleted successfully!";
        } else {
            return "Failed to delete supplier!";
        }
    }

    @GetMapping("/suppliers/name/{name}")
    public List<Supplier> getSuppliersByName(@PathVariable String name) {
        return supplierDAO.getByName(name);
    }

    @GetMapping("/contact-email/{email}")
    public List<Supplier> getSuppliersByContactEmail(@PathVariable String email) {
        return supplierDAO.getByContactEmail(email);
    }
}
