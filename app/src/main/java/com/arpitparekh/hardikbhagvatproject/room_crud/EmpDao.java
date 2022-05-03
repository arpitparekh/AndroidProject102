package com.arpitparekh.hardikbhagvatproject.room_crud;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EmpDao {

    @Insert
    void insertData(Emp e);

    @Update
    void updateData(Emp e);

    @Delete
    void deleteData(Emp e);

    @Query("select * from EmpTable")
    List<Emp> showData();

    @Query("select * from emptable where 'key'=:key")
    List<Emp> showSpecificEmpData(int key);

    @Insert
    void insertWholeList(List<Emp> list);

    @Update
    void updateWholeList(List<Emp> list);

    @Query("update emptable set name=:name,address=:address where 'key'=:key")
    void updateData2(int key,String name,String address);

    @Query("delete from emptable where 'key'=:key")
    void deleteData2(int key);

    @Query("select COUNT(*) from EmpTable")
    int numberOfData();

}
