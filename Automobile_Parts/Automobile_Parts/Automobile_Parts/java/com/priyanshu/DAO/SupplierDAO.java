package com.priyanshu.DAO;

import com.priyanshu.model.Supplier;

import java.util.List;

public interface SupplierDAO {

    int save(Supplier supplier);

    int update(Supplier supplier, int id);

    int delete(int id);

    List<Supplier> getAll();

    Supplier getById(int id);

    List<Supplier> getByName(String name);

    List<Supplier> getByContactEmail(String email);
}
