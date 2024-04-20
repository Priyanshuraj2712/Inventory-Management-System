package com.priyanshu.DAO;

import java.util.List;
import com.priyanshu.model.Warehouse;

public interface WarehouseDAO {

    int save(Warehouse warehouse);

    int update(Warehouse warehouse, int id);

    int delete(int id);

    List<Warehouse> getAll();

    Warehouse getById(int id);

    List<Warehouse> getByLocation(String location);

    List<Warehouse> getByCapacityGreaterThan(int capacity);

    List<Warehouse> getByCapacityLessThan(int capacity);

    List<Warehouse> getAllSortedByLocation();

    List<Warehouse> getAllSortedByCapacity();
}
