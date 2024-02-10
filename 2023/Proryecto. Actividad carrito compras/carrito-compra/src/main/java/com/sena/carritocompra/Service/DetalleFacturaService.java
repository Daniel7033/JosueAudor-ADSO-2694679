package com.sena.carritocompra.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carritocompra.Entity.DetalleFactura;
import com.sena.carritocompra.IRepository.IDetalleFacturaRepository;
import com.sena.carritocompra.IService.IDetalleFacturaService;

@Service
public class DetalleFacturaService implements IDetalleFacturaService{

    @Autowired
    private IDetalleFacturaRepository repository;

    @Override
    public List<DetalleFactura> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<DetalleFactura> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public DetalleFactura save(DetalleFactura df) {
        return repository.save(df);
    }

    @Override
    public void update(DetalleFactura df, Long id) {
        Optional<DetalleFactura> op = repository.findById(id);

        if (op.isEmpty()) {
            System.out.print("Registro no existe");
        } else{
            DetalleFactura updatDetalleFactura = op.get();
            updatDetalleFactura.setCantidad(df.getCantidad());
            updatDetalleFactura.setValorPagar(df.getValorPagar());
            updatDetalleFactura.setProductoId(df.getProductoId());
            updatDetalleFactura.setFacturaId(df.getFacturaId());
            updatDetalleFactura.setEstado(df.getEstado());
            updatDetalleFactura.setFechaModificacion(LocalDateTime.now());

            repository.save(updatDetalleFactura);
        }
        
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);;
    }

    @Override
    public void deletedAt(Long id) {
        Optional<DetalleFactura> op = repository.findById(id);

        if(op.isEmpty()){
            System.out.print("Registro no existe para eliminar.");
        } else{
            DetalleFactura updatedDetalleFactura = op.get();
            updatedDetalleFactura.setFechaEliminacion(LocalDateTime.now());
            repository.save(updatedDetalleFactura);
        }
    }
    
}
