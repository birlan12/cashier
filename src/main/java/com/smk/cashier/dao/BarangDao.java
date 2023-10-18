package com.smk.cashier.dao;

import com.smk.cashier.model.Barang;

import java.sql.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class BarangDao implements Dao<Barang, Integer> {
    private final Optional<Connection> Connection;

    public BarangDao() {
        Connection = JdbcConnection.getConnection();
    }

    @Override
    public Optional<Barang> get(int id) {
        return Optional.empty();
    }

    @Override
    public Collection<Barang> getAll() {
        return null;
    }

    @Override
    public Optional<Integer> save(Barang barang) {
        Barang noNullBarang = Objects.requireNonNull(barang);
        String sql = "INSERT INTO Barang" + "(kode_barang, nama_barang, harga_barang, created_by, update_by, date_created, last_modified)" +
        "VALUES(?,?,?,?,?,?,?)";
        return Connection.flatMap(Conn -> {
            Optional<Integer> generatedId = Optional.empty();
            try {
                PreparedStatement ps = Conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, barang.getKodeBarang());
                ps.setString(2,barang.getNamaBarang());
                ps.setInt(3,barang.getHargaBarang());
                ps.setString(4,barang.getCreatedBy());
                ps.setString(5,barang.getUpdateBy());
                ps.setDate(6, new Date(barang.getDateCreated().getTime()));
                ps.setDate(7, new Date(barang.getLastModified().getTime()));
                int numberofInsertedRows = ps.executeUpdate();
                if (numberofInsertedRows > 0){
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next()){
                        Optional.of(rs.getInt(1));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return generatedId;
        });
    }



    @Override
    public void update(Barang barang) {

    }

    @Override
    public void delete(Barang barang) {

    }
}
